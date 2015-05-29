package spider;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import spider.LinkQueue;
import spider.PageRank;
import spider.StartOperation;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	   //ThreadPool
		 ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                 new ArrayBlockingQueue<Runnable>(5));
		  String[] urlArray=new String[5];
        urlArray[0]="http://www.baidu.com/";
        urlArray[1]="http://www.hao123.com/";
        urlArray[2]="http://www.youku.com/";
        urlArray[3]="http://news.sina.com.cn/";
        urlArray[4]="http://www.renren.com/";
//        urlArray[5]="http://su.58.com/";
//        urlArray[6]="http://military.china.com/zh_cn/";
//        urlArray[7]="http://mail.163.com/";
//        urlArray[8]="http://www.qidian.com/Default.aspx";
//        urlArray[9]="http://www.eastmoney.com/";
        for(int i=0;i<urlArray.length;i++){
     	   try {
     		   T t=new T(urlArray[i]);
     		  executor.execute(t);
              System.out.println("线程池中线程数目："+executor.getPoolSize()+"， 队列中等待执行的任务数目："+
              executor.getQueue().size()+"， 已执行完的任务数目："+executor.getCompletedTaskCount());
     	} catch (Exception e) {
     		// TODO Auto-generated catch block
     		e.printStackTrace();
     	}
        }
        executor.shutdown();

//        String[] urlArray=new String[2];
//        urlArray[0]="http://www.baidu.com/";
//        urlArray[1]="http://www.hao123.com/";
//        for(int i=0;i<urlArray.length;i++){
////     	   try {
////     		   T t=new T(urlArray[i]);
////     		   t.setName(urlArray[i]);
////     		   t.start();
////     	} catch (Exception e) {
////     		// TODO Auto-generated catch block
////     		e.printStackTrace();
////     	}
//        }
}
}
class T extends Thread{  
    //重写run()方法  
	private String startUrl;
	public T(String startUrl){
		this.startUrl=startUrl;
	}
    public void run(){  
    	System.out.println("thread name: "+this.getName());

    	try {
			StartOperation.operation(this.startUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//try {
//	Thread.sleep(1000);
//} catch (InterruptedException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
    }  
} 