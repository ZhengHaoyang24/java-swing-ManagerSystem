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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import panelFunctionScripts.DelPeopleHomepage;
import panelFunctionScripts.HomePageSearch;

public class DelPanel extends JPanel { // 删除

	JFrame jFrame;

	JButton jButton = new JButton("查看");
	JButton delButton = new JButton("确定删除");
	JTextField jTextField = new JTextField("输入工号", 20);

	static String tishiString = " "; // 显示信息 String
	static String thisDelPeopleString = " "; //
	JLabel xinxijLabel = new JLabel(tishiString);

	GoButtonListener goButtonListener = new GoButtonListener();

	private class GoButtonListener implements ActionListener { // 前往按钮 内部类Listener //查找并显示

		HomePageSearch homePageSearch = new HomePageSearch(); // 实例化HomePageSearch
		DelPeopleHomepage delPeopleHomepage = new DelPeopleHomepage();

		String regex = "[0-9]+"; // 全数字 正则表达式

		@Override
		public void actionPerformed(ActionEvent e) {
			String searchString = new String(jTextField.getText()); // 得到搜索框信息

			// TODO Auto-generated method stub

			// TODO Auto-generated method stub
			if (searchString.equals("")) { // 文本框为空时

				JLabel textJLabelShow = new JLabel("          请输入查询关键词");
				JDialog jDialog = new JDialog(jFrame, "提示");
				jDialog.setBounds(700, 350, 200, 150); // 提示小窗口大小
				jDialog.setVisible(true);
				jDialog.add(textJLabelShow);

			} else {

				try {
					if (legalNumber(searchString) && searchNumberExist(searchString)) { // 判断是否全为数字 按照编号查找

						thisDelPeopleString = delPeopleHomepage.searchNumberDel(searchString); // 无前缀信息
						tishiString = homePageSearch.searchNumberResult(searchString);
						xinxijLabel.setText(tishiString); // 显示信息
					} else {

						JLabel textJLabelShow = new JLabel("         输入的工号不存在或不合法");
						JDialog jDialog = new JDialog(jFrame, "提示");
						jDialog.setBounds(700, 350, 200, 150); // 提示小窗口大小
						jDialog.setVisible(true);
						jDialog.add(textJLabelShow);

					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
	}

	DelButtonListener delButtonLisetener = new DelButtonListener();

	private class DelButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			DelPeopleHomepage delPeopleHomepage = new DelPeopleHomepage();
			HomePageSearch homePageSearch = new HomePageSearch(); // 实例化HomePageSearch
			String delString = null;
			String[] delArrayString = null;

			String searchString = new String(jTextField.getText()); // 得到搜索框信息
			String regex = "[0-9]+"; // 全数字 正则表达式
			if (legalNumber(searchString)) { // 是否合法

				try {
					if (searchString.matches(regex) && searchNumberExist(searchString)) { // 是否存在

						delString = delPeopleHomepage.searchNumberDel(searchString); // 无前缀信息
						delArrayString = delString.split("，");

						delPeopleHomepage.deletePeopleAll(delArrayString[0]); // delAll
						delPeopleHomepage.delCategroPeople(delArrayString[0], delArrayString[5]); // delCategro
						delPeopleHomepage.delManager(delArrayString[0]);

						JLabel textJLabelShow = new JLabel("        删除完成");
						JDialog jDialog = new JDialog(jFrame, "提示");
						jDialog.setBounds(700, 350, 200, 150); // 提示小窗口大小
						jDialog.setVisible(true);
						jDialog.add(textJLabelShow);
					} else {

						JLabel textJLabelShow = new JLabel("       不存在此员工");
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
				JLabel textJLabelShow = new JLabel("       输入正确的员工编号");
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

	public DelPanel(JFrame jFrame) {
		this.jFrame = jFrame;
		setLayout(null);

		this.init();
		this.setBackground(new Color(137, 175, 155)); // 改变界面颜色
//		jButton.addActionListener(goButtonListener);

	}

	public DelPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);

		this.init();
		this.setBackground(new Color(252, 157, 154)); // 改变界面颜色
		jButton.addActionListener(goButtonListener);
		delButton.addActionListener(delButtonLisetener);
	}

	void init() {

		xinxijLabel.setBounds(50, 10, 500, 20); // 提示信息
		add(xinxijLabel);
		jTextField.setBounds(130, 100, 250, 30); // 框
		jButton.setBounds(400, 100, 60, 30); // 按钮
		delButton.setBounds(230, 300, 100, 40);
		add(delButton);
		add(jButton);
		add(jTextField);

	}
}
