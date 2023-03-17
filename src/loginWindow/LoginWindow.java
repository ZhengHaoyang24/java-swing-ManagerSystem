package loginWindow;

import password.*;
import homepage.*;
import time.*;

import javax.crypto.KeyAgreement;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginWindow extends JFrame {
	static int times = 0; // 记录密码输入错误次数
	
	LocalTime localTime = new LocalTime();
	JLabel jLabelTime = new JLabel(localTime.getLocalTimString());    //获取时间
	String timeString = localTime.getLocalTiminTitleString();
	
	JFrame jFrame = new JFrame();   
//	JPanel jPanel = new JPanel();
	Box daBox = Box.createVerticalBox();
	Box box = Box.createVerticalBox(); // 大box
	Box box_xia = Box.createHorizontalBox();
	Box box_timeBox = Box.createHorizontalBox();

	JTextField jTextField; // 账号框
	JLabel jLabel;
	JPasswordField jPasswordField; // 密码框
	JButton jButton; // 登录按钮
	JButton jButton2; // 修改密码按钮
	JButton forgetPasButton;  //帮助按钮

	SetButtonListener setButtonListener = new SetButtonListener();   //修改密码 实例化  监听类
	private class SetButtonListener implements ActionListener{   

		@Override
		public void actionPerformed(ActionEvent e) {    //修改密码按钮 监听器 内部类
			// TODO Auto-generated method stub
			
			SetPasWindow SetPasWindow = new SetPasWindow("修改密码");   //销毁页面  进入SetPasWindow
			dispose();
			
		}
		
	}
	
	BangzhuListener bangzhuListener = new BangzhuListener();  //监听类 帮助按钮 实例化
	private class BangzhuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {   //帮助按钮监听器 内部类
			// TODO Auto-generated method stub
			JLabel help_text = new JLabel(); 
			help_text.setText("<html>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp初始账号为：username"
					+ "<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp初始密码为：000000</html>") ;
			JDialog help_window = new JDialog(jFrame, "帮助"); 
			help_window.setBounds(650, 350, 280, 150); // 提示小窗口大小
			help_window.setVisible(true);
			help_window.add(help_text);
//			help_window.setDefaultCloseOperation(EXIT_ON_CLOSE);
						
		}	
	}
	
	DengluListener dengluListener = new DengluListener();  // 监听类  登录按钮 实例化
	private class DengluListener implements ActionListener {  // 登录按钮监听器 内部类
		@Override
 
		public void actionPerformed(ActionEvent e) {  // 登录监听 方法重写 
			
			String password = new String(jPasswordField.getPassword()); // 获取密码框输入信息
			String accou = new String(jTextField.getText()); // 获取账号框信息
			JudgePassword judgePassword = new JudgePassword(); // 实例化JudgePassword 类
			JudgeAccount judgeAccount = new JudgeAccount(); // 实例化JudgeAccount类

			try {
				if ((!judgePassword.Judge(password)) || (!judgeAccount.Judge(accou))) { // 判断密码与账号是否正确
					if (times <= 2) { // 输入错误超过1次，提示窗口
						times++;
						JLabel textJLabel2 = new JLabel("        您输入的账号或密码已错误" + times + "次,还有" + (4 - times) + 
								"次机会.");
						JDialog jDialog2 = new JDialog(jFrame, "提示");
						jDialog2.setBounds(650, 350, 300, 150); // 提示小窗口大小
						jDialog2.setVisible(true);
						jDialog2.add(textJLabel2);
						jDialog2.setDefaultCloseOperation(EXIT_ON_CLOSE);

						
					} else {  // 错误超过五次，提示是否修改密码
						JLabel textJLabel2 = new JLabel("      你的密码输入已经错误4次,请退出系统稍后再试");
						JDialog jDialog2 = new JDialog(jFrame, "提示");
						jDialog2.setBounds(650, 350, 300, 150); // 提示小窗口大小 
						jDialog2.setVisible(true);
						jDialog2.add(textJLabel2);
						jDialog2.setDefaultCloseOperation(EXIT_ON_CLOSE);
					}
 
				} else {
					
					// loading 转换页面 登陆成功  转到 homePageWindow
					HomePageWindow homePageWindow = new HomePageWindow(timeString);
					dispose();
					
				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	public LoginWindow(String s) { // 构造方法
		// TODO Auto-generated constructor stub
		super(s);
		setBounds(500, 200, 600, 450);    //界面大小

		this.init();
//		this.add(jLabelTime);
		this.add(box);
		this.add(box_xia);
		
		this.getContentPane().setBackground(new Color(137,157,192));    //改变界面颜色
		this.setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jButton2.addActionListener(setButtonListener);  //修改按钮监听事件
		jButton.addActionListener(dengluListener); // 登录按钮监听事件
		forgetPasButton.addActionListener(bangzhuListener);  //帮助按钮监听事件
//		this.setBackground(Color.yellow); //为窗体设置颜色
	}

	void init() {
		
		setLayout(new FlowLayout());

		box.add(jLabelTime);    //添加时间

		jLabel = new JLabel("账号");
		jTextField = new JTextField(20);
		JLabel jLabel2 = new JLabel("密码");
		jPasswordField = new JPasswordField(20);

		box.add(Box.createVerticalStrut(120));
		box.add(jLabel);
		box.add(jTextField);
		box.add(Box.createVerticalStrut(20));
		box.add(jLabel2);
		box.add(jPasswordField);
		box.add(Box.createVerticalStrut(100));

		                                        //向box_xia添加组件
		jButton2 = new JButton("修改密码");  //修改按钮
		jButton2.setBackground(Color.cyan);
		jButton = new JButton("登录");     //登录按钮
		jButton.setBackground(Color.green);
		forgetPasButton = new JButton("帮助");  //忘记密码按钮
		forgetPasButton.setBackground(Color.orange);
		box_xia.add(jButton2);
		box_xia.add(Box.createHorizontalStrut(100));   //按钮距离
		box_xia.add(jButton);
		box_xia.add(Box.createHorizontalStrut(100));
		box_xia.add(forgetPasButton);
		 

		daBox.add(box);
		daBox.add(box_xia);
		jFrame.add(daBox);
	}
}
