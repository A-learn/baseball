package threadpra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import com.sun.net.ssl.internal.www.protocol.https.Handler;



public class pitchadj extends Thread {
	BufferedReader in ;
	PrintWriter out ;
	public pitchadj(Socket ss) throws IOException{
		in = new BufferedReader(new 
				InputStreamReader(ss.getInputStream()));
		out = new PrintWriter(
				new OutputStreamWriter(ss.getOutputStream()));
	}
	static int sss,bb;
	static boolean player=false;
	public void run() {
		player=false;
		sss=0; bb=0;
		String str = null;
		double x = 0;
		boolean done=false;
		
		CounterServer.setb(true);
		while(true){
			//System.out.print(CounterServer.getb()+" ");
			try {
				sleep(5200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		while(player==false){
		if(CounterServer.getb()==true){
			
			CounterServer.setb(false);
			//System.out.print(CounterServer.getb()+" ");
		while(done==false){ // 計時並判斷
			
			if(player==true)break;
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x=x+0.1;
			//if(((int)(x*10))%10==0)
			//{System.out.print((int)x+"*");}
			if(x<4&&EchoThread.rev.equals("5")&&done==false){
				out.println("揮棒落空 好球");
				out.flush();
				done=true;
				sss++;
				out.println(sss+" 好球 "+bb+" 壞球");
				out.flush();
			}
			else if(x>=3.5&&x<=4.8){
				
				if(EchoThread.rev.equals("5")&&done==false){
				out.println("打擊出去 "+randeven(1));
				out.flush();
				done=true;
				out.println(sss+" 好球 "+bb+" 壞球");
				out.flush();
				//EchoThread.rev=null;
				}
			}
			else if(x>=4.8&&EchoThread.rev.equals("5")&&done==false){
				
				out.println("軟弱滾地球 刺殺出局");
				out.flush();
				done=true;
				player=true;
			}
			//沒揮棒
			else if(x>=5&&done==false){
				out.println(randeven(2)+"");
				out.flush();
				//System.out.print("球到手套了");
				done=true;
				out.println(sss+" 好球 "+bb+" 壞球");
				out.flush();
			}
			if(sss==3){
				out.println("3振出局");
				out.flush();
				done=true;
				player=true;
			}
			if(bb==4){
				out.println("保送");
				out.flush();
				done=true;
				player=true;
			}
//				else System.out.print("*** ");
			
			
			
		}
		if(player==true)break;
		x=0;
		EchoThread.rev="0";
		//sleep(2000);
		done=false;
		
	   }
	 }
		break;
	}
		out.println("3");//傳出3代表結束一個一打席
		out.flush();

		
	}
	public String randeven(int evan){
		int q=(int)(Math.random()*11+1);
		int t=(int)(Math.random()*10+1);
		String r = null;
		switch(evan)
		{	
		case 1:	
			if(q>=1&&q<=4)
			{r="安打!";player=true;}
			else if(q>=5&&q<=9)
			{r="接殺!";player=true;}
			else if(q>=10&&q<=11)
			{r= "界外!";
			if(sss<=2){sss++;}	}
//			else if(q>=10&&q<=11)
//			{r= "揮棒落空 好球";}
			break;
		case 2:
			if(t>=1&&t<=6)
			{r="好球";sss++;}
			else if(t>=7&&t<=10)
			{r="壞球";bb++;}
			break;
		}
//	System.out.print("rand"+q); 安打 接殺 界外 
		return r;
	}
	
	
}
