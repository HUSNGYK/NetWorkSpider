package spider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import spider.LinkQueue;
public class PageRank {
static Map<String,Double> map=new HashMap<String,Double>();
public static double alpha = 0.85;  
public static void addPr(String url,Double pr){
		map.put(url, pr);
}
public static String findMaxValue(Map<String,Double> map1){
//		@SuppressWarnings({ "unused", "unchecked" })
//		List<Map.Entry<String, Double>> infoIds =
//			    new ArrayList<Map.Entry<String, Double>>(map.entrySet());
//		Collections.sort(infoIds, new Comparator<Map.Entry<String, Double>>() {   
//		    public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {      
//		        //return (o2.getValue() - o1.getValue()); 
//		        return (o1.getKey()).toString().compareTo(o2.getKey());
//		    }
//		}); 
		
//		 String id = infoIds.get(0).toString();
		 
//		 System.out.println("id: "+id);
    Iterator<String> iterator = map1.keySet().iterator();  
    double maxValue=0.0;
    String maxKey=null;
    while (iterator.hasNext()) {    
		  Object key1 = iterator.next();   
		  if(map1.get(key1)>maxValue&& !LinkQueue.getVisitedUrl().contains(key1)){
			  maxValue=(double) map1.get(key1);
	   		  maxKey=(String) key1;
		  }
     } 
 	 
// 	 System.out.println("MAX is :"+maxKey+" "+map1.get(maxKey));
	return maxKey;    
		
	}
public static double countPr(Map<String,Double> map1,String url1,int outLinkNum){
	   double dl=map1.get(url1);
	    double temp=dl/outLinkNum;
	    temp=1-alpha+alpha*temp;
	    return temp;
	     
	}
public static Map<String, Double> getMap() {
	return map;
}
public static void setMap(Map<String, Double> map) {
	PageRank.map = map;
}
public static double getAlpha() {
	return alpha;
}
public static void setAlpha(double alpha) {
	PageRank.alpha = alpha;
}

}
