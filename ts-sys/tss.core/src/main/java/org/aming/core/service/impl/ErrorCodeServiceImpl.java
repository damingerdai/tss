package org.aming.core.service.impl;

import org.aming.core.service.ErrorCodeService;
import org.aming.tss.base.exception.TssException;
import org.aming.tss.base.props.ErrorProp;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author daming
 * @version 2018/2/11.
 */
@Service
public class ErrorCodeServiceImpl implements ErrorCodeService {

	private ErrorProp errorProp;

	@Override
	public String getErrorMessage(String errorCode) throws TssException {
		return errorProp.getErrorMessage(errorCode);
	}

	@Override
	public String getErrorMessage(String errorCode, String defaultValue) throws TssException {
		Optional<String> optional = Optional.ofNullable(errorProp.getErrorMessage(errorCode));
		return optional.orElse(defaultValue);
	}

	public ErrorCodeServiceImpl(ErrorProp errorProp) {
		super();
		this.errorProp = errorProp;
	}
}
