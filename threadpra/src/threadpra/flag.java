package threadpra;

public class flag {
	
	protected  boolean player=false;
	public  synchronized boolean getp(){return player;}
	public synchronized void setp(boolean b){player=b;}
	
	protected    boolean nextplayer=true;
	public  synchronized void setnp(boolean b){nextplayer=b;}
	public  synchronized boolean getnp(){return nextplayer;}
	
	protected   String rev="NULL";
	public   synchronized void setr(String x){
		rev=x;
	}
	public  synchronized String getrev(){
		return rev;
	}
	
	protected    boolean ballgo=true;
	public  synchronized void setbg(boolean b){ballgo=b;}
	public  synchronized boolean getbg(){return ballgo;}
	
	
	protected    boolean finish=false;
	public  synchronized void setfi(boolean b){finish=b;}
	public  synchronized boolean getfi(){return finish;}
	public flag(){}
}
