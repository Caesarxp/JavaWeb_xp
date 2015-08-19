package com.chat.login;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.chat.dao.userDao;
import com.chat.model.Client;
 
/**
 * 
 */
public class LoginUI extends JFrame {
    // �û���
    private JTextField username;
    // ����
    private JPasswordField password;
    // С����
    private JLabel jl1;
    private JLabel jl3;
    private JLabel jl4;
    // С��ť
    private JButton bu1;
    private JButton bu2;
    private userDao ud=new userDao();
 
    // ��ѡ��
//    private JCheckBox jc1;
//    private JCheckBox jc2;
 
    // �б��
//    private JComboBox jcb;
 
    /*
     * ���췽��
     */
    public LoginUI() {
        // ���ô��ڱ���
        this.setTitle("������");
        // ���������ʼ��
        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ���ò��ַ�ʽΪ���Զ�λ
        this.setLayout(null);
         
        this.setBounds(0, 0, 355, 265);
        // ���ô���ı���ͼ��
        //Image image = new ImageIcon("e:/a.gif").getImage();
        //this.setIconImage(image);
         
        // �����С���ܸı�
        this.setResizable(false);
         
        // ������ʾ
        this.setLocationRelativeTo(null);
 
        // ����ɼ�
        this.setVisible(true);
        //�رռ���
        this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//System.exit(0);
			}
		});
    }
 
    /*
     * ��ʼ������
     */
    public void init() {
    
        // ����һ������
        Container con = this.getContentPane();
        jl1 = new JLabel();
        jl1.setBounds(0, 0, 355, 265);
        // �û������¼�����
        username = new JTextField();
        username.setBounds(100, 100, 150, 20);
        // �û������¼������Աߵ�����
        jl3 = new JLabel("�û�����");
        jl3.setBounds(50, 100, 70, 20);
 
        // ���������
        password = new JPasswordField();
        password.setBounds(100, 130, 150, 20);
        // ����������Աߵ�����
       jl4 = new JLabel("���룺");
        jl4.setBounds(60, 130, 70, 20);
        // ��ť�趨
        bu1 = new JButton("��¼");
        bu1.setBounds(50, 200, 75, 20);
        // ����¼��ť���1���¼�
        bu1.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                    String getName =username.getText();
                    char[] getPwd =password.getPassword();
                    String pw=new String(getPwd);
                     //���в����ж�
                     if(pw.equals(ud.findUserByName(getName))){
                    	 Client c1=new Client(getName);
                    	 //setVisible(false);
                     }
                     else{
                    	 JOptionPane.showConfirmDialog(null, "��������û�������,c��������");
                     }
                     
            }
        });
         
         
        bu2 = new JButton("ע��");
        bu2.setBounds(230, 200, 65, 20);
        bu2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                    String getName =username.getText();
                    char[] getPwd =password.getPassword();
                    String pw=new String(getPwd);
                    //ע�ᣬ�������ݿ����
                    ud.addUser(getName, pw);
                     //JOptionPane.showConfirmDialog(null, "��������û�����"+getName);
            }
        });
         
        
        jl1.add(jl3);
        jl1.add(jl4);
        jl1.add(bu1);
        jl1.add(bu2);
        con.add(jl1);
        con.add(username);
        con.add(password);
 
    }
    
    public static void main(String[] args) {
        // ʵ��������
        LoginUI qq = new LoginUI();
    }
 
}