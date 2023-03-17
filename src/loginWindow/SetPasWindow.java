package loginWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.text.AbstractDocument.LeafElement;

import password.*;
import time.LocalTime;

public class SetPasWindow extends JFrame { // �޸�����ҳ��

	JFrame setPasWindowFrame = new JFrame();

	JPanel jPanel = new JPanel();
	Box kongBox = Box.createHorizontalBox();
	Box kuangBox1 = Box.createHorizontalBox();
	Box kuangBox2 = Box.createHorizontalBox();
	Box kuangBox3 = Box.createHorizontalBox();
	Box kuangBox4 = Box.createHorizontalBox();
	Box kuangBox5 = Box.createHorizontalBox();
	Box jBox = Box.createHorizontalBox(); 
	Box acBox = Box.createVerticalBox();
	Box pasBox = Box.createVerticalBox();
	Box sangekuang = Box.createVerticalBox();
//
	JLabel oldAccountJLabel = new JLabel("��������˺�");
	JTextField oldAccouJTextField = new JTextField(20); // ���˺ſ�
//	JLabel newAccouJLabel = new JLabel("���������˺�");
//	JTextField newAccountJTextField = new JTextField(20); // ���˺ſ�
	JLabel oldPasJLabel = new JLabel("������ԭ����");
	JTextField oldPasJTextField = new JTextField(20); // ԭ�����
	JLabel newPasJLabel1 = new JLabel("������������");
	JTextField newPasJTextField1 = new JTextField(20); // �������1
	JLabel newPasJLabel2 = new JLabel("������������");
	JTextField newPaJTextField2 = new JTextField(20); // �������2

	JButton jButtonQue = new JButton("ȷ��"); // ȷ����ť
	JButton jButtonCancel = new JButton("����"); // ȡ����ť

	QuedingButton quedingListenerButton = new QuedingButton(); // ʵ����ȷ����ť

	private class QuedingButton implements ActionListener { // �ڲ��� ȷ����ť
		@Override
		public void actionPerformed(ActionEvent e) { 
			SetAccoandPas set = new SetAccoandPas();

			String accoOldString = new String(oldAccouJTextField.getText()); // ��ȡ���˺ſ���Ϣ
//			String accoNewString = new String(newAccountJTextField.getText()); // ��ȡ���˺ſ���Ϣ
			String pasOldString = new String(oldPasJTextField.getText()); // ��ȡԭ�������Ϣ
			String pasNewString1 = new String(newPasJTextField1.getText()); // ��ȡԭ�������Ϣ1
			String pasNewString2 = new String(newPaJTextField2.getText()); // ��ȡԭ�������Ϣ2
			// TODO Auto-generated method stub
			try {
				if (accoOldString.equals("")||pasOldString.equals("")||pasNewString1.equals("")||pasNewString2.equals("")){
					//�ж��ı����Ƿ�����
					JLabel textJLabel2 = new JLabel("                    ����δ�������Ϣ�������ơ�");
					JDialog jDialog2 = new JDialog(setPasWindowFrame, "  ");
					jDialog2.setBounds(650, 350, 300, 150); // ��ʾС���ڴ�С
					jDialog2.setVisible(true);
					jDialog2.add(textJLabel2);
					jDialog2.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} else {
					if (set.getPassword().equals(pasOldString) && pasNewString1.equals(pasNewString2)
							&& accoOldString.equals(set.getAccount())) { // ȫ��
						set.setPas(pasNewString2);
						JLabel textJLabel2 = new JLabel("      �޸ĳɹ�������");
						JDialog jDialog2 = new JDialog(setPasWindowFrame, "  ");
						jDialog2.setBounds(650, 350, 300, 150); // ��ʾС���ڴ�С
						jDialog2.setVisible(true);
						jDialog2.add(textJLabel2);
						jDialog2.setDefaultCloseOperation(EXIT_ON_CLOSE);

					} else {
						if (!accoOldString.equals(set.getAccount())) {
							JLabel textJLabel2 = new JLabel("      �������ԭ�˺Ŵ�������������");
							JDialog jDialog2 = new JDialog(setPasWindowFrame, "  ");
							jDialog2.setBounds(650, 350, 300, 150); // ��ʾС���ڴ�С
							jDialog2.setVisible(true);
							jDialog2.add(textJLabel2);
							jDialog2.setDefaultCloseOperation(EXIT_ON_CLOSE);
						} else {
							if (!pasOldString.equals(set.getPassword())) {
								JLabel textJLabel2 = new JLabel("      �������ԭ�����������������");
								JDialog jDialog2 = new JDialog(setPasWindowFrame, "  ");
								jDialog2.setBounds(650, 350, 300, 150); // ��ʾС���ڴ�С
								jDialog2.setVisible(true);
								jDialog2.add(textJLabel2);
								jDialog2.setDefaultCloseOperation(EXIT_ON_CLOSE);
							} else {
								if (!pasNewString1.equals(pasNewString2)) { // �������벻��
									JLabel textJLabel2 = new JLabel("      ��������������벻��ͬ������������");
									JDialog jDialog2 = new JDialog(setPasWindowFrame, "  ");
									jDialog2.setBounds(650, 350, 300, 150); // ��ʾС���ڴ�С
									jDialog2.setVisible(true);
									jDialog2.add(textJLabel2);
									jDialog2.setDefaultCloseOperation(EXIT_ON_CLOSE);

								}

							}
						}

					}
				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	CancelButton jButtonCance = new CancelButton(); // ʵ����ȡ����ť

	private class CancelButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			LoginWindow loginWindow = new LoginWindow("wqd"); // ����ҳ�� ����LoginWindow
			dispose();
		}

		public void setPreferredSize(Dimension dimension) {
			// TODO Auto-generated method stub

		}

		public void setBackground(Color blue) {
			// TODO Auto-generated method stub

		}

	}

	public SetPasWindow(String s) { // ���췽��
		// TODO Auto-generated constructor stub
		super(s);
		setBounds(500, 200, 600, 450); // �����С

		this.initSetWindow();
//		this.add(jButtonCancel);

		this.add(sangekuang);
		this.getContentPane().setBackground(Color.pink); // �ı������ɫ
		this.setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jButtonQue.addActionListener(quedingListenerButton); // ȷ����ť�����¼�

		jButtonCancel.addActionListener(jButtonCance); // ȡ����ť�����¼�
	}

	void initSetWindow() {

		setLayout(new FlowLayout()); 
		kuangBox1.add(oldAccountJLabel);
		kuangBox1.add(Box.createHorizontalStrut(10));
		kuangBox1.add(oldAccouJTextField);
//		kuangBox2.add(newAccouJLabel);
//		kuangBox2.add(Box.createHorizontalStrut(10));
//		kuangBox2.add(newAccountJTextField);
		kuangBox3.add(oldPasJLabel);
		kuangBox3.add(Box.createHorizontalStrut(10));
		kuangBox3.add(oldPasJTextField);
		kuangBox4.add(newPasJLabel1);
		kuangBox4.add(Box.createHorizontalStrut(10));
		;
		kuangBox4.add(newPasJTextField1);
		kuangBox5.add(newPasJLabel2);
		kuangBox5.add(Box.createHorizontalStrut(10));
		kuangBox5.add(newPaJTextField2);

		acBox.add(Box.createVerticalStrut(80));
		acBox.add(kuangBox1);
		acBox.add(Box.createVerticalStrut(6));
		acBox.add(kuangBox2);

		pasBox.add(Box.createVerticalStrut(20));
		pasBox.add(kuangBox3);
		pasBox.add(Box.createVerticalStrut(6));
		pasBox.add(kuangBox4);
		pasBox.add(Box.createVerticalStrut(6));
		pasBox.add(kuangBox5);
		pasBox.add(Box.createVerticalStrut(90)); // �˺����������

		jButtonQue.setBackground(Color.green);

		jButtonCance.setBackground(Color.PINK);
		jBox.add(jButtonCancel);
		jBox.add(pasBox.createHorizontalStrut(50)); // ȡ����ť��ȷ����ť����
		jBox.add(jButtonQue);
		pasBox.add(Box.createVerticalStrut(20));
//		kongBox.add(jButtonCancel);		
		sangekuang.add(kongBox);
		sangekuang.add(acBox);
		sangekuang.add(pasBox);
		sangekuang.add(jBox); 
		setPasWindowFrame.add(sangekuang);
//		pasBox.add(Box.createVerticalStrut(50)); // �˺����������

	}
}
