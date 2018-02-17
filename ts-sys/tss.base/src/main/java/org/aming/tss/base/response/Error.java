package org.aming.tss.base.response;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author daming
 * @version 2018/2/16.
 */
public class Error implements Serializable {
	private static final long serialVersionUID = 771737134832583652L;

	private String errorCode;
	private String errorMessage;

	public String getErrorCode() {
		return errorCode;
	}

	public Error setErrorCode(String errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Error setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

	public Error() {
		super();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
