package homepagePanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import homepage.HomePageWindow;
import time.LocalTime;

public class AllinformationWindow extends JFrame{
	
	LocalTime localTime = new LocalTime();
	String timeString = localTime.getLocalTiminTitleString();
	
	
	JButton jButton = new JButton("����");
	
	

	JTable table = new JTable();
	DefaultTableModel tableModel = new DefaultTableModel();
	
	ButtonListener buttonListener = new ButtonListener();
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			HomePageWindow homePageWindow = new HomePageWindow(timeString);
			dispose();
			
		}
		
	}
	
	public AllinformationWindow(String s){
		
		
		
		super(s);
		jButton.addActionListener(buttonListener);
		
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());
		this.setContentPane(root);
		root.add(jButton,BorderLayout.SOUTH);
		
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setRowHeight(24);
		table.setModel(tableModel);
		
		root.add(new JScrollPane(table),BorderLayout.CENTER);
		
		tableModel.addColumn("����");
		tableModel.addColumn("�Ա�");
		tableModel.addColumn("����");
		tableModel.addColumn("����");
		tableModel.addColumn("�¹���");
		tableModel.addColumn("����");
		
		try {
			readAlllist();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setBounds(500, 200, 600, 450);    //�����С
		this.getContentPane().setBackground(new Color(130,130,180));    //�ı������ɫ
		this.setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void addRow(String [] rowdata) {   //��ÿ����Ϣ �����б���   ����
		
		Vector<String> rowData = new Vector<String>();
		rowData.add(rowdata[0]);
		rowData.add(rowdata[1]);
		rowData.add(rowdata[2]);
		rowData.add(rowdata[3]);
		rowData.add(rowdata[4]);
		rowData.add(rowdata[5]);
		tableModel.addRow(rowData);	
	}
	
	public void readAlllist() throws IOException { // ����ÿ����Ϣ
		String []array = new String[6];
		File file = new File("file/information/all.txt");
		Reader reader = new FileReader(file);
		BufferedReader searchReader2 = new BufferedReader(reader);
		// �����ļ���ȡ
			String lineString;
			while ((lineString = searchReader2.readLine()) != null) {;
				array = lineString.split("��");
				addRow(array);
			}
	}
	
}
