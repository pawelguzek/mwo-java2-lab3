package pl.edu.agh.mwo.java.crawler;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class CrawlerStarter {

	public static void main(String[] args) throws IOException 
	{
		
		Crawler c = new Crawler("http://www.onet.pl", new TextExtractor(), new ConsoleResultsPrinter());
		
		c.addSentenceFinder(new SentenceByWordFinder("szpital"));
		c.addSentenceFinder(new SentenceByCharCountFinder(10, 'd'));
			
		c.run();

	}
}
