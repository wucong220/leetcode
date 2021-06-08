package test;
 
//
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class TestDate {
 
    public static long StringToMS(String str) {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
 
        Date d = null ;
         
        try {
             d = sdf.parse(str);
            System.out.printf("字符串 %s 通过格式  yyyy/MM/dd HH:mm:ss %n转换为日期对象: %s %n",str,d.toString());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  d.getTime(); 
         
    }
    
    public static void main(String[] args) {
		System.out.println(StringToMS("2015-02-10 02:04:55"));
		System.out.println(System.currentTimeMillis());
	}
}
