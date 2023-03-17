package homepagePanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import panelFunctionScripts.DelPeopleHomepage;
import panelFunctionScripts.HomePageSearch;
import panelFunctionScripts.SetManagerScripts;

public class SetManagerPanel extends JPanel {
	JFrame jFrame;
	JButton changeButton = new JButton("确定更职");
	JLabel jLabel = new JLabel("工号");
	JLabel jLabel2 = new JLabel("将此提职为");
	JButton checkButton = new JButton("查看");
	JTextField jTextField = new JTextField("输入员工工号");
	JComboBox<String> comBox = new JComboBox<String>(); // 下拉列表

	static String tishiString = " "; // 显示信息 String
	static String thisDelPeopleString = ""; //
	JLabel xinxijLabel = new JLabel(tishiString);

	CheckButtonListener checkButtonListener = new CheckButtonListener();

	private class CheckButtonListener implements ActionListener { // 前往按钮 内部类Listener //查找并显示

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String searchString = new String(jTextField.getText()); // 得到搜索框信息
			HomePageSearch homePageSearch = new HomePageSearch(); // 实例化HomePageSearch
			DelPeopleHomepage delPeopleHomepage = new DelPeopleHomepage();

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

					try {
						thisDelPeopleString = delPeopleHomepage.searchNumberDel(searchString); // 无前缀信息
						tishiString = homePageSearch.searchNumberResult(searchString);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					xinxijLabel.setText(tishiString); // 显示信息

				} else { // 按照姓名查找

					try {
						thisDelPeopleString = delPeopleHomepage.searchNameDel(searchString);
						tishiString = homePageSearch.searchNameResult(searchString);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					xinxijLabel.setText(tishiString); // 显示信息
				}
			}
		}
	}

	ChangeButtonListener changeButtonListener = new ChangeButtonListener();
	private class ChangeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String searchString = new String(jTextField.getText()); // 得到搜索框信息
			HomePageSearch homePageSearch = new HomePageSearch(); // 实例化HomePageSearch
//			DelPeopleHomepage delPeopleHomepage = new DelPeopleHomepage();
			SetManagerScripts setManagerScripts = new SetManagerScripts();
			String regex = "[0-9]+"; // 全数字 正则表达式
			String managerNameString = comBox.getSelectedItem().toString(); // 获取职位
			
			if (searchString.matches(regex)) {
				try { 
					if (searchNumberExist(searchString) && legalNumber(searchString)) {
						System.out.println("yes");
						setManagerScripts.setManager(searchString, managerNameString);
						JLabel textJLabelShow = new JLabel("                        成功");
						JDialog jDialog = new JDialog(jFrame, "提示");
						jDialog.setBounds(700, 350, 200, 150); // 提示小窗口大小
						jDialog.setVisible(true);
						jDialog.add(textJLabelShow);
						
					} else {
						JLabel textJLabelShow = new JLabel("          编号有误或不存在此员工");
						JDialog jDialog = new JDialog(jFrame, "提示");
						jDialog.setBounds(700, 350, 200, 150); // 提示小窗口大小
						jDialog.setVisible(true);
						jDialog.add(textJLabelShow);

					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else {
				JLabel textJLabelShow = new JLabel("          请输入查询关键词");
				JDialog jDialog = new JDialog(jFrame, "提示");
				jDialog.setBounds(700, 350, 200, 150); // 提示小窗口大小
				jDialog.setVisible(true);
				jDialog.add(textJLabelShow);
			}
		}
	}

	public boolean legalNumber(String s) { // 编号是否合法
		String[] x = s.split("");
		if (x.length != 6) {
			return false;
		} else {
			return true;
		}
	}

	public boolean searchNumberExist(String s) throws IOException { // 判断编号是否已经存在

		File file = new File("file/information/all.txt");
		Reader reader = new FileReader(file);
		BufferedReader searchReader1 = new BufferedReader(reader);
		// 进行文件读取
		String lineString;
		while ((lineString = searchReader1.readLine()) != null) {
			String str = lineString;
			String[] strArray = str.split("，");
			if (strArray[0].equals(s)) {
				return true;
			}
		}
		return false;
	}

	public SetManagerPanel(JFrame jFrame) {
		this.jFrame = jFrame;
		setLayout(null);

		this.init();
		this.setBackground(new Color(137, 175, 155)); // 改变界面颜色

//		checkButton.addActionListener(checkButtonListener);
//		changeButton.addActionListener(checkButtonListener);
	}

	public SetManagerPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);

		this.init();
		this.setBackground(new Color(232, 221, 203)); // 改变界面颜色

		checkButton.addActionListener(checkButtonListener);
		changeButton.addActionListener(changeButtonListener);
	}

	void init() {
		comBox.addItem("董事长");
		comBox.addItem("(CEO)首席执行官");
		comBox.addItem("(CBO)商务总监");
		comBox.addItem("(CIO)技术总监");
		comBox.addItem("(CFO)财务总监");
		comBox.addItem("(CHO)人事总监");

		jLabel2.setBounds(180, 154, 90, 20);
		add(jLabel2);
		xinxijLabel.setBounds(50, 10, 500, 20); // 提示信息
		add(xinxijLabel);
		jLabel.setBounds(150, 90, 30, 20);
		add(jLabel);
		jTextField.setBounds(180, 85, 185, 30);
		add(jTextField);
		checkButton.setBounds(370, 87, 60, 26);
		add(checkButton);
		comBox.setBounds(256, 150, 140, 30); // 选项卡
		add(comBox);
		changeButton.setBounds(240, 250, 100, 40);
		add(changeButton);

	}
}
