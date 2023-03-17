package panelFunctionScripts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import javax.swing.InputVerifier;

public class HomePageSearch { // ����Ա�� ����ʵ��

	public String searchNumberResult(String s) throws IOException { // ���ձ�Ų���

		File file = new File("file/information/all.txt");
		Reader reader = new FileReader(file);
		BufferedReader searchReader1 = new BufferedReader(reader);
		// �����ļ���ȡ
		try {
			String lineString;
			while ((lineString = searchReader1.readLine()) != null) {
				String str = lineString;
				String[] strArray = str.split("��");
				if (strArray[0].equals(s)) {
					return "���:" + strArray[0] + "    �Ա�:" + strArray[1] + "    ����:" + strArray[2] + "    ����:"
							+ strArray[3] + "��    ����:" + strArray[4] + "Ԫ/��    ����:" + strArray[5];
				}
			}
			return "                     û���ҵ���Ա����Ϣ";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "                     û���ҵ���Ա����Ϣ";
		}
	}

	public String searchNameResult(String s) throws IOException { // ������������

		File file = new File("file/information/all.txt");
		Reader reader = new FileReader(file);
		BufferedReader searchReader2 = new BufferedReader(reader);
		// �����ļ���ȡ
		try {
			String lineString;
			while ((lineString = searchReader2.readLine()) != null) {
				String str = lineString;
				String[] strArray = str.split("��");
				if (strArray[2].equals(s)) {
					return "���:" + strArray[0] + "    �Ա�:" + strArray[1] + "    ����:" + strArray[2] + "    ����:"
							+ strArray[3] + "��    ����:" + strArray[4] + "Ԫ/��    ����:" + strArray[5];
				}
			}
			return "                    û���ҵ���Ա����Ϣ";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "                     û���ҵ���Ա����Ϣ";
		}
	}

	public String changeOldScriptString(String s) throws IOException { // ���ؾ���Ϣ

		File file = new File("file/information/all.txt");
		Reader reader = new FileReader(file);
		BufferedReader searchReader2 = new BufferedReader(reader);
		// �����ļ���ȡ
		try {
			String lineString;
			while ((lineString = searchReader2.readLine()) != null) {
				String str = lineString;
				String[] strArray = str.split("��");
				if (strArray[0].equals(s)) {

					return strArray[0] + "��" + strArray[1] + "��" + strArray[2] + "��" + strArray[3] + "��" + strArray[4]
							+ "��" + strArray[5];
				}
			}
			return "";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "";
		}
	}

	public boolean changeString(String old) throws IOException { // ������Ϣ ����
		String[] oldArray = old.split("��");
		File allFile = new File("file/information/all.txt");
		File txtFile = new File("file/information/caiwubu.txt");
		Writer writerAll = new FileWriter(allFile, true); // д������
		Writer eriWriterTxt = new FileWriter(txtFile); // д�����
		Reader reader = new FileReader(allFile);
		BufferedReader bufferedReader = new BufferedReader(reader);
		// �����ļ���ȡ
		try {
			String lineString;
			while ((lineString = bufferedReader.readLine()) != null) {
				System.out.println(lineString);
				String[] strArray = lineString.split("��");

				if (strArray[0].equals(oldArray[0])) {
					strArray[4] = oldArray[4];
					writerAll.write(strArray[0] + "��" + strArray[1] + "��" + strArray[2] + "��" + strArray[3] + "��"
							+ strArray[4] + "��" + strArray[5]);
					writerAll.flush();
					return true;

				}
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public String arrayToString(String[] strArray) {
		return strArray[0] + "��" + strArray[1] + "��" + strArray[2] + "��" + strArray[3] + "��" + strArray[4] + "��"
				+ strArray[5];
	}

	public String getManagerString() throws IOException { // ����һ��manager��Ϣ

		File file = new File("file/manager/manager.txt");
		Reader reader = new FileReader(file);
		BufferedReader searchReaderManager = new BufferedReader(reader);
		// �����ļ���ȡ
		String lineStringManager;
		while ((lineStringManager = searchReaderManager.readLine()) != null) {
			String str = lineStringManager;
			return str;
		}
		return null;
	}

	public String getPeopleNum() throws IOException { // ����Ա������

		File filePeople = new File("file/information/all.txt");
		Reader reader = new FileReader(filePeople);
		BufferedReader searchPeopleReader = new BufferedReader(reader);
		// �����ļ���ȡ
		int amount = 0;

		String lineString;
		while (searchPeopleReader.readLine() != null) {
			amount++;
		}
		String numInString = String.valueOf(amount);
		return numInString;

	}

	public String getAllSalary() throws IOException { // ����ÿ���ܹ�����

		File salaryFile = new File("file/information/all.txt");
		Reader reader = new FileReader(salaryFile);
		BufferedReader searchSalaryReader = new BufferedReader(reader);
		// �����ļ���ȡ
		int amount = 0;
		int salary;
		String lineString;

		while ((lineString = searchSalaryReader.readLine()) != null) {
			String[] strArray = lineString.split("��");
			salary = Integer.parseInt(strArray[4]);
			amount = salary + amount;
		}
		String numInString = String.valueOf(amount);
		return numInString;
	}
	
	public String getCategroAmount(String bumenString) throws IOException {     //���������������
		
		File categroyFile = null; 

		// �жϲ��ţ���ɾ��������Ϣ
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
		
		Reader reader = new FileReader(categroyFile);
		BufferedReader searchPeopleReader = new BufferedReader(reader);
		// �����ļ���ȡ
		int amount = 0;

		String lineString;
		while (searchPeopleReader.readLine() != null) {
			amount++;
		}
		String numInString = String.valueOf(amount);
		return numInString;
	}

}
