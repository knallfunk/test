package com.wisedu.cloud.smp.common.util;

import org.apache.log4j.Logger;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TransMapToObj {

	/**
	 * 通用方法将map转成javabean
	 * 
	 * @author litong
	 * @date 2014年12月1日
	 * @param originMap
	 *            要转化的map
	 * @param clazz
	 *            要转成的对象类
	 * @return
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	private static final Logger LOGGER = Logger
			.getLogger(TransMapToObj.class);

	private TransMapToObj(){
		// Do nothing
	}
	public static <T> T transMapToClass(Map<String, Object> originMap,
			Class<T> clazz)  {
		try {
			Map<String, Object> map = transMapKeyToLowercase(originMap);
			T c = clazz.newInstance();
			Field[] fields = c.getClass().getDeclaredFields();
			for (Field field : fields) {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(),
						clazz);
				Method writeMethod = pd.getWriteMethod();
				Class<?> typeClazz = field.getType();
				String key = field.getName().toLowerCase();
				if (typeClazz.toString().contains("java.lang.String")) {
					String value = (String) map.get(key);
					writeMethod.invoke(c, value);
				} else if (typeClazz.toString().contains("double")) {
					// 如果数据库中使用varchar 只能先转string
					Object value = map.get(key);
					Double doubleValue = Double.valueOf(value.toString());
					writeMethod.invoke(c, doubleValue);
				} else if (typeClazz.toString().contains("int")) {
					// 如果数据库中使用varchar 只能先转string
					Object value = map.get(key);
					Integer intValue = Integer.valueOf(value.toString());
					writeMethod.invoke(c, intValue);
				}
			}
			return c;
		} catch (Exception e) {
			LOGGER.error("",e);
		}
		return (T) new Object();
	}

	/**
	 * 将map中key转成小写
	 * 
	 * @author litong
	 * @date 2014年12月1日
	 * @param map
	 * @return
	 */

	public static Map<String, Object> transMapKeyToLowercase(
			Map<String, Object> map) {
		Map<String, Object> retmap = new HashMap<String, Object>();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String keynew = entry.getKey().toLowerCase();
			Object value = entry.getValue();
			retmap.put(keynew, value);
		}
		return retmap;
	}
}
