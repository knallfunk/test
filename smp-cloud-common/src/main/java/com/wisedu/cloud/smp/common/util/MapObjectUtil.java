/**
 * 
 */
package com.wisedu.cloud.smp.common.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 对象与map相互转化
 * 
 * @author huangxuecan
 * 
 */
public class MapObjectUtil {

	private MapObjectUtil(){
		// Do nothing
	}

	/**
	 * 将对象转为map
	 * 
	 * @param Object
	 * @return Map
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static Map<String, Object> objectConvertToMap(Object obj)
			throws IllegalAccessException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (obj == null)
			return null;
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			Object o = field.get(obj);
			resultMap.put(field.getName(), o);

		}
		return resultMap;
	}

	/**
	 * 将map装换为对象
	 * 
	 * @param obj
	 * @param map
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	public static Object mapConvertToObject(Object obj, Map<String, Object> map)
			throws IllegalAccessException {
		if (obj == null || map == null || map.size() == 0) {
			return null;
		}
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String fieldName = field.getName();
			String fieldType = field.get(obj).getClass().getName();
			Object mapValue = map.get(fieldName);
			if (mapValue != null
					&& mapValue.getClass().getName().equals(fieldType)) {
				Field[] fieldChildren = field.getClass().getDeclaredFields();
				if (fieldChildren.length <= 0) {
					field.set(obj, mapValue);
				} else {
					if (mapValue instanceof Map)
					field.set(
							obj,
							mapConvertToObject(field,
									(Map<String, Object>) mapValue));
				}
			}
		}
		return obj;

	}

}
