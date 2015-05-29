package spider;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.htmlparser.util.ParserException;

public class StartOperation {
	public static void operation(String startUrl) throws Exception{
		HttpClient httpclient=new DefaultHttpClient();

		HttpGet httpget = null;
		try{
		 httpget = new HttpGet(startUrl);
		 LinkQueue.addUnVisitedUrl(startUrl);
		}catch(Exception e){
			System.out.println("you are wrong");
		}
		HttpResponse response = null;
		try {
			response = httpclient.execute(httpget);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int statueCode=response.getStatusLine().getStatusCode();
		if(statueCode==200){
			    HttpEntity entity = response.getEntity();  
			    System.out.println(response.getStatusLine());  
			    if (entity != null) {
			    	
//			    	   System.out.println("Response content length: " + entity.getContentLength());  
			    	 
					  String UrlString=EntityUtils.toString(entity);
					  int n=LinkQueue.getUnVisitedUrlNum();
					
//					  System.out.println("未访问的URL before dequeue: ");
//					  System.out.println(LinkQueue.getUnVisitedUrl());	
					  String url= (String) LinkQueue.unVisitedUrlDeQueue();
					  LinkQueue.addVisitedUrl(url);
//					  System.out.println("已访问过的URL After dequeue： ");
//					  System.out.println(LinkQueue.getVisitedUrl());
					  PageRank.addPr(url, 1.0);
					  HTMLParserTool.extracLinks(url);
//					  System.out.println("未访问的URL: ");
//					  System.out.println(LinkQueue.getUnVisitedUrl());
//					  System.out.println(LinkQueue.getVisitedUrlNum());
//					  LinkQueue.removeVisitedUrl(url);
//					  System.out.println("已访问过的URL: ");
//					  System.out.println(LinkQueue.getVisitedUrl());	
		               //System.out.println(EntityUtils.toString(entity));  
		               EntityUtils.consume(entity); 

		             
		               MyCrawler.urlCrawler();
//		               HTMLParserTool.extracLinks(url);
		               System.out.println(PageRank.getMap());
			    }
		}
		//System.out.println("response"+response.toString());
		//System.out.println("After remove");


			}

}
