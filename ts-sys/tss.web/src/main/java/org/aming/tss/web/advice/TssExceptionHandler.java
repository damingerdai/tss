package org.aming.tss.web.advice;

import org.aming.tss.base.exception.TssException;
import org.aming.tss.base.response.Response;
import org.aming.tss.base.response.Error;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author daming
 * @version 2018/2/16.
 */
@ControllerAdvice
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
}
