package com.chat.model;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client extends Frame{
	TextField  file=new TextField();//输入框
	TextArea area=new TextArea();
	Socket sc;
	InputStream in;
	OutputStream os;
	File log;
	FileReader fr;//读取日志文件流
	String name;//定义姓名
	boolean isConnect;
	public Client(String name){
		//弹出框
		this.name =name;
		setTitle("聊天室---"+name);
		setSize(400,300);
		//居中
		setLocationRelativeTo(null);
		//大小固定
		setResizable(false);
		//可见
		setVisible(true);
		add(file,BorderLayout.SOUTH);
		add(area,BorderLayout.NORTH); 
		//可调大小·
		pack();
		area.setEditable(false);//只读
		this.addWindowListener(new WindowAdapter() {
			
			
			public void windowClosing(WindowEvent e) {
				String xx="下线了";
				try {
					os.write(xx.getBytes());
					isConnect=false;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		//输入输出流初始化
		init();
		new Thread(new ResThread()).start();//new出一个线程
		//输入框的监听事件
		file.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String input=file.getText();//得到发送数据
				try {
					os.write(input.getBytes());			
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				file.setText("");
			}
		});
	}
	
	class ResThread implements Runnable{
		@Override
		public void run() {
			byte[] b=new byte[1024];
			try {
				log=new File(name+".txt");
				//判断日志否存在，如存在读取日志
				if(log.exists()){
					System.out.println("已存在");
					fr=new FileReader(log);
					char[] cbuf=new char[1024];
					fr.read(cbuf);
					String st=new String(cbuf);
					area.append(st);
				}
				while(isConnect){
					//读取服务器返回数据
					int len = in.read(b);
					String back=new String(b,0,len);
					area.append(back+"\n");			
				
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	//初始化代码
	public  void init(){
		try {
			sc=new Socket("127.0.0.6",2017);
			os=sc.getOutputStream();
			in=sc.getInputStream();
			isConnect=true;
			os.write(name.getBytes());//将用户传递给客户端
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
