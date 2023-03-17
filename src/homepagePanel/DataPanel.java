package homepagePanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.IllegalCharsetNameException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import panelFunctionScripts.HomePageSearch;
import time.LocalTime;

public class DataPanel extends JPanel {
	
	LocalTime localTime = new LocalTime();
	String timeString = localTime.getLocalTiminTitleString();
	
	JLabel jLabelAbout = new JLabel("<html>MSoft is the world's Personal Computer software developed by the pilot, Tricy Zheng and "
			+ "Pillch Bao is the founder of it. Ranked third among the top brands in the \"Barents Weekly\" published in the World "
			+ "Brand Laboratory prepared the 2006 World Brand 500 2006 Global 100 companies are respected degree "
			+ "list No. 12. The enterprise at the 2008 annual \"Fortune\" the world's largest 500 companies were ranked 1th</html>");

	JLabel peopleJLabel = new JLabel("����Ա��:"); // Ա��ͳ��
	JLabel getPeopleJLabel = new JLabel();
	JLabel anquanzhibaoJLabel = new JLabel("��ȫ�ʱ���:"); // ��������
	JLabel caigoubuJLabel = new JLabel("�ɹ���:");
	JLabel caiwubuJLabel = new JLabel("����");
	JLabel chanpinshejizhongxinJLabel = new JLabel("��Ʒ�������:");
	JLabel fawubuJLabel = new JLabel("����:");
	JLabel gongyishiyebuJLabel = new JLabel("������ҵ��:");
	JLabel guanlibuJLabel = new JLabel("����:");
	JLabel jishuyanfazhongxinJLabel = new JLabel("�����з�����:");
	JLabel renliziyuanbuJLabel = new JLabel("������Դ��:");
	JLabel yewubuJLabel = new JLabel("ҵ��:");
	JLabel yingxiaobuJLabel = new JLabel("Ӫ����:");
	JLabel zongjingbanJLabel = new JLabel("�ܾ���:");
	JLabel anquanzhibaoJLabel2 = new JLabel();
	JLabel caigoubuJLabel2 = new JLabel();
	JLabel caiwubuJLabel2 = new JLabel();
	JLabel chanpinshejizhongxinJLabel2 = new JLabel();
	JLabel fawubuJLabel2 = new JLabel();
	JLabel gongyishiyebuJLabel2 = new JLabel();
	JLabel guanlibuJLabel2 = new JLabel();
	JLabel jishuyanfazhongxinJLabel2 = new JLabel();
	JLabel renliziyuanbuJLabel2 = new JLabel();
	JLabel yewubuJLabel2 = new JLabel();
	JLabel yingxiaobuJLabel2 = new JLabel();
	JLabel zongjingbanJLabel2 = new JLabel();

	JLabel jLabel1 = new JLabel("���³�:"); // ְλ
	JLabel jLabel2 = new JLabel("(CEO)��ϯִ�й�:");
	JLabel jLabel3 = new JLabel("(CBO)�����ܼ�:");
	JLabel jLabel4 = new JLabel("(CIO)�����ܼ�:");
	JLabel jLabel5 = new JLabel("(CFO)�����ܼ�:");
	JLabel jLabel6 = new JLabel("(CHO)�����ܼ�:");
	JLabel jLabel1Str = new JLabel();
	JLabel jLabel2Str = new JLabel();
	JLabel jLabel3Str = new JLabel();
	JLabel jLabel4Str = new JLabel();
	JLabel jLabel5Str = new JLabel();
	JLabel jLabel6Str = new JLabel();

	JLabel expensesAllJLabel = new JLabel("ȫ��ҵ��֧��:");
	JLabel expensesAllJLabel2 = new JLabel();
	JLabel incomeAllJLabel = new JLabel("ȫ��ҵ������:");
	JLabel incomeAllJLabel2 = new JLabel();
	JLabel chunlirunJLabel = new JLabel("������:");
	JLabel chunlirunJLabel2 = new JLabel();
	JLabel yanfaJLabel = new JLabel("�з�����:");
	JLabel yanfaJLabel2 = new JLabel();
	JLabel gupiaoJLabel = new JLabel("��Ʊ����:");
	JLabel gupiaoJLabel2 = new JLabel();
	JLabel touziJLabel = new JLabel("Ͷ�ʷ���:");
	JLabel touziJLabel2 = new JLabel();
	JLabel zongzichanJLabel = new JLabel("��˾���ʲ�:");
	JLabel zongzichanJLabel2 = new JLabel();

	JButton updateButton = new JButton("ˢ��");

	UpdateButtonListener updateButtonListener = new UpdateButtonListener(); // update�����¼�

	private class UpdateButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			HomePageSearch homePageSearch = new HomePageSearch();
			String[] managerArrayString = null;
			String[] tempStrarrayStrings = null;

			// ��ʾ��˾ְλ
			try {
				managerArrayString = (homePageSearch.getManagerString()).split("��");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (managerArrayString[0].equals("��")) {
				jLabel1Str.setText("��");
			} else {
				try {
					tempStrarrayStrings = (homePageSearch.changeOldScriptString(managerArrayString[0])).split("��");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jLabel1Str.setText(tempStrarrayStrings[2]);
			}
			if (managerArrayString[1].equals("��")) {
				jLabel2Str.setText("��");
			} else {
				try {
					tempStrarrayStrings = (homePageSearch.changeOldScriptString(managerArrayString[1])).split("��");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jLabel2Str.setText(tempStrarrayStrings[2]);
			}
			if (managerArrayString[2].equals("��")) {
				jLabel3Str.setText("��");
			} else {
				try {
					tempStrarrayStrings = (homePageSearch.changeOldScriptString(managerArrayString[2])).split("��");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jLabel3Str.setText(tempStrarrayStrings[2]);
			}
			if (managerArrayString[3].equals("��")) {
				jLabel4Str.setText("��");
			} else {
				try {
					tempStrarrayStrings = (homePageSearch.changeOldScriptString(managerArrayString[3])).split("��");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jLabel4Str.setText(tempStrarrayStrings[2]);
			}
			if (managerArrayString[4].equals("��")) {
				jLabel5Str.setText("��");
			} else {
				try {
					tempStrarrayStrings = (homePageSearch.changeOldScriptString(managerArrayString[4])).split("��");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jLabel5Str.setText(tempStrarrayStrings[2]);
			}
			if (managerArrayString[5].equals("��")) {
				jLabel6Str.setText("��");
			} else {
				try {
					tempStrarrayStrings = (homePageSearch.changeOldScriptString(managerArrayString[5])).split("��");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jLabel6Str.setText(tempStrarrayStrings[2]);
			}
			// ��ʾԱ���ܸ���

			try {
				if (homePageSearch.getPeopleNum().equals("0")) {
					getPeopleJLabel.setText("0");
				} else {
					getPeopleJLabel.setText(homePageSearch.getPeopleNum() + "��");
				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// �õ���������Ա������
			try {
				if (homePageSearch.getCategroAmount("��ȫ�ʱ���").equals("0")) {
					anquanzhibaoJLabel2.setText("0");
				} else {

					anquanzhibaoJLabel2.setText(homePageSearch.getCategroAmount("��ȫ�ʱ���") + "��");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				if (homePageSearch.getCategroAmount("�ɹ���").equals("0")) {
					caigoubuJLabel2.setText("0");
				} else {

					caigoubuJLabel2.setText(homePageSearch.getCategroAmount("�ɹ���") + "��");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				if (homePageSearch.getCategroAmount("����").equals("0")) {
					caiwubuJLabel2.setText("0");
				} else {

					caiwubuJLabel2.setText(homePageSearch.getCategroAmount("����") + "��");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				if (homePageSearch.getCategroAmount("��Ʒ�������").equals("0")) {
					chanpinshejizhongxinJLabel2.setText("0");
				} else {

					chanpinshejizhongxinJLabel2.setText(homePageSearch.getCategroAmount("��Ʒ�������") + "��");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				if (homePageSearch.getCategroAmount("����").equals("0")) {
					fawubuJLabel2.setText("0");
				} else {

					fawubuJLabel2.setText(homePageSearch.getCategroAmount("����") + "��");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				if (homePageSearch.getCategroAmount("������ҵ��").equals("0")) {
					gongyishiyebuJLabel2.setText("0");
				} else {

					gongyishiyebuJLabel2.setText(homePageSearch.getCategroAmount("������ҵ��") + "��");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				if (homePageSearch.getCategroAmount("����").equals("0")) {
					guanlibuJLabel2.setText("0");
				} else {

					guanlibuJLabel2.setText(homePageSearch.getCategroAmount("����") + "��");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				if (homePageSearch.getCategroAmount("�����з�����").equals("0")) {
					jishuyanfazhongxinJLabel2.setText("0");
				} else {

					jishuyanfazhongxinJLabel2.setText(homePageSearch.getCategroAmount("�����з�����") + "��");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				if (homePageSearch.getCategroAmount("������Դ��").equals("0")) {
					renliziyuanbuJLabel2.setText("0");
				} else {

					renliziyuanbuJLabel2.setText(homePageSearch.getCategroAmount("������Դ��") + "��");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (homePageSearch.getCategroAmount("ҵ��").equals("0")) {
					yewubuJLabel2.setText("0");
				} else {

					yewubuJLabel2.setText(homePageSearch.getCategroAmount("ҵ��") + "��");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (homePageSearch.getCategroAmount("Ӫ����").equals("0")) {
					yingxiaobuJLabel2.setText("0");
				} else {

					yingxiaobuJLabel2.setText(homePageSearch.getCategroAmount("Ӫ����") + "��");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (homePageSearch.getCategroAmount("�ܾ���").equals("0")) {
					zongjingbanJLabel2.setText("0");
				} else {

					zongjingbanJLabel2.setText(homePageSearch.getCategroAmount("�ܾ���") + "��");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// ������Ϣ
			int allSalary = 0;
			try {
				allSalary = Integer.parseInt(homePageSearch.getAllSalary());
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // תΪ����
			int incomeAll = (int) (allSalary * 12 / 0.1);
			int expensesAll = (int) (incomeAll * 0.7);
			int chunlirun = (int) (incomeAll * 0.3);
			int yanfa = (int) (expensesAll * 0.5);
			int inves = (int) (expensesAll * 0.4);
			int gupiao = (int) (incomeAll * 0.21);
			int zongzichan = (int) (incomeAll/0.73*0.0001);

			incomeAllJLabel2.setText(String.valueOf(incomeAll) + "Ԫ");
			expensesAllJLabel2.setText(String.valueOf(expensesAll) + "Ԫ");
			chunlirunJLabel2.setText(String.valueOf(chunlirun) + "Ԫ");
			yanfaJLabel2.setText(String.valueOf(yanfa) + "Ԫ");
			touziJLabel2.setText(String.valueOf(inves) + "Ԫ");
			gupiaoJLabel2.setText(String.valueOf(gupiao) + "Ԫ");
			zongzichanJLabel2.setText(String.valueOf(zongzichan) + "��Ԫ");

		}

	}
	

	public DataPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);

		this.init();
		this.setBackground(new Color(255, 245, 247)); // �ı������ɫ
		updateButton.addActionListener(updateButtonListener);
		
	}


	void init() {
		
		

		peopleJLabel.setBounds(10, 200, 90, 20); // Ա��
		add(peopleJLabel);
		getPeopleJLabel.setBounds(70, 200, 90, 20);
		add(getPeopleJLabel);
		// ���� Ա��
		anquanzhibaoJLabel.setBounds(10, 230, 90, 20); // ��ȫ�ʱ�
		add(anquanzhibaoJLabel);
		anquanzhibaoJLabel2.setBounds(80, 230, 90, 20);
		add(anquanzhibaoJLabel2);
		caigoubuJLabel.setBounds(10, 250, 90, 20); // �ɹ���
		add(caigoubuJLabel);
		caigoubuJLabel2.setBounds(60, 250, 90, 20);
		add(caigoubuJLabel2);
		caiwubuJLabel.setBounds(10, 270, 90, 20); // ����
		add(caiwubuJLabel);
		caiwubuJLabel2.setBounds(60, 270, 90, 20);
		add(caiwubuJLabel2);
		chanpinshejizhongxinJLabel.setBounds(10, 290, 90, 20); // ��Ʒ���
		add(chanpinshejizhongxinJLabel);
		chanpinshejizhongxinJLabel2.setBounds(90, 290, 90, 20);
		add(chanpinshejizhongxinJLabel2);
		fawubuJLabel.setBounds(10, 310, 90, 20); // ����
		add(fawubuJLabel);
		fawubuJLabel2.setBounds(60, 310, 90, 20);
		add(fawubuJLabel2);
		gongyishiyebuJLabel.setBounds(10, 330, 90, 20); // ������ҵ
		add(gongyishiyebuJLabel);
		gongyishiyebuJLabel2.setBounds(80, 330, 90, 20);
		add(gongyishiyebuJLabel2);
		guanlibuJLabel.setBounds(140, 230, 90, 20); // ���� �ڶ���
		add(guanlibuJLabel);
		guanlibuJLabel2.setBounds(190, 230, 90, 20);
		add(guanlibuJLabel2);
		jishuyanfazhongxinJLabel.setBounds(140, 250, 90, 20); // �����з�����
		add(jishuyanfazhongxinJLabel);
		jishuyanfazhongxinJLabel2.setBounds(220, 250, 90, 20);
		add(jishuyanfazhongxinJLabel2);
		renliziyuanbuJLabel.setBounds(140, 270, 90, 20); // ������Դ��
		add(renliziyuanbuJLabel);
		renliziyuanbuJLabel2.setBounds(210, 270, 90, 20);
		add(renliziyuanbuJLabel2);
		yewubuJLabel.setBounds(140, 290, 90, 20); // ҵ��
		add(yewubuJLabel);
		yewubuJLabel2.setBounds(190, 290, 90, 20);
		add(yewubuJLabel2);
		yingxiaobuJLabel.setBounds(140, 310, 90, 20); // Ӫ����
		add(yingxiaobuJLabel);
		yingxiaobuJLabel2.setBounds(190, 310, 90, 20);
		add(yingxiaobuJLabel2);
		zongjingbanJLabel.setBounds(140, 330, 90, 20); // �ܾ���
		add(zongjingbanJLabel);
		zongjingbanJLabel2.setBounds(190, 330, 90, 20);
		add(zongjingbanJLabel2);
		
		// ������Ϣ
		expensesAllJLabel.setBounds(320, 200, 90, 20);
		add(expensesAllJLabel);
		expensesAllJLabel2.setBounds(405, 200, 200, 20);
		add(expensesAllJLabel2);	
		incomeAllJLabel.setBounds(320, 220, 90, 20);
		add(incomeAllJLabel);
		incomeAllJLabel2.setBounds(405, 220, 200, 20);
		add(incomeAllJLabel2);
		chunlirunJLabel.setBounds(320, 240, 90, 20);
		add(chunlirunJLabel);
		chunlirunJLabel2.setBounds(370, 240, 200, 20);
		add(chunlirunJLabel2);
		yanfaJLabel.setBounds(320, 260, 200, 20);
		add(yanfaJLabel);
		yanfaJLabel2.setBounds(380, 260, 200, 20);
		add(yanfaJLabel2);
		gupiaoJLabel.setBounds(320, 280, 90, 20);
		add(gupiaoJLabel);
		gupiaoJLabel2.setBounds(380, 280, 200, 20);
		add(gupiaoJLabel2);
		touziJLabel.setBounds(320, 300, 90, 20);
		add(touziJLabel);
		touziJLabel2.setBounds(380, 300, 200, 20);
		add(touziJLabel2);
		zongzichanJLabel.setBounds(320,330,90,20);
		add(zongzichanJLabel);
		zongzichanJLabel2.setBounds(390,330,200,20);
		add(zongzichanJLabel2);
		
		


		updateButton.setBounds(515, 5, 60, 30); // ��ť
		add(updateButton);

		jLabel1.setBounds(69, 30, 90, 20); // ְλ
		add(jLabel1);
		jLabel2.setBounds(10, 50, 100, 20);
		add(jLabel2);
		jLabel3.setBounds(22, 70, 100, 20);
		add(jLabel3);
		jLabel4.setBounds(27, 90, 100, 20);
		add(jLabel4);
		jLabel5.setBounds(23, 110, 100, 20);
		add(jLabel5);
		jLabel6.setBounds(22, 130, 100, 20);
		add(jLabel6);
		//
		jLabel1Str.setBounds(120, 30, 50, 20);
		add(jLabel1Str);
		jLabel2Str.setBounds(120, 50, 50, 20);
		add(jLabel2Str);
		jLabel3Str.setBounds(120, 70, 50, 20);
		add(jLabel3Str);
		jLabel4Str.setBounds(120, 90, 50, 20);
		add(jLabel4Str);
		jLabel5Str.setBounds(120, 110, 50, 20);
		add(jLabel5Str);
		jLabel6Str.setBounds(120, 130, 50, 20);
		add(jLabel6Str);
		
		
		jLabelAbout.setBounds(200, -10, 320, 200);
		add(jLabelAbout);
	}

}
