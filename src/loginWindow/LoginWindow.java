package loginWindow;

import password.*;
import homepage.*;
import time.*;

import javax.crypto.KeyAgreement;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginWindow extends JFrame {
	static int times = 0; // ��¼��������������
	
	LocalTime localTime = new LocalTime();
	JLabel jLabelTime = new JLabel(localTime.getLocalTimString());    //��ȡʱ��
	String timeString = localTime.getLocalTiminTitleString();
	
	JFrame jFrame = new JFrame();   
//	JPanel jPanel = new JPanel();
	Box daBox = Box.createVerticalBox();
	Box box = Box.createVerticalBox(); // ��box
	Box box_xia = Box.createHorizontalBox();
	Box box_timeBox = Box.createHorizontalBox();

	JTextField jTextField; // �˺ſ�
	JLabel jLabel;
	JPasswordField jPasswordField; // �����
	JButton jButton; // ��¼��ť
	JButton jButton2; // �޸����밴ť
	JButton forgetPasButton;  //������ť

	SetButtonListener setButtonListener = new SetButtonListener();   //�޸����� ʵ����  ������
	private class SetButtonListener implements ActionListener{   

		@Override
		public void actionPerformed(ActionEvent e) {    //�޸����밴ť ������ �ڲ���
			// TODO Auto-generated method stub
			
			SetPasWindow SetPasWindow = new SetPasWindow("�޸�����");   //����ҳ��  ����SetPasWindow
			dispose();
			
		}
		
	}
	
	BangzhuListener bangzhuListener = new BangzhuListener();  //������ ������ť ʵ����
	private class BangzhuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {   //������ť������ �ڲ���
			// TODO Auto-generated method stub
			JLabel help_text = new JLabel(); 
			help_text.setText("<html>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp��ʼ�˺�Ϊ��username"
					+ "<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp��ʼ����Ϊ��000000</html>") ;
			JDialog help_window = new JDialog(jFrame, "����"); 
			help_window.setBounds(650, 350, 280, 150); // ��ʾС���ڴ�С
			help_window.setVisible(true);
			help_window.add(help_text);
//			help_window.setDefaultCloseOperation(EXIT_ON_CLOSE);
						
		}	
	}
	
	DengluListener dengluListener = new DengluListener();  // ������  ��¼��ť ʵ����
	private class DengluListener implements ActionListener {  // ��¼��ť������ �ڲ���
		@Override
 
		public void actionPerformed(ActionEvent e) {  // ��¼���� ������д 
			
			String password = new String(jPasswordField.getPassword()); // ��ȡ�����������Ϣ
			String accou = new String(jTextField.getText()); // ��ȡ�˺ſ���Ϣ
			JudgePassword judgePassword = new JudgePassword(); // ʵ����JudgePassword ��
			JudgeAccount judgeAccount = new JudgeAccount(); // ʵ����JudgeAccount��

			try {
				if ((!judgePassword.Judge(password)) || (!judgeAccount.Judge(accou))) { // �ж��������˺��Ƿ���ȷ
					if (times <= 2) { // ������󳬹�1�Σ���ʾ����
						times++;
						JLabel textJLabel2 = new JLabel("        ��������˺Ż������Ѵ���" + times + "��,����" + (4 - times) + 
								"�λ���.");
						JDialog jDialog2 = new JDialog(jFrame, "��ʾ");
						jDialog2.setBounds(650, 350, 300, 150); // ��ʾС���ڴ�С
						jDialog2.setVisible(true);
						jDialog2.add(textJLabel2);
						jDialog2.setDefaultCloseOperation(EXIT_ON_CLOSE);

						
					} else {  // ���󳬹���Σ���ʾ�Ƿ��޸�����
						JLabel textJLabel2 = new JLabel("      ������������Ѿ�����4��,���˳�ϵͳ�Ժ�����");
						JDialog jDialog2 = new JDialog(jFrame, "��ʾ");
						jDialog2.setBounds(650, 350, 300, 150); // ��ʾС���ڴ�С 
						jDialog2.setVisible(true);
						jDialog2.add(textJLabel2);
						jDialog2.setDefaultCloseOperation(EXIT_ON_CLOSE);
					}
 
				} else {
					
					// loading ת��ҳ�� ��½�ɹ�  ת�� homePageWindow
					HomePageWindow homePageWindow = new HomePageWindow(timeString);
					dispose();
					
				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	public LoginWindow(String s) { // ���췽��
		// TODO Auto-generated constructor stub
		super(s);
		setBounds(500, 200, 600, 450);    //�����С

		this.init();
//		this.add(jLabelTime);
		this.add(box);
		this.add(box_xia);
		
		this.getContentPane().setBackground(new Color(137,157,192));    //�ı������ɫ
		this.setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jButton2.addActionListener(setButtonListener);  //�޸İ�ť�����¼�
		jButton.addActionListener(dengluListener); // ��¼��ť�����¼�
		forgetPasButton.addActionListener(bangzhuListener);  //������ť�����¼�
//		this.setBackground(Color.yellow); //Ϊ����������ɫ
	}

	void init() {
		
		setLayout(new FlowLayout());

		box.add(jLabelTime);    //���ʱ��

		jLabel = new JLabel("�˺�");
		jTextField = new JTextField(20);
		JLabel jLabel2 = new JLabel("����");
		jPasswordField = new JPasswordField(20);

		box.add(Box.createVerticalStrut(120));
		box.add(jLabel);
		box.add(jTextField);
		box.add(Box.createVerticalStrut(20));
		box.add(jLabel2);
		box.add(jPasswordField);
		box.add(Box.createVerticalStrut(100));

		                                        //��box_xia������
		jButton2 = new JButton("�޸�����");  //�޸İ�ť
		jButton2.setBackground(Color.cyan);
		jButton = new JButton("��¼");     //��¼��ť
		jButton.setBackground(Color.green);
		forgetPasButton = new JButton("����");  //�������밴ť
		forgetPasButton.setBackground(Color.orange);
		box_xia.add(jButton2);
		box_xia.add(Box.createHorizontalStrut(100));   //��ť����
		box_xia.add(jButton);
		box_xia.add(Box.createHorizontalStrut(100));
		box_xia.add(forgetPasButton);
		 

		daBox.add(box);
		daBox.add(box_xia);
		jFrame.add(daBox);
	}
}
