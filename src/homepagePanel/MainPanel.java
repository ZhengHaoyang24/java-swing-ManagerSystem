package homepagePanel;

import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import homepage.HomePageWindow;
import loginWindow.LoginWindow;
import loginWindow.SetPasWindow;
import panelFunctionScripts.HomePageSearch;
import time.LocalTime;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel {   //主页
	
	LocalTime localTime = new LocalTime();
	String timeString = localTime.getLocalTiminTitleString();

	JButton allInforButton = new JButton("显示所有信息");
	
	JButton jButton = new JButton("前往");
	JTextField jTextField = new JTextField("输入工号或姓名");
	JLabel jLabel = new JLabel("搜索");
	JButton backButton = new JButton("退出登录");
	//HomePageWindow homepage; 
	JFrame jFrame;
	
	public MainPanel(JFrame jFrame){
		this.jFrame=jFrame;
		setLayout(null);

		this.init();
		this.setBackground(new Color(137,175,155)); // 改变界面颜色
		jButton.addActionListener(goButtonListener);
		backButton.addActionListener(quitButtonListener);
		allInforButton.addActionListener(allInformationButtonListener);
	}
	
	AllinformationButtonListener allInformationButtonListener = new AllinformationButtonListener();
	private class AllinformationButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AllinformationWindow allinformationWindow = new AllinformationWindow("员工信息");   //销毁页面  进入SetPasWindow
			jFrame.dispose();
			
		}
		
	}
	
	
	
	
	
	
	//退出登录按钮  事件处理
	QuitButtonListener quitButtonListener = new QuitButtonListener();
	private class QuitButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {   //回到登录页面
			// TODO Auto-generated method stub
			
			LoginWindow loginWindow = new LoginWindow("你好");
			jFrame.dispose();	
		}
	}

	// 前往按钮 事件处理
	GoButtonListener goButtonListener = new GoButtonListener();
	private class GoButtonListener implements ActionListener { // 前往按钮 内部类Listener
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String searchString = new String(jTextField.getText()); // 得到搜索框信息
			HomePageSearch homePageSearch = new HomePageSearch(); // 实例化HomePageSearch

			String regex = "[0-9]+"; // 全数字 正则表达式
			// TODO Auto-generated method stub
			if (searchString.equals("")) { // 文本框为空时

				JLabel textJLabelShow = new JLabel("          请输入查询关键词");
				JDialog jDialog = new JDialog(jFrame, "提示");
				jDialog.setBounds(700, 350, 200, 150); // 提示小窗口大小
				jDialog.setVisible(true);
				jDialog.add(textJLabelShow);

			} else {
				if (searchString.matches(regex)) { // 判断是否全为数字 按照编号查找
//						System.out.println(searchString);

					JLabel textJLabelShow = null;
					try {
						textJLabelShow = new JLabel("      " + homePageSearch.searchNumberResult(searchString));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JDialog jDialog = new JDialog(jFrame, "提示");
					jDialog.setBounds(550, 350, 500, 150); // 提示小窗口大小
					jDialog.setVisible(true);
					jDialog.add(textJLabelShow);

				} else { // 按照姓名查找 
					System.out.println(searchString);
					JLabel textJLabelShow = null;
					try {
						textJLabelShow = new JLabel("      " + homePageSearch.searchNameResult(searchString));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JDialog jDialog = new JDialog(jFrame, "提示");
					jDialog.setBounds(550, 350, 500, 150); // 提示小窗口大小
					jDialog.setVisible(true);
					jDialog.add(textJLabelShow);

				}
			}

		}

	}

	public MainPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);

		this.init();
		this.setBackground(Color.LIGHT_GRAY); // 改变界面颜色
		jButton.addActionListener(goButtonListener);
		backButton.addActionListener(quitButtonListener);
		allInforButton.addActionListener(allInformationButtonListener);	

	}

	void init() {

		jLabel.setBounds(85, 130, 70, 20); // 搜索
		jTextField.setBounds(120, 125, 300, 30); // 框
		jButton.setBounds(430, 125, 60, 30); // 按钮
		backButton.setBounds(5, 5, 90, 30);
		allInforButton.setBounds(450, 340, 110, 30);
		add(allInforButton);
		add(backButton);
		add(jLabel);
		add(jButton);
		add(jTextField);

	}

}
