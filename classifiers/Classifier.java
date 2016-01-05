package classifiers;

import java.io.IOException;

public interface Classifier {
	public String[] getClassNames();

	public String apply(String newFilePath) throws IOException;

	public void train(String[] dirPaths) throws IOException;
}
