package by.teachmeskills.eshop.exceptions;

import lombok.extern.log4j.Log4j;

@Log4j
public class RequestParamNullException extends CommandException {
    public RequestParamNullException(String message) {
        super(message);
        log.error("Request param null exception");
    }
}
