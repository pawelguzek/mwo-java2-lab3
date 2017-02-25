package pl.edu.agh.mwo.java.crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;



public class Crawler {

	protected TextExtractor textExtractor;
	protected ConsoleResultsPrinter consoleResultsPrinter;
	protected List<SentenceFinder> sentenceFinders; 
	
	Set<String> urlsToProcess = new HashSet<>();
	Set<String> processedUrls = new HashSet<>();
	protected UrlFinder urlFinder;
	protected PerformanceLogger performanceLogger;
	
	protected int urlsToProcessCount = 1; 


	public Crawler(String urlToProcess, TextExtractor textExtractor, ConsoleResultsPrinter consoleResultsPrinter, UrlFinder urlFinder, PerformanceLogger performanceLogger) 
	{
		this.urlsToProcess.add(urlToProcess);
		this.textExtractor = textExtractor;
		this.consoleResultsPrinter = consoleResultsPrinter;
		this.urlFinder = urlFinder;
		this.performanceLogger = performanceLogger;
		sentenceFinders = new ArrayList<>();
	}
	
	public void addSentenceFinder(SentenceFinder sentenceFinder)
	{
		sentenceFinders.add(sentenceFinder);
	}
	
	public void run()
	{	
		while (!urlsToProcess.isEmpty() && processedUrls.size() <= urlsToProcessCount )
		{
			String urlToProcess = urlsToProcess.iterator().next();
			urlsToProcess.remove(urlToProcess);
			processedUrls.add(urlToProcess);
			
			Document doc = null;
			try {
				doc = Jsoup.connect(urlToProcess).get();
			} catch (Exception e) {
				continue;
			}
			
			List<String> sentences = textExtractor.extractText(doc);
			
			performanceLogger.addProcessedPage(sentences);
			
			for(SentenceFinder sentenceFinder : sentenceFinders)
				consoleResultsPrinter.print(sentenceFinder.findSentences(sentences), urlToProcess);
			
			for (String newUrl : urlFinder.find(doc))
			{
				if (!urlsToProcess.contains(newUrl) && !processedUrls.contains(newUrl))
					urlsToProcess.add(newUrl);
			}

		}
	}

	public int getUrlsToProcessCount() {
		return urlsToProcessCount;
	}

	public void setUrlsToProcessCount(int urlsToProcessCount) {
		this.urlsToProcessCount = urlsToProcessCount;
	}

}
