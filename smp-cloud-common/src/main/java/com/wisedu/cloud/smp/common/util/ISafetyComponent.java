package com.wisedu.cloud.smp.common.util;

/**
 *
 * @author nick
 * 2013-3-12
 */
public interface ISafetyComponent {
	public boolean isSafe(String sign, Object ... keyvalues);
}
