package spider;

import java.net.URL;
import java.util.Set;

import javax.xml.soap.Node;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.NodeList;



//import org.htmlparser.util.NodeList;
import spider.LinkQueue;
import spider.PageRank;
import spider.URLAvailability;
public class HTMLParserTool {
	
@SuppressWarnings("unused")
public static void extracLinks(String url) throws ParserException{

     try{
    	
    		Parser parser=new Parser(url);
    	     //parser have  possibility have no resource
    	    
    		  parser.setEncoding("gb2312");  
    	      
    	      NodeFilter frameFilter = new NodeFilter() {  
    	            
    	          private static final long serialVersionUID = 1L;  

//    	          public boolean accept(Node node) {  
//    	              if (node.getTextContent().startsWith("frame src=")) {  
//    	                  return true;  
//    	              } else {  
//    	                  return false;  
//    	              }  
//    	          }

    			@Override
    			public boolean accept(org.htmlparser.Node arg0) {
    				// TODO Auto-generated method stub
    				return false;
    			}
    	      };
    	      OrFilter linkFilter = new OrFilter(new NodeClassFilter(  
    	              LinkTag.class), frameFilter);  
    	      NodeList list = parser.extractAllNodesThatMatch(linkFilter);  
    	      int i;
    	      int outLinkNum=((org.htmlparser.util.NodeList) list).size();
//    	      System.out.println("outLinkNum: "+outLinkNum);
    	      for ( i = 0; i < ((org.htmlparser.util.NodeList) list).size(); i++) {  
    	    	  LinkTag tag =  (LinkTag) list.elementAt(i);  
    	          if (tag instanceof LinkTag)  
    	          {  
//    	        	  System.out.println("LinkTag");
    	              LinkTag link = (LinkTag) tag;  
    	              String linkUrl = link.getLink();  
    	              String text = link.getLinkText();  
    	              char firstLetter;
//    	              System.out.println(text + " : " + linkUrl); 
    	              if(linkUrl==null||"".equals(linkUrl)||text==null||"".equals(text))
    	            	  continue;
    	              else {
    	            	  firstLetter=linkUrl.charAt(0);
//    	            	  System.out.println(firstLetter);
    	            	 
    	              }
    	            	   

//    	              System.out.println(text + " : " + firstLetter); 

    	              //collect linkUrl
    	              if(firstLetter=='h'){
    	              LinkQueue.addUnVisitedUrl(linkUrl);
    	              double temp = PageRank.countPr(PageRank.map, url,outLinkNum);
    	              PageRank.addPr(linkUrl, temp);
    	              }
    	            
    	              
    	          }  else  
    	          {  
    	              //  <frame src="test.html"/>  
//    	        	  System.out.println("frame");

    	              String frame = tag.getText();  
    	              int start = frame.indexOf("src=");  
    	              frame = frame.substring(start);  
    	              int end = frame.indexOf(" ");  
    	              if (end == -1)  
    	                  end = frame.indexOf(">");  
    	              frame = frame.substring(5, end - 1);  
    	              System.out.println(frame);  
    	          }  
    	      }  
    	      
     } catch (ParserException e) {  
          e.printStackTrace();  
      }  
}
}
