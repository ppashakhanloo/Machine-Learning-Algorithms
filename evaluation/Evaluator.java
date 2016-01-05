package evaluation;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import classifiers.Classifier;

public class Evaluator {

	private HashMap<String, String> classifierResults = new HashMap<String, String>();
	private HashMap<String, String> realClasses = new HashMap<String, String>();
	private Classifier trainedClassifier;
	private int[] realNumClasses;

	public Evaluator(Classifier trainedClassifier) {
		this.trainedClassifier = trainedClassifier;
		this.realNumClasses = new int[trainedClassifier.getClassNames().length];
	}

	public double accuracy() {
		// accuracy = (tp + tn) / (tp+fp+fn+tn)
		double tp = 0d;

		for (String doc : classifierResults.keySet()) {
			if (classifierResults.get(doc).equals(realClasses.get(doc)))
				tp++; // class is what it must be.
		}
		return tp / (double) classifierResults.size();
	}

	public void classPrecRecall() {
		// precision = tp / (tp + fp)
		// recall = tp / (tp + fn)
		double numAllTestData = 0;
		for (int i = 0; i < realNumClasses.length; i++) {
			numAllTestData += realNumClasses[i];
		}

		for (int i = 0; i < trainedClassifier.getClassNames().length; i++) {
			System.out.print(".");
			// we are checking this class!
			double tp = 0d;
			for (String doc : classifierResults.keySet()) {
				if (classifierResults.get(doc).equals(realClasses.get(doc))
						&& classifierResults.get(doc).equals(
								trainedClassifier.getClassNames()[i]))
					tp++;
			}
			System.out.println("DATA FOR CLASS <<"
					+ trainedClassifier.getClassNames()[i] + ">>");
			System.out.println("Precision=" + (tp / numAllTestData));
			System.out
					.println("RECALL   =" + (tp / (double) realNumClasses[i]));
		}
	}

	public double F1_macroAveraging() {
		// F1 = (2*p*r) / (p + r)
		// precision = tp / (tp + fp)
		// recall = tp / (tp + fn)
		double numAllTestData = 0;
		for (int i = 0; i < realNumClasses.length; i++) {
			numAllTestData += realNumClasses[i];
		}

		double allP = 0d;
		double allR = 0d;

		for (int i = 0; i < trainedClassifier.getClassNames().length; i++) {
			// we are checking this class!
			double tp = 0d;
			for (String doc : classifierResults.keySet()) {
				if (classifierResults.get(doc).equals(realClasses.get(doc))
						&& classifierResults.get(doc).equals(
								trainedClassifier.getClassNames()[i]))
					tp++;
			}
			allP += (tp / numAllTestData);
			allR += (tp / (double) realNumClasses[i]);
		}
		allP /= (double) trainedClassifier.getClassNames().length;
		allR /= (double) trainedClassifier.getClassNames().length;
		return (2.0 * allP * allR) / (allP + allR);
	}

	public double AUC() {
		// regarding pos class
		// false negative rate vs true positive rate graph
		// fn=ok! result is negative but is in fact pos
		// tp=ok! result is positive and it is pos in fact

		double fn = 0d;
		double tp = 0d;
		for (String doc : classifierResults.keySet()) {
			if (classifierResults.get(doc).equals("pos")
					&& classifierResults.get(doc).equals("pos")) {
				tp++;
			} else if (classifierResults.get(doc).equals("neg")
					&& realClasses.get(doc).equals("pos")) {
				fn++;
			}
		}
		return fn / tp;
	}

	// classifier must be trained before passing
	public void applyAllTestData(String[] dirPaths, String[] testDataClasses)
			throws IOException {
		System.out.println("applying test data...");
		for (int i = 0; i < dirPaths.length; i++) {
			System.out.println("one dir finished...");
			File dir = new File(dirPaths[i]);
			File[] directoryListing = dir.listFiles();
			this.realNumClasses[i] = directoryListing.length;
			if (directoryListing != null) {
				for (File child : directoryListing) {
					classifierResults.put(child.getAbsolutePath(),
							trainedClassifier.apply(child.getAbsolutePath()));
					realClasses
							.put(child.getAbsolutePath(), testDataClasses[i]);
				}
			}
		}
	}
}
