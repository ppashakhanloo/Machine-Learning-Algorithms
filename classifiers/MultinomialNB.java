package classifiers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

import utilities.Utils;

public class MultinomialNB implements Classifier {

	private ArrayList<String> vocabulary = new ArrayList<String>();
	private int numDocs;
	private int[] numDocsOfEachClass;
	private int numClasses;
	private ArrayList<TreeMap<String, Integer>> vocabOfClasses;
	private double[] prior;
	private double[][] condprob;
	private String[] classNames;

	public String[] getClassNames() {
		return classNames;
	}

	public int[] getNumDocsOfEachClass() {
		return numDocsOfEachClass;
	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		MultinomialNB nb = new MultinomialNB(new String[] { "pos", "neg" });

		long t1 = System.currentTimeMillis();
		nb.train(new String[] {
				"C:\\Users\\Pardis\\Dropbox\\[ UNIVERSITY ]\\Sem 7\\MIR\\Project\\Project02\\IMDB\\aclImdb\\train\\pos",
				"C:\\Users\\Pardis\\Dropbox\\[ UNIVERSITY ]\\Sem 7\\MIR\\Project\\Project02\\IMDB\\aclImdb\\train\\neg" });
		long t2 = System.currentTimeMillis();
		System.out.println("train finished in " + (t2 - t1) / 1000
				+ " seconds.");
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("Enter file to test:");
			try {
				t1 = System.currentTimeMillis();
				System.out.println("class chosen = "
						+ nb.apply(scan.nextLine()));
				t2 = System.currentTimeMillis();
				System.out.println("Test finished in " + (t2 - t1) / 1000
						+ " seconds.");
			} catch (Exception e) {
				System.out.println("invalid.");
				e.printStackTrace();
			} finally {
				scan.close();
			}
		}
	}

	public MultinomialNB(String[] classNames) throws IOException {
		this.numDocs = 0;
		this.numClasses = classNames.length;
		this.numDocsOfEachClass = new int[classNames.length];
		this.vocabOfClasses = new ArrayList<TreeMap<String, Integer>>(
				classNames.length);
		this.prior = new double[classNames.length];
		this.classNames = classNames;
	}

	private void extractVocabulary(String[] dirPaths) throws IOException {
		for (int i = 0; i < dirPaths.length; i++) {
			extractVocabulary(dirPaths[i], i);
		}

		// now, we can initialize the condprob
		this.condprob = new double[vocabulary.size()][classNames.length];

	}

	public void train(String[] dirPaths) throws IOException {

		extractVocabulary(dirPaths);
		for (int c = 0; c < classNames.length; c++) {
			int N_c = numDocsOfEachClass[c];
			prior[c] = (double) N_c / (double) numDocs;

			int T_ct[][] = new int[classNames.length][vocabulary.size()];
			for (String t : vocabulary) {
				if (vocabOfClasses.get(c).get(t) != null)
					T_ct[c][vocabulary.indexOf(t)] = vocabOfClasses.get(c).get(
							t);
			}

			double sigma = 0;
			for (String t : vocabulary) {
				sigma += (T_ct[c][vocabulary.indexOf(t)] + 1.0);
			}

			for (String t : vocabulary) {
				condprob[vocabulary.indexOf(t)][c] = (T_ct[c][vocabulary
						.indexOf(t)] + 1.0) / sigma;
			}
		}
	}

	public String apply(String newDocPath) throws IOException {

		FileInputStream fis = new FileInputStream(new File(newDocPath));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		String newDocContent = "";
		String line = "";
		while (line != null) {
			line = br.readLine();
			newDocContent += line + " ";
		}
		double[] score = new double[numClasses];

		List<String> newDocTokens = Utils.tokenizeString(newDocContent);
		TreeMap<String, Integer> termFreq = new TreeMap<String, Integer>();

		for (String str : newDocTokens) {
			if (vocabulary.contains(str)) {
				if (!termFreq.containsKey(str))
					termFreq.put(str, 1);
				else {
					int temp = termFreq.get(str) + 1;
					termFreq.put(str, temp);
				}
			}
		}
		br.close();

		for (int c = 0; c < numClasses; c++) {
			score[c] = Math.log10(prior[c]);
			for (String t : termFreq.keySet()) {
				score[c] += Math.log10(condprob[vocabulary.indexOf(t)][c]);
			}
		}

		// return class id
		return classNames[Utils.argmax(score)];
	}

	private void extractVocabulary(String directoryPath, int classID)
			throws IOException {
		File dir = new File(directoryPath);
		File[] directoryListing = dir.listFiles();
		numDocs += directoryListing.length;
		numDocsOfEachClass[classID] = directoryListing.length;
		TreeMap<String, Integer> thisClassVocab = new TreeMap<String, Integer>();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				System.out.print(".");
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
						if (!thisClassVocab.containsKey(term)) {
							thisClassVocab.put(term, 1);
						} else if (thisClassVocab.containsKey(term)) {
							int temp = thisClassVocab.get(term) + 1;
							thisClassVocab.put(term, new Integer(temp));
						}
					}
				}
				br.close();
			}
		}
		vocabOfClasses.add(thisClassVocab);
	}
}
