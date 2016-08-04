package com.wisedu.cloud.smp.common.util;

import java.util.regex.Pattern;

/**
 * @author huangxuecan
 *
 */
public class TimeValidatorUtil {
	
	public static final String DATE_REGIX = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})"//普通年份0001-9999
    		+ "\\-(((0[13578]|1[02])\\-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)\\-(0[1-9]|[12][0-9]|30))|(02\\-(0[1-9]|[1][0-9]|2[0-8]))))"//平年和闰年月份 分大小月 不包括2月29日
    		+ "|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))\\-02\\-29)$";//润年的2月29日
	public static final String TIME_REGIX = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})"//普通年份0001-9999
    		+ "-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))"//平年和闰年月份 分大小月 不包括2月29日
    		+ "|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))"//润年的2月29日
    		+ "\\s([0-1][0-9]|2[0-3])\\:([0-5][0-9])\\:([0-5][0-9])";
	/**
	 *验证日期格式为：YYYY-MM-DD 
	 * @param String
	 * @return boolean
	 *
	 */
	public static boolean validateDate(String date){
        Pattern p = Pattern.compile(DATE_REGIX);		
		return p.matcher(date).matches();
	}
	
	/**
	 *验证时间格式为：YYYY-MM-DD HH:mm:ss 
	 * @param String
	 * @return boolean
	 *
	 */
	public static boolean validateTime(String time){
		Pattern p = Pattern.compile(TIME_REGIX);
		return p.matcher(time).matches();
	}

}
