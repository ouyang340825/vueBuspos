package com.njty.carpark.utils;


import com.njty.carpark.bean.MsgBean;
import com.njty.carpark.bean.TreeMsgBean;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class SystemUtils {
	private static String strZero = "0000000000000000000000";
	private static int TIME_S = 60;
	private static int TIME_H = TIME_S * TIME_S;
	private static int TIME_D = 24 * TIME_H;

	/**
	 * 描述：取系统时间
	 * @return
	 */
	public static String getCurrentSystemTime() {
		SimpleDateFormat dateFormatter =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		return dateFormatter.format(c.getTime());
	}


	/**
	 * 描述：取系统时间
	 * @return
	 */
	public static String getCurrentSystemTime(String format) {
		SimpleDateFormat dateFormatter =new SimpleDateFormat(format);
		Calendar c = Calendar.getInstance();
		return dateFormatter.format(c.getTime());
	}

	/**
	 * 描述信息：加减月
	 * @param num
	 * @param format
	 * @return
	 */
	public static String funMonthTimeInfo(int num, String format) {
		SimpleDateFormat dateFormatter =new SimpleDateFormat(format);
		Date now = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		c.add(Calendar.MONTH, num);
		return dateFormatter.format(c.getTime());
	}

	/**
	 * 描述信息：加减天
	 * @param num
	 * @param format
	 * @return
	 */
	public static String funDayTimeInfo(int num, String format) {
		SimpleDateFormat dateFormatter =new SimpleDateFormat(format);
		Date now = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		c.add(Calendar.DAY_OF_YEAR, num);
		return dateFormatter.format(c.getTime());
	}

	/**
	 * 描述信息：加减小时
	 * @param num
	 * @param format
	 * @return
	 */
	public static String funHourTimeInfo(int num, String format) {
		SimpleDateFormat dateFormatter =new SimpleDateFormat(format);
		Date now = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		c.add(Calendar.HOUR, num);
		return dateFormatter.format(c.getTime());
	}

	/**
	 * 描述信息：
	 * @param num
	 * @param stime
	 * @param format
	 * @return
	 */
	public static String funDayTimeInfo(int num, String stime, String format) {
		SimpleDateFormat dateFormatter =new SimpleDateFormat(format);
		Date now = strToDate(stime, format);
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		c.add(Calendar.DAY_OF_YEAR, num);
		return dateFormatter.format(c.getTime());
	}

	/**
	 * 描述信息：格式化
	 * @param time
	 * @param toFormat
	 * @param formFormat
	 * @return
	 */
	public static String funDataFormatInfo(String time, String toFormat, String formFormat) {
		try {
			DateFormat format = new SimpleDateFormat(toFormat);
			SimpleDateFormat formatter = new SimpleDateFormat(formFormat);
			time = formatter.format(format.parse(time));
		}catch (Exception e){
			e.printStackTrace();
		}
		return time;
	}


	/**
	 * 描述信息：取用户Session最后访问时间与当前系统时间比较
	 * @param mUserLastAccessedTime
	 * @return
	 */
	public static boolean getUserLastAccessedTime(long mUserLastAccessedTime){
		Calendar c = Calendar.getInstance();

		//如果大于5分钟，则系统默认为此用户已退出，只是没响应关闭事件
		if ((c.getTimeInMillis() - mUserLastAccessedTime) > (1000 * 60 * 4) ){
			return true;
		}
		return false;
	}


	/**
	 * 描述信息：根据毫秒获取方法调用所耗时间
	 * @param startTime
	 * @return
	 */
	public static Long getMethodUsedTime(long startTime){
		Long time = System.currentTimeMillis() - startTime;
		return time;
	}







	/**
	 * 描述信息：分隔字符串，返回数组
	 * @param strInfo
	 * @param strSepChars
	 * @return
	 */
	public static String[] funSplit(String strInfo, String strSepChars) {
		return StringUtils.split(strInfo, strSepChars);
	}




	/**
	 * 描述信息：生成密码
	 * @return
	 */
	public static String funRandomPwdInfo() {
		String strRet = "";
		Random random = new Random();

		int argFly[] = new int[]{0,0,0};
		int nTemp = 0;
		while (strRet.length() < 6) {
			nTemp = random.nextInt(3);
			argFly[nTemp] = argFly[nTemp] + 1;
			strRet += funRandomCharInfo(nTemp);

			if (strRet.length() == 6) {
				for (int nItem = 0; nItem < argFly.length; nItem++) {
					if (argFly[nItem] < 2) {
						argFly = new int[]{0,0,0};
						strRet = "";
					}
				}
			}
		}
		return strRet;
	}

	/**
	 * 描述信息：生成随机数
	 * @param key
	 * @return
	 */
	public static String funRandomCharInfo(int key) {
		//String strTel = "!@#$%*()_+^&}{:;?.";
		String strChar = "1234567890ABCDEFGHIJKLMNOPQRSTUVXWYZabcdefghijklmnopqrstuvxwyz";
		//String strInfo = "1234567890";
		Random random = new Random();

		String strRet = "";
		switch (key) {
			case 0:
				strRet = ""+strChar.charAt(random.nextInt(strChar.length()));
				break;

			case 1:
				strRet = ""+strChar.charAt(random.nextInt(strChar.length()));
				break;

			case 2:
				strRet = ""+strChar.charAt(random.nextInt(strChar.length()));
				break;
		}
		return strRet;
	}



	/***
	 * 描述：两日期相差天数
	 * @param
	 * @return
	 */
	public static long getSubDay(String startTime, String endTime) {
		SimpleDateFormat dateFormatter =new SimpleDateFormat("yyyy-MM-dd");
		long onday = 0x5265c00;
		long nRet = 0;
		try {
			nRet = (dateFormatter.parse(endTime).getTime() - dateFormatter.parse(startTime).getTime()) / onday;
		}catch (Exception e){
			e.printStackTrace();
		}
		return nRet;
	}



	/**
	 * 描述信息：处理时间
	 * @param strInfo
	 * @return
	 */
	public static String DealDevUpLoadDriverLogInfo(String strInfo) {
		String strRet = "";
		try {
			if (strInfo != null && strInfo.trim().length() != 0)
			{
				int nRet = Integer.parseInt(strInfo);

				if ((nRet / TIME_D) != 0)
				{
					strRet = (nRet / TIME_D)+"天，";
					nRet = nRet % TIME_D;
				}

				if ((nRet / TIME_H) != 0)
				{
					strRet += (nRet / TIME_H)+"小时，";
					nRet = nRet % TIME_H;
				}


				if ((nRet / TIME_S) != 0)
				{
					strRet += (nRet / TIME_S)+"分，";
					nRet = nRet % TIME_S;
				}

				if (nRet != 0)
				{
					strRet += nRet+"秒";
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return strRet;
	}


	/**
	 * 两个字符串日期间的间
	 * 2012-07-01与2012-07-10 返回10
	 * 顺序不限
	 * 合法值始终返回正数
	 * @param sDate
	 * @param eDate
	 * @return 非法数据返回-1
	 */
	public static int daysBetweenTwoDate(String sDate, String eDate)
	{
		Date d1 = strToDate(sDate, "yyyy-MM-dd");
		Date d2 = strToDate(eDate, "yyyy-MM-dd");
		if (d1 != null && d2 != null)
		{
			long ms = Math.abs(d2.getTime() - d1.getTime());
			return (int) (ms / (24 * 60 * 60 * 1000)) + 1;
		}
		return -1;
	}

	/**
	 * 描述信息：比较时间
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	public static int funCompareTimeInfo(String sDate, String eDate)
	{
		Date d1 = strToDate(sDate, "yyyy-MM-dd");
		Date d2 = strToDate(eDate, "yyyy-MM-dd");
		if (d1 != null && d2 != null)
		{
			long ms = d2.getTime() - d1.getTime();
			return (int) (ms / (24 * 60 * 60 * 1000)) + 1;
		}
		return -1;
	}


	/**
	 * 字符串转日期
	 * @param sDate
	 * @param format
	 * @return
	 */
	public static Date strToDate(String sDate, String format)
	{
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try
		{
			date = sdf.parse(sDate);
		}
		catch (Exception e)
		{
		}
		return date;
	}

	// 字符串转日期类型
	public static Date StrToDateTime(String sdate, String formatstyle)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(formatstyle);
		Date d = new Date();
		try
		{
			d.setTime(sdf.parse(sdate).getTime());
		} catch (ParseException ex)
		{}

		return d;
	}

	// 格式化日期类型
	public static String FormatDateTime(Date d, String formatstyle)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(formatstyle);
		return sdf.format(d);
	}



	// 计算日期的加减天数
	public static Date IncDay(Date d, int i)
	{
		long dd = (86400000l * i);
		d.setTime(d.getTime() + dd);
		return d;
	}

	/**
	 * 描述信息：中文
	 * @param s
	 * @return
	 */
	public static String toUtf8String(String s)
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (c >= 0 && c <= 255)
			{
				sb.append(c);
			}
			else
			{
				byte[] b;
				try
				{
					b = Character.toString(c).getBytes("utf-8");
				}
				catch (Exception ex)
				{
					System.out.println(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++)
				{
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}


	/**
	 * 描述信息：强转
	 * @param strRet
	 * @return
	 */
	public static int parseInt(String strRet)
	{
		int nRet = -1;
		try
		{
			nRet = Integer.parseInt(strRet);
		}
		catch (Exception e)
		{

		}
		return nRet;
	}

	/**
	 *
	 * 描述信息：检查经纬度是否为负值
	 * 创建时间：2013-4-22
	 * @author hj
	 * @param lat
	 * @param log
	 * @return
	 */
	public static boolean checkItude(String lat, String log)
	{
		try
		{
			if (lat==null || log==null
					|| Integer.parseInt(lat)<=0 || Integer.parseInt(log)<=0)
			{
				return true;
			}
		}
		catch (Exception e)
		{
		}
		return false;
	}

	/**
	 *
	 * 描述信息：去除list中重复数据
	 * 创建时间：2013-4-24
	 * @author hj
	 * @param list
	 * @return
	 */
	public static ArrayList removeDuplicate(ArrayList list)
	{
		for (int i = 0,k=list.size() - 1; i < k; i++)
		{
			for (int j = list.size() - 1; j > i; j--)
			{
				if (list.get(j).equals(list.get(i)))
				{
					list.remove(j);
				}
			}
		}
		return list;
	}

	/**
	 *
	 * 描述信息：去除list中重复数据
	 * 创建时间：2013-4-24
	 * @author hj
	 * @param list
	 * @return
	 */
	public static List removeDuplicateList(List list)
	{
		for (int i = 0,k=list.size() - 1; i < k; i++)
		{
			for (int j = list.size() - 1; j > i; j--)
			{
				if (list.get(j).equals(list.get(i)))
				{
					list.remove(j);
				}
			}
		}
		return list;
	}

	/**
	 *
	 * 描述信息：合并list
	 * 创建时间：2013-4-24
	 * @author hj
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List combineList(List list1, List list2)
	{
		List list = new ArrayList();
		if(list1==null||list1.size()<=0)
		{
			return list2;
		}
		list = list1;
		list.addAll(list2);
		return list;
	}

	public static boolean isRightSim(String sim)
	{
		if (sim!=null&&sim.length()<=0)
		{
			String regex = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher =pattern.matcher(sim);
			return matcher.find();
		}else {
			return false;
		}

	}



	/**
	 * 描述信息：返回天数
	 * @param strMonth
	 * @return
	 */
	public static int funMonthCntInfo(String strMonth)
	{
		int nRet = 30;
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, parseInt(strMonth.split("-")[0]));
		cal.set(Calendar.MONTH, parseInt(strMonth.split("-")[1]) - 1);//Java月份才0开始算
		nRet = cal.getActualMaximum(Calendar.DATE);
		if (strMonth.equals(SystemUtils.funDayTimeInfo(0, "yyyy-MM")))
		{
			nRet = parseInt(SystemUtils.funDayTimeInfo(0, "dd"));
		}
		return nRet;
	}


	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23) + uuid.substring(24);
	}

	public static MsgBean toMsgBeanMysqlData(List<Map<String,Object>> list) {
		MsgBean msgBean = new MsgBean();
		msgBean.setRows((List<?>) list.get(0));
		msgBean.setTotal(Integer.parseInt(((ArrayList) list.get(1)).get(0).toString()));
		return msgBean;

	}

	public static MsgBean toMsgBeanForSelect(List<Map<String,Object>> list) {
		MsgBean msgBean = new MsgBean();
		if(list.size()>0){
			msgBean.setRows(list);
			int total= Integer.parseInt(list.get(0).get("TOTAL").toString());
			msgBean.setTotal(total);
		}else if(list.size()==0){
			msgBean.setTotal(0);
			msgBean.setMsg(Constants.GLOBAL_MSG_NORECORD);
		}
		return msgBean;
	}

	public static TreeMsgBean toMsgBeanForSelectTree(List<Map<String,Object>> list) {
		TreeMsgBean treeMsgBean = new TreeMsgBean();
		if(list.size()>0){
			treeMsgBean.setData(list);
			int total= Integer.parseInt(list.get(0).get("TOTAL").toString());
			treeMsgBean.setCount(total);
		}else if(list.size()==0){
			treeMsgBean.setCount(0);
			treeMsgBean.setMsg(Constants.GLOBAL_MSG_NORECORD);
			treeMsgBean.setData(list);
		}
		return treeMsgBean;
	}

	public static MsgBean toMsgBeanForExportData(List<Map<String,Object>> list) {
		MsgBean msgBean = new MsgBean();
		if(list.size()>0){
			msgBean.setRows(list);
			msgBean.setTotal(list.size());
		}else if(list.size()==0){
			msgBean.setTotal(0);
			msgBean.setMsg(Constants.GLOBAL_MSG_NORECORD);
		}
		return msgBean;
	}

	public static MsgBean toMsgBeanForAddMOdDel(int total) {
		MsgBean msgBean= new MsgBean();
		if(total>0){
			msgBean.setSuccess(Constants.GLOBAL_MSG_BOOL_SUCCESS);
		}
		return msgBean;
	}

	/**
	 * 十进制转其它进制
	 * @param tenNumber
	 * @param hexNumber
	 * @return
	 */
	public static String tenToanyHexNumber(int tenNumber, int hexNumber) {
		List<String> list = new ArrayList<String>();
		while (tenNumber / hexNumber != 0) {
			int aa = tenNumber % hexNumber;//获取求余的数字
			list.add(String.valueOf(aa));
			tenNumber = tenNumber / hexNumber;//获取除去进制数后的数，看是都还以为被除
		}
		list.add(String.valueOf(tenNumber));//将最后一个数添加进入集合
		String endHexNumber = "";
		Collections.reverse(list);
		for (int i = 0; i < list.size(); i++) {
			endHexNumber = endHexNumber + list.get(i);
		}
		return endHexNumber;
	}

	/**
	 * 二进制转十进制
	 * @param inteter
	 * @return
	 */
	public static int twoToTenHexNumber(String inteter) {
		int inteterSum = 0;
		for (int i = inteter.length(); i > 0; i--) {
			int scale = 2;
			if (inteter.charAt(-(i - inteter.length())) == '1') {
				if (i != 1) {
					for (int j = 1; j < i - 1; j++) {
						scale *= 2;
					}
				} else {
					scale = 1;
				}
			} else {
				scale = 0;
			}
			inteterSum += scale;
		}
		return inteterSum;
	}

	public static Map<String, Object> setParams(Map<String, Object> params) {
		Integer limit = Integer.parseInt(params.get("limit").toString());
		Integer page = Integer.parseInt(params.get("page").toString());
		params.put("startNum",page*limit-limit);
		params.put("endNum",page*limit);
		return params;
	}
}
