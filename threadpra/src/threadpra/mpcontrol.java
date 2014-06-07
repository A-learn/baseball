package threadpra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class mpcontrol extends Thread{
	BufferedReader in ;
	PrintWriter out ;
	Socket ss;
	flag p1=new flag();
	pitchadj pa=null;
	pitchgo pgo =null;
	public mpcontrol(Socket ss,flag p1) throws IOException{
		in = new BufferedReader(new 
				InputStreamReader(ss.getInputStream()));
		out = new PrintWriter(
				new OutputStreamWriter(ss.getOutputStream()));
		this.ss=ss;
		this.p1=p1;
	}
	
//	static int sss,bb;
//	static boolean player=false;
	public void run(){
		
		try {int c=0;
			String stname="pa";
			out.println("成功進入! 請準備打擊 按開始鍵開始 之後請默數傳來秒數揮擊");
			out.flush();
			
			while(p1.getrev().equals("start")==false){
					if(p1.getfi()==true)
					{						
						Thread.currentThread().interrupt(); 
						 System.out.println("mp斷線");
						break;
					}
					
				}
			
			p1.setr("0");
			pitchadj pa=new pitchadj(ss,p1);
			pitchgo pgo =new pitchgo(ss,p1);
			
			pa.start();
			pgo.start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pa.interrupt();
			pgo.interrupt();
		}
	}

}
