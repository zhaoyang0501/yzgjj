package yzgjj;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Password {
	public static void main(String arg[]) throws ClientProtocolException, IOException{
		Long b=System.currentTimeMillis();
		for(int a=0;a<100;a++){
			Password.send("321084196709104210","3");
		}
		Long e=System.currentTimeMillis();
		System.out.println(e-b);
	}
	
	public static void post() throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();  
    	HttpGet httpget = new HttpGet("http://58.220.193.178:8880/yw/login.asp?username=321084198709104210&password=1101319");  
        // 执行get请求. 162515   
        CloseableHttpResponse response = httpclient.execute(httpget);  
        System.out.println("Response content: " + response.getFirstHeader("Content-Length"));  
        System.out.println("------------------------------------");  
	}
	
	
	public static void send(String id,String password) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();  
    	HttpGet httpget = new HttpGet("http://58.220.193.178:8880/yw/login.asp?username="+id+"&password="+password);  
        // 执行get请求.    
        CloseableHttpResponse response = httpclient.execute(httpget);  
        System.out.println("Response content: " + response.getFirstHeader("Content-Length"));  
        System.out.println("------------------------------------");  
	}
}
