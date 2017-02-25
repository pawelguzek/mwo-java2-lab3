package pl.edu.agh.mwo.java.crawler;

import java.util.ArrayList;
import java.util.Collection;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UrlFinder {

	public Collection<String> find(Document doc) 
	{
		ArrayList<String> results = new ArrayList<>();

		Elements links = doc.select("a");
		for(Element link : links)
			results.add(link.attr("abs:href"));		
		
		return results;			
	}
		
}
