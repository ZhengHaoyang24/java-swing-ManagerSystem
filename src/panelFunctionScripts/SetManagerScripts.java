package panelFunctionScripts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class SetManagerScripts {

	static String cboString = ""; // �����ܼ�
	static String ceoString = ""; // ��ϯִ�й�
	static String cfoString = ""; // �����ܼ�
	static String choString = ""; // �����ܼ�
	static String cioString = ""; // �����ܼ�
	static String dongString = ""; // ���³�

	public void setManager(String numberString ,String managerString) throws IOException { // ɾ��manager�ļ���Ϣ
		String[] managerArray = new String[6];
		int i = 0;
		File file = new File("file/manager/manager.txt");
		Reader reader = new FileReader(file);
		BufferedReader searchReader = new BufferedReader(reader);

		String lineString;
		while ((lineString = searchReader.readLine()) != null) {
			String str = lineString;
			managerArray = str.split("��");
		}

		if(managerString.equals("���³�")) {
			i=0;
		}
		if(managerString.equals("(CEO)��ϯִ�й�")) {
			i=1;
		}
		if(managerString.equals("(CBO)�����ܼ�")) {
			i=2;
		}
		if(managerString.equals("(CIO)�����ܼ�")) {
			i=3;
		}
		if(managerString.equals("(CFO)�����ܼ�")) {
			i=4;
		}
		if(managerString.equals("(CHO)�����ܼ�")) {
			i=5;
		}
		managerArray[i]=numberString;

		FileWriter ftFileWriter = new FileWriter(file,false);// append����false��ʾд������ʱ���Ḳ���ļ���֮ǰ���ڵ�����
		ftFileWriter.write(managerArray[0] + "��" + managerArray[1] + "��" + managerArray[2] + "��" + managerArray[3] + "��"
				+ managerArray[4] + "��" + managerArray[5]);
		ftFileWriter.flush();
	}

}
