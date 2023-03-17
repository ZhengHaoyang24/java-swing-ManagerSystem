package panelFunctionScripts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class AddPeopleScripts {
	
	private String categroFile;

	public boolean addPeople(String []strArray) throws IOException {   //写入所有文件

		File allFile = new File("file/information/all.txt"); 
		
		Writer writerAll=new FileWriter(allFile,true);    //写入所有
		writerAll.write(strArray[0] + "，" + strArray[1] + "，" + strArray[2] + "，" + strArray[3] + "，" + strArray[4]
				+ "，" + strArray[5]+"\r\n");
		writerAll.flush();    //缓冲区

		return true;
		
	}
	
	public boolean addCategroPeople(String []strArray,String bumenString ) throws IOException {   //写入分类文件	
		

		File categroyFile = null; 
		//判断部门，并删除其中信息
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

		Writer writerAll=new FileWriter(categroyFile,true);    //写入所有
		writerAll.write(strArray[0] + "，" + strArray[1] + "，" + strArray[2] + "，" + strArray[3] + "，" + strArray[4]
				+ "，" + strArray[5]+"\r\n");
		writerAll.flush();    //缓冲区

		return true;
		
		
	}

}
