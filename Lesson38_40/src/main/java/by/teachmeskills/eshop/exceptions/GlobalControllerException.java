package by.teachmeskills.eshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import static by.teachmeskills.eshop.utils.EshopConstants.REDIRECT_TO_LOGIN_PAGE;

@ControllerAdvice(basePackages = "by.teachmeskills.eshop.controllers")
public class GlobalControllerException {
    @ExceptionHandler
    public ModelAndView SessionException(Exception e) {
        System.out.println(e.getMessage());
        return new ModelAndView(REDIRECT_TO_LOGIN_PAGE);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthorizationException.class)
    public ModelAndView AuthException(Exception e) {
        System.out.println(e.getMessage());
        return new ModelAndView(REDIRECT_TO_LOGIN_PAGE);
    }
}
