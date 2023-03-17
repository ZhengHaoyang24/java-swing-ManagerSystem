package homepagePanel;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import homepage.HomePageWindow;

public class AddPanel extends JPanel {
	HomePageWindow homepage;

//	private static final long serialVersionUID = 1L;

	Box zuo1box1 = Box.createHorizontalBox(); // 盒子
	Box zuo1box2 = Box.createHorizontalBox();
	Box zuo1box3 = Box.createHorizontalBox();
	Box youBox1 = Box.createHorizontalBox();
	Box youBox2 = Box.createHorizontalBox();
	Box youBox3 = Box.createHorizontalBox();
	Box zuoVer1 = Box.createVerticalBox();
	Box zuoVer2 = Box.createVerticalBox();
	Box rigeBox = Box.createHorizontalBox();
	Box buttonBox = Box.createHorizontalBox();
	Box mostpBox = Box.createVerticalBox();

	JLabel sexjLabel = new JLabel("性别");
	JLabel agejLabel = new JLabel("年龄"); // 年龄
	JTextField agejTextField = new JTextField(15);
	JLabel numberjLabel = new JLabel("编号");
	JTextField numjTextField = new JTextField("六位数字编号",15); // 编号
	JLabel namejLabel = new JLabel("姓名");
	JTextField namejTextField = new JTextField(15); // 姓名
	JLabel salaryjLabel = new JLabel("工资");
	JTextField salaryjTextField = new JTextField(15); // 工资框
	JLabel deparmentjLabel = new JLabel("部门");

	JRadioButton female = new JRadioButton("女");// 创建一个按钮组 性别选择
	JRadioButton male = new JRadioButton("男");
	ButtonGroup group = new ButtonGroup();

	JComboBox<String> comBox = new JComboBox<String>(); // 下拉列表

	JButton jButton = new JButton("确定");

	QueButtonListener queButtonListener = new QueButtonListener(); // 确定 事件处理

	private class QueButtonListener implements ActionListener { 
		@Override
		public void actionPerformed(ActionEvent e) {
			String ageString = new String(agejTextField.getText()); // 获取年龄框信息
			System.out.println(ageString);
			String numberString = new String(numjTextField.getText()); // 获取编号框信息
			System.out.println(numberString);
			String nameString = new String(namejTextField.getText()); // 获取姓名框信息
			System.out.println(nameString);
			String salaryString = new String(salaryjTextField.getText()); // 获取工资框信息
			System.out.println(salaryString);
			String bumneString = comBox.getSelectedItem().toString(); // 获取部门
			System.out.println(bumneString);
			Enumeration<AbstractButton> radioBtns = group.getElements(); // 获取性别信息
			String sexString = null; // Enumeration接口中定义了一些方法，
			while (radioBtns.hasMoreElements()) { // 通过这些方法可以枚举（一次获得一个）对象集合中的元素
				AbstractButton btn = radioBtns.nextElement();
				if (btn.isSelected()) {
					sexString = btn.getText(); // jta2为文本域对象
					break;
				}
			}
			System.out.println(sexString);
			// 判断选择框   	// 选择框是否合法
			try {
				if (legalNumber(numberString) && !searchNumberExist(numberString) && !nameString.equals("")
						&& !salaryString.equals("") && !ageString.equals("") && !sexString.equals("")
						&& !bumneString.equals("")) { // 加入员工 写入文件
					
					if (bumneString.equals("财务部")) {
						File allFile = new File("file/information/all.txt"); 
						File txtFile = new File("file/information/caiwubu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //写入所有
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // 写入分类
						writerAll.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						writerAll.flush();    //缓冲区
						eriWriterTxt.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						eriWriterTxt.flush();     //缓冲区
	
					}
					if (bumneString.equals("采购部")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/caigoubu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //写入所有
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // 写入分类
						writerAll.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						writerAll.flush();    //缓冲区
						eriWriterTxt.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						eriWriterTxt.flush();     //缓冲区

					}
					if (bumneString.equals("产品设计中心")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/chanpingshejizhongxin.txt");
						Writer writerAll=new FileWriter(allFile,true);    //写入所有
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // 写入分类
						writerAll.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						writerAll.flush();    //缓冲区
						eriWriterTxt.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						eriWriterTxt.flush();     //缓冲区

					}
					if (bumneString.equals("法务部")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/fawubu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //写入所有
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // 写入分类
						writerAll.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						writerAll.flush();    //缓冲区
						eriWriterTxt.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						eriWriterTxt.flush();     //缓冲区

					}
					if (bumneString.equals("管理部")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/guanlibu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //写入所有
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // 写入分类
						writerAll.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						writerAll.flush();    //缓冲区
						eriWriterTxt.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						eriWriterTxt.flush();     //缓冲区

					}
					if (bumneString.equals("技术研发中心")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/jishuyanfazhongxin.txt");
						Writer writerAll=new FileWriter(allFile,true);    //写入所有
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // 写入分类
						writerAll.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						writerAll.flush();    //缓冲区
						eriWriterTxt.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						eriWriterTxt.flush();     //缓冲区

					}
					if (bumneString.equals("业务部")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/yewubu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //写入所有
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // 写入分类
						writerAll.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						writerAll.flush();    //缓冲区
						eriWriterTxt.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						eriWriterTxt.flush();     //缓冲区

					}
					if (bumneString.equals("营销部")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/yingxiaobu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //写入所有
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // 写入分类
						writerAll.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						writerAll.flush();    //缓冲区
						eriWriterTxt.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						eriWriterTxt.flush();     //缓冲区

					}
					if (bumneString.equals("总经办")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/zongjingban.txt");
						Writer writerAll=new FileWriter(allFile,true);    //写入所有
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // 写入分类
						writerAll.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						writerAll.flush();    //缓冲区
						eriWriterTxt.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						eriWriterTxt.flush();     //缓冲区

					}
					if (bumneString.equals("安全质保部")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/anquanzhibaobu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //写入所有
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // 写入分类
						writerAll.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						writerAll.flush();    //缓冲区
						eriWriterTxt.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						eriWriterTxt.flush();     //缓冲区

					}
					if (bumneString.equals("公益事业部")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/gongyishiyebu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //写入所有
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // 写入分类
						writerAll.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						writerAll.flush();    //缓冲区
						eriWriterTxt.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						eriWriterTxt.flush();     //缓冲区

					}
					
					if (bumneString.equals("人力资源部")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/renliziyuanbu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //写入所有
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // 写入分类
						writerAll.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						writerAll.flush();    //缓冲区
						eriWriterTxt.write(numberString+"，"+sexString+"，"+nameString+"，"+ageString+"，"+salaryString+"，"+bumneString+"\r\n");
						eriWriterTxt.flush();     //缓冲区

					}
					
					JLabel textJLabelShow = new JLabel("<html>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
							+ "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&"
							+ "nbsp&nbsp添加成功！添加的员工信息为："+ "<br><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp编号:" + numberString + ""
									+ "&nbsp&nbsp&nbsp性别:" + sexString + 
							"&nbsp&nbsp&nbsp姓名:" + nameString + "&nbsp&nbsp&nbsp年龄:"+ageString+"岁&nbsp&nbsp&nbsp工资:" + salaryString + "元/月&nbsp&nbsp&nbsp部门:"
									+ "" + bumneString+"</html>");
					JDialog jDialog = new JDialog(homepage, "提示");
					jDialog.setBounds(600, 350, 500, 150); // 提示小窗口大小
					jDialog.setVisible(true);
					jDialog.add(textJLabelShow);
					

				} else {
					if (numberString.equals("") || nameString.equals("") || salaryString.equals("")
							|| ageString.equals("") || sexString.equals("") || bumneString.equals("")) {
						JLabel textJLabelShow = new JLabel("            有未添选项，请完善");
						JDialog jDialog = new JDialog(homepage, "提示");
						jDialog.setBounds(700, 350, 200, 150); // 提示小窗口大小
						jDialog.setVisible(true);
						jDialog.add(textJLabelShow);

					} else {
						if (!legalNumber(numberString)) {
							JLabel textJLabelShow = new JLabel("             编号不符合要求");
							JDialog jDialog = new JDialog(homepage, "提示");
							jDialog.setBounds(700, 350, 200, 150); // 提示小窗口大小
							jDialog.setVisible(true);
							jDialog.add(textJLabelShow);

						}
						if (searchNumberExist(numberString)) {
							JLabel textJLabelShow = new JLabel("             编号已经存在");
							JDialog jDialog = new JDialog(homepage, "提示");
							jDialog.setBounds(700, 350, 200, 150); // 提示小窗口大小
							jDialog.setVisible(true);
							jDialog.add(textJLabelShow);
						}
						
					}

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



	public AddPanel() { // 无参构造方法

		this.init();
		add(mostpBox);
		this.setBackground(new Color(96,143,159)); // 改变界面颜色

		jButton.addActionListener(queButtonListener); // 确定 添加监听

	}

	void init() {

//		jButton.setBounds(400, 400, 90,30);
//		add(jButton);

		// 添加 左边 组件
		zuo1box1.add(numberjLabel); // 编号
		zuo1box1.add(Box.createHorizontalStrut(10));
		zuo1box1.add(numjTextField);
		zuo1box2.add(namejLabel); // 姓名
		zuo1box2.add(Box.createHorizontalStrut(10));
		zuo1box2.add(namejTextField);
		zuo1box3.add(salaryjLabel); // 工资
		zuo1box3.add(Box.createHorizontalStrut(10));
		zuo1box3.add(salaryjTextField);
		zuoVer1.add(zuo1box1);
		zuoVer1.add(Box.createVerticalStrut(30));
		zuoVer1.add(zuo1box2);
		zuoVer1.add(Box.createVerticalStrut(30));
		zuoVer1.add(zuo1box3);

		// 添加 右边 组件
		youBox1.add(sexjLabel); // 性别
		youBox1.add(Box.createHorizontalStrut(87));
		group.add(female); // 将男 女 加入到group里
		group.add(male);
		youBox1.add(female);
		youBox1.add(Box.createHorizontalStrut(10));
		youBox1.add(male);
		youBox2.add(agejLabel); // 年龄
		youBox2.add(Box.createHorizontalStrut(20)); // 男女单选 距离
		youBox2.add(agejTextField);
		youBox3.add(deparmentjLabel);
		youBox3.add(Box.createHorizontalStrut(10));
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
		youBox3.add(comBox);
		zuoVer2.add(youBox1);
		zuoVer2.add(Box.createVerticalStrut(30));
		zuoVer2.add(youBox2);
		zuoVer2.add(Box.createVerticalStrut(30));
		zuoVer2.add(youBox3);

		rigeBox.add(zuoVer1);
		rigeBox.add(Box.createHorizontalStrut(40));
		rigeBox.add(zuoVer2);

		mostpBox.add(Box.createVerticalStrut(80)); // 上边距

		jButton.setBackground(Color.GREEN);
		buttonBox.add(jButton);
		mostpBox.add(rigeBox);
		mostpBox.add(Box.createVerticalStrut(50)); //
		mostpBox.add(buttonBox);

	}

}
