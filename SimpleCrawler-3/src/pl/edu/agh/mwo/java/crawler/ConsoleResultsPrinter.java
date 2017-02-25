package pl.edu.agh.mwo.java.crawler;

import java.util.List;

public class ConsoleResultsPrinter 
{

	public void print(String sentence)
	{
		System.out.println(sentence);
	}

	public void print(List<String> sentences, String url) 
	{
		System.out.println("===============> "+Thread.currentThread().getName()+" ==> " +url);
		for (String sentence : sentences)
		{
			print (sentence);
		}		
	}
}
