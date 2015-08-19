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
			System.out.println("����˿���");
			while(true){
				Socket so=sc.accept();
				System.out.println("����");
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
		File log;//��־�ļ������
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
			// TODO ��д����
			byte[] buf=new byte[1024];
			int len = 0;
			try {
				len = in.read(buf);
				name=new String(buf,0,len);//�õ�����
				//������־
				log=new File(this.name+".txt");
				fo=new FileOutputStream(log,true);
			while(isConnect){
					len = in.read(buf);
					String st=new String(buf,0,len);//�ͻ��˶�ȡ������
					//��ǰʱ��
					Date d1=new Date();
					SimpleDateFormat df2=new  SimpleDateFormat("yyyy-MM-dd ' ' HH:mm:ss");
					String d=df2.format(d1)+"-----"+this.name;
					total=d+"\n"+st;//
					if("������".equals(st)){
						isConnect=false;
						arry.remove(this);//�Ƴ���ǰ�ͻ��˴���
					}
					else{
						//���͸�ÿ���ͻ���
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
		//���͸��ͻ���
		public void send(String s){
			try {
				fo.write((s+System.getProperty("line.separator")).getBytes());//��¼ÿ����־
				os.write(s.getBytes());//���͸��ͻ�
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
