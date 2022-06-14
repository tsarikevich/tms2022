package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;

public class LogoutCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(false);
        session.invalidate();
        return SIGN_IN_PAGE.getPath();
    }
}
