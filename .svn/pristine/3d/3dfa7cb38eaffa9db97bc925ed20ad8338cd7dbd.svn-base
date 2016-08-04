package com.wisedu.cloud.smp.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author huangxuecan
 * 
 */
public class JsonUtils {

	private static Gson gson = new GsonBuilder().setDateFormat(
			"yyyy-MM-dd HH:mm:ss").create();

	/**
	 * //考虑到可能会有的编码问题，所以使用net.sf.json包
	 * 
	 * @param <T>
	 * @param o
	 * @return
	 */
	public static <T> String toJson(T o) {
		String s = "";
		if (o == null) {
			return s;
		}

		if (o instanceof Collection || o.getClass().isArray()) {
			// 如果是数组
			s = JSONArray.fromObject(o).toString();
		} else {
			s = JSONObject.fromObject(o).toString();
		}
		return s;
	}

	/**
	 * 从json转到对象
	 * 
	 * @param <T>
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> List<T> fromJsonArray(String json, Class<T> clazz) {
		JSONArray array = JSONArray.fromObject(json);
		List<T> list = new ArrayList<T>();
		for (Iterator it = array.iterator(); it.hasNext();) {
			JSONObject jsonObject = (JSONObject) it.next();
			list.add((T) JSONObject.toBean(jsonObject, clazz));
		}
		return list;

	}
}
