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
	
	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("localhost", 3335);
			BufferedReader in = new BufferedReader(new 
					InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(s.getOutputStream()));
			Scanner c=new Scanner(System.in);
			
			clithread cli =new clithread(s);
			cli.start();
			
			
			while(true){
				String cc=c.next();
				out.println(cc);
				out.flush();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
