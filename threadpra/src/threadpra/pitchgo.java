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
	 flag p1=new flag();
	public pitchgo(Socket ss,flag p1) throws IOException{
		in = new BufferedReader(new 
				InputStreamReader(ss.getInputStream()));
		out = new PrintWriter(
				new OutputStreamWriter(ss.getOutputStream()));
		this.p1=p1;
	}
	public pitchgo(boolean b) throws IOException{
		setnp(b);
	}
	protected boolean nextplayer=true;
	public boolean getnp(){
		return nextplayer;
	}
	public void setnp(boolean b){
		nextplayer=b;
	}
	
	
	public void run() {
		
//		out.println("���\�i�J! �зǳƥ���  ���}�l��}�l ���q�ƶǨӬ�ƴ���  ��5����");
//		out.flush();
//		while(EchoThread.rev.equals("start")==false){}
		
		while(true){
			
			while(p1.getnp()==false){
				//wait
				if(p1.getfi()==true)
					{Thread.currentThread().interrupt();  
					System.out.println("斷線go");
					break;
					}
				}
			
			if(p1.getfi()==true)
			{Thread.currentThread().interrupt();  
				break;
			}
			
		out.println("請默數傳來秒數 揮擊");
		out.flush();
		try {
			Thread.sleep(3200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(p1.getp()==false)
		{if(p1.getp()==true)
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
				if(p1.getp()==true)
				{break;
				}
				
				out.println("2秒後投出下一球");
				out.flush();
				Thread.sleep(2000);
				p1.setbg(true);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	  }
		
	}
	
  }
	
	
}
