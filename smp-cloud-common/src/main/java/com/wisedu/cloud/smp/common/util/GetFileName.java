package com.wisedu.cloud.smp.common.util;

import java.io.File;

public class GetFileName {

	public static String getFileName(String originalFileFullPath)
	{
		if(null != originalFileFullPath && !originalFileFullPath.isEmpty())
		{
			int parseIndex = originalFileFullPath.lastIndexOf(File.separator);
			if(-1 == parseIndex)
			{
				return null;
			}
			else
			{
				return originalFileFullPath.substring(parseIndex+1);
			}
		}
		else
		{
			return null;
		}

	}
	
	public static String getDirectory(String originalFileFullPath)
	{
		if(null != originalFileFullPath && !originalFileFullPath.isEmpty())
		{
			int parseIndex = originalFileFullPath.lastIndexOf(File.separator);
			if(-1 == parseIndex)
			{
				return null;
			}
			else
			{
				return originalFileFullPath.substring(0,parseIndex);
			}
		}
		else
		{
			return null;
		}

	}
	
	public static String getFileNameNoSuffix(String originalFileFullPath)
	{
		if(null != originalFileFullPath && !originalFileFullPath.isEmpty())
		{
			int parseIndex = originalFileFullPath.lastIndexOf(File.separator);
			int dotIndex = originalFileFullPath.lastIndexOf('.');
			if(-1 != parseIndex &&  -1 != dotIndex)
			{
				return originalFileFullPath.substring(parseIndex+1,dotIndex);	
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}

	}
	
}
