package threadpra;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoThread extends Thread {
	BufferedReader in ;
	PrintWriter out ;
	Socket ss2=null;
	flag p1=new flag();
	public EchoThread(Socket ss,flag p1) throws IOException{
		in = new BufferedReader(new 
				InputStreamReader(ss.getInputStream()));
		out = new PrintWriter(
				new OutputStreamWriter(ss.getOutputStream()));
		ss2=ss;
		this.p1=p1;
	}
	public EchoThread(){}
	private String rev="NULL";
//	public  void setr(String x){
//		rev=x;
//	}
//	public String getrev(){
//		return rev;
//	}
	
	public void run() {
		try {
			
			
			while(true){
				
				rev = in.readLine();
				p1.setr(rev);
				System.out.println("Server收到:"+rev);
				
				if(rev.equals("3")==true)
				{System.out.print(" 下一打席");}
				if(rev.equals("np"))
				{System.out.print("下一打席");
					
					p1.setnp(true);
					
					rev="";
				
				}
				
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
