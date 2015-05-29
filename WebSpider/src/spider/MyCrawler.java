package spider;
import org.htmlparser.util.ParserException;

import spider.LinkQueue;
import spider.PageRank;
public class MyCrawler {
	public static void urlCrawler() throws ParserException{
		while(!LinkQueue.unVisitedUrlIsEmpty()){
			
			String url=PageRank.findMaxValue(PageRank.map);
			 boolean isAvailabilityUrl=URLAvailability.isConnect(url);
	    	 if(isAvailabilityUrl==false)
	    		break;
			LinkQueue.addVisitedUrl(url);
			HTMLParserTool.extracLinks(url);
//			LinkQueue.removeVisitedUrl(url);
			
		}
		System.out.println("Done!");
	}
	
}


