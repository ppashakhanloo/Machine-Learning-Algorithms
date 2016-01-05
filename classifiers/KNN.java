package classifiers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedSet;

import utilities.Utils;

public class KNN implements Classifier {

	public static void main(String[] args) throws IOException {
		KNN knn = new KNN(new String[] { "pos", "neg" });
		knn.setK(3);
		knn.train(new String[] {
				"C:\\Users\\Pardis\\Dropbox\\[ UNIVERSITY ]\\Sem 7\\MIR\\Project\\Project02\\IMDB - small\\aclImdb\\train\\pos",
				"C:\\Users\\Pardis\\Dropbox\\[ UNIVERSITY ]\\Sem 7\\MIR\\Project\\Project02\\IMDB - small\\aclImdb\\train\\neg" });

		System.out.println("train finished!");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("Enter file to test:");
			String s = scan.nextLine();
			try {
				long t1 = System.currentTimeMillis();
				System.out.println("class chosen = " + knn.apply(s));
				long t2 = System.currentTimeMillis();
				System.out.println("Test finished in " + (t2 - t1) / 1000
						+ " sec");
			} catch (Exception e) {
				System.out.println("invalid.");
				e.printStackTrace();
			}
		}
	}

	private HashMap<String, HashMap<String, Integer>> D_prime = new HashMap<String, HashMap<String, Integer>>();
	private ArrayList<String> vocabulary = new ArrayList<String>();
	private HashMap<String, Integer> whichDocWhichClass = new HashMap<String, Integer>();
	private int K;
	private int numDocs;
	private int numClasses;
	private HashMap<String, double[]> docVectors = null;
	private String[] classNames;
	private int[] numDocsOfEachClass;

	public KNN(String[] classNames) {
		this.numDocs = 0;
		this.numClasses = classNames.length;
		this.classNames = classNames;
		this.numDocsOfEachClass = new int[numClasses];
		this.K = 1;
	}

	public void setK(int k) {
		K = k;
	}

	public String[] getClassNames() {
		return classNames;
	}

	public int[] getNumDocsOfEachClass() {
		return numDocsOfEachClass;
	}

	public void train(String[] dirPaths) throws IOException {
		long t1 = System.currentTimeMillis();
		preProcess(dirPaths);
		long t2 = System.currentTimeMillis();
		System.out.println("preprocess finished in " + (t2 - t1) + " ms.");
	}

	private void preProcess(String[] directoryPaths) throws IOException {
		for (int i = 0; i < directoryPaths.length; i++) {
			extractVocabulary(directoryPaths[i], i);
			System.out.println("one directory scanned and parsed!");
		}
	}

	private void extractVocabulary(String directoryPath, int i)
			throws IOException {
		File dir = new File(directoryPath);
		File[] directoryListing = dir.listFiles();
		this.numDocs += directoryListing.length;
		this.numDocsOfEachClass[i] = directoryListing.length;
		if (directoryListing != null) {
			for (File child : directoryListing) {
				whichDocWhichClass.put(child.getAbsolutePath(), i);
				HashMap<String, Integer> tfTable = new HashMap<String, Integer>();
				FileInputStream fis = new FileInputStream(child);
				BufferedReader br = new BufferedReader(new InputStreamReader(
						fis));
				String wholeFile = "";
				String line = "";
				while (line != null) {
					line = br.readLine();
					wholeFile += line + " ";
				}
				for (String term : Utils.tokenizeString(wholeFile)) {
					if (!term.matches(".*\\d+.*")) {
						if (!vocabulary.contains(term))
							vocabulary.add(term);
						if (!tfTable.containsKey(term)) {
							tfTable.put(term, 1);
						} else {
							int temp = tfTable.get(term) + 1;
							tfTable.put(term, temp);
						}
					}
				}

				D_prime.put(child.getAbsolutePath(), tfTable);
				br.close();
			}
		}
	}

	public String apply(String newFilePath) throws IOException {
		ArrayList<String> S_k = computeNearestNeighbors(newFilePath);
		double[] p_j = new double[numClasses];
		for (String doc : S_k) {
			p_j[whichDocWhichClass.get(doc)]++;
		}
		return classNames[Utils.argmax(p_j)];
	}

	private HashMap<String, double[]> getDocVectors() {
		int x = 0;
		HashMap<String, double[]> docVecs = new HashMap<String, double[]>();
		for (String doc : D_prime.keySet()) {
			double[] thisDocVec = new double[vocabulary.size()];
			for (String term : D_prime.get(doc).keySet()) {
				thisDocVec[vocabulary.indexOf(term)] = Math.log10(this.numDocs
						/ (double) df(term))
						* (double) D_prime.get(doc).get(term);
			}
			x++;
			if (x % 10 == 0)
				System.out.print(x + ".");
			docVecs.put(doc, thisDocVec);
		}
		return docVecs;
	}

	private double df(String term) {
		double dfT = 0.0d;
		for (String string : D_prime.keySet()) {
			if (D_prime.get(string).containsKey(term))
				dfT++;
		}
		return dfT;
	}

	private ArrayList<String> computeNearestNeighbors(String newFilePath)
			throws IOException {
		ArrayList<String> nearestDocs = new ArrayList<String>();

		if (docVectors == null)
			docVectors = getDocVectors();

		HashMap<String, Double> similarities = new HashMap<String, Double>();

		double[] newDocVector = getDocVector(newFilePath);

		for (String doc : docVectors.keySet()) {
			similarities.put(doc,
					computeCosineSimilarity(newDocVector, docVectors.get(doc)));
		}

		SortedSet<Entry<String, Double>> ss = Utils
				.entriesSortedByValues(similarities);
		final int maplength = ss.size();
		@SuppressWarnings("unchecked")
		final Entry<String, Double>[] array_util = new Entry[maplength];
		ss.toArray(array_util);

		for (int i = 0; i < K; i++) {
			nearestDocs.add(array_util[i].getKey());
		}

		return nearestDocs;
	}

	private double[] getDocVector(String newFilePath) throws IOException {
		System.out.println("in doc vector");
		FileInputStream fis = new FileInputStream(newFilePath);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		HashMap<String, Integer> myTfTable = new HashMap<String, Integer>();

		String wholeFile = "";
		String line = "";
		while (line != null) {
			line = br.readLine();
			wholeFile += line + " ";
		}
		for (String term : Utils.tokenizeString(wholeFile)) {
			if (!term.matches(".*\\d+.*")) {
				if (vocabulary.contains(term))
					if (!myTfTable.containsKey(term)) {
						myTfTable.put(term, 1);
					} else {
						int temp = myTfTable.get(term) + 1;
						myTfTable.put(term, temp);
					}
			}
		}
		br.close();

		double[] thisDocVec = new double[vocabulary.size()];
		for (String term : myTfTable.keySet()) {
			if (vocabulary.contains(term))
				thisDocVec[vocabulary.indexOf(term)] = Math.log10(this.numDocs
						/ (double) df(term))
						* (double) myTfTable.get(term);
		}

		return thisDocVec;
	}

	private Double computeCosineSimilarity(double[] newDocVector, double[] ds) {
		double res = 0.0d;

		for (int i = 0; i < ds.length; i++)
			res += newDocVector[i] * ds[i];

		return res;
	}
}
