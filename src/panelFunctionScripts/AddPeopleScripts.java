package panelFunctionScripts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class AddPeopleScripts {
	
	private String categroFile;

	public boolean addPeople(String []strArray) throws IOException {   //д�������ļ�

		File allFile = new File("file/information/all.txt"); 
		
		Writer writerAll=new FileWriter(allFile,true);    //д������
		writerAll.write(strArray[0] + "��" + strArray[1] + "��" + strArray[2] + "��" + strArray[3] + "��" + strArray[4]
				+ "��" + strArray[5]+"\r\n");
		writerAll.flush();    //������

		return true;
		
	}
	
	public boolean addCategroPeople(String []strArray,String bumenString ) throws IOException {   //д������ļ�	
		

		File categroyFile = null; 
		//�жϲ��ţ���ɾ��������Ϣ
		if (bumenString.equals("��ȫ�ʱ���")) {
			categroyFile = new File("file/information/anquanzhibaobu.txt");	
		}
		if (bumenString.equals("�ɹ���")) {
			categroyFile = new File("file/information/caigoubu.txt");	
		}
		if (bumenString.equals("����")) {
			categroyFile = new File("file/information/caiwubu.txt");	
		}
		if (bumenString.equals("��Ʒ�������")) {
			categroyFile = new File("file/information/chanpingshejizhongxin.txt");	
		}
		if (bumenString.equals("����")) {
			categroyFile = new File("file/information/fawubu.txt");	
		}
		if (bumenString.equals("������ҵ��")) {
			categroyFile = new File("file/information/gongyishiyebu.txt");	
		}
		if (bumenString.equals("����")) {
			categroyFile = new File("file/information/guanlibu.txt");	
		}
		if (bumenString.equals("�����з�����")) {
			categroyFile = new File("file/information/jishuyanfazhongxin.txt");	
		}
		if (bumenString.equals("������Դ��")) {
			categroyFile = new File("file/information/renliziyuanbu.txt");	
		}
		if (bumenString.equals("ҵ��")) {
			categroyFile = new File("file/information/yewubu.txt");	
		}
		if (bumenString.equals("Ӫ����")) {
			categroyFile = new File("file/information/yingxiaobu.txt");	
		}
		if (bumenString.equals("�ܾ���")) {
			categroyFile = new File("file/information/zongjingban.txt"); 
		}

		Writer writerAll=new FileWriter(categroyFile,true);    //д������
		writerAll.write(strArray[0] + "��" + strArray[1] + "��" + strArray[2] + "��" + strArray[3] + "��" + strArray[4]
				+ "��" + strArray[5]+"\r\n");
		writerAll.flush();    //������

		return true;
		
		
	}

}
