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

public class DelPanel extends JPanel { // ɾ��

	JFrame jFrame;

	JButton jButton = new JButton("�鿴");
	JButton delButton = new JButton("ȷ��ɾ��");
	JTextField jTextField = new JTextField("���빤��", 20);

	static String tishiString = " "; // ��ʾ��Ϣ String
	static String thisDelPeopleString = " "; //
	JLabel xinxijLabel = new JLabel(tishiString);

	GoButtonListener goButtonListener = new GoButtonListener();

	private class GoButtonListener implements ActionListener { // ǰ����ť �ڲ���Listener //���Ҳ���ʾ

		HomePageSearch homePageSearch = new HomePageSearch(); // ʵ����HomePageSearch
		DelPeopleHomepage delPeopleHomepage = new DelPeopleHomepage();

		String regex = "[0-9]+"; // ȫ���� ������ʽ

		@Override
		public void actionPerformed(ActionEvent e) {
			String searchString = new String(jTextField.getText()); // �õ���������Ϣ

			// TODO Auto-generated method stub

			// TODO Auto-generated method stub
			if (searchString.equals("")) { // �ı���Ϊ��ʱ

				JLabel textJLabelShow = new JLabel("          �������ѯ�ؼ���");
				JDialog jDialog = new JDialog(jFrame, "��ʾ");
				jDialog.setBounds(700, 350, 200, 150); // ��ʾС���ڴ�С
				jDialog.setVisible(true);
				jDialog.add(textJLabelShow);

			} else {

				try {
					if (legalNumber(searchString) && searchNumberExist(searchString)) { // �ж��Ƿ�ȫΪ���� ���ձ�Ų���

						thisDelPeopleString = delPeopleHomepage.searchNumberDel(searchString); // ��ǰ׺��Ϣ
						tishiString = homePageSearch.searchNumberResult(searchString);
						xinxijLabel.setText(tishiString); // ��ʾ��Ϣ
					} else {

						JLabel textJLabelShow = new JLabel("         ����Ĺ��Ų����ڻ򲻺Ϸ�");
						JDialog jDialog = new JDialog(jFrame, "��ʾ");
						jDialog.setBounds(700, 350, 200, 150); // ��ʾС���ڴ�С
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
			HomePageSearch homePageSearch = new HomePageSearch(); // ʵ����HomePageSearch
			String delString = null;
			String[] delArrayString = null;

			String searchString = new String(jTextField.getText()); // �õ���������Ϣ
			String regex = "[0-9]+"; // ȫ���� ������ʽ
			if (legalNumber(searchString)) { // �Ƿ�Ϸ�

				try {
					if (searchString.matches(regex) && searchNumberExist(searchString)) { // �Ƿ����

						delString = delPeopleHomepage.searchNumberDel(searchString); // ��ǰ׺��Ϣ
						delArrayString = delString.split("��");

						delPeopleHomepage.deletePeopleAll(delArrayString[0]); // delAll
						delPeopleHomepage.delCategroPeople(delArrayString[0], delArrayString[5]); // delCategro
						delPeopleHomepage.delManager(delArrayString[0]);

						JLabel textJLabelShow = new JLabel("        ɾ�����");
						JDialog jDialog = new JDialog(jFrame, "��ʾ");
						jDialog.setBounds(700, 350, 200, 150); // ��ʾС���ڴ�С
						jDialog.setVisible(true);
						jDialog.add(textJLabelShow);
					} else {

						JLabel textJLabelShow = new JLabel("       �����ڴ�Ա��");
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
				JLabel textJLabelShow = new JLabel("       ������ȷ��Ա�����");
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

	public DelPanel(JFrame jFrame) {
		this.jFrame = jFrame;
		setLayout(null);

		this.init();
		this.setBackground(new Color(137, 175, 155)); // �ı������ɫ
//		jButton.addActionListener(goButtonListener);

	}

	public DelPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);

		this.init();
		this.setBackground(new Color(252, 157, 154)); // �ı������ɫ
		jButton.addActionListener(goButtonListener);
		delButton.addActionListener(delButtonLisetener);
	}

	void init() {

		xinxijLabel.setBounds(50, 10, 500, 20); // ��ʾ��Ϣ
		add(xinxijLabel);
		jTextField.setBounds(130, 100, 250, 30); // ��
		jButton.setBounds(400, 100, 60, 30); // ��ť
		delButton.setBounds(230, 300, 100, 40);
		add(delButton);
		add(jButton);
		add(jTextField);

	}
}
