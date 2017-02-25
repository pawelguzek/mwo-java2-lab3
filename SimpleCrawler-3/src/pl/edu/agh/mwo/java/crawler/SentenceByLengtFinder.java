package pl.edu.agh.mwo.java.crawler;

import java.util.List;
import java.util.stream.Collectors;

public class SentenceByLengtFinder implements SentenceFinder {

	protected int minumumLength;
	
	public SentenceByLengtFinder(int minumumLength) {
		super();
		this.minumumLength = minumumLength;
	}

	@Override
	public List<String> findSentences(List<String> sentences) {
		return sentences.stream().filter(s -> s.length() >= minumumLength).collect(Collectors.toList());
	}

}
