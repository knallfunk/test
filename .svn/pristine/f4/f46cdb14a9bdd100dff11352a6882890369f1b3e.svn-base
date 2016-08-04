package com.wisedu.cloud.smp.common.util;

import java.io.IOException;

import org.apache.http.annotation.Immutable;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

/**
 *
 *
 * @author work.
 *         Created 2013-4-13.
 */
@Immutable
public class BwopHttpRequestRetryHandler implements HttpRequestRetryHandler {
	
	/** the number of times a method will be retried */
    private final int retryCount;
    
    /**
     * Default constructor
     */
    @SuppressWarnings("javadoc")
	public BwopHttpRequestRetryHandler(int retryCount) {
        super();
        this.retryCount = retryCount;
    }

	public boolean retryRequest(IOException exception, int executionCount,
			HttpContext context) {
		return this.retryCount > executionCount;
	}
	
	/**
     * @return the maximum number of times a method will be retried
     */
    public int getRetryCount() {
        return this.retryCount;
    }

	
}
