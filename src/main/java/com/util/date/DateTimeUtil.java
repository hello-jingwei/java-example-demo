package com.util.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {
	/**
	 * 获取n日之前或者之后的日期
	 * 
	 * @return
	 */
	public static String format(String dateTime, String srcFormat, String destFormat) {
		SimpleDateFormat srcSimpleDateFormat = new SimpleDateFormat(srcFormat);
		Date date = null;
		try {
			date = srcSimpleDateFormat.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (null == date) {
			return null;
		}

		SimpleDateFormat destSimpleDateFormat = new SimpleDateFormat(destFormat);
		return destSimpleDateFormat.format(date);
	}

	/**
	 * 获取n日之前或者之后的日期
	 * 
	 * @return
	 */
	public static String getDay(int n) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, n);
		return simpleDateFormat.format(calendar.getTime());
	}

	/**
	 * 获取n日之前或者之后的00时00分00秒
	 * 
	 * @return
	 */
	public static String getTime(int n) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, n);
		return simpleDateFormat.format(calendar.getTime());
	}

	/**
	 * 获取n月之前或者之后的月份
	 * 
	 * @return
	 */
	public static String getMonth(int n) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, n);
		return simpleDateFormat.format(calendar.getTime());
	}

	/**
	 * 获取n年之前或者之后的年份
	 * 
	 * @return
	 */
	public static String getYear(int n) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, n);
		return simpleDateFormat.format(calendar.getTime());
	}

	/**
	 * 获取当前的年月日时
	 * 
	 * @return
	 */
	public static String getCurrentData() {
		Date date = new Date();
		// 转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	/**
	 * 获取当前的年月日时分秒
	 * 
	 * @return
	 */
	public static String getCurrentDataTime() {
		Date date = new Date();
		// 转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	/**
	 * 获取当前的年月日时
	 * 
	 * @return
	 */
	public static String getCurrentDataHour() {
		Date date = new Date();
		// 转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
		return dateFormat.format(date);
	}

	/**
	 * 获取当前时间之后的时间
	 * 
	 * @return
	 */
	public static Date getAfterCurrentDataTime(String remindeTime) {
		Date currentTime = new Date();
		long currentMS = currentTime.getTime();
		long remindeMS = (long) (Float.valueOf(remindeTime) * 60 * 60 * 1000);
		return new Date(currentMS + remindeMS);
	}

	public static int getDiffDays(Timestamp timestamp) {
		long stime = timestamp.getTime();
		long btime = System.currentTimeMillis();
		int days = (int) ((btime - stime) / (1000 * 60 * 60 * 24));
		return days;
	}

	/**
	 * 
	 * @return
	 */
	public static String getFirstDayOfMonth() {
		// 获取当前月第一天：
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		// 设置为1号,当前日期既为本月第一天
		c.set(Calendar.DAY_OF_MONTH, 1);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String first = sdf.format(c.getTime());
		return first;
	}

	/**
	 * 
	 * @return
	 */
	public static String getLastDayOfMonth() {
		// 获取当前月最后一天
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String last = sdf.format(ca.getTime());
		return last;
	}

	/**
	 * 
	 * @param currentDate
	 * @return
	 */
	public static String getCurrentYearMonth(String currentDate) {
		SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdfDay.parse(currentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyy-MM");
		return sdfMonth.format(date);
	}

	/**
	 * 
	 * @param currentDate
	 * @return
	 */
	public static String getLastYearMonth(String currentDate) {

		SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdfDay.parse(currentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -1);
		Date lastMonth = cal.getTime();
		SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyy-MM");
		return sdfMonth.format(lastMonth);
	}

	/**
	 * 获取当前的年月日时分秒yyyyMMddHHmmss
	 * 
	 * @return @throws
	 */
	public static String getCurrentDateTimeNoIntervalStyle() {
		Date date = new Date();
		// 转换日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(date);
	}

	/**
	 * 获取当前的年月日时分秒yyyyMMddHHmmss
	 * 
	 * @return yyyyMMdd
	 */
	public static String getDateForOss() {
		Date date = new Date();
		// 转换日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return dateFormat.format(date);
	}
	
	/**
	 * 获取当前的年月日时分秒毫秒 yyyyMMddHHmmssSSS
	 */
	public static String getDateToMill() {
		Date date = new Date();
		// 转换日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return dateFormat.format(date);
	}

	/**
	 * 
	 * 时间格式字符串yyyy-MM-dd HH:mm:ss格式化成yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String formatteNewDateTimeByString(String timeString) {
		SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = oldDateFormat.parse(timeString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(date);
	}

	/**
	 * 字符串转成日期
	 * 
	 * @return @throws
	 */
	public static Date convertToDate(String date) {
		// 转换日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = null;
		try {
			newDate = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
	}

	/**
	 * 字符串转成日期
	 * 
	 * @return @throws
	 */
	public static Date convertToDateHour(String date) {
		// 转换日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
		Date newDate = null;
		try {
			newDate = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
	}

	/**
	 * 判断时间格式为是否为yyyy-MM-dd
	 * 
	 * @return @throws
	 */

	public static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {

			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			convertSuccess = false;
		}
		return convertSuccess;
	}

	/**
	 * 获取当前时间n月之前或者之后的的时间 n 为负数，当前时间之前，n 为正数 当前时间之后
	 * 
	 * @return
	 */
	public static String getTimeBeforeCurrentTimeByMonth(int n) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, n);
		return format.format(calendar.getTime());
	}

	/**
	 * yyyy-MM-dd HH:mm:ss字符串转成日期
	 * 
	 * @return @throws
	 */
	public static Date stringDateconvertToDate(String date) {
		// 转换日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date newDate = null;
		try {
			newDate = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
	}

	/**
	 * 将14位的数字日期转换为（yyyy-MM-dd HH:mm:ss）日期格式
	 * 
	 * @param date
	 * @return
	 * @throws ParseException 将异常抛到上级处理
	 */
	public static String setNumToDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date numDate = sdf.parse(date);
		String forMatDate = sdf1.format(numDate);

		return forMatDate;
	}

	/**
	 * 获取n日之前或者之后的日期
	 * 
	 * @return
	 */
	public static String getIntervalDate(int n) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, n);
		return simpleDateFormat.format(calendar.getTime());
	}

	/**
	 * 将时间戳转换为日期
	 * 
	 * @return
	 */
	public static String stampToDate(long time) {
		String dateStr;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(time);
		dateStr = simpleDateFormat.format(date);
		return dateStr;
	}

	/**
	 * 10位时间戳转换成日期格式字符串
	 * 
	 * @param seconds   精确到秒的字符串
	 * @param formatStr
	 * @return
	 */
	public static String ts2DateTime(long seconds) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date(Long.valueOf(seconds) * 1000));
	}

	public static String dateTime2TS(String strDate) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(strDate);
		long ts = date.getTime();
		String result = String.valueOf(ts);
		return result;
	}

	/**
	 * 日期格式字符串转换成UNIX时间戳
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String Date2UNIXTimeStamp(String dateStr) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return String.valueOf(sdf.parse(dateStr).getTime() / 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 将美国中部标准时间转换为yyyy-MM-dd HH:mm:ss格式
	 * 
	 * @param EEE MMM dd HH:mm:ss z yyyy
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String CSTTimeToString(String dateStr) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
			Date date = sdf.parse(dateStr);
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 获取当前的年月日
	 * 
	 * @return
	 */
	public static String getCurrentDateTimes() {
		Date date = new Date();
		// 转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(date);
	}

	/**
	 * 将字符串格式转换成年月日时
	 * 
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static String dateTimeToHour(String strDate) throws ParseException {
		SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd HH");
		Date date = null;
		try {
			date = sdfDay.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdfMonth.format(date);
	}

	/**
	 * 获取过去任意天内的日期数组
	 * 
	 * @param intervals intervals天内
	 * @return 已经过去的天数内日期数组
	 */
	public static ArrayList<String> getPastDays(int intervals) {
		ArrayList<String> pastDaysList = new ArrayList<>(); // 定义过去的日期数组
		for (int i = 0; i < intervals; i++) {
			pastDaysList.add(getPastDate(i));
		}
		return pastDaysList;
	}

	/**
	 * 获取过去第几天的日期
	 * 
	 * @param past
	 * @return
	 */
	public static String getPastDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(today);
		return result;
	}
	
	/**
	 * 获取过去第几天的日期时间
	 * 
	 * @param past
	 * @return
	 */
	public static String getPastDateTime(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result = format.format(today);
		return result;
	}

	/**
	 * 获取过去任意月内的月份数组
	 * 
	 * @param intervals 需要获取之前多少月月份数据
	 * @return 已经过去的月份数组
	 */
	public static ArrayList<String> getPastMonths(int intervals) {
		ArrayList<String> pastMonthsList = new ArrayList<>(); // 定义过去的月份数组
		for (int i = 0; i < intervals; i++) {
			pastMonthsList.add(getPastMonth(i));
		}
		return pastMonthsList;
	}

	/**
	 * 获取过去几年内的年份
	 * 
	 * @param intervals 获取几年的数据
	 * @return 已经过去的月份数组
	 */
	public static ArrayList<String> getPastYears(int intervals) {
		ArrayList<String> pastYearsList = new ArrayList<>(); // 定义过去的年份数组
		for (int i = 0; i < intervals; i++) {
			pastYearsList.add(getPastYear(i));
		}
		return pastYearsList;
	}

	/**
	 * 获取过去第几月的月份
	 * 
	 * @param past
	 * @return
	 */
	public static String getPastMonth(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		String result = format.format(today);
		return result;
	}

	/**
	 * 获取过去第几年年份
	 * 
	 * @param past 年
	 * @return 2018
	 */
	public static String getPastYear(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - past);
		Date today = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		String result = format.format(today);
		return result;
	}

	/**
	 * 判断时间是否大于1970年。如果大于返回true，如果小于或等于，返回false。
	 * 
	 * @param date
	 * @return
	 */
	public static boolean judgeYear(Object date) {
		if (date instanceof String) {
			String year = ((String) date).substring(0, 4);
			return year.compareTo("1970") == 1;
		} else if (date instanceof Date) {
			Calendar c = Calendar.getInstance();
			c.setTime((Date) date);
			return c.get(Calendar.YEAR) > 1970;
		} else if (date instanceof Timestamp) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = df.format(date);
			String year = str.substring(0, 4);
			return year.compareTo("1970") == 1;
		}
		return false;
	}

	public static int calcSecondInterval(String time) throws ParseException {
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateTime = simpleFormat.parse(time);
		Date curTime = simpleFormat.parse(getCurrentDataTime());
		long dateTimestamp = dateTime.getTime();
		long curtTimestamp = curTime.getTime();
		return  (int) ((curtTimestamp - dateTimestamp) / 1000);
	}

	public static String getTimeForOss() {
		Date date = new Date();
		// 转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss");
		return dateFormat.format(date);
	}

	public static void main(String[] args) {
		System.out.println(getTimeForOss());
		getDateForOss();
	}

}
