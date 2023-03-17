package homepage;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.net.DatagramPacket;

import javax.naming.InitialContext;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.text.ChangedCharSetException;

import homepagePanel.AddPanel;
import homepagePanel.ChangePanel;
import homepagePanel.DataPanel;
import homepagePanel.DelPanel;
import homepagePanel.MainPanel;
import homepagePanel.SetManagerPanel;

public class HomePageWindow extends JFrame {      //���ܿ��

	
//	DelPanelNullLayout delPanel; 
//	AddPanelNullLayout addPanel;
	
	
	JTabbedPane jTabbedPane = new JTabbedPane();   //ѡ�����
	
	MainPanel mainPanel =new MainPanel(getJFrame());   //ѡ�ҳ��
	AddPanel addPanel = new AddPanel();
	ChangePanel changePanel = new ChangePanel();
	DelPanel delPanel = new DelPanel();
	DataPanel dataPanel = new DataPanel();
	SetManagerPanel setManagerPanel = new SetManagerPanel();
	
	Box box = Box.createHorizontalBox();

	public HomePageWindow(String string) {

		super(string);
		
		jTabbedPane.add("    ��ҳ    ",mainPanel);  //���ѡ�
		jTabbedPane.add("    ¼��    ",addPanel);
		jTabbedPane.add("    ��Ա����    ",changePanel);
		jTabbedPane.add("    ����    ",delPanel);
		jTabbedPane.add("    ��ְ    ",setManagerPanel);
		jTabbedPane.add("    ��˾����    ",dataPanel);
		
		this.add(jTabbedPane); 
		
		this.getContentPane().setBackground(Color .white);    //�ı�ѡ�������ɫ
		setBounds(500, 200, 600, 450);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public JFrame getJFrame(){
		return this;
		
	}

}
