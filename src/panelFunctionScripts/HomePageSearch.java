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

public class HomePageSearch { // 搜索员工 功能实现

	public String searchNumberResult(String s) throws IOException { // 按照编号查找

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
					return "编号:" + strArray[0] + "    性别:" + strArray[1] + "    姓名:" + strArray[2] + "    年龄:"
							+ strArray[3] + "岁    工资:" + strArray[4] + "元/月    部门:" + strArray[5];
				}
			}
			return "                     没有找到该员工信息";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "                     没有找到该员工信息";
		}
	}

	public String searchNameResult(String s) throws IOException { // 按照姓名查找

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
					return "编号:" + strArray[0] + "    性别:" + strArray[1] + "    姓名:" + strArray[2] + "    年龄:"
							+ strArray[3] + "岁    工资:" + strArray[4] + "元/月    部门:" + strArray[5];
				}
			}
			return "                    没有找到该员工信息";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "                     没有找到该员工信息";
		}
	}

	public String changeOldScriptString(String s) throws IOException { // 返回旧信息

		File file = new File("file/information/all.txt");
		Reader reader = new FileReader(file);
		BufferedReader searchReader2 = new BufferedReader(reader);
		// 进行文件读取
		try {
			String lineString;
			while ((lineString = searchReader2.readLine()) != null) {
				String str = lineString;
				String[] strArray = str.split("，");
				if (strArray[0].equals(s)) {

					return strArray[0] + "，" + strArray[1] + "，" + strArray[2] + "，" + strArray[3] + "，" + strArray[4]
							+ "，" + strArray[5];
				}
			}
			return "";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "";
		}
	}

	public boolean changeString(String old) throws IOException { // 更改信息 代码
		String[] oldArray = old.split("，");
		File allFile = new File("file/information/all.txt");
		File txtFile = new File("file/information/caiwubu.txt");
		Writer writerAll = new FileWriter(allFile, true); // 写入所有
		Writer eriWriterTxt = new FileWriter(txtFile); // 写入分类
		Reader reader = new FileReader(allFile);
		BufferedReader bufferedReader = new BufferedReader(reader);
		// 进行文件读取
		try {
			String lineString;
			while ((lineString = bufferedReader.readLine()) != null) {
				System.out.println(lineString);
				String[] strArray = lineString.split("，");

				if (strArray[0].equals(oldArray[0])) {
					strArray[4] = oldArray[4];
					writerAll.write(strArray[0] + "，" + strArray[1] + "，" + strArray[2] + "，" + strArray[3] + "，"
							+ strArray[4] + "，" + strArray[5]);
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
		return strArray[0] + "，" + strArray[1] + "，" + strArray[2] + "，" + strArray[3] + "，" + strArray[4] + "，"
				+ strArray[5];
	}

	public String getManagerString() throws IOException { // 返回一行manager信息

		File file = new File("file/manager/manager.txt");
		Reader reader = new FileReader(file);
		BufferedReader searchReaderManager = new BufferedReader(reader);
		// 进行文件读取
		String lineStringManager;
		while ((lineStringManager = searchReaderManager.readLine()) != null) {
			String str = lineStringManager;
			return str;
		}
		return null;
	}

	public String getPeopleNum() throws IOException { // 计算员工个数

		File filePeople = new File("file/information/all.txt");
		Reader reader = new FileReader(filePeople);
		BufferedReader searchPeopleReader = new BufferedReader(reader);
		// 进行文件读取
		int amount = 0;

		String lineString;
		while (searchPeopleReader.readLine() != null) {
			amount++;
		}
		String numInString = String.valueOf(amount);
		return numInString;

	}

	public String getAllSalary() throws IOException { // 计算每月总共工资

		File salaryFile = new File("file/information/all.txt");
		Reader reader = new FileReader(salaryFile);
		BufferedReader searchSalaryReader = new BufferedReader(reader);
		// 进行文件读取
		int amount = 0;
		int salary;
		String lineString;

		while ((lineString = searchSalaryReader.readLine()) != null) {
			String[] strArray = lineString.split("，");
			salary = Integer.parseInt(strArray[4]);
			amount = salary + amount;
		}
		String numInString = String.valueOf(amount);
		return numInString;
	}
	
	public String getCategroAmount(String bumenString) throws IOException {     //计算各个部门人数
		
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
		BufferedReader searchPeopleReader = new BufferedReader(reader);
		// 进行文件读取
		int amount = 0;

		String lineString;
		while (searchPeopleReader.readLine() != null) {
			amount++;
		}
		String numInString = String.valueOf(amount);
		return numInString;
	}

}
