package pl.edu.agh.mwo.java.crawler;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Crawler {

	protected String urlToProcess;

	public Crawler(String initUrl) throws MalformedURLException
	{
		urlToProcess = initUrl;
	}

	
	public void run () throws IOException
	{

		Document doc = null;
		doc = Jsoup.connect(urlToProcess).get();

		
		String text = doc.body().text();

		String[] sentences = text.split("\\.");
		
		for(int i = 0 ; i < sentences.length ; i++)
		{
			System.out.println(sentences[i]);
			
			////////// ?? 

		}	

		
	}
}
