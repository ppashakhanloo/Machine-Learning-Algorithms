package ui;

import java.util.Scanner;

import classifiers.KNN;
import classifiers.MultinomialNB;
import classifiers.SVM;
import evaluation.Evaluator;

public class Main {
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		MultinomialNB nb = null;
		KNN knn = null;
		SVM svm = null;
		Evaluator eval = null;
		String line = "-1";
		while (true) {
			System.out.println("Choose what to do:");
			System.out
					.println("\t1: Train Multinomial Naive Bayes (1st dataset)");
			System.out
					.println("\t2: Train Multinomial Naive Bayes (2nd dataset)");
			System.out.println("\t3: Train KNN (1st dataset)");
			System.out.println("\t4: Train KNN (2nd dataset)");
			System.out.println("\t5: Train SVM (1st dataset)");
			System.out.println("\t6: Train SVM (2nd dataset)");
			System.out
					.println("\t7: Evaluate Multinomial Naive Bayes (1st dataset)");
			System.out
					.println("\t8: Evaluate Multinomial Naive Bayes (2nd dataset)");
			System.out.println("\t9: Evaluate KNN with k = 1 (1st dataset)");
			System.out.println("\t10: Evaluate KNN with k = 3 (1st dataset)");
			System.out.println("\t11: Evaluate KNN with k = 5 (1st dataset)");
			System.out.println("\t12: Evaluate KNN with k = 1 (2nd dataset)");
			System.out.println("\t13: Evaluate KNN with k = 3 (2nd dataset)");
			System.out.println("\t14: Evaluate KNN with k = 5 (2nd dataset)");
			System.out.println("\t15: Evaluate SVM (1st dataset)");
			System.out.println("\t16: Evaluate SVM (2nd dataset)");
			line = scan.nextLine();
			switch (line) {
			case "1":
				// Train Multinomial Naive Bayes (1st dataset)
				nb = new MultinomialNB(new String[] { "pos", "neg" });
				nb.train(new String[] {
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\IMDB\\aclImdb\\train\\pos",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\IMDB\\aclImdb\\train\\neg" });
				break;
			case "2":
				// Train Multinomial Naive Bayes (2nd dataset)
				nb = new MultinomialNB(new String[] { "C01", "C02", "C03",
						"C04", "C05", "C06", "C07", "C08", "C09", "C10", "C11",
						"C12", "C13", "C14", "C15", "C16", "C17", "C18", "C19",
						"C20", "C21", "C22", "C23" });
				nb.train(new String[] {
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C01",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C02",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C03",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C04",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C05",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C06",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C07",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C08",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C09",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C10",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C11",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C12",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C13",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C14",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C15",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C16",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C17",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C18",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C19",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C20",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C21",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C22",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C23" });
				break;
			case "3":
				// Train KNN (1st dataset)
				knn = new KNN(new String[] { "pos", "neg" });
				knn.train(new String[] {
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\IMDB\\aclImdb\\train\\pos",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\IMDB\\aclImdb\\train\\neg" });
				break;
			case "4":
				// Train KNN (2nd dataset)
				knn = new KNN(new String[] { "C01", "C02", "C03", "C04", "C05",
						"C06", "C07", "C08", "C09", "C10", "C11", "C12", "C13",
						"C14", "C15", "C16", "C17", "C18", "C19", "C20", "C21",
						"C22", "C23" });
				knn.train(new String[] {
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C01",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C02",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C03",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C04",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C05",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C06",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C07",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C08",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C09",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C10",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C11",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C12",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C13",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C14",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C15",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C16",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C17",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C18",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C19",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C20",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C21",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C22",
						"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\train\\C23" });
				break;
			case "5":
				// Train SVM (1st dataset)
				svm = new SVM();
				svm.train("C:/Users/Pardis/Desktop/imdb_train.arff");
				break;
			case "6":
				// Train SVM (2nd dataset)
				svm = new SVM();
				svm.train("C:/Users/Pardis/Desktop/med_train.arff");
				break;

			case "7":
				// Evaluate Multinomial Naive Bayes (1st dataset)
				eval = new Evaluator(nb);
				eval.applyAllTestData(
						new String[] {
								"C:\\Users\\Pardis\\Dropbox\\[ UNIVERSITY ]\\Sem 7\\MIR\\Project\\Project02\\IMDB\\aclImdb\\test\\pos",
								"C:\\Users\\Pardis\\Dropbox\\[ UNIVERSITY ]\\Sem 7\\MIR\\Project\\Project02\\IMDB\\aclImdb\\test\\neg" },
						new String[] { "pos", "neg" });
				System.out.println("The classifier applied to all test data.");
				System.out.println("ACCURACY = " + eval.accuracy());
				System.out.println("PRECISION RECALL");
				eval.classPrecRecall();
				System.out.println("F1-MACRO-AVERAGED="
						+ eval.F1_macroAveraging());
				System.out.println("AUC = " + eval.AUC());
				break;
			case "8":
				// Evaluate Multinomial Naive Bayes (2nd dataset)
				eval = new Evaluator(nb);
				eval.applyAllTestData(
						new String[] {
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C01",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C02",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C03",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C04",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C05",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C06",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C07",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C08",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C09",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C10",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C11",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C12",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C13",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C14",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C15",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C16",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C17",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C18",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C19",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C20",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C21",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C22",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C23" },
						new String[] { "C01", "C02", "C03", "C04", "C05",
								"C06", "C07", "C08", "C09", "C10", "C11",
								"C12", "C13", "C14", "C15", "C16", "C17",
								"C18", "C19", "C20", "C21", "C22", "C23" });
				System.out.println("The classifier applied to all test data.");
				System.out.println("ACCURACY = " + eval.accuracy());
				System.out.println("PRECISION RECALL");
				eval.classPrecRecall();
				System.out.println("F1-MACRO-AVERAGED="
						+ eval.F1_macroAveraging());
				break;
			case "9":
				// Evaluate KNN with k = 1 (1st dataset)
				knn.setK(1);
				eval = new Evaluator(knn);
				eval.applyAllTestData(
						new String[] {
								"C:\\Users\\Pardis\\Dropbox\\[ UNIVERSITY ]\\Sem 7\\MIR\\Project\\Project02\\IMDB\\aclImdb\\test\\pos",
								"C:\\Users\\Pardis\\Dropbox\\[ UNIVERSITY ]\\Sem 7\\MIR\\Project\\Project02\\IMDB\\aclImdb\\test\\neg" },
						new String[] { "pos", "neg" });
				System.out.println("The classifier applied to all test data.");
				System.out.println("ACCURACY = " + eval.accuracy());
				System.out.println("PRECISION RECALL");
				eval.classPrecRecall();
				System.out.println("F1-MACRO-AVERAGED="
						+ eval.F1_macroAveraging());
				System.out.println("AUC = " + eval.AUC());
				break;
			case "10":
				// Evaluate KNN with k = 3 (1st dataset)
				knn.setK(3);
				eval = new Evaluator(knn);
				eval.applyAllTestData(
						new String[] {
								"C:\\Users\\Pardis\\Dropbox\\[ UNIVERSITY ]\\Sem 7\\MIR\\Project\\Project02\\IMDB\\aclImdb\\test\\pos",
								"C:\\Users\\Pardis\\Dropbox\\[ UNIVERSITY ]\\Sem 7\\MIR\\Project\\Project02\\IMDB\\aclImdb\\test\\neg" },
						new String[] { "pos", "neg" });
				System.out.println("The classifier applied to all test data.");
				System.out.println("ACCURACY = " + eval.accuracy());
				System.out.println("PRECISION RECALL");
				eval.classPrecRecall();
				System.out.println("F1-MACRO-AVERAGED="
						+ eval.F1_macroAveraging());
				System.out.println("AUC = " + eval.AUC());
				break;
			case "11":
				// Evaluate KNN with k = 5 (1st dataset)
				knn.setK(5);
				eval = new Evaluator(knn);
				eval.applyAllTestData(
						new String[] {
								"C:\\Users\\Pardis\\Dropbox\\[ UNIVERSITY ]\\Sem 7\\MIR\\Project\\Project02\\IMDB\\aclImdb\\test\\pos",
								"C:\\Users\\Pardis\\Dropbox\\[ UNIVERSITY ]\\Sem 7\\MIR\\Project\\Project02\\IMDB\\aclImdb\\test\\neg" },
						new String[] { "pos", "neg" });
				System.out.println("The classifier applied to all test data.");
				System.out.println("ACCURACY = " + eval.accuracy());
				System.out.println("PRECISION RECALL");
				eval.classPrecRecall();
				System.out.println("F1-MACRO-AVERAGED="
						+ eval.F1_macroAveraging());
				System.out.println("AUC = " + eval.AUC());
				break;
			case "12":
				// Evaluate KNN with k = 1 (2nd dataset)
				knn.setK(1);
				eval = new Evaluator(knn);
				eval.applyAllTestData(
						new String[] {
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C01",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C02",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C03",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C04",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C05",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C06",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C07",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C08",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C09",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C10",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C11",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C12",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C13",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C14",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C15",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C16",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C17",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C18",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C19",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C20",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C21",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C22",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C23" },
						new String[] { "C01", "C02", "C03", "C04", "C05",
								"C06", "C07", "C08", "C09", "C10", "C11",
								"C12", "C13", "C14", "C15", "C16", "C17",
								"C18", "C19", "C20", "C21", "C22", "C23" });
				System.out.println("The classifier applied to all test data.");
				System.out.println("ACCURACY = " + eval.accuracy());
				System.out.println("PRECISION RECALL");
				eval.classPrecRecall();
				System.out.println("F1-MACRO-AVERAGED="
						+ eval.F1_macroAveraging());
				break;
			case "13":
				// Evaluate KNN with k = 3 (2nd dataset)
				knn.setK(3);
				eval = new Evaluator(knn);
				eval.applyAllTestData(
						new String[] {
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C01",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C02",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C03",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C04",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C05",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C06",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C07",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C08",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C09",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C10",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C11",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C12",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C13",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C14",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C15",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C16",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C17",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C18",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C19",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C20",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C21",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C22",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C23" },
						new String[] { "C01", "C02", "C03", "C04", "C05",
								"C06", "C07", "C08", "C09", "C10", "C11",
								"C12", "C13", "C14", "C15", "C16", "C17",
								"C18", "C19", "C20", "C21", "C22", "C23" });
				System.out.println("The classifier applied to all test data.");
				System.out.println("ACCURACY = " + eval.accuracy());
				System.out.println("PRECISION RECALL");
				eval.classPrecRecall();
				System.out.println("F1-MACRO-AVERAGED="
						+ eval.F1_macroAveraging());
				break;
			case "14":
				// Evaluate KNN with k = 5 (2nd dataset)
				knn.setK(5);
				eval = new Evaluator(knn);
				eval.applyAllTestData(
						new String[] {
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C01",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C02",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C03",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C04",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C05",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C06",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C07",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C08",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C09",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C10",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C11",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C12",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C13",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C14",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C15",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C16",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C17",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C18",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C19",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C20",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C21",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C22",
								"C:\\Users\\Pardis\\Dropbox\\[UNIVERSITY]\\Sem7\\MIR\\Project\\Project02\\ohsumed-all-docs\\ohsumed-all\\test\\C23" },
						new String[] { "C01", "C02", "C03", "C04", "C05",
								"C06", "C07", "C08", "C09", "C10", "C11",
								"C12", "C13", "C14", "C15", "C16", "C17",
								"C18", "C19", "C20", "C21", "C22", "C23" });
				System.out.println("The classifier applied to all test data.");
				System.out.println("ACCURACY = " + eval.accuracy());
				System.out.println("PRECISION RECALL");
				eval.classPrecRecall();
				System.out.println("F1-MACRO-AVERAGED="
						+ eval.F1_macroAveraging());
				break;
			case "15":
				// Evaluate SVM (1st dataset)
				if (svm != null) {
					svm.test("C:/Users/Pardis/Desktop/imdb_test.arff");
					svm.evaluate();
				}
				break;
			case "16":
				// Evaluate SVM (2nd dataset)
				if (svm != null) {
					svm.test("C:/Users/Pardis/Desktop/med_test.arff");
					svm.evaluate();
				}
				break;
			}
		}
	}
}
