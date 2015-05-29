package spider;

import java.net.HttpURLConnection;
import java.net.URL;

public class URLAvailability {  
private static URL url;  
private static HttpURLConnection con;  
private static int state = -1;  
  
/** 
   * 功能：检测当前URL是否可连接或是否有效, 
   * 描述：最多连接网络 5 次, 如果 5 次都不成功，视为该地址不可用 
   * @param urlStr 指定URL网络地址 
   * @return URL 
   */  
public static synchronized boolean isConnect(String urlStr) {  
   int counts = 0;  
   if (urlStr == null || urlStr.length() <= 0) {                         
    return false;                   
   }  
   while (counts < 5) {  
    try {  
     url = new URL(urlStr);  
     con = (HttpURLConnection) url.openConnection();  
     state = con.getResponseCode();  
//     System.out.println(counts +"= "+state);  
     if (state == 200) {  
//      System.out.println("URL可用！"); 
      return true;
     }  
  break;
    }catch (Exception ex) {  
     counts++;   
//     System.out.println("URL不可用，连接第 "+counts+" 次");  
     urlStr = null;  
     continue;  
    }  
   }  
  if(counts==5)
	  return false;
return false;

}  
}  
