package threadpra;

//package com.ch07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class CounterServer {
String fileName = "counter.txt";
BufferedReader in ;
PrintWriter out ;
AddThread add = null;
mpcontrol mt= null;
EchoThread echo = null;
Socket socket=null;
public void listen() throws IOException {
  File file = new File(fileName);
  checkFile(file);
  int xxx=0;
  try {
    ServerSocket server = new ServerSocket(1234);
    while (true) {
      System.out.println("等待連線中...");
      socket = server.accept();
      System.out.print("..");
  
      flag p1=new flag();
      
//      EchoThread echo = new EchoThread(socket);
     
    

       add = new AddThread(file);
	  mt= new mpcontrol(socket,p1);
	  echo = new EchoThread(socket,p1);
	  add.start();
	  mt.start();
	  echo.start();
//	  in = new BufferedReader(new 
//				InputStreamReader(socket.getInputStream()));
//	  out = new PrintWriter(
//				new OutputStreamWriter(socket.getOutputStream()));
//	  out.println("歡迎進入! 請準備打擊 按開始鍵開始 之後請默數傳來秒數揮擊");
//		out.flush();
//	  while(true){
//		  String msg=in.readLine();
//		  if(msg.equals("start")==true){
//			  AddThread add = new AddThread(file);
//			  mpcontrol mt= new mpcontrol(socket);
//			  add.start();
//			  mt.start();
//			  break;
//		  }
//	  }
	  
	 
    }
  } catch (IOException e) {
    e.printStackTrace();
    System.out.println("連線錯誤");
    out.close();
    in.close();
    add.interrupt();
    mt.interrupt();
    echo.interrupt();
    socket.close();
    
  }
}

public void checkFile(File file) {
  if (!file.exists()) {
    try {
      FileWriter out = new FileWriter(file, false);
      out.write("0\n");
      out.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class AddThread extends Thread {
  File file;

  public AddThread(File file) {
    this.file = file;
  }

  public void run() {
    synchronized (file) {
      System.out.println(getName() + "開始存取");
      BufferedReader in = null;
      FileWriter out = null;
      try {
        in = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(in.readLine());
        in.close();
        n++;
        out = new FileWriter(file, false);
        out.write(String.valueOf(n) + "\n");
        out.flush();
        out.close();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println(getName() + "結束存取");
    }
  }
}

public static void main(String[] args) {
  CounterServer counter = new CounterServer();
  try {
	counter.listen();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}