package panelFunctionScripts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DelPeopleHomepage {

	public void deletePeopleAll(String bianhao) throws IOException { // 删除所有文件里的信息
		String[] bookinf1 = new String[6]; // 存放每行分割后数据
		File file = new File("file/information/all.txt");
		Reader reader = new FileReader(file);
		BufferedReader searchReader1 = new BufferedReader(reader);
		String tempString;// 定义一个字符串，每一次读出该行字符串内容
		List<String> list = new ArrayList<>();// 定义一个list字符串集合用来储存每一行的字符串信息
		while ((tempString = searchReader1.readLine()) != null) {
			list.add(tempString);
		}

		for (String delBook : list) {
			bookinf1 = delBook.split("，");
			System.out.println(bookinf1[0]);

			if (bianhao.equals(bookinf1[0])) {
				list.remove(delBook);// 在集合中删除该行
				FileWriter fd = new FileWriter(file, false);
				fd.write("");// 执行删除操作，写入空内容覆盖之前的内容
				fd.close();
				break;
			}
		}
		for (String user : list) {
			bookinf1 = user.split("，");
			FileWriter fw = new FileWriter(file, true);
			fw.write(bookinf1[0] + "，" + bookinf1[1] + "，" + bookinf1[2] + "，" + bookinf1[3] + "，" + bookinf1[4] + "，"
					+ bookinf1[5]);// 执行重新写入内容的操作，将修改过的集合通过数组读下标后，再重新存写入文件中
			fw.write(System.getProperty("line.separator"));// 在段落后添加一个换行符
			fw.close();
		}

	}

	public void delCategroPeople(String number, String bumenString) throws IOException {
		String[] xinxiString = new String[6];
		File categroyFile = null;

		// 判断部门，并删除其中信息
		if (bumenString.equals("安全质保部")) {
			categroyFile = new File("file/information/anquanzhibaobu.txt");
		}
		if (bumenString.equals("采购部")) {
			categroyFile = new File("file/information/caigoubu.txt");
		}
		if (bumenString.equals("财务部")) {
			categroyFile = new File("file/information/caiwubu.txt");
		}
		if (bumenString.equals("产品设计中心")) {
			categroyFile = new File("file/information/chanpingshejizhongxin.txt");
		}
		if (bumenString.equals("法务部")) {
			categroyFile = new File("file/information/fawubu.txt");
		}
		if (bumenString.equals("公益事业部")) {
			categroyFile = new File("file/information/gongyishiyebu.txt");
		}
		if (bumenString.equals("管理部")) {
			categroyFile = new File("file/information/guanlibu.txt");
		}
		if (bumenString.equals("技术研发中心")) {
			categroyFile = new File("file/information/jishuyanfazhongxin.txt");
		}
		if (bumenString.equals("人力资源部")) {
			categroyFile = new File("file/information/renliziyuanbu.txt");
		}
		if (bumenString.equals("业务部")) {
			categroyFile = new File("file/information/yewubu.txt");
		}
		if (bumenString.equals("营销部")) {
			categroyFile = new File("file/information/yingxiaobu.txt");
		}
		if (bumenString.equals("总经办")) {
			categroyFile = new File("file/information/zongjingban.txt");
		}

		Reader reader = new FileReader(categroyFile);
		BufferedReader searchReader = new BufferedReader(reader);
		String tempString;// 定义一个字符串，每一次读出该行字符串内容
		List<String> list = new ArrayList<>();// 定义一个list字符串集合用来储存每一行的字符串信息
		while ((tempString = searchReader.readLine()) != null) {
			list.add(tempString);
		}
		for (String delPeople : list) {
			xinxiString = delPeople.split("，");
			// 找到即将删除的书籍在集合中的位置，将该部分内容从集合中删除，然后清空整个文件
			if (number.equals(xinxiString[0])) {
				list.remove(delPeople);// 在集合中删除该行
				FileWriter fd = new FileWriter(categroyFile, false);// append传入false表示写入内容时将会覆盖文件中之前存在的内容
				fd.write("");// 执行删除操作，写入空内容覆盖之前的内容
				fd.close();
				break;
			}
		}
		for (String user : list) {
			xinxiString = user.split("，");
			FileWriter fw = new FileWriter(categroyFile, true);// append传入true表示写入内容时将不会覆盖文件中之前存在的内容，将新的内容写在之前内容的后面
			fw.write(xinxiString[0] + "，" + xinxiString[1] + "，" + xinxiString[2] + "，" + xinxiString[3] + "，"
					+ xinxiString[4] + "，" + xinxiString[5]);// 执行重新写入内容的操作，将修改过的集合通过数组读下标后，再重新存写入文件中
			fw.write(System.getProperty("line.separator"));// 在段落后添加一个换行符
			fw.close();
		}
	}

	public String searchNumberDel(String s) throws IOException { // 按照编号查找 返回

		File file = new File("file/information/all.txt");
		Reader reader = new FileReader(file);
		BufferedReader searchReader1 = new BufferedReader(reader);
		// 进行文件读取
		try {
			String lineString;
			while ((lineString = searchReader1.readLine()) != null) {
				String str = lineString;
				String[] strArray = str.split("，");
				if (strArray[0].equals(s)) {
					return strArray[0] + "，" + strArray[1] + "，" + strArray[2] + "，" + strArray[3] + "，" + strArray[4]
							+ "，" + strArray[5];
				}
			}
			return "                 没有找到该员工";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "                 没有找到该员工";
		}
	}

	public String searchNameDel(String s) throws IOException { // 按照姓名查找 返回

		File file = new File("file/information/all.txt");
		Reader reader = new FileReader(file);
		BufferedReader searchReader2 = new BufferedReader(reader);
		// 进行文件读取
		try {
			String lineString;
			while ((lineString = searchReader2.readLine()) != null) {
				String str = lineString;
				String[] strArray = str.split("，");
				if (strArray[2].equals(s)) {
					return strArray[0] + "，" + strArray[1] + "，" + strArray[2] + "，" + strArray[3] + "，" + strArray[4]
							+ "，" + strArray[5];
				}
			}
			return "                 没有找到该员工";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "                 没有找到该员工";
		}
	}

	public boolean legalNumber(String s) { // 编号是否合法
		String[] x = s.split("");
		if (x.length != 6) {
			return false;
		} else {
			return true;
		}
	}

	public boolean searchNumberExist(String s) throws IOException { // 判断编号是否已经存在

		File file = new File("file/information/all.txt");
		Reader reader = new FileReader(file);
		BufferedReader searchReader1 = new BufferedReader(reader);
		// 进行文件读取
		String lineString;
		while ((lineString = searchReader1.readLine()) != null) {
			String str = lineString;
			String[] strArray = str.split("，");
			if (strArray[0].equals(s)) {
				return true;
			}
		}
		return false;
	}

	public void delManager(String numberString) throws IOException { // 删除manager文件信息
		String[] managerArray = new String[6];
		int i = 0;
		File file2 = new File("file/manager/manager.txt");
		Reader reader2 = new FileReader(file2);
		BufferedReader searchReader = new BufferedReader(reader2);
		

		String lineString;
		while ((lineString = searchReader.readLine()) != null) {
			String str = lineString;
			managerArray = str.split("，");
		}
		for (i = 0; i < 6; i++) {
			if (managerArray[i].equals(numberString)) {
				managerArray[i] = "无";
			}
		}

		FileWriter ftFileWriter = new FileWriter(file2, false);// append传入false表示写入内容时将会覆盖文件中之前存在的内容

		ftFileWriter.write(managerArray[0] + "，" + managerArray[1] + "，" + managerArray[2] + "，" + managerArray[3] + "，"
				+ managerArray[4] + "，" + managerArray[4] + "，" + managerArray[5]);
		ftFileWriter.flush();

	}

}
