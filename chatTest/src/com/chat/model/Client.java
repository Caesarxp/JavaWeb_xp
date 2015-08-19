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
	TextField  file=new TextField();//�����
	TextArea area=new TextArea();
	Socket sc;
	InputStream in;
	OutputStream os;
	File log;
	FileReader fr;//��ȡ��־�ļ���
	String name;//��������
	boolean isConnect;
	public Client(String name){
		//������
		this.name =name;
		setTitle("������---"+name);
		setSize(400,300);
		//����
		setLocationRelativeTo(null);
		//��С�̶�
		setResizable(false);
		//�ɼ�
		setVisible(true);
		add(file,BorderLayout.SOUTH);
		add(area,BorderLayout.NORTH); 
		//�ɵ���С��
		pack();
		area.setEditable(false);//ֻ��
		this.addWindowListener(new WindowAdapter() {
			
			
			public void windowClosing(WindowEvent e) {
				String xx="������";
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
		//�����������ʼ��
		init();
		new Thread(new ResThread()).start();//new��һ���߳�
		//�����ļ����¼�
		file.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String input=file.getText();//�õ���������
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
				//�ж���־����ڣ�����ڶ�ȡ��־
				if(log.exists()){
					System.out.println("�Ѵ���");
					fr=new FileReader(log);
					char[] cbuf=new char[1024];
					fr.read(cbuf);
					String st=new String(cbuf);
					area.append(st);
				}
				while(isConnect){
					//��ȡ��������������
					int len = in.read(b);
					String back=new String(b,0,len);
					area.append(back+"\n");			
				
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	//��ʼ������
	public  void init(){
		try {
			sc=new Socket("127.0.0.6",2017);
			os=sc.getOutputStream();
			in=sc.getInputStream();
			isConnect=true;
			os.write(name.getBytes());//���û����ݸ��ͻ���
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
