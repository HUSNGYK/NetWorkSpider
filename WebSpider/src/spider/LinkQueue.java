package spider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import spider.PageRank;
public class LinkQueue {
	//已访问的URL集合
private static Set visitedUrl=new HashSet();

	//待访问的URL集合
//优先级队列
private static Queue unVisitedUrl=new PriorityQueue();
public static Queue getUnVisitedUrl() {
	return unVisitedUrl;
}

public static void setUnVisited(Queue unVisitedUrl) {
	LinkQueue.unVisitedUrl = unVisitedUrl;
}

public static Set getVisitedUrl() {
	return visitedUrl;
}
public static void addVisitedUrl(String url){
	visitedUrl.add(url);
}
public static void removeVisitedUrl(String url){
	visitedUrl.remove(url);
}
public static Object unVisitedUrlDeQueue(){
	
	return unVisitedUrl.remove();
}

public static void addUnVisitedUrl(String url){
	if(url!=null&& !url.trim().equals("")&&!visitedUrl.contains(url)&&!unVisitedUrl.contains(url))
	unVisitedUrl.add(url);
}
public static int getVisitedUrlNum(){
	return visitedUrl.size();
}
public static int getUnVisitedUrlNum(){
	return unVisitedUrl.size();
}
public static boolean unVisitedUrlIsEmpty(){
	return unVisitedUrl.isEmpty();
}
public static void setVisitedUrl(Set visitedUrl) {
	LinkQueue.visitedUrl = visitedUrl;
}


}
