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

public class MainPanel extends JPanel {   //��ҳ
	
	LocalTime localTime = new LocalTime();
	String timeString = localTime.getLocalTiminTitleString();

	JButton allInforButton = new JButton("��ʾ������Ϣ");
	
	JButton jButton = new JButton("ǰ��");
	JTextField jTextField = new JTextField("���빤�Ż�����");
	JLabel jLabel = new JLabel("����");
	JButton backButton = new JButton("�˳���¼");
	//HomePageWindow homepage; 
	JFrame jFrame;
	
	public MainPanel(JFrame jFrame){
		this.jFrame=jFrame;
		setLayout(null);

		this.init();
		this.setBackground(new Color(137,175,155)); // �ı������ɫ
		jButton.addActionListener(goButtonListener);
		backButton.addActionListener(quitButtonListener);
		allInforButton.addActionListener(allInformationButtonListener);
	}
	
	AllinformationButtonListener allInformationButtonListener = new AllinformationButtonListener();
	private class AllinformationButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AllinformationWindow allinformationWindow = new AllinformationWindow("Ա����Ϣ");   //����ҳ��  ����SetPasWindow
			jFrame.dispose();
			
		}
		
	}
	
	
	
	
	
	
	//�˳���¼��ť  �¼�����
	QuitButtonListener quitButtonListener = new QuitButtonListener();
	private class QuitButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {   //�ص���¼ҳ��
			// TODO Auto-generated method stub
			
			LoginWindow loginWindow = new LoginWindow("���");
			jFrame.dispose();	
		}
	}

	// ǰ����ť �¼�����
	GoButtonListener goButtonListener = new GoButtonListener();
	private class GoButtonListener implements ActionListener { // ǰ����ť �ڲ���Listener
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String searchString = new String(jTextField.getText()); // �õ���������Ϣ
			HomePageSearch homePageSearch = new HomePageSearch(); // ʵ����HomePageSearch

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
//						System.out.println(searchString);

					JLabel textJLabelShow = null;
					try {
						textJLabelShow = new JLabel("      " + homePageSearch.searchNumberResult(searchString));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JDialog jDialog = new JDialog(jFrame, "��ʾ");
					jDialog.setBounds(550, 350, 500, 150); // ��ʾС���ڴ�С
					jDialog.setVisible(true);
					jDialog.add(textJLabelShow);

				} else { // ������������ 
					System.out.println(searchString);
					JLabel textJLabelShow = null;
					try {
						textJLabelShow = new JLabel("      " + homePageSearch.searchNameResult(searchString));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JDialog jDialog = new JDialog(jFrame, "��ʾ");
					jDialog.setBounds(550, 350, 500, 150); // ��ʾС���ڴ�С
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
		this.setBackground(Color.LIGHT_GRAY); // �ı������ɫ
		jButton.addActionListener(goButtonListener);
		backButton.addActionListener(quitButtonListener);
		allInforButton.addActionListener(allInformationButtonListener);	

	}

	void init() {

		jLabel.setBounds(85, 130, 70, 20); // ����
		jTextField.setBounds(120, 125, 300, 30); // ��
		jButton.setBounds(430, 125, 60, 30); // ��ť
		backButton.setBounds(5, 5, 90, 30);
		allInforButton.setBounds(450, 340, 110, 30);
		add(allInforButton);
		add(backButton);
		add(jLabel);
		add(jButton);
		add(jTextField);

	}

}
