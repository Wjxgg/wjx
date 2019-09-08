package com.bw.wjx.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author zhuzg
 *���ڴ�������
 */
public class DateUtil {
	/**
	 * ��ȡ�����ʱ�䵽���ڵ�����
	 * @param futureDate
	 * @return
	 */
	public int getRemainDays(Date futureDate) {
		return (int)(futureDate.getTime()-new Date().getTime())/1000/3600/24;	
	}
	
	/**
	 * �ж��Ƿ��ǽ��췽��
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String dateStr = simpleDateFormat.format(date);
		String todayStr = simpleDateFormat.format(new Date());
		return dateStr.equals(todayStr);
		
	}
	
	
	/**
	 * �ж����ǲ��Ǳ���
	 * @param date
	 * @return
	 */
	public static boolean isCurrentMonth(Date date) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
		String dateStr = simpleDateFormat.format(date);
		String todayStr = simpleDateFormat.format(new Date());
		return dateStr.equals(todayStr);
		
	}
	
	/**
	 * �õ������·ݵĿ�ʼ
	 * @return
	 * @throws ParseException 
	 */
	public static Date getMonthStart(Date date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String string = format.format(date);//199809
		String monthStart = string + "01 00:00:00";
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.parse(monthStart);
	}
	
	
	/**
	 * �õ������·ݵ����ʱ�� 23��59
	 * @return
	 * @throws ParseException 
	 */
	public static Date getMonthEnd(Date date) throws ParseException {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE, 0);
		//calendar.set(Calendar.HOUR, 0);
		
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime(); 
		
	}
	
	/**
	 * 
	 * @param birthday
	 * @return
	 */
	public int getAge(Date birthday) {
		
		Calendar instance = Calendar.getInstance();
		instance.setTime(birthday);
		
		//
		int birthYear = instance.get(Calendar.YEAR);
		int birthMonth = instance.get(Calendar.MONTH);
		int birthDate = instance.get(Calendar.DAY_OF_MONTH);
		
		//
		instance.setTime(new Date());
		int currentYear = instance.get(Calendar.YEAR);
		int currentMonth = instance.get(Calendar.MONTH);
		int currentDate = instance.get(Calendar.DAY_OF_MONTH);
		
		int age = currentYear-birthYear;
		if(currentMonth<birthMonth) {
			age--;
		}else if(currentMonth==birthMonth && currentDate<birthDate){
			age --;
		}
		
		return age;
		
	}
	
	
}
