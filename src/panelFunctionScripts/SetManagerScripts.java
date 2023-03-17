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

	static String cboString = ""; // 商务总监
	static String ceoString = ""; // 首席执行官
	static String cfoString = ""; // 财务总监
	static String choString = ""; // 人事总监
	static String cioString = ""; // 技术总监
	static String dongString = ""; // 董事长

	public void setManager(String numberString ,String managerString) throws IOException { // 删除manager文件信息
		String[] managerArray = new String[6];
		int i = 0;
		File file = new File("file/manager/manager.txt");
		Reader reader = new FileReader(file);
		BufferedReader searchReader = new BufferedReader(reader);

		String lineString;
		while ((lineString = searchReader.readLine()) != null) {
			String str = lineString;
			managerArray = str.split("，");
		}

		if(managerString.equals("董事长")) {
			i=0;
		}
		if(managerString.equals("(CEO)首席执行官")) {
			i=1;
		}
		if(managerString.equals("(CBO)商务总监")) {
			i=2;
		}
		if(managerString.equals("(CIO)技术总监")) {
			i=3;
		}
		if(managerString.equals("(CFO)财务总监")) {
			i=4;
		}
		if(managerString.equals("(CHO)人事总监")) {
			i=5;
		}
		managerArray[i]=numberString;

		FileWriter ftFileWriter = new FileWriter(file,false);// append传入false表示写入内容时将会覆盖文件中之前存在的内容
		ftFileWriter.write(managerArray[0] + "，" + managerArray[1] + "，" + managerArray[2] + "，" + managerArray[3] + "，"
				+ managerArray[4] + "，" + managerArray[5]);
		ftFileWriter.flush();
	}

}
