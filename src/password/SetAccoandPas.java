package password;
import java.io.*;
import loginWindow.*;
import java.util.*;

public class SetAccoandPas {	
	public void setPas(String password) throws IOException {
		try {
			File file = new File("file/acc_pas/password.txt");
			OutputStream out = new FileOutputStream(file);
			byte[] words = password.getBytes(); // 2.将要输出的内容转换为字节数组
			// System.out.println(words.length); //验算字节数
			 // 3.将字节一个个写到输出流
			for (int i = 0; i < words.length; i++) { 
			out.write(words[i]); // 一次只写一个字节
		}  
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			}catch (IOException e) {
			 e.printStackTrace(); 
			 }
		 
	} 
	public void setAccount(String account) throws IOException{
		try {
			File file = new File("file/acc_pas/account.txt");
			OutputStream out = new FileOutputStream(file);
			byte[] words = account.getBytes(); // 2.将要输出的内容转换为字节数组
			// System.out.println(words.length); //验算字节数
			 // 3.将字节一个个写到输出流
			for (int i = 0; i < words.length; i++) { 
			out.write(words[i]); // 一次只写一个字节
		}  
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			}catch (IOException e) {
			 e.printStackTrace(); 
			 }
		
		
	}
	
	public String getAccount() throws IOException {
		
		File file1 = new File("file/acc_pas/account.txt");
		String line1; 
		Reader reader=new FileReader(file1);
		BufferedReader br=new BufferedReader(reader);
		line1 =br.readLine(); 
//		System.out.println(line1);
		return line1; 
		
	}
	
	public String getPassword() throws IOException {
		
		File file2 = new File("file/acc_pas/password.txt");
		String line2; 
		Reader reader=new FileReader(file2);
		BufferedReader br=new BufferedReader(reader);
		line2 =br.readLine(); 
//		System.out.println(line2);
		return line2; 
		
	}

}
