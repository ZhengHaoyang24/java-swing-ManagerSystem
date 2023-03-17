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
	JButton changeButton = new JButton("ȷ����ְ");
	JLabel jLabel = new JLabel("����");
	JLabel jLabel2 = new JLabel("������ְΪ");
	JButton checkButton = new JButton("�鿴");
	JTextField jTextField = new JTextField("����Ա������");
	JComboBox<String> comBox = new JComboBox<String>(); // �����б�

	static String tishiString = " "; // ��ʾ��Ϣ String
	static String thisDelPeopleString = ""; //
	JLabel xinxijLabel = new JLabel(tishiString);

	CheckButtonListener checkButtonListener = new CheckButtonListener();

	private class CheckButtonListener implements ActionListener { // ǰ����ť �ڲ���Listener //���Ҳ���ʾ

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String searchString = new String(jTextField.getText()); // �õ���������Ϣ
			HomePageSearch homePageSearch = new HomePageSearch(); // ʵ����HomePageSearch
			DelPeopleHomepage delPeopleHomepage = new DelPeopleHomepage();

			String regex = "[0-9]+"; // ȫ���� ������ʽ
			// TODO Auto-generated method stub
			if (searchString.equals("")) { // �ı���Ϊ��ʱ

				JLabel textJLabelShow = new JLabel("          �������ѯ�ؼ���");
				JDialog jDialog = new JDialog(jFrame, "��ʾ");
				jDialog.setBounds(700, 350, 200, 150); // ��ʾС���ڴ�С
				jDialog.setVisible(true);
				jDialog.add(textJLabelShow);

			} else {
				if (searchString.matches(regex)) { // �ж��Ƿ�ȫΪ���� ���ձ�Ų���

					try {
						thisDelPeopleString = delPeopleHomepage.searchNumberDel(searchString); // ��ǰ׺��Ϣ
						tishiString = homePageSearch.searchNumberResult(searchString);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					xinxijLabel.setText(tishiString); // ��ʾ��Ϣ

				} else { // ������������

					try {
						thisDelPeopleString = delPeopleHomepage.searchNameDel(searchString);
						tishiString = homePageSearch.searchNameResult(searchString);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					xinxijLabel.setText(tishiString); // ��ʾ��Ϣ
				}
			}
		}
	}

	ChangeButtonListener changeButtonListener = new ChangeButtonListener();
	private class ChangeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String searchString = new String(jTextField.getText()); // �õ���������Ϣ
			HomePageSearch homePageSearch = new HomePageSearch(); // ʵ����HomePageSearch
//			DelPeopleHomepage delPeopleHomepage = new DelPeopleHomepage();
			SetManagerScripts setManagerScripts = new SetManagerScripts();
			String regex = "[0-9]+"; // ȫ���� ������ʽ
			String managerNameString = comBox.getSelectedItem().toString(); // ��ȡְλ
			
			if (searchString.matches(regex)) {
				try { 
					if (searchNumberExist(searchString) && legalNumber(searchString)) {
						System.out.println("yes");
						setManagerScripts.setManager(searchString, managerNameString);
						JLabel textJLabelShow = new JLabel("                        �ɹ�");
						JDialog jDialog = new JDialog(jFrame, "��ʾ");
						jDialog.setBounds(700, 350, 200, 150); // ��ʾС���ڴ�С
						jDialog.setVisible(true);
						jDialog.add(textJLabelShow);
						
					} else {
						JLabel textJLabelShow = new JLabel("          �������򲻴��ڴ�Ա��");
						JDialog jDialog = new JDialog(jFrame, "��ʾ");
						jDialog.setBounds(700, 350, 200, 150); // ��ʾС���ڴ�С
						jDialog.setVisible(true);
						jDialog.add(textJLabelShow);

					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else {
				JLabel textJLabelShow = new JLabel("          �������ѯ�ؼ���");
				JDialog jDialog = new JDialog(jFrame, "��ʾ");
				jDialog.setBounds(700, 350, 200, 150); // ��ʾС���ڴ�С
				jDialog.setVisible(true);
				jDialog.add(textJLabelShow);
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

	public SetManagerPanel(JFrame jFrame) {
		this.jFrame = jFrame;
		setLayout(null);

		this.init();
		this.setBackground(new Color(137, 175, 155)); // �ı������ɫ

//		checkButton.addActionListener(checkButtonListener);
//		changeButton.addActionListener(checkButtonListener);
	}

	public SetManagerPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);

		this.init();
		this.setBackground(new Color(232, 221, 203)); // �ı������ɫ

		checkButton.addActionListener(checkButtonListener);
		changeButton.addActionListener(changeButtonListener);
	}

	void init() {
		comBox.addItem("���³�");
		comBox.addItem("(CEO)��ϯִ�й�");
		comBox.addItem("(CBO)�����ܼ�");
		comBox.addItem("(CIO)�����ܼ�");
		comBox.addItem("(CFO)�����ܼ�");
		comBox.addItem("(CHO)�����ܼ�");

		jLabel2.setBounds(180, 154, 90, 20);
		add(jLabel2);
		xinxijLabel.setBounds(50, 10, 500, 20); // ��ʾ��Ϣ
		add(xinxijLabel);
		jLabel.setBounds(150, 90, 30, 20);
		add(jLabel);
		jTextField.setBounds(180, 85, 185, 30);
		add(jTextField);
		checkButton.setBounds(370, 87, 60, 26);
		add(checkButton);
		comBox.setBounds(256, 150, 140, 30); // ѡ�
		add(comBox);
		changeButton.setBounds(240, 250, 100, 40);
		add(changeButton);

	}
}
