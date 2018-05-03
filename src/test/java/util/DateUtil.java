package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {


    /**
     * @return
     */
    public static String DefaultDateFormat = "yyyy-MM-dd";
    public static String DefaultTimeFormat = "yyyy-MM-dd HH:mm:ss";

    public static String getCurrentYearAndMonth() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date d = new Date(System.currentTimeMillis());
        return sdf.format(d);
    }

    public static String getPreMonth(int i) {
        Calendar c = Calendar.getInstance();
        return null;
    }

    public static String getCurrentYearFirstDay() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");

        c.add(Calendar.YEAR, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(c.getTime());
    }

    public static String getCurrentMonthFirstDay() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");

        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(c.getTime());
    }

    public static String getTommorrowDate() {
        Date date = new Date();
        Calendar cc = new GregorianCalendar();
        cc.clear();
        cc.setTime(date);
        cc.add(cc.DATE, 1);  //把日期往后增加一天.整数往后推,负数往前移动
        date = cc.getTime();  //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //大写的HH就是使用24小时制度
        String dateString = formatter.format(date);
        return dateString;
    }

    public static String getTommorrowDateTime() {
        Date date = new Date();
        Calendar cc = new GregorianCalendar();
        cc.clear();
        cc.setTime(date);
        cc.add(cc.DATE, 1);  //把日期往后增加一天.整数往后推,负数往前移动
        date = cc.getTime();  //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 00:00:00"); //大写的HH就是使用24小时制度
        String dateString = formatter.format(date);
        return dateString;
    }

    public static String getTommorrowTime() {
        Date date = new Date();
        Calendar cc = new GregorianCalendar();
        cc.clear();
        cc.setTime(date);
        cc.add(cc.DATE, 1);  //把日期往后增加一天.整数往后推,负数往前移动
        date = cc.getTime();  //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //大写的HH就是使用24小时制度
        String dateString = formatter.format(date);
        return dateString;
    }

    public static String getNextMonthData() {
        Date date = new Date();
        Calendar cc = new GregorianCalendar();
        cc.clear();
        cc.setTime(date);
        cc.add(cc.MONTH, 1);  //把日期往后增加一个月.整数往后推,负数往前移动
        date = cc.getTime();  //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //大写的HH就是使用24小时制度
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 将Date类型转换成String类型
     * 需要注意给定的模式必须和给定的字符串格式匹配，否则会抛出java.text.ParseException异常
     * @param str
     * @return
     */
    public static Date stringToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dt = new Date();
        try {
            dt = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }

    public static String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(sdf.format(date));
//        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return sdf.format(date);
    }
}

