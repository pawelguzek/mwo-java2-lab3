package pl.edu.agh.mwo.java.crawler;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SentenceByLengtFinderTest {

	@Test
	public void testSimple10() {
		SentenceByLengtFinder sentenceByLengtFinder = new SentenceByLengtFinder(10);
		List<String> sentences = Arrays.asList("dziesiêæ l", "piêtnaœcie lite", "czte");
		
		List<String> results = sentenceByLengtFinder.findSentences(sentences);		
		assertEquals(2,  results.size());
	}

	@Test
	public void testSimple11() {
		SentenceByLengtFinder sentenceByLengtFinder = new SentenceByLengtFinder(11);
		List<String> sentences = Arrays.asList("dziesiêæ l", "piêtnaœcie lite", "czte");
		
		List<String> results = sentenceByLengtFinder.findSentences(sentences);		
		assertEquals(1,  results.size());
	}


}
