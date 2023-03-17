package password;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JudgeAccount {   //ÅĞ¶ÏÕËºÅÕıÈ·
	public boolean Judge (String accou) throws IOException{
		File file = new File("file/acc_pas/account.txt");
		
		String line; 
		Reader reader=new FileReader(file);
		BufferedReader br=new BufferedReader(reader);
		line=br.readLine(); 
//		System.out.println(line);
		if (line.equals(accou)) {
//			System.out.println("ÃÜÂëÕıÈ·");
			return true;
		} 
		else {
//			System.out.println("ÃÜÂë´íÎó");
			return false;
			
		} 
	}

}
