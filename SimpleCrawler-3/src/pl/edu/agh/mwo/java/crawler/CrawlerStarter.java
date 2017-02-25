package pl.edu.agh.mwo.java.crawler;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class CrawlerStarter {

	public static void main(String[] args) throws IOException 
	{
		
		Crawler c = new Crawler("http://www.onet.pl", new TextExtractor(), new ConsoleResultsPrinter(), new UrlFinder(), new PerformanceLogger());
		
		c.addSentenceFinder(new SentenceByWordFinder("BOR"));
//		c.addSentenceFinder(new SentenceByCharCountFinder(10, 'd'));
		
//		c.addSentenceFinder(new SentenceFinder(){
//			@Override
//			public List<String> findSentences(List<String> sentences) {
//				List<String> result = new ArrayList<>();
//				for (String sentence : sentences)
//					if (sentence.length() > 300)
//						result.add(sentence);
//				return result;
//			}			
//		});	
		
//		c.addSentenceFinder(new SentenceFinder(){
//			@Override
//			public List<String> findSentences(List<String> sentences) {
//				List<String> result = new ArrayList<>();
//				for (String sentence : sentences)
//					if (sentence.charAt(0) == ' ')
//						result.add(sentence);
//				return result;
//			}			
//		});
		
//		c.addSentenceFinder( (sentences) -> {
//			List<String> result = new ArrayList<>();
//			for (String sentence : sentences)
//				if (sentence.charAt(0) == ' ')
//					result.add(sentence);
//			return result;
//			}			
//		);
	
//		c.addSentenceFinder( (sentences) -> {
//			List<String> result = new ArrayList<>();
//			for (String sentence : sentences)
//				if (sentence.split(" ").length > 70)
//					result.add(sentence);
//			return result;
//			}			
//		);
	
//		c.addSentenceFinder(sentences -> 
//		sentences.stream()
//			.filter(sentence -> sentence.split(" ").length > 70)
//			.collect(Collectors.toList()));

//		c.addSentenceFinder(sentences -> 
//		sentences.stream()
//			.filter(sentence -> sentence.length() < 10)
//			.collect(Collectors.toList()));
		
		c.setUrlsToProcessCount(100);
		c.run();
		
		System.out.println("CRAWLER FINISHED!");

	}

}
