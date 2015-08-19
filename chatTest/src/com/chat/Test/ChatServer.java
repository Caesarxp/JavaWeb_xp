package com.chat.Test;

import java.net.*;
import java.util.StringTokenizer;
import java.io.*;

import javax.swing.*;
import java.awt.*;
public class ChatServer extends JFrame
{   private static int clientNum=0;  //当前连接的用户数   
    private int maxClients=10;//允许连接的用户最大数
   	private ServerSocket ss;
   	private CommunicationThread[]communications;
   	private int leftID[]=new int[maxClients];
    private int IDnum=0;
   
   	public ChatServer()
	{  leftID[0]=-1;
	  try {
         ss = new ServerSocket(50000,maxClients);
      }
      // process problems creating ServerSocket
      catch( IOException ioException ) {
         System.out.println("服务器起动不成功！");
         System.exit(0);
        
      }
	  communications=new CommunicationThread [maxClients];
	  
	  for (int i=0;i<maxClients;i++) //循环等待用户连接
      { try {
      	 //等待用户连接,连接成功时创建server端通信线程并启动它
      	 communications[i]=new CommunicationThread(ss.accept(),i); 
      	 communications[i].start();
      	 
      	for (int m=0;m<clientNum;m++)    //发送给聊天的各个在线用户
		{   int biaoji=0;
			for(int j=0;j<IDnum;j++)
			{
				if(m==leftID[j])
				{
					biaoji=1;
					
					break;
				}            					
			}
			if(biaoji==0)
			{
				communications[m].output.writeUTF("水晶宫提示：#&。|。&#"+"用户"+(i+1)+"上线了；"+"在线人数为"+String.valueOf(clientNum-IDnum+1));
				
			}
			
		}
      	clientNum++;
      	 
        }
        catch( IOException ioException ) {
        
        } 
      }	  
    }
      
     private  class CommunicationThread extends Thread 
     {
     	private Socket socket;
     	private int clientID;
   	    private DataInputStream input;
        private DataOutputStream output;
        String message;
     	public CommunicationThread(Socket ss,int number)
     	{
     		socket=ss;        //取连接Socket 
     		clientID=number;  //取分配给用户的ID
     		
     		try {
     		 //从Socket得到输入/输出流	
             input = new DataInputStream( socket.getInputStream() );  
             output = new DataOutputStream( socket.getOutputStream() );  
            
            }catch( IOException ioException )
            {
             System.out.println("读写数据有问题");
            }
         
        }
        public void run()
        {     
        
        	 try {
        		  output.writeInt(clientID);//给用户发送clientID
        		  output.writeUTF("水晶宫提示：#&。|。&#"+"在线人数为"+String.valueOf(clientNum-IDnum));
 			} catch (IOException e) {
 				
 				System.out.println("clientID没有发出去");
 			}  
 			while (true) {   //循环读一用户clientID发送来的信息,发送给在线的各个用户 				
        		try {
        			
        			String message=input.readUTF();  //读用户clientID发送来的信息
        			 //发送私密消息，在私密消息发送时，加了*号
        			if(message.startsWith("*"))    
        			{
        				StringTokenizer min=new StringTokenizer(message,"*");
        				String si=min.nextToken();        				
        				int str1=Integer.parseInt(si)-1;        				
    					if(str1<clientNum)
    					{
    						message=min.nextToken();
    					    //发送给聊天的各个在线的用户
            			   int biaoji=0;
            				for(int j=0;j<IDnum;j++)
            				{
            					if(str1==leftID[j])//即私聊的人在离开的人中；
            					{
            						biaoji=1;       //若私聊的人在离开的人中，就把BIAOJI设为1，并退出这层循环。；
            						communications[clientID].output.writeUTF("水晶宫提示：#&。|。&#"+"对不起，你找的人不在线 ");
            						break;
            					}            					
            				}
            				if(biaoji==0)           
        					{            					
            					if(str1!=clientID)
            					{    
            						communications[str1].output.writeUTF("私密 "+(clientID+1)+message);
            						//System.out.println(message);
            						communications[clientID].output.writeUTF("(你发的私密信息) \n"+message);
            					}
            					else if(str1==clientID)
            					{
            						communications[clientID].output.writeUTF("水晶宫提示：#&。|。&#怎么和自己说话啊？ ");
            					}
        					}
    					}
    					else if(str1>=clientNum)
    					{    						
    							communications[clientID].output.writeUTF("水晶宫提示：#&。|。&#对不起，你找的人不在线");    					  						   						
    					}    					     			
    					
        			}
        			//发送群消息
        			else
        			{
        				for (int i=0;i<clientNum;i++)    //发送给在线的各个用户
            			{   int biaoji=0;
            				for(int j=0;j<IDnum;j++)
            				{
            					if(i==leftID[j])
            					{
            						biaoji=1;
            						
            						break;
            					}            					
            				}
            				if(biaoji==0)
        					{
        						communications[i].output.writeUTF(" "+message);
        					}            				
            			}        		
        			}      			
        			
        	    }
               
               catch( IOException ioException ) {
                //ioException.printStackTrace();
            	   //当客户端离开
            	   leftID[IDnum]=clientID;
            	   System.out.println(leftID[IDnum]+"客户下线了");
            	   for (int m=0;m<clientNum;m++)    //发送给在线的各个用户
           		{   int biaoji=0;
           			for(int j=0;j<IDnum;j++)
           			{
           				if(m==leftID[j])
           				{
           					biaoji=1;
           					
           					break;
           				}            					
           			}
           			if(biaoji==0)
           			{
           				try {
							communications[m].output.writeUTF("水晶宫提示：#&。|。&#"+"用户"+(leftID[IDnum]+1)+"下线了;"+"在线人数为"+String.valueOf(clientNum-IDnum-1));
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.print("发不出去"+(clientNum-IDnum-1)+";");
							
						}
           			}
           			
           		}
            	   IDnum++;            	  
            	   break;               
               }
               
           }
         try { 
         output.close();
         input.close();
         socket.close();
         }
         catch( EOFException ioException ) {
            System.err.println( "Client terminated connection" );
        }
         catch( IOException ioException ) {
             ioException.printStackTrace();
             System.exit( 1 );
        }	 
        
     }
      
 	}
     

	public static void main(String[] args)
	{
		new ChatServer();
		 
	}
//////
	
}