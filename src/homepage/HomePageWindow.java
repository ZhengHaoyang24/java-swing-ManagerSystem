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

public class HomePageWindow extends JFrame {      //功能框架

	
//	DelPanelNullLayout delPanel; 
//	AddPanelNullLayout addPanel;
	
	
	JTabbedPane jTabbedPane = new JTabbedPane();   //选项卡窗口
	
	MainPanel mainPanel =new MainPanel(getJFrame());   //选项卡页面
	AddPanel addPanel = new AddPanel();
	ChangePanel changePanel = new ChangePanel();
	DelPanel delPanel = new DelPanel();
	DataPanel dataPanel = new DataPanel();
	SetManagerPanel setManagerPanel = new SetManagerPanel();
	
	Box box = Box.createHorizontalBox();

	public HomePageWindow(String string) {

		super(string);
		
		jTabbedPane.add("    主页    ",mainPanel);  //添加选项卡
		jTabbedPane.add("    录用    ",addPanel);
		jTabbedPane.add("    人员调动    ",changePanel);
		jTabbedPane.add("    清退    ",delPanel);
		jTabbedPane.add("    提职    ",setManagerPanel);
		jTabbedPane.add("    公司详情    ",dataPanel);
		
		this.add(jTabbedPane); 
		
		this.getContentPane().setBackground(Color .white);    //改变选项卡背景颜色
		setBounds(500, 200, 600, 450);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public JFrame getJFrame(){
		return this;
		
	}

}
