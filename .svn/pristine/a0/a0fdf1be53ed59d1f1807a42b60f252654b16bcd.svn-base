package com.wisedu.cloud.smp.common.util;

import org.apache.log4j.Logger;

/**
 * Operations on local file system.
 * <p>
 * 
 * @author yy
 * @version v0.1
 * @date 2014-08-13
 */

public class LocalFileOperate {

	private static final Logger LOGGER = Logger
			.getLogger(LocalFileOperate.class);

	private LocalFileOperate() {
		// Do nothing
	}

	public static void copyFolder(String ori, String dest) {
		String copyString = "cp -r ";
		String command = copyString + ori + " " + dest;
		callShell(command);
	}

	public static void callShell(String shellString) {
		try {
			Process process = Runtime.getRuntime().exec(shellString);
			int exitValue = process.waitFor();
			if (0 != exitValue) {
				LOGGER.error("call shell failed. error code is :" + exitValue);
			}
		} catch (Exception e) {
			LOGGER.error("call shell failed. " + e);
		}
	}
}
