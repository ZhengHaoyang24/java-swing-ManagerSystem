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
	JLabel numjLabel = new JLabel("����Ա��");
	JButton goButton = new JButton("�鿴"); 
	JButton queButton = new JButton("ȷ��");
	JLabel salaryjLabel = new JLabel("����");
	JLabel bumenjLabel = new JLabel("������");
	JTextField salaryjTextField = new JTextField(15); // ���ʿ�
	JTextField searchjTextField = new JTextField("���빤��",15); // ������
	
	JComboBox<String> comBox = new JComboBox<String>(); // �����б�

	GoButtonClass goButtonClass = new GoButtonClass();  
	private class GoButtonClass implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String getSearchString = new String(searchjTextField.getText()); // �õ���������Ϣ    
			HomePageSearch homePageSearch = new HomePageSearch(); // ʵ����HomePageSearch
			System.out.println(getSearchString);
			try {
				if (legalNumber(getSearchString) && searchNumberExist(getSearchString)) {   //����

					tishiString = homePageSearch.searchNumberResult(getSearchString);
					xinxijLabel.setText(tishiString);	   //��ʾ��Ϣ

				}
				else {
					JLabel textJLabelShow = new JLabel("              �������Ա���������,�򲻴���");
					JDialog jDialog = new JDialog(jFrame, "��ʾ");
					jDialog.setBounds(650, 350, 300, 150); // ��ʾС���ڴ�С
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
	private class QueDingButton implements ActionListener{     //ȷ��

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String searchString = new String(searchjTextField.getText()); // �õ���������Ϣ
			String bumneString = comBox.getSelectedItem().toString(); // ��ȡ����
			String salaryuString = new String(salaryjTextField.getText());  //�õ�����
			DelPeopleHomepage delPeopleHomepage = new DelPeopleHomepage();   //ɾ��
			HomePageSearch homePageSearch = new HomePageSearch();  
			AddPeopleScripts addPeopleScripts = new AddPeopleScripts();   //���

			String oldString = null;
			try {
				oldString = homePageSearch.changeOldScriptString(searchString);    //�õ�����Ϣ
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}   //����Ϣ

			try {
				System.out.println(searchString);
				System.out.println(salaryuString);
				if (legalNumber(searchString) && searchNumberExist(searchString)) {   //�ж���������Ϣ�Ƿ�ͺϷ�
					System.out.println(searchString);
					System.out.println(salaryuString);
					String [] oldXinxiArray = oldString.split("��");
					delPeopleHomepage.deletePeopleAll(searchString);   //ɾ������Ϣ  �����ļ���  
					String yuanbumenString = oldXinxiArray[5];
					delPeopleHomepage.delCategroPeople(oldXinxiArray[0],yuanbumenString);   //�ڸ����ļ�ɾ��
					
					oldXinxiArray[4]=salaryuString;
					oldXinxiArray[5]=bumneString;
					addPeopleScripts.addPeople(oldXinxiArray);
					addPeopleScripts.addCategroPeople(oldXinxiArray,bumneString);
					
					JLabel textJLabelShow = new JLabel("          ��Ա�����ɹ�");  
					JDialog jDialog = new JDialog(jFrame, "��ʾ");
					jDialog.setBounds(650, 350, 300, 150); // ��ʾС���ڴ�С
					jDialog.setVisible(true);
					jDialog.add(textJLabelShow);
					
				}
				else {
					
					JLabel textJLabelShow = new JLabel("           �������Ա���������,�򲻴���");
					JDialog jDialog = new JDialog(jFrame, "��ʾ");
					jDialog.setBounds(650, 350, 300, 150); // ��ʾС���ڴ�С
					jDialog.setVisible(true);
					jDialog.add(textJLabelShow);
					
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

	public ChangePanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		this.init();
//		this.add(verBox);
		this.setBackground(new Color(249, 205, 173)); // �ı������ɫ
		goButton.addActionListener(goButtonClass);
		queButton.addActionListener(queDingButton);
	}

	public ChangePanel(JFrame jFrame) {
		this.jFrame = jFrame;
		setLayout(null);

		this.init();
		this.setBackground(new Color(137, 175, 155)); // �ı������ɫ

	}

	void init() {
		xinxijLabel.setBounds(50, 10, 500, 20);  //��ʾ��Ϣ
		add(xinxijLabel);
		numjLabel.setBounds(100, 50, 50, 30);  //����
		add(numjLabel);
		searchjTextField.setBounds(170, 50, 220, 30);  //������
		add(searchjTextField); 
		goButton.setBounds(405, 52, 60, 27);   //ǰ����ť
		add(goButton);
		salaryjLabel.setBounds(100, 165, 30, 20);  //����
		add(salaryjLabel);
		salaryjTextField.setBounds(140, 160, 100, 30);  //���ֿ�
		add(salaryjTextField);
		bumenjLabel.setBounds(330, 165, 40, 20);  //����
		add(bumenjLabel);
		comBox.setBounds(375, 160, 100, 30);  //ѡ�
		add(comBox);
		queButton.setBounds(250, 250, 60, 30);
		add(queButton);

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

	}
}
