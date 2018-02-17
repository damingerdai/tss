package org.aming.tss.base.response;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author daming
 * @version 2018/2/1.
 */
public class Response implements Serializable {

    private static final long serialVersionUID = -7558906894507306601L;

    private static final int DEFAULT_STATUS_CODE = 200;

    private int statusCode = DEFAULT_STATUS_CODE;

    private Error error;

	public int getStatusCode() {
		return statusCode;
	}

	public Response setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public Error getError() {
		return error;
	}

	public Response setError(Error error) {
		this.error = error;
		return this;
	}

	public Response() {
        super();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
