package password;
import java.io.*;
import loginWindow.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;


public class JudgePassword {     //�ж������Ƿ���ȷ
	public boolean Judge (String pas) throws IOException{
		File file = new File("file/acc_pas/password.txt");
		
		String line; 
		Reader reader=new FileReader(file);
		BufferedReader br=new BufferedReader(reader);
		line=br.readLine(); 
//		System.out.println(line);
		if (line.equals(pas)) {
//			System.out.println("������ȷ");
			return true;
		} 
		else {
//			System.out.println("�������");
			return false; 
			
		} 
	}

	
	

}
