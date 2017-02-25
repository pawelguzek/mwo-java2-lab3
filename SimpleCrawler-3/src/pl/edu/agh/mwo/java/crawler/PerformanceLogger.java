package pl.edu.agh.mwo.java.crawler;

import java.util.List;

public class PerformanceLogger {

	protected int totalProcessedPages = 0;
	protected int totalProcessedSentences = 0;
	protected int totalProcessedTextChars = 0;
	
	protected int intervalProcessedPages = 0;
	protected int intervalProcessedSentences = 0;
	protected int intervalProcessedTextChars = 0;
	
	protected final long intervalLengthMiliseconds = 2000;
	protected long startTime = System.currentTimeMillis();
	protected long lastPrintedTime = System.currentTimeMillis();
	
	public void addProcessedPage(List<String> sentences) 
	{
		totalProcessedPages++;
		intervalProcessedPages++;
		
		totalProcessedSentences += sentences.size();
		intervalProcessedSentences += sentences.size();
		
		int charsCount = sentences.stream().mapToInt(sentence -> sentence.length()).sum();		
		totalProcessedTextChars += charsCount;
		intervalProcessedTextChars += charsCount;
		
		if (lastPrintedTime + intervalLengthMiliseconds < System.currentTimeMillis())
		{
			printStatistics();
			intervalProcessedPages = 0;
			intervalProcessedSentences = 0;
			intervalProcessedTextChars = 0;
			lastPrintedTime = System.currentTimeMillis();
		}
	}
	
	protected void printStatistics()
	{
		System.out.println();
		System.out.println("AT: "+(System.currentTimeMillis()-startTime)+" after: "+(System.currentTimeMillis()-lastPrintedTime)+"ms");
		System.out.println("TOTAL:   pages: "+totalProcessedPages+"; sentences: "+totalProcessedSentences+"; chars: "+totalProcessedTextChars);
		System.out.println("CURRENT: pages: "+intervalProcessedPages+"; sentences: "+intervalProcessedSentences+"; chars: "+intervalProcessedTextChars);
		System.out.println();
	}
}
