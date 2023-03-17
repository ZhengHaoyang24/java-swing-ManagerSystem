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

	Box zuo1box1 = Box.createHorizontalBox(); // ����
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

	JLabel sexjLabel = new JLabel("�Ա�");
	JLabel agejLabel = new JLabel("����"); // ����
	JTextField agejTextField = new JTextField(15);
	JLabel numberjLabel = new JLabel("���");
	JTextField numjTextField = new JTextField("��λ���ֱ��",15); // ���
	JLabel namejLabel = new JLabel("����");
	JTextField namejTextField = new JTextField(15); // ����
	JLabel salaryjLabel = new JLabel("����");
	JTextField salaryjTextField = new JTextField(15); // ���ʿ�
	JLabel deparmentjLabel = new JLabel("����");

	JRadioButton female = new JRadioButton("Ů");// ����һ����ť�� �Ա�ѡ��
	JRadioButton male = new JRadioButton("��");
	ButtonGroup group = new ButtonGroup();

	JComboBox<String> comBox = new JComboBox<String>(); // �����б�

	JButton jButton = new JButton("ȷ��");

	QueButtonListener queButtonListener = new QueButtonListener(); // ȷ�� �¼�����

	private class QueButtonListener implements ActionListener { 
		@Override
		public void actionPerformed(ActionEvent e) {
			String ageString = new String(agejTextField.getText()); // ��ȡ�������Ϣ
			System.out.println(ageString);
			String numberString = new String(numjTextField.getText()); // ��ȡ��ſ���Ϣ
			System.out.println(numberString);
			String nameString = new String(namejTextField.getText()); // ��ȡ��������Ϣ
			System.out.println(nameString);
			String salaryString = new String(salaryjTextField.getText()); // ��ȡ���ʿ���Ϣ
			System.out.println(salaryString);
			String bumneString = comBox.getSelectedItem().toString(); // ��ȡ����
			System.out.println(bumneString);
			Enumeration<AbstractButton> radioBtns = group.getElements(); // ��ȡ�Ա���Ϣ
			String sexString = null; // Enumeration�ӿ��ж�����һЩ������
			while (radioBtns.hasMoreElements()) { // ͨ����Щ��������ö�٣�һ�λ��һ�������󼯺��е�Ԫ��
				AbstractButton btn = radioBtns.nextElement();
				if (btn.isSelected()) {
					sexString = btn.getText(); // jta2Ϊ�ı������
					break;
				}
			}
			System.out.println(sexString);
			// �ж�ѡ���   	// ѡ����Ƿ�Ϸ�
			try {
				if (legalNumber(numberString) && !searchNumberExist(numberString) && !nameString.equals("")
						&& !salaryString.equals("") && !ageString.equals("") && !sexString.equals("")
						&& !bumneString.equals("")) { // ����Ա�� д���ļ�
					
					if (bumneString.equals("����")) {
						File allFile = new File("file/information/all.txt"); 
						File txtFile = new File("file/information/caiwubu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //д������
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // д�����
						writerAll.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						writerAll.flush();    //������
						eriWriterTxt.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						eriWriterTxt.flush();     //������
	
					}
					if (bumneString.equals("�ɹ���")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/caigoubu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //д������
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // д�����
						writerAll.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						writerAll.flush();    //������
						eriWriterTxt.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						eriWriterTxt.flush();     //������

					}
					if (bumneString.equals("��Ʒ�������")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/chanpingshejizhongxin.txt");
						Writer writerAll=new FileWriter(allFile,true);    //д������
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // д�����
						writerAll.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						writerAll.flush();    //������
						eriWriterTxt.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						eriWriterTxt.flush();     //������

					}
					if (bumneString.equals("����")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/fawubu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //д������
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // д�����
						writerAll.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						writerAll.flush();    //������
						eriWriterTxt.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						eriWriterTxt.flush();     //������

					}
					if (bumneString.equals("����")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/guanlibu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //д������
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // д�����
						writerAll.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						writerAll.flush();    //������
						eriWriterTxt.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						eriWriterTxt.flush();     //������

					}
					if (bumneString.equals("�����з�����")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/jishuyanfazhongxin.txt");
						Writer writerAll=new FileWriter(allFile,true);    //д������
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // д�����
						writerAll.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						writerAll.flush();    //������
						eriWriterTxt.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						eriWriterTxt.flush();     //������

					}
					if (bumneString.equals("ҵ��")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/yewubu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //д������
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // д�����
						writerAll.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						writerAll.flush();    //������
						eriWriterTxt.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						eriWriterTxt.flush();     //������

					}
					if (bumneString.equals("Ӫ����")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/yingxiaobu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //д������
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // д�����
						writerAll.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						writerAll.flush();    //������
						eriWriterTxt.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						eriWriterTxt.flush();     //������

					}
					if (bumneString.equals("�ܾ���")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/zongjingban.txt");
						Writer writerAll=new FileWriter(allFile,true);    //д������
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // д�����
						writerAll.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						writerAll.flush();    //������
						eriWriterTxt.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						eriWriterTxt.flush();     //������

					}
					if (bumneString.equals("��ȫ�ʱ���")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/anquanzhibaobu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //д������
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // д�����
						writerAll.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						writerAll.flush();    //������
						eriWriterTxt.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						eriWriterTxt.flush();     //������

					}
					if (bumneString.equals("������ҵ��")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/gongyishiyebu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //д������
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // д�����
						writerAll.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						writerAll.flush();    //������
						eriWriterTxt.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						eriWriterTxt.flush();     //������

					}
					
					if (bumneString.equals("������Դ��")) {
						File allFile = new File("file/information/all.txt");
						File txtFile = new File("file/information/renliziyuanbu.txt");
						Writer writerAll=new FileWriter(allFile,true);    //д������
						Writer eriWriterTxt = new FileWriter(txtFile,true);  // д�����
						writerAll.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						writerAll.flush();    //������
						eriWriterTxt.write(numberString+"��"+sexString+"��"+nameString+"��"+ageString+"��"+salaryString+"��"+bumneString+"\r\n");
						eriWriterTxt.flush();     //������

					}
					
					JLabel textJLabelShow = new JLabel("<html>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
							+ "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&"
							+ "nbsp&nbsp��ӳɹ�����ӵ�Ա����ϢΪ��"+ "<br><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp���:" + numberString + ""
									+ "&nbsp&nbsp&nbsp�Ա�:" + sexString + 
							"&nbsp&nbsp&nbsp����:" + nameString + "&nbsp&nbsp&nbsp����:"+ageString+"��&nbsp&nbsp&nbsp����:" + salaryString + "Ԫ/��&nbsp&nbsp&nbsp����:"
									+ "" + bumneString+"</html>");
					JDialog jDialog = new JDialog(homepage, "��ʾ");
					jDialog.setBounds(600, 350, 500, 150); // ��ʾС���ڴ�С
					jDialog.setVisible(true);
					jDialog.add(textJLabelShow);
					

				} else {
					if (numberString.equals("") || nameString.equals("") || salaryString.equals("")
							|| ageString.equals("") || sexString.equals("") || bumneString.equals("")) {
						JLabel textJLabelShow = new JLabel("            ��δ��ѡ�������");
						JDialog jDialog = new JDialog(homepage, "��ʾ");
						jDialog.setBounds(700, 350, 200, 150); // ��ʾС���ڴ�С
						jDialog.setVisible(true);
						jDialog.add(textJLabelShow);

					} else {
						if (!legalNumber(numberString)) {
							JLabel textJLabelShow = new JLabel("             ��Ų�����Ҫ��");
							JDialog jDialog = new JDialog(homepage, "��ʾ");
							jDialog.setBounds(700, 350, 200, 150); // ��ʾС���ڴ�С
							jDialog.setVisible(true);
							jDialog.add(textJLabelShow);

						}
						if (searchNumberExist(numberString)) {
							JLabel textJLabelShow = new JLabel("             ����Ѿ�����");
							JDialog jDialog = new JDialog(homepage, "��ʾ");
							jDialog.setBounds(700, 350, 200, 150); // ��ʾС���ڴ�С
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


	public boolean legalNumber(String s) { // ����Ƿ�Ϸ�
		String[] x = s.split("");
		if (x.length != 6) {
			return false;
		} else {
			return true;
		}
	}

	public boolean searchNumberExist(String s) throws IOException { // �жϱ���Ƿ��Ѿ�����

		File file = new File("file/information/all.txt");
		Reader reader = new FileReader(file);
		BufferedReader searchReader1 = new BufferedReader(reader);
		// �����ļ���ȡ
		String lineString;
		while ((lineString = searchReader1.readLine()) != null) {
			String str = lineString;
			String[] strArray = str.split("��");
			if (strArray[0].equals(s)) {
				return true;
			}
		}
		return false;
	}



	public AddPanel() { // �޲ι��췽��

		this.init();
		add(mostpBox);
		this.setBackground(new Color(96,143,159)); // �ı������ɫ

		jButton.addActionListener(queButtonListener); // ȷ�� ��Ӽ���

	}

	void init() {

//		jButton.setBounds(400, 400, 90,30);
//		add(jButton);

		// ��� ��� ���
		zuo1box1.add(numberjLabel); // ���
		zuo1box1.add(Box.createHorizontalStrut(10));
		zuo1box1.add(numjTextField);
		zuo1box2.add(namejLabel); // ����
		zuo1box2.add(Box.createHorizontalStrut(10));
		zuo1box2.add(namejTextField);
		zuo1box3.add(salaryjLabel); // ����
		zuo1box3.add(Box.createHorizontalStrut(10));
		zuo1box3.add(salaryjTextField);
		zuoVer1.add(zuo1box1);
		zuoVer1.add(Box.createVerticalStrut(30));
		zuoVer1.add(zuo1box2);
		zuoVer1.add(Box.createVerticalStrut(30));
		zuoVer1.add(zuo1box3);

		// ��� �ұ� ���
		youBox1.add(sexjLabel); // �Ա�
		youBox1.add(Box.createHorizontalStrut(87));
		group.add(female); // ���� Ů ���뵽group��
		group.add(male);
		youBox1.add(female);
		youBox1.add(Box.createHorizontalStrut(10));
		youBox1.add(male);
		youBox2.add(agejLabel); // ����
		youBox2.add(Box.createHorizontalStrut(20)); // ��Ů��ѡ ����
		youBox2.add(agejTextField);
		youBox3.add(deparmentjLabel);
		youBox3.add(Box.createHorizontalStrut(10));
		comBox.addItem("�ܾ���");
		comBox.addItem("����");
		comBox.addItem("�ɹ���");
		comBox.addItem("��Ʒ�������");
		comBox.addItem("����");
		comBox.addItem("��ȫ�ʱ���");
		comBox.addItem("������ҵ��");
		comBox.addItem("����");
		comBox.addItem("�����з�����");
		comBox.addItem("ҵ��");
		comBox.addItem("Ӫ����");
		comBox.addItem("������Դ��");
		youBox3.add(comBox);
		zuoVer2.add(youBox1);
		zuoVer2.add(Box.createVerticalStrut(30));
		zuoVer2.add(youBox2);
		zuoVer2.add(Box.createVerticalStrut(30));
		zuoVer2.add(youBox3);

		rigeBox.add(zuoVer1);
		rigeBox.add(Box.createHorizontalStrut(40));
		rigeBox.add(zuoVer2);

		mostpBox.add(Box.createVerticalStrut(80)); // �ϱ߾�

		jButton.setBackground(Color.GREEN);
		buttonBox.add(jButton);
		mostpBox.add(rigeBox);
		mostpBox.add(Box.createVerticalStrut(50)); //
		mostpBox.add(buttonBox);

	}

}
