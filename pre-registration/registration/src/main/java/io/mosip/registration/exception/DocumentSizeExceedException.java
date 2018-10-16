package io.mosip.registration.exception;

import io.mosip.kernel.core.exception.BaseUncheckedException;
import io.mosip.registration.errorcodes.ErrorCodes;

public class DocumentSizeExceedException extends BaseUncheckedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4879473387592007255L;

	public DocumentSizeExceedException() {
		super();

	}

	public DocumentSizeExceedException(String message, Throwable cause) {
		super(ErrorCodes.PRG_PAM‌_001.toString(), message, cause);

	}

	public DocumentSizeExceedException(String message) {
		super(ErrorCodes.PRG_PAM‌_001.toString(), message);

	}

}
