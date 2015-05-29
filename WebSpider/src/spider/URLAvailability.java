package spider;

import java.net.HttpURLConnection;
import java.net.URL;

public class URLAvailability {  
private static URL url;  
private static HttpURLConnection con;  
private static int state = -1;  
  
/** 
   * ���ܣ���⵱ǰURL�Ƿ�����ӻ��Ƿ���Ч, 
   * ����������������� 5 ��, ��� 5 �ζ����ɹ�����Ϊ�õ�ַ������ 
   * @param urlStr ָ��URL�����ַ 
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
//      System.out.println("URL���ã�"); 
      return true;
     }  
  break;
    }catch (Exception ex) {  
     counts++;   
//     System.out.println("URL�����ã����ӵ� "+counts+" ��");  
     urlStr = null;  
     continue;  
    }  
   }  
  if(counts==5)
	  return false;
return false;

}  
}  
