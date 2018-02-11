package org.aming.core.service;

import org.aming.tss.base.exception.TssException;

/**
 * @author daming
 * @version 2018/2/11.
 */
public interface ErrorCodeService {

	/**
	 * 根据错误编码获取错误信息
	 * @param errorCode
	 * @return
	 * @throws TssException
	 */
	String getErrorMessage(String errorCode) throws TssException;

	/**
	 * 根据错误编码获取错误信息,
	 * 如果不存在，则返回默认错误信息
	 * @param errorCode
	 * @param defaultValue
	 * @return
	 * @throws TssException
	 */
	String getErrorMessage(String errorCode, String defaultValue) throws TssException;
}
