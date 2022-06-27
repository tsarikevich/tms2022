package by.teachmeskills.eshop.exceptions;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import static by.teachmeskills.eshop.utils.EshopConstants.REDIRECT_TO_LOGIN_PAGE;

@Log4j
@ControllerAdvice(basePackages = "by.teachmeskills.eshop.controllers")
public class GlobalControllerException {
    @ExceptionHandler
    public ModelAndView SessionException(Exception e) {
        log.error(e.getMessage());
        return new ModelAndView(REDIRECT_TO_LOGIN_PAGE);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthorizationException.class)
    public ModelAndView AuthException(Exception e) {
        log.error(e.getMessage());
        return new ModelAndView(REDIRECT_TO_LOGIN_PAGE);
    }
}
