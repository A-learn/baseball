package threadpra;

import java.awt.ScrollPane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class clithread extends Thread{

		BufferedReader in ;
		PrintWriter out ;
		private JFrame frame;
		private JTextField textField;
		private JTextArea textArea;
		private ScrollPane scrollPane;
		Socket ss2=null;
		
		public clithread(Socket ss) throws IOException{
			in = new BufferedReader(new 
					InputStreamReader(ss.getInputStream()));
			out = new PrintWriter(
					new OutputStreamWriter(ss.getOutputStream()));
			ss2=ss;
		
		}
		
		static String str,st2="";
		public void run() {
			try {
				out.println("Hello server");
				out.flush();
				//pitchadj pi=new pitchadj(ss2);
				
//				System.out.println("已送出Hello");
				//window w=new window(clithread.str);
				while(true){
					
				 str = in.readLine();
				System.out.println("client收到:"+str);
				st2=st2+"\n"+str;
				if(str.equals("3"))
					{System.out.print("出局! 下一打席");}
				
				}
				
			} catch (IOException e) {
				System.out.println("發生傳輸例外");
				out.close();
			    try {
					in.close();
					ss2.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			    
			}
		}
		
	

}