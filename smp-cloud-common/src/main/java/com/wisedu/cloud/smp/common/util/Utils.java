package com.wisedu.cloud.smp.common.util;


import java.io.UnsupportedEncodingException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author huangxuecan
 * @date   2014年11月30日
 *
 */
public class Utils {
	private static final Log LOGGER = LogFactory.getLog(Utils.class);

	private Utils(){
	    super();
	}
	public static boolean isNullOrEmpty(@SuppressWarnings("rawtypes") Map map) {
		return map == null || map.isEmpty();
	}
	
	public static boolean isNullOrEmpty(@SuppressWarnings("rawtypes") List list) {
		return list == null || list.isEmpty();
	}
	
	public static boolean isNullOrEmpty(Object[] objects) {
		return objects == null || objects.length == 0;
	}
	
	public static boolean isNullOrEmpty(String string) {
		return string == null || "".trim().equals(string);
	}

	public static boolean isNullOrQuote(String string) {
		return string == null || "\"\"".equals(string.trim());
	}
	
	public static boolean isQuote(String string) {
		if(string == null) {
			return false;
		}
		return "\"\"".equals(string.trim());
	}
	
	public static boolean isNullOrEmpty(@SuppressWarnings("rawtypes") Collection collection) {
		return collection == null || collection.isEmpty();
	}
	
	public static boolean isNullOrEmpty(long[] array) {
		return array == null || array.length == 0;
	}
	
	public static String formatDate(Date date, String pattern) {
		if(date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static String formatDate(long date, String pattern) {
		Date d = new Date(date);
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(d);
	}
	
	public static Date parseDate(String dateStr, String pattern) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			 date = sdf.parse(dateStr);
		} catch (ParseException e) {
			LOGGER.error("parseDate meets exceptions",e);
		}
		return date;
	}


	
	/*将输入的字符串的第一个字母变成大写字母，然后返回*/
	public static String firstUpperCase(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}
	
	public static String getMD5Str(String str) {
		 
        MessageDigest messageDigest;

		StringBuilder md5StrBuff = new StringBuilder();
		try {
            messageDigest = MessageDigest.getInstance("MD5");  
  
            messageDigest.reset();  
  
            messageDigest.update(str.getBytes("UTF-8"));

			byte[] byteArray = messageDigest.digest();


			for (int i = 0; i < byteArray.length; i++) {
				if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
					md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
				else
					md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
			}

		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("getMD5Str meets exceptions",e);
        } catch (UnsupportedEncodingException e) {  
			LOGGER.error("getMD5Str meets exceptions",e);
        }  
  
        return md5StrBuff.toString();
    }  
}
