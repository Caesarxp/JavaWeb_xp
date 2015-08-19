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
    // 用户名
    private JTextField username;
    // 密码
    private JPasswordField password;
    // 小容器
    private JLabel jl1;
    private JLabel jl3;
    private JLabel jl4;
    // 小按钮
    private JButton bu1;
    private JButton bu2;
    private userDao ud=new userDao();
 
    // 复选框
//    private JCheckBox jc1;
//    private JCheckBox jc2;
 
    // 列表框
//    private JComboBox jcb;
 
    /*
     * 构造方法
     */
    public LoginUI() {
        // 设置窗口标题
        this.setTitle("聊天室");
        // 窗体组件初始化
        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置布局方式为绝对定位
        this.setLayout(null);
         
        this.setBounds(0, 0, 355, 265);
        // 设置窗体的标题图标
        //Image image = new ImageIcon("e:/a.gif").getImage();
        //this.setIconImage(image);
         
        // 窗体大小不能改变
        this.setResizable(false);
         
        // 居中显示
        this.setLocationRelativeTo(null);
 
        // 窗体可见
        this.setVisible(true);
        //关闭监听
        this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//System.exit(0);
			}
		});
    }
 
    /*
     * 初始化方法
     */
    public void init() {
    
        // 创建一个容器
        Container con = this.getContentPane();
        jl1 = new JLabel();
        jl1.setBounds(0, 0, 355, 265);
        // 用户号码登录输入框
        username = new JTextField();
        username.setBounds(100, 100, 150, 20);
        // 用户号码登录输入框旁边的文字
        jl3 = new JLabel("用户名：");
        jl3.setBounds(50, 100, 70, 20);
 
        // 密码输入框
        password = new JPasswordField();
        password.setBounds(100, 130, 150, 20);
        // 密码输入框旁边的文字
       jl4 = new JLabel("密码：");
        jl4.setBounds(60, 130, 70, 20);
        // 按钮设定
        bu1 = new JButton("登录");
        bu1.setBounds(50, 200, 75, 20);
        // 给登录按钮添加1个事件
        bu1.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                    String getName =username.getText();
                    char[] getPwd =password.getPassword();
                    String pw=new String(getPwd);
                     //进行查找判断
                     if(pw.equals(ud.findUserByName(getName))){
                    	 Client c1=new Client(getName);
                    	 //setVisible(false);
                     }
                     else{
                    	 JOptionPane.showConfirmDialog(null, "您输入的用户名错误,c重新输入");
                     }
                     
            }
        });
         
         
        bu2 = new JButton("注册");
        bu2.setBounds(230, 200, 65, 20);
        bu2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                    String getName =username.getText();
                    char[] getPwd =password.getPassword();
                    String pw=new String(getPwd);
                    //注册，插入数据库语句
                    ud.addUser(getName, pw);
                     //JOptionPane.showConfirmDialog(null, "您输入的用户名是"+getName);
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
        // 实例化对象
        LoginUI qq = new LoginUI();
    }
 
}