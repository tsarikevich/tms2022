package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.teachmeskills.eshop.PagesPathEnum.REGISTRATION_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.CHECK_NEW_USER;

public class RegistrationRedirectCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        request.setAttribute(CHECK_NEW_USER.getValue(), true);
        return REGISTRATION_PAGE.getPath();
    }
}
