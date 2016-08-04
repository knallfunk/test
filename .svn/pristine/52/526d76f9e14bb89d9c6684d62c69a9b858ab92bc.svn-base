package com.wisedu.cloud.smp.common.util;


/**
 * 
 * @author: huangxuecan
 * @date: 2014年9月17日 下午4:46:23
 * 
 */

public class FileNameUtil {

	public static String getFileType(String fileName) {
		String ret = null;
		if (null != fileName) {
			int lastIndexOfdot = fileName.lastIndexOf('.');
			if (-1 == lastIndexOfdot)
				ret = "";
			else
				ret = fileName.substring(lastIndexOfdot + 1);
		}
		return ret;
	}

	public static String getFileNameNoSuffix(String fileName) {
		String ret = null;
		if (null != fileName) {
			int lastIndexOfdot = fileName.lastIndexOf('.');
			if (-1 == lastIndexOfdot)
				ret = fileName;
			else
				ret = fileName.substring(0, lastIndexOfdot);
		}
		return ret;
	}

}
