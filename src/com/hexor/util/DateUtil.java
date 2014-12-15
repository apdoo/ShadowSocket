package com.hexor.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * @author Dong
 *
 */
public class DateUtil {
    
 
    /**
     * 返回日期：yyyyMMddHHmmss格式的字符串
     */
    public static String getStrOfDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    /**
     * 获取当前日期时间 返回日期：yyyy-MM-dd HH:mm:ss
     * 
     * @author WikerYong
     * @version 2012-1-9 上午09:47:39
     * @return
     */
    public static String getStrOfDateTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    /**
     * 字符串转为日期类型，返回yyyy-MM-dd HH:mm:ss格式
     * 
     * @author WikerYong Email:<a href="#">yw_312@foxmail.com</a>
     * @version 2012-7-5 下午04:33:49
     * @param str
     * @return
     */
    public static Date getDateByStr(String str) {
        Date date = new Date();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = formatter.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    
    /**
     * 获取当前日期时间 返回日期：yyyy-MM-dd HH:mm
     * 
     * @author WikerYong Email:<a href="#">yw_312@foxmail.com</a>
     * @version 2012-1-31 下午02:57:30
     * @return
     */
    public static String getStrOfDateMinute() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    /**
     * 返回日期：yyyyMMddHHmmssSSS格式的字符串
     * 
     * @author WikerYong
     * @version 2011-11-25 下午07:18:44
     * @return
     */
    public static String getStrOfMs() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    /**
     * 返回日期：yyyyMM格式的字符串
     */
    public static String getMonthFolder() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    /**
     * 返回日期：yyyyMMdd格式的字符串
     */
    public static String getDateFolder() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    /**
     * 获取当前月份
     * 
     * @author WikerYong Email:<a href="#">yw_312@foxmail.com</a>
     * @version 2012-4-9 上午10:45:28
     * @return
     */
    public static String getMonth() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    /**
     * 获取当前年份
     * 
     * @author WikerYong Email:<a href="#">yw_312@foxmail.com</a>
     * @version 2012-7-5 下午04:31:07
     * @return
     */
    public static String getYear() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    /**
     * 返回日期：yyyyMMddHH格式的字符串
     * 
     * @author WikerYong
     * @version 2011-12-20 下午03:43:14
     * @return
     */
    public static String getDataOfHour() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHH");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    /**
     * 返回时间：yyyyMMddHHmm格式
     */
    public static String getStrOfTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    /**
     * 返回时间：yyyy-MM-dd格式
     */
    public static String getCurrentDay() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    public static String getLastDay(int day) {
        Date yestoday = new Date(new Date().getTime() - 1000 * 60
                * 60 * 24 * day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(yestoday);
    }

    /**
     * 获取昨天、前天的日期
     *
     * @param currentDate
     * @return
     */
    public static String[] getLastDates(String currentDate) {
        String currYear, currMonth, currDay;
        currYear = currentDate.substring(0, 4);
        currMonth = currentDate.substring(4, 6);
        currDay = currentDate.substring(6);

        // 月份或日期首位是0
        String tempMonth, tempDay;
        if (currMonth.substring(0, 1).equals("0")) {
            tempMonth = "0";
        } else {
            tempMonth = "";
        }
        if (currDay.substring(0, 1).equals("0") || currDay.equals("10")) {
            tempDay = "0";
        } else {
            tempDay = "";
        }

        String returnDays[] = new String[2];

        if (currMonth.equals("01") && currDay.equals("01")) {
            returnDays[0] = (Integer.parseInt(currYear) - 1) + "1231";
            returnDays[1] = (Integer.parseInt(currYear) - 1) + "1230";
        } else if (currMonth.equals("01") && currDay.equals("02")) {
            returnDays[0] = currYear + "0101";
            returnDays[1] = (Integer.parseInt(currYear) - 1) + "1231";
        } else if (Integer.parseInt(currMonth) >= 1 && Integer.parseInt(currDay) > 2) {
            returnDays[0] = currYear + currMonth + tempDay + (Integer.parseInt(currDay) - 1);
            if (currDay.equals("11")) {
                returnDays[1] = currYear + currMonth + "0" + (Integer.parseInt(currDay) - 2);
            } else {
                returnDays[1] = currYear + currMonth + tempDay + (Integer.parseInt(currDay) - 2);
            }
        } else if (Integer.parseInt(currMonth) > 1 && Integer.parseInt(currDay) == 2) {
            returnDays[0] = currYear + currMonth + "01";
            if (currMonth.equals("10")) {
                returnDays[1] = currYear
                        + "0"
                        + (Integer.parseInt(currMonth) - 1)
                        + (getLastDayOfUpMonth(Integer.parseInt(currYear),
                                Integer.parseInt(currMonth), Integer.parseInt(currDay)));
            } else {
                returnDays[1] = currYear
                        + tempMonth
                        + (Integer.parseInt(currMonth) - 1)
                        + (getLastDayOfUpMonth(Integer.parseInt(currYear),
                                Integer.parseInt(currMonth), Integer.parseInt(currDay)));
            }
        } else if (Integer.parseInt(currMonth) > 1 && Integer.parseInt(currDay) == 1) {
            if (currMonth.equals("10")) {
                returnDays[0] = currYear
                        + "0"
                        + (Integer.parseInt(currMonth) - 1)
                        + (getLastDayOfUpMonth(Integer.parseInt(currYear),
                                Integer.parseInt(currMonth), Integer.parseInt(currDay)));
                returnDays[1] = currYear
                        + "0"
                        + (Integer.parseInt(currMonth) - 1)
                        + (getLastDayOfUpMonth(Integer.parseInt(currYear),
                                Integer.parseInt(currMonth), Integer.parseInt(currDay)) - 1);
            } else {
                returnDays[0] = currYear
                        + tempMonth
                        + (Integer.parseInt(currMonth) - 1)
                        + (getLastDayOfUpMonth(Integer.parseInt(currYear),
                                Integer.parseInt(currMonth), Integer.parseInt(currDay)));
                returnDays[1] = currYear
                        + tempMonth
                        + (Integer.parseInt(currMonth) - 1)
                        + (getLastDayOfUpMonth(Integer.parseInt(currYear),
                                Integer.parseInt(currMonth), Integer.parseInt(currDay)) - 1);
            }
        } else {
            returnDays[0] = currYear + currMonth + tempDay + (Integer.parseInt(currDay) - 1);
            returnDays[1] = currYear + currMonth + tempDay + (Integer.parseInt(currDay) - 2);
        }

        return returnDays;
    }

    public static int getLastDayOfUpMonth(int year, int month, int date) {
        Calendar calendar = new GregorianCalendar(year, month, date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置�?�?当前日期既为本月第一�?
        calendar.add(Calendar.MONTH, -1);// 月增�?�?
        calendar.add(Calendar.DAY_OF_MONTH, -1);// 日期倒数�?��,既得到本月最后一�?
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取当月第一天
     *
     * @author WikerYong
     * @version 2011-11-21 下午04:45:06
     * @return
     */
    public static String getFirstDayOfMonth() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1�?
        str = sdf.format(lastDate.getTime());
        return str;
    }

    /**
     * 获取当月的最后一天
     *
     * @author WikerYong
     * @version 2011-11-21 下午04:46:06
     * @return
     */
    public static String getLastDayOfMonteh() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);//
        lastDate.add(Calendar.MONTH, 1);//
        lastDate.add(Calendar.DATE, -1);//
        str = sdf.format(lastDate.getTime());
        return str;
    }

    /**
     * 获取去年的年份
     *
     * @return
     */
    public static String getLastYear() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(currentTime);
        c.add(Calendar.YEAR, -1);
        String dateString = formatter.format(c.getTime());
        return dateString;
    }

    /**
     * 获取前年的年份
     *
     * @return
     */
    public static String getBeforeLastYear() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(currentTime);
        c.add(Calendar.YEAR, -2);
        String dateString = formatter.format(c.getTime());
        return dateString;
    }

    /**
     * 获取某年某月的最后一天日期
     *
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    /**
     * 获取某月第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    /**
     * 判断日期是否为同一天
     *
     * @param dateA
     * @param dateB
     * @return true 则为同一天，false则为不在同一天
     */
    public static boolean isSameDay(Date dateA,Date dateB) {
        Calendar calDateA = Calendar.getInstance();
        calDateA.setTime(dateA);

        Calendar calDateB = Calendar.getInstance();
        calDateB.setTime(dateB);

        return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)
                && calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)
                &&  calDateA.get(Calendar.DAY_OF_MONTH) == calDateB.get(Calendar.DAY_OF_MONTH);
    }
    /**
     * 接受YYYY-MM-DD的日期字符串参数,返回两个日期相差的天数
     * @param start
     * @param end
     * @return
     * @throws java.text.ParseException
     */
    public static long getDistDates(String start,String end) throws ParseException
    {
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          Date startDate = sdf.parse(start);
          Date endDate = sdf.parse(end);
          return getDistDates(startDate,endDate);
    }

    /**
     * 返回两个日期相差的天数
     * @param startDate
     * @param endDate
     * @return
     * @throws java.text.ParseException
     */
    public static long getDistDates(Date startDate,Date endDate)
    {
        long totalDate = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        long timestart = calendar.getTimeInMillis();
        calendar.setTime(endDate);
        long timeend = calendar.getTimeInMillis();
        totalDate = Math.abs((timeend - timestart))/(1000*60*60*24);
        return totalDate;
    }

    /**
     * 获取与_fromdate相差_monthCount个月的日期
     * @param _fromdate:YYYY-MM-DD
     * @param _monthCount
     * @return
     * @throws java.text.ParseException
     */
    public static String getDistMonths(String _fromdate,int _monthCount) throws ParseException
    {
        String resultDate = "";
        int year,month,date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(_fromdate));
        year = calendar.get(Calendar.YEAR);
        date = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH) + 1 + _monthCount;
        int c = new Integer((month-1)/12);
        month = month%12;
        if(month == 0)
        month = 12;
        year += c;
        resultDate = year + "-" + month + "-" + date;
        return resultDate;
    }

    /**
     * 计算每个月的天数，以数组返回
     * @param months
     * @param date
     * @return
     * @throws java.text.ParseException
     */
    public static String[] countMonthDates(int months,Date date) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String _date = date == null ? sdf.format(new Date()) : sdf.format(date);//如果不给定起算时间则从今天算起

        return countMonthDates(months,_date);
    }

    /**
     * 计算每个月的天数，以数组返回
     * @param months
     * @param date
     * @return
     * @throws java.text.ParseException
     */   
    public static String[] countMonthDates(int months,String date) throws ParseException    
    {    
        String[] results = null;//结果    
        String _today = date == null ? new SimpleDateFormat("yyyy-MM-dd").format(new Date()) : date;//如果不给定起算时间则从今天算起    
        int _months = months > 0 ? months : 24;//如果不给定计算的月数则计算未来两年里面的24月    
        String startDate = getDistMonths(_today,0);//获得起算日期的YYYY-MM-DD格式的字符串日期    
        results = new String[_months];  
        for(int i = 1; i <= _months; i++)    
        {    
            String nextMonthDate = getDistMonths(_today,i);//每个月的截至日期    
            String desc = startDate + " 至 " + nextMonthDate;    
            long dates = getDistDates(startDate,nextMonthDate);//返回天数  
            results[i-1] = desc + " ：共 " + dates + " 天！";  
            startDate = nextMonthDate;//当前月的结束日期作为下一个月的起始日期    
        }    
        return results;    
    }  
    
    /**获得当前时间 小时
     * @return
     */
    public static String getHours(){
    	Calendar cal = Calendar.getInstance();
    	int hour=cal.get(Calendar.HOUR_OF_DAY);
    	return hour+"";
    }
    /**返回当前时间毫秒数 如：1406881893488
     * @return
     */
    public static long getCurrentTimeMillis(){
    	 return System.currentTimeMillis();
    }
    
    
    /**获得耗时时间
     * @return
     */
    public static String getTaskTime(long start,long end){
    	Calendar c = Calendar.getInstance();  
        c.setTimeInMillis(end - start);  
		return "耗时: " + c.get(Calendar.MINUTE) + "分 "  
                + c.get(Calendar.SECOND) + "秒 " + c.get(Calendar.MILLISECOND)  
                + " 毫秒"; 
    }

    /**
     * 获得多少天以后的日期 返回yyyy-MM-dd
     */
    public static String  nDaysAftertoday(int n){
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Calendar rightNow = Calendar.getInstance();
        //rightNow.add(Calendar.DAY_OF_MONTH,-1);
        rightNow.add(Calendar.DAY_OF_MONTH,+n);
        return  df.format(rightNow.getTime());
    }

    public static void main(String[] args) {
        System.out.println(getStrOfDateTime());
    }
}