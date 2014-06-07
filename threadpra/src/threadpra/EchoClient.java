//package com.ch07;
package threadpra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
	static Socket ss=null;
	public static void main(String[] args) {
		
		try {
			 ss = new Socket("203.64.183.102",1234);
			BufferedReader in = new BufferedReader(new 
					InputStreamReader(ss.getInputStream()));
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(ss.getOutputStream()));
			Scanner c=new Scanner(System.in);
			
			clithread cli =new clithread(ss);
			cli.start();
			window w=new window(clithread.str);
		
			while(true){
				String cc=c.next();
				out.println(cc);
				out.flush();
				Thread.currentThread().interrupt();  
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
