package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
public class LocalTime{

    public String getLocalTimString() {          //��ҳ
    	SimpleDateFormat sdf = new SimpleDateFormat();// ��ʽ��ʱ�� 
        sdf.applyPattern("yyyy-MM-dd");// aΪam/pm�ı��  
        Date date = new Date();// ��ȡ��ǰʱ�� 
		String str[]={"������","����һ","���ڶ�","������","������","������","������"};//�ַ�������
		Calendar rightNow=Calendar.getInstance();
		int day=rightNow.get(rightNow.DAY_OF_WEEK);//��ȡʱ��
		return "                            "+sdf.format(date)+" "+str[day-1];
    } 
    public String getLocalTiminTitleString() {           //����
    	SimpleDateFormat sdf = new SimpleDateFormat();// ��ʽ��ʱ�� 
        sdf.applyPattern("yyyy-MM-dd");// aΪam/pm�ı��  
        Date date = new Date();// ��ȡ��ǰʱ�� 
		String str[]={"������","����һ","���ڶ�","������","������","������","������"};//�ַ�������
		Calendar rightNow=Calendar.getInstance();
		int day=rightNow.get(rightNow.DAY_OF_WEEK);//��ȡʱ��
		return sdf.format(date)+" "+str[day-1]; 
    }
}
