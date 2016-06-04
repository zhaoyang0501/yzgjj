package yzgjj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Main {
	final static Logger log = Logger.getLogger("main");
	
	final static Integer threads=10;
	
	public static void main(String[] args) throws IOException {
		
		final Crack crack =new Crack();
		
	
		
		final List<String> passwords = crack.getPasswords("d:\\passwords.txt");
		log.info("passwords size"+passwords.size());
		if(passwords.size()<20)
			throw new RuntimeException("字典大小不够！");
		
		/**分割用于多线程*/
		List<List<String>> listarrays=new 	ArrayList<List<String>>();
		for(int i=0;i<threads;i++){
			 int b=(passwords.size()/threads)*i;
			 int e= i+1==threads?passwords.size():((passwords.size()/threads)*(i+1));
			 listarrays.add(passwords.subList(b+1,e));
		}
		
		
		for(final List<String> bean:listarrays){
			
			new Thread(){
				public void run() {
					try {
						crack.doCrack(bean, "3210841212");
					} catch (Exception e) {
						log.info("fuck"+this);
					}
				}
				
			}.start();
		}
	}

}
