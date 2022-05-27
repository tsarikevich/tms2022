package by.teachmeskills.eshop.exceptions;

import lombok.extern.log4j.Log4j;

@Log4j
public class CommandException extends Exception {
    public CommandException(String message) {
        super(message);
        log.error("Command exception");
    }
}
