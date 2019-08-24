package apps.proman.api.exception;

import apps.proman.service.common.exception.ErrorCode;

public class UnauthorizedException extends RestException {

    public UnauthorizedException(final ErrorCode errorCode, final Object... parameters){
        super(errorCode, parameters);
    }

}
