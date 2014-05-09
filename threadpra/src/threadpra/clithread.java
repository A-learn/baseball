package threadpra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class clithread extends Thread{

		BufferedReader in ;
		PrintWriter out ;
		public clithread(Socket ss) throws IOException{
			in = new BufferedReader(new 
					InputStreamReader(ss.getInputStream()));
			out = new PrintWriter(
					new OutputStreamWriter(ss.getOutputStream()));
		}
		public void run() {
			try {
				out.println("Hello server");
				out.flush();
//				System.out.println("已送出Hello");
				while(true){
					
				String str = in.readLine();
				System.out.println("client收到:"+str);
				if(str.equals("3"))
				{System.out.print("出局! 下一打席");}
				}
				
			} catch (IOException e) {
				System.out.println("發生傳輸例外");
			}
		}
	
	

}
