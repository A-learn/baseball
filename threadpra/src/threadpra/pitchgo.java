package threadpra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import com.sun.org.apache.bcel.internal.generic.BALOAD;

public class pitchgo extends Thread{
	BufferedReader in ;
	PrintWriter out ;
	 
	public pitchgo(Socket ss) throws IOException{
		in = new BufferedReader(new 
				InputStreamReader(ss.getInputStream()));
		out = new PrintWriter(
				new OutputStreamWriter(ss.getOutputStream()));
	}
	public void run() {
		out.println("成功進入! 請準備打擊  請默數傳來秒數揮擊  按5揮棒");
		out.flush();
		try {
			Thread.sleep(5200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(pitchadj.player==false)
		{if(pitchadj.player==true)
		{break;}
			out.println("球投出! 5秒後到");
			out.flush();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//out.println("ball come!!");
			//out.flush();
			try {
				Thread.sleep(800);
				if(pitchadj.player==true)
				{break;
				}
				
				out.println("2秒後投出下一球 ");
				out.flush();
				Thread.sleep(2000);
				CounterServer.setb(true);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	  }
	}
	
	
}
