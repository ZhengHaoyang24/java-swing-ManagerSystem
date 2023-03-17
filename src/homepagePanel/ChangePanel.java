package homepagePanel;

import homepage.*;
import panelFunctionScripts.*;
import panelFunctionScripts.HomePageSearch;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChangePanel extends JPanel {

	JFrame jFrame;
	static String tishiString = "  ";
	JLabel xinxijLabel = new JLabel(tishiString);
	JLabel numjLabel = new JLabel("调动员工");
	JButton goButton = new JButton("查看"); 
	JButton queButton = new JButton("确定");
	JLabel salaryjLabel = new JLabel("工资");
	JLabel bumenjLabel = new JLabel("调动至");
	JTextField salaryjTextField = new JTextField(15); // 工资框
	JTextField searchjTextField = new JTextField("输入工号",15); // 搜索框
	
	JComboBox<String> comBox = new JComboBox<String>(); // 下拉列表

	GoButtonClass goButtonClass = new GoButtonClass();  
	private class GoButtonClass implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String getSearchString = new String(searchjTextField.getText()); // 得到搜索框信息    
			HomePageSearch homePageSearch = new HomePageSearch(); // 实例化HomePageSearch
			System.out.println(getSearchString);
			try {
				if (legalNumber(getSearchString) && searchNumberExist(getSearchString)) {   //查找

					tishiString = homePageSearch.searchNumberResult(getSearchString);
					xinxijLabel.setText(tishiString);	   //显示信息

				}
				else {
					JLabel textJLabelShow = new JLabel("              你输入的员工编号有误,或不存在");
					JDialog jDialog = new JDialog(jFrame, "提示");
					jDialog.setBounds(650, 350, 300, 150); // 提示小窗口大小
					jDialog.setVisible(true);
					jDialog.add(textJLabelShow);
					
				}
			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	QueDingButton queDingButton = new QueDingButton();
	private class QueDingButton implements ActionListener{     //确定

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String searchString = new String(searchjTextField.getText()); // 得到搜索框信息
			String bumneString = comBox.getSelectedItem().toString(); // 获取部门
			String salaryuString = new String(salaryjTextField.getText());  //得到工资
			DelPeopleHomepage delPeopleHomepage = new DelPeopleHomepage();   //删除
			HomePageSearch homePageSearch = new HomePageSearch();  
			AddPeopleScripts addPeopleScripts = new AddPeopleScripts();   //添加

			String oldString = null;
			try {
				oldString = homePageSearch.changeOldScriptString(searchString);    //得到旧信息
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}   //旧信息

			try {
				System.out.println(searchString);
				System.out.println(salaryuString);
				if (legalNumber(searchString) && searchNumberExist(searchString)) {   //判断搜索框信息是否和合法
					System.out.println(searchString);
					System.out.println(salaryuString);
					String [] oldXinxiArray = oldString.split("，");
					delPeopleHomepage.deletePeopleAll(searchString);   //删除就信息  所有文件中  
					String yuanbumenString = oldXinxiArray[5];
					delPeopleHomepage.delCategroPeople(oldXinxiArray[0],yuanbumenString);   //在各个文件删除
					
					oldXinxiArray[4]=salaryuString;
					oldXinxiArray[5]=bumneString;
					addPeopleScripts.addPeople(oldXinxiArray);
					addPeopleScripts.addCategroPeople(oldXinxiArray,bumneString);
					
					JLabel textJLabelShow = new JLabel("          人员调动成功");  
					JDialog jDialog = new JDialog(jFrame, "提示");
					jDialog.setBounds(650, 350, 300, 150); // 提示小窗口大小
					jDialog.setVisible(true);
					jDialog.add(textJLabelShow);
					
				}
				else {
					
					JLabel textJLabelShow = new JLabel("           你输入的员工编号有误,或不存在");
					JDialog jDialog = new JDialog(jFrame, "提示");
					jDialog.setBounds(650, 350, 300, 150); // 提示小窗口大小
					jDialog.setVisible(true);
					jDialog.add(textJLabelShow);
					
				}
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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

	public ChangePanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		this.init();
//		this.add(verBox);
		this.setBackground(new Color(249, 205, 173)); // 改变界面颜色
		goButton.addActionListener(goButtonClass);
		queButton.addActionListener(queDingButton);
	}

	public ChangePanel(JFrame jFrame) {
		this.jFrame = jFrame;
		setLayout(null);

		this.init();
		this.setBackground(new Color(137, 175, 155)); // 改变界面颜色

	}

	void init() {
		xinxijLabel.setBounds(50, 10, 500, 20);  //提示信息
		add(xinxijLabel);
		numjLabel.setBounds(100, 50, 50, 30);  //工号
		add(numjLabel);
		searchjTextField.setBounds(170, 50, 220, 30);  //搜索框
		add(searchjTextField); 
		goButton.setBounds(405, 52, 60, 27);   //前往按钮
		add(goButton);
		salaryjLabel.setBounds(100, 165, 30, 20);  //工资
		add(salaryjLabel);
		salaryjTextField.setBounds(140, 160, 100, 30);  //工字框
		add(salaryjTextField);
		bumenjLabel.setBounds(330, 165, 40, 20);  //部门
		add(bumenjLabel);
		comBox.setBounds(375, 160, 100, 30);  //选项卡
		add(comBox);
		queButton.setBounds(250, 250, 60, 30);
		add(queButton);

		comBox.addItem("总经办");
		comBox.addItem("财务部");
		comBox.addItem("采购部");
		comBox.addItem("产品设计中心");
		comBox.addItem("法务部");
		comBox.addItem("安全质保部");
		comBox.addItem("公益事业部");
		comBox.addItem("管理部");
		comBox.addItem("技术研发中心");
		comBox.addItem("业务部");
		comBox.addItem("营销部");
		comBox.addItem("人力资源部");

	}
}
