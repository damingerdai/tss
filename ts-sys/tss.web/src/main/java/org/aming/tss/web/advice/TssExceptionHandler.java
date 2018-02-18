package org.aming.tss.web.advice;

import org.aming.tss.base.constant.ErrorCodeConstant;
import org.aming.tss.base.exception.TssException;
import org.aming.tss.base.response.Response;
import org.aming.tss.base.response.Error;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author daming
 * @version 2018/2/16.
 */
@RestControllerAdvice
public class TssExceptionHandler {

	@ExceptionHandler(TssException.class)
	public Response handleTssException(TssException ex) {
		return new Response()
				.setStatusCode(-1)
				.setError(new Error()
						.setErrorCode(ex.getCode())
						.setErrorMessage(ex.getMessage())
				);
	}

	@ExceptionHandler(Exception.class)
	public Response handleCommonException(Exception ex) {
		System.err.println(ex);
		return new Response()
				.setStatusCode(-1)
				.setError(new Error()
						.setErrorCode(ErrorCodeConstant.ERR_DAO_SYSTEM)
						.setErrorMessage(ex.getMessage())
				);
	}
}
