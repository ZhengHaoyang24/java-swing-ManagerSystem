package panelFunctionScripts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DelPeopleHomepage {

	public void deletePeopleAll(String bianhao) throws IOException { // ɾ�������ļ������Ϣ
		String[] bookinf1 = new String[6]; // ���ÿ�зָ������
		File file = new File("file/information/all.txt");
		Reader reader = new FileReader(file);
		BufferedReader searchReader1 = new BufferedReader(reader);
		String tempString;// ����һ���ַ�����ÿһ�ζ��������ַ�������
		List<String> list = new ArrayList<>();// ����һ��list�ַ���������������ÿһ�е��ַ�����Ϣ
		while ((tempString = searchReader1.readLine()) != null) {
			list.add(tempString);
		}

		for (String delBook : list) {
			bookinf1 = delBook.split("��");
			System.out.println(bookinf1[0]);

			if (bianhao.equals(bookinf1[0])) {
				list.remove(delBook);// �ڼ�����ɾ������
				FileWriter fd = new FileWriter(file, false);
				fd.write("");// ִ��ɾ��������д������ݸ���֮ǰ������
				fd.close();
				break;
			}
		}
		for (String user : list) {
			bookinf1 = user.split("��");
			FileWriter fw = new FileWriter(file, true);
			fw.write(bookinf1[0] + "��" + bookinf1[1] + "��" + bookinf1[2] + "��" + bookinf1[3] + "��" + bookinf1[4] + "��"
					+ bookinf1[5]);// ִ������д�����ݵĲ��������޸Ĺ��ļ���ͨ��������±�������´�д���ļ���
			fw.write(System.getProperty("line.separator"));// �ڶ�������һ�����з�
			fw.close();
		}

	}

	public void delCategroPeople(String number, String bumenString) throws IOException {
		String[] xinxiString = new String[6];
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
		BufferedReader searchReader = new BufferedReader(reader);
		String tempString;// ����һ���ַ�����ÿһ�ζ��������ַ�������
		List<String> list = new ArrayList<>();// ����һ��list�ַ���������������ÿһ�е��ַ�����Ϣ
		while ((tempString = searchReader.readLine()) != null) {
			list.add(tempString);
		}
		for (String delPeople : list) {
			xinxiString = delPeople.split("��");
			// �ҵ�����ɾ�����鼮�ڼ����е�λ�ã����ò������ݴӼ�����ɾ����Ȼ����������ļ�
			if (number.equals(xinxiString[0])) {
				list.remove(delPeople);// �ڼ�����ɾ������
				FileWriter fd = new FileWriter(categroyFile, false);// append����false��ʾд������ʱ���Ḳ���ļ���֮ǰ���ڵ�����
				fd.write("");// ִ��ɾ��������д������ݸ���֮ǰ������
				fd.close();
				break;
			}
		}
		for (String user : list) {
			xinxiString = user.split("��");
			FileWriter fw = new FileWriter(categroyFile, true);// append����true��ʾд������ʱ�����Ḳ���ļ���֮ǰ���ڵ����ݣ����µ�����д��֮ǰ���ݵĺ���
			fw.write(xinxiString[0] + "��" + xinxiString[1] + "��" + xinxiString[2] + "��" + xinxiString[3] + "��"
					+ xinxiString[4] + "��" + xinxiString[5]);// ִ������д�����ݵĲ��������޸Ĺ��ļ���ͨ��������±�������´�д���ļ���
			fw.write(System.getProperty("line.separator"));// �ڶ�������һ�����з�
			fw.close();
		}
	}

	public String searchNumberDel(String s) throws IOException { // ���ձ�Ų��� ����

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
					return strArray[0] + "��" + strArray[1] + "��" + strArray[2] + "��" + strArray[3] + "��" + strArray[4]
							+ "��" + strArray[5];
				}
			}
			return "                 û���ҵ���Ա��";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "                 û���ҵ���Ա��";
		}
	}

	public String searchNameDel(String s) throws IOException { // ������������ ����

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
					return strArray[0] + "��" + strArray[1] + "��" + strArray[2] + "��" + strArray[3] + "��" + strArray[4]
							+ "��" + strArray[5];
				}
			}
			return "                 û���ҵ���Ա��";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "                 û���ҵ���Ա��";
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

	public void delManager(String numberString) throws IOException { // ɾ��manager�ļ���Ϣ
		String[] managerArray = new String[6];
		int i = 0;
		File file2 = new File("file/manager/manager.txt");
		Reader reader2 = new FileReader(file2);
		BufferedReader searchReader = new BufferedReader(reader2);
		

		String lineString;
		while ((lineString = searchReader.readLine()) != null) {
			String str = lineString;
			managerArray = str.split("��");
		}
		for (i = 0; i < 6; i++) {
			if (managerArray[i].equals(numberString)) {
				managerArray[i] = "��";
			}
		}

		FileWriter ftFileWriter = new FileWriter(file2, false);// append����false��ʾд������ʱ���Ḳ���ļ���֮ǰ���ڵ�����

		ftFileWriter.write(managerArray[0] + "��" + managerArray[1] + "��" + managerArray[2] + "��" + managerArray[3] + "��"
				+ managerArray[4] + "��" + managerArray[4] + "��" + managerArray[5]);
		ftFileWriter.flush();

	}

}
