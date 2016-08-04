package com.wisedu.cloud.smp.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;

public class TimeUtils {
	public static final String DEFAULT_DATE_TIME_FORMAT_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static final String DEFAULT_DATE_TIME_FORMAT_HH_MM = "yyyy-MM-dd HH:mm";
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	public static final String DATE_TIME_BEGIN_AT = " 00:00:00";


	public static final String getCurrentDate(){
		return new SimpleDateFormat(DEFAULT_DATE_FORMAT)
				.format(new Date(System.currentTimeMillis()));
	}

	public static final String getCurrentTime(){
		return new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT_HH_MM_SS)
				.format(new Date(System.currentTimeMillis()));
	}
}
