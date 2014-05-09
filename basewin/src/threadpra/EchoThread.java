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
	public EchoThread(Socket ss) throws IOException{
		in = new BufferedReader(new 
				InputStreamReader(ss.getInputStream()));
		out = new PrintWriter(
				new OutputStreamWriter(ss.getOutputStream()));
	}
	static String rev="NULL";
	public void run() {
		try {
			
			while(true){
				
				rev = in.readLine();
				System.out.println("Server收到:"+rev);
				if(EchoThread.rev.equals("3")==true)
				{System.out.print(" 下一打席");}
			}
			
		} catch (IOException e) {
			System.out.println("發生傳輸例外");
		}
	}
}
