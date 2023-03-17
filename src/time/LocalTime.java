package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
public class LocalTime{

    public String getLocalTimString() {          //首页
    	SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间 
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记  
        Date date = new Date();// 获取当前时间 
		String str[]={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};//字符串数组
		Calendar rightNow=Calendar.getInstance();
		int day=rightNow.get(rightNow.DAY_OF_WEEK);//获取时间
		return "                            "+sdf.format(date)+" "+str[day-1];
    } 
    public String getLocalTiminTitleString() {           //标题
    	SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间 
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记  
        Date date = new Date();// 获取当前时间 
		String str[]={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};//字符串数组
		Calendar rightNow=Calendar.getInstance();
		int day=rightNow.get(rightNow.DAY_OF_WEEK);//获取时间
		return sdf.format(date)+" "+str[day-1]; 
    }
}
