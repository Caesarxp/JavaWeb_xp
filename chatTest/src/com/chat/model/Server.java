package com.chat.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Server{
	String total;
	ArrayList<ClientThread> arry=new ArrayList<>();//
	public void start(){
		ServerSocket sc;
		try {
			sc=new ServerSocket(2017);
			System.out.println("服务端开启");
			while(true){
				Socket so=sc.accept();
				System.out.println("来了");
				ClientThread c1=new ClientThread(so);
				arry.add(c1);
				new Thread(c1).start();
						
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	class ClientThread implements Runnable{
		Socket s;
		InputStream in;
		OutputStream os;
		String name;
		File log;//日志文件储存点
		FileOutputStream fo;//
		boolean isConnect;
		ClientThread(Socket s){
			this.s=s;
			try {
				this.in=s.getInputStream();
				this.os=s.getOutputStream();
				isConnect=true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		@Override
		public void run() {
			// TODO 读写操作
			byte[] buf=new byte[1024];
			int len = 0;
			try {
				len = in.read(buf);
				name=new String(buf,0,len);//得到名字
				//生成日志
				log=new File(this.name+".txt");
				fo=new FileOutputStream(log,true);
			while(isConnect){
					len = in.read(buf);
					String st=new String(buf,0,len);//客户端读取的数据
					//当前时间
					Date d1=new Date();
					SimpleDateFormat df2=new  SimpleDateFormat("yyyy-MM-dd ' ' HH:mm:ss");
					String d=df2.format(d1)+"-----"+this.name;
					total=d+"\n"+st;//
					if("下线了".equals(st)){
						isConnect=false;
						arry.remove(this);//移除当前客户端窗口
					}
					else{
						//发送给每个客户端
						for(int i=0;i<arry.size();i++){
							ClientThread c=arry.get(i);
							c.send(total);
						}
					}
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
					
			
		}
		//发送给客户端
		public void send(String s){
			try {
				fo.write((s+System.getProperty("line.separator")).getBytes());//纪录每条日志
				os.write(s.getBytes());//发送给客户
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Server s=new Server();
		s.start();
	}

}
