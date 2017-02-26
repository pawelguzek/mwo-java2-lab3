package pl.edu.agh.mwo.java.crawler;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Crawler {

	protected String urlToProcess;
	protected TextExtractor textExtractor;

	public Crawler(String initUrl) throws MalformedURLException
	{
		urlToProcess = initUrl;
		textExtractor = new TextExtractor();
	}

	
	public void run () throws IOException
	{

		Document doc = null;
		doc = Jsoup.connect(urlToProcess).get();

		
		String[] sentences = textExtractor.extractText(doc);
		
		char charToFind = 'p';		
		for(int i = 0 ; i < sentences.length ; i++)
		{
			int charCount=0;
			for( int j = 0; j < sentences[i].length(); j++){
				if(sentences[i].charAt(j) == charToFind)
					charCount ++;
			}
			if(charCount > 15)
				System.out.println(sentences[i]);
			
//			if(sentences[i].contains("gry")){
//				
//			System.out.println(sentences[i]);
//			}
//			////////// ?? 

		}	
		
	}
	

}
