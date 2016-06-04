package yzgjj;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

public class Main {
	final static Logger log = Logger.getLogger(Main.class);
	
	final static Integer threads=10;
	
	public static void main(String[] args) throws IOException {
		
		final Crack crack =new Crack();
		
	
		
		final List<String> passwords = crack.getPasswords("d:\\passwords.txt");
		
		for(int i=0;i<threads;i++){
			int b=(passwords.size()/threads)*i;
			int e=(passwords.size()/threads)*(i+1);
			new Thread(){
				public void run() {
					try {
						crack.doCrack(passwords.subList(b, e), "3210841212");
					} catch (Exception e) {
						log.info(this);
					}
				}
				
			}.start();
		}
	}

}
