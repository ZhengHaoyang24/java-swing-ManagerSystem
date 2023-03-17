package loginWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.text.AbstractDocument.LeafElement;

import password.*;
import time.LocalTime;

public class SetPasWindow extends JFrame { // 修改密码页面

	JFrame setPasWindowFrame = new JFrame();

	JPanel jPanel = new JPanel();
	Box kongBox = Box.createHorizontalBox();
	Box kuangBox1 = Box.createHorizontalBox();
	Box kuangBox2 = Box.createHorizontalBox();
	Box kuangBox3 = Box.createHorizontalBox();
	Box kuangBox4 = Box.createHorizontalBox();
	Box kuangBox5 = Box.createHorizontalBox();
	Box jBox = Box.createHorizontalBox(); 
	Box acBox = Box.createVerticalBox();
	Box pasBox = Box.createVerticalBox();
	Box sangekuang = Box.createVerticalBox();
//
	JLabel oldAccountJLabel = new JLabel("输入你的账号");
	JTextField oldAccouJTextField = new JTextField(20); // 旧账号框
//	JLabel newAccouJLabel = new JLabel("请输入新账号");
//	JTextField newAccountJTextField = new JTextField(20); // 新账号框
	JLabel oldPasJLabel = new JLabel("请输入原密码");
	JTextField oldPasJTextField = new JTextField(20); // 原密码框
	JLabel newPasJLabel1 = new JLabel("请输入新密码");
	JTextField newPasJTextField1 = new JTextField(20); // 新密码框1
	JLabel newPasJLabel2 = new JLabel("再输入新密码");
	JTextField newPaJTextField2 = new JTextField(20); // 新密码框2

	JButton jButtonQue = new JButton("确定"); // 确定按钮
	JButton jButtonCancel = new JButton("返回"); // 取消按钮

	QuedingButton quedingListenerButton = new QuedingButton(); // 实例化确定按钮

	private class QuedingButton implements ActionListener { // 内部类 确定按钮
		@Override
		public void actionPerformed(ActionEvent e) { 
			SetAccoandPas set = new SetAccoandPas();

			String accoOldString = new String(oldAccouJTextField.getText()); // 获取旧账号框信息
//			String accoNewString = new String(newAccountJTextField.getText()); // 获取新账号框信息
			String pasOldString = new String(oldPasJTextField.getText()); // 获取原密码框信息
			String pasNewString1 = new String(newPasJTextField1.getText()); // 获取原密码框信息1
			String pasNewString2 = new String(newPaJTextField2.getText()); // 获取原密码框信息2
			// TODO Auto-generated method stub
			try {
				if (accoOldString.equals("")||pasOldString.equals("")||pasNewString1.equals("")||pasNewString2.equals("")){
					//判断文本框是否输完
					JLabel textJLabel2 = new JLabel("                    您有未输入的信息，请完善。");
					JDialog jDialog2 = new JDialog(setPasWindowFrame, "  ");
					jDialog2.setBounds(650, 350, 300, 150); // 提示小窗口大小
					jDialog2.setVisible(true);
					jDialog2.add(textJLabel2);
					jDialog2.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} else {
					if (set.getPassword().equals(pasOldString) && pasNewString1.equals(pasNewString2)
							&& accoOldString.equals(set.getAccount())) { // 全对
						set.setPas(pasNewString2);
						JLabel textJLabel2 = new JLabel("      修改成功！！！");
						JDialog jDialog2 = new JDialog(setPasWindowFrame, "  ");
						jDialog2.setBounds(650, 350, 300, 150); // 提示小窗口大小
						jDialog2.setVisible(true);
						jDialog2.add(textJLabel2);
						jDialog2.setDefaultCloseOperation(EXIT_ON_CLOSE);

					} else {
						if (!accoOldString.equals(set.getAccount())) {
							JLabel textJLabel2 = new JLabel("      你输入的原账号错误，请重新输入");
							JDialog jDialog2 = new JDialog(setPasWindowFrame, "  ");
							jDialog2.setBounds(650, 350, 300, 150); // 提示小窗口大小
							jDialog2.setVisible(true);
							jDialog2.add(textJLabel2);
							jDialog2.setDefaultCloseOperation(EXIT_ON_CLOSE);
						} else {
							if (!pasOldString.equals(set.getPassword())) {
								JLabel textJLabel2 = new JLabel("      你输入的原密码错误，请重新输入");
								JDialog jDialog2 = new JDialog(setPasWindowFrame, "  ");
								jDialog2.setBounds(650, 350, 300, 150); // 提示小窗口大小
								jDialog2.setVisible(true);
								jDialog2.add(textJLabel2);
								jDialog2.setDefaultCloseOperation(EXIT_ON_CLOSE);
							} else {
								if (!pasNewString1.equals(pasNewString2)) { // 两次密码不对
									JLabel textJLabel2 = new JLabel("      输入的两次新密码不相同，请重新输入");
									JDialog jDialog2 = new JDialog(setPasWindowFrame, "  ");
									jDialog2.setBounds(650, 350, 300, 150); // 提示小窗口大小
									jDialog2.setVisible(true);
									jDialog2.add(textJLabel2);
									jDialog2.setDefaultCloseOperation(EXIT_ON_CLOSE);

								}

							}
						}

					}
				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	CancelButton jButtonCance = new CancelButton(); // 实例化取消按钮

	private class CancelButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			LoginWindow loginWindow = new LoginWindow("wqd"); // 销毁页面 进入LoginWindow
			dispose();
		}

		public void setPreferredSize(Dimension dimension) {
			// TODO Auto-generated method stub

		}

		public void setBackground(Color blue) {
			// TODO Auto-generated method stub

		}

	}

	public SetPasWindow(String s) { // 构造方法
		// TODO Auto-generated constructor stub
		super(s);
		setBounds(500, 200, 600, 450); // 界面大小

		this.initSetWindow();
//		this.add(jButtonCancel);

		this.add(sangekuang);
		this.getContentPane().setBackground(Color.pink); // 改变界面颜色
		this.setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jButtonQue.addActionListener(quedingListenerButton); // 确定按钮监听事件

		jButtonCancel.addActionListener(jButtonCance); // 取消按钮监听事件
	}

	void initSetWindow() {

		setLayout(new FlowLayout()); 
		kuangBox1.add(oldAccountJLabel);
		kuangBox1.add(Box.createHorizontalStrut(10));
		kuangBox1.add(oldAccouJTextField);
//		kuangBox2.add(newAccouJLabel);
//		kuangBox2.add(Box.createHorizontalStrut(10));
//		kuangBox2.add(newAccountJTextField);
		kuangBox3.add(oldPasJLabel);
		kuangBox3.add(Box.createHorizontalStrut(10));
		kuangBox3.add(oldPasJTextField);
		kuangBox4.add(newPasJLabel1);
		kuangBox4.add(Box.createHorizontalStrut(10));
		;
		kuangBox4.add(newPasJTextField1);
		kuangBox5.add(newPasJLabel2);
		kuangBox5.add(Box.createHorizontalStrut(10));
		kuangBox5.add(newPaJTextField2);

		acBox.add(Box.createVerticalStrut(80));
		acBox.add(kuangBox1);
		acBox.add(Box.createVerticalStrut(6));
		acBox.add(kuangBox2);

		pasBox.add(Box.createVerticalStrut(20));
		pasBox.add(kuangBox3);
		pasBox.add(Box.createVerticalStrut(6));
		pasBox.add(kuangBox4);
		pasBox.add(Box.createVerticalStrut(6));
		pasBox.add(kuangBox5);
		pasBox.add(Box.createVerticalStrut(90)); // 账号与密码距离

		jButtonQue.setBackground(Color.green);

		jButtonCance.setBackground(Color.PINK);
		jBox.add(jButtonCancel);
		jBox.add(pasBox.createHorizontalStrut(50)); // 取消按钮与确定按钮距离
		jBox.add(jButtonQue);
		pasBox.add(Box.createVerticalStrut(20));
//		kongBox.add(jButtonCancel);		
		sangekuang.add(kongBox);
		sangekuang.add(acBox);
		sangekuang.add(pasBox);
		sangekuang.add(jBox); 
		setPasWindowFrame.add(sangekuang);
//		pasBox.add(Box.createVerticalStrut(50)); // 账号与密码距离

	}
}
