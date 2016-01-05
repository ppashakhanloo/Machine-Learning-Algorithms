package utilities;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public final class Utils {

	public static int argmax(double[] score) {
		int maxIndex = -1;
		double maxVal = Double.NEGATIVE_INFINITY;
		for (int i = 0; i < score.length; i++) {
			double elem = score[i];
			if (elem > maxVal) {
				maxVal = elem;
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValues(
			Map<K, V> map) {
		SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(
				new Comparator<Map.Entry<K, V>>() {
					@Override
					public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
						int res = e2.getValue().compareTo(e1.getValue());
						return res != 0 ? res : 1;
					}
				});
		sortedEntries.addAll(map.entrySet());
		return sortedEntries;
	}

	public static List<String> tokenizeString(String string) {
		List<String> result = new ArrayList<String>();
		Analyzer analyzer = new StandardAnalyzer();
		try {
			TokenStream stream = analyzer.tokenStream(null, new StringReader(
					string));
			stream.reset();
			while (stream.incrementToken()) {
				result.add(stream.getAttribute(CharTermAttribute.class)
						.toString());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		analyzer.close();
		return result;
	}

}