package threadpra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.activation.FileDataSource;

import com.sun.net.ssl.internal.www.protocol.https.Handler;



public class pitchadj extends Thread {
	BufferedReader in ;
	PrintWriter out ;
	flag p1=new flag();
	public pitchadj(Socket ss,flag p1) throws IOException{
		in = new BufferedReader(new 
				InputStreamReader(ss.getInputStream()));
		out = new PrintWriter(
				new OutputStreamWriter(ss.getOutputStream()));
		this.p1=p1;
	}
	public pitchadj() {
		
	}
	
	int sss,bb;
	

	
	
	
	
	public  void  run() {
		
		
		
		String str = null;
		double x = 0;
		boolean done=false;
	while(true){
		int t=0;
			
		while(p1.getnp()==false){
		//wait
			try {	
				sleep(1000);
				t++;
				
				if(t>60){
					p1.setfi(true);
				 Thread.currentThread().interrupt();  
				 System.out.println("adj 斷線");
				break;
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(p1.getfi()==true){break;}
		sss=0; bb=0;
		//nextplayer=false;
		
		p1.setp(false);
		p1.setbg(true);
	
		while(true){
			//System.out.print(CounterServer.getb()+" ");
			try {
				
				
				sleep(3200);
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		while(p1.getp()==false){
		if(p1.getbg()==true){
			
			p1.setbg(false);
			//System.out.print(CounterServer.getb()+" ");
		while(done==false){ // 計時並判斷
			
			if(p1.getp()==true)break;
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x=x+0.1;
			//if(((int)(x*10))%10==0)
			//{System.out.print((int)x+"*");}
			if(x>=1&&x<=2.2&&p1.getrev().equals("5")&&done==false){
				out.println("(揮棒太早)"+"\r\n");
				out.flush();
				done=true;
			}
			if(x<=3.7&&x>=2.2&&p1.getrev().equals("5")&&done==false){
				out.println("(揮棒過早)揮棒落空 好球");
				out.flush();
				done=true;
				sss++;
				out.println(sss+" 好球 "+bb+" 壞球"+"\r\n");
				out.flush();
			}
			else if(x>=3.7&&x<=4.8){
				
				if(p1.getrev().equals("5")&&done==false){
				out.println("打擊出去 "+randeven(1));
				out.flush();
				done=true;
				out.println(sss+" 好球 "+bb+" 壞球"+"\r\n");
				out.flush();
				//EchoThread.rev=null;
				}
			}
			else if(x>=4.8&&x<=5.3&&p1.getrev().equals("5")&&done==false){
				
				out.println("(揮棒稍晚)軟弱滾地球 刺殺出局");
				out.flush();
				done=true;
				p1.setp(true);
			}
			//沒揮棒
			else if(x>=5.3&&done==false){
				out.println(randeven(2)+"");
				out.flush();
				//System.out.print("球到手套了");
				done=true;
				out.println(sss+" 好球 "+bb+" 壞球"+"\r\n");
				out.flush();
			}
			if(sss==3){
				out.println("3振出局");
				out.flush();
				done=true;
				p1.setp(true);
			}
			if(bb==4){
				out.println("保送");
				out.flush();
				done=true;
				p1.setp(true);
			}
//				else System.out.print("*** ");
			
			
			
		}
		x=0;
		p1.setr("0");
		//sleep(2000);
		done=false;
		if(p1.getp()==true)break;
		
		
	   }
	 }//now player
		break;
	}
		p1.setnp(false);
		out.println("3");//傳出3代表結束一個一打席
		out.flush();
		
	}//nextplayer
	
	}
	public String randeven(int evan){
		int q=(int)(Math.random()*11+1);
		int t=(int)(Math.random()*10+1);
		String r = null;
		switch(evan)
		{	
		case 1:	
			if(q>=1&&q<=4)
			{r="安打!";p1.setp(true);}
			else if(q>=5&&q<=9)
			{r="接殺!";p1.setp(true);}
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