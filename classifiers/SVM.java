package classifiers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.LibSVM;
import weka.core.Instances;
import weka.core.SelectedTag;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.filters.*;

public class SVM {

	private Filter filter;
	private LibSVM svmClassifier;
	private Instances dataFiltered;
	private Instances testFiltered;

	public static void save(LibSVM model, String path) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(path);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(model);
		out.close();
	}

	public static LibSVM load(String path) throws IOException,
			ClassNotFoundException {
		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream in = new ObjectInputStream(fis);
		System.out.println("Loading SVM model...");
		Object obj = in.readObject();
		System.out.print("Model loaded.");
		in.close();
		fis.close();
		return (LibSVM) obj;
	}

	public void train(String train_data_arff) throws Exception {
		DataSource source = new DataSource(train_data_arff);
		Instances data = source.getDataSet();
		if (data.classIndex() == -1)
			data.setClassIndex(data.numAttributes() - 1);

		filter = new StringToWordVector();
		filter.setInputFormat(data);
		dataFiltered = Filter.useFilter(data, filter);

		// svmClassifier = SVM
		// .load("C:/Users/Pardis/workspace/MIR_PROJECT2_PART2/svm_med.model");

		svmClassifier = null;

		if (svmClassifier == null) {
			svmClassifier = new LibSVM();
			System.out.println("Training started...");
			svmClassifier.setNormalize(true);
			svmClassifier.setKernelType(new SelectedTag(
					LibSVM.KERNELTYPE_LINEAR, LibSVM.TAGS_KERNELTYPE));
			svmClassifier.setCacheSize(1000);
			svmClassifier.buildClassifier(dataFiltered);
			SVM.save(svmClassifier, "./svm.model");
		}

	}

	public void test(String test_data_arff) throws Exception {
		DataSource test = new DataSource(test_data_arff);
		Instances testData = test.getDataSet();
		if (testData.classIndex() == -1)
			testData.setClassIndex(testData.numAttributes() - 1);
		testFiltered = Filter.useFilter(testData, filter);
	}

	public void evaluate() throws Exception {
		Evaluation eval = new Evaluation(dataFiltered);
		eval.evaluateModel(svmClassifier, testFiltered);
		System.out.println("Class details:\n" + eval.toClassDetailsString());
		System.out.println("Confusion matrix:\n" + eval.toMatrixString());
	}

	public static void main(String[] args) throws Exception {
		SVM svm = new SVM();
		svm.train("C:/Users/Pardis/Desktop/train_med.arff");
		System.out.println("Train finished.");
		svm.test("C:/Users/Pardis/Desktop/test_med.arff");
		System.out.println("Test finished.");
		System.out.println("Evaluation started...");
		svm.evaluate();
	}

}