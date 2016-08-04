package com.wisedu.cloud.smp.common.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;

public class CommonUtils {

	public static final String toUtf8(String str)
			throws UnsupportedEncodingException {
		return new String(str.getBytes("UTF-8"), "UTF-8");
	}

	public static final Object copyObject(Object from, Object to)
			throws IllegalArgumentException, IllegalAccessException {
		Field[] fromFields = from.getClass().getDeclaredFields();
		Field[] toFields = to.getClass().getDeclaredFields();
		for (Field fromField : fromFields) {
			fromField.setAccessible(true);
			for (Field toField : toFields) {
				toField.setAccessible(true);
				if (toField.getName().equals(fromField.getName())) {
					toField.set(to, fromField.get(from));
					break;
				}
			}
		}
		return to;
	}
}
