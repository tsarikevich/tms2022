package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.User;
import by.teachmeskills.eshop.domain.UserStorage;
import by.teachmeskills.eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

import static by.teachmeskills.eshop.PagesPathEnum.REGISTRATION_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.CHECK_NEW_USER;
import static by.teachmeskills.eshop.RequestParamsEnum.NEW_USER_DAY;
import static by.teachmeskills.eshop.RequestParamsEnum.NEW_USER_EMAIL;
import static by.teachmeskills.eshop.RequestParamsEnum.NEW_USER_MONTH;
import static by.teachmeskills.eshop.RequestParamsEnum.NEW_USER_NAME;
import static by.teachmeskills.eshop.RequestParamsEnum.NEW_USER_PASSWORD;
import static by.teachmeskills.eshop.RequestParamsEnum.NEW_USER_SURNAME;
import static by.teachmeskills.eshop.RequestParamsEnum.NEW_USER_YEAR;
import static by.teachmeskills.eshop.RequestParamsEnum.USER_LOGIN;

public class AddNewUserToBaseCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter(NEW_USER_NAME.getValue());
        String password = request.getParameter(NEW_USER_PASSWORD.getValue());
        int month = Integer.parseInt(request.getParameter(NEW_USER_MONTH.getValue()));
        int year = Integer.parseInt(request.getParameter(NEW_USER_YEAR.getValue()));
        int day = Integer.parseInt(request.getParameter(NEW_USER_DAY.getValue()));
        LocalDate localDate = LocalDate.of(year, month, day);
        String name = request.getParameter(NEW_USER_NAME.getValue());
        String surname = request.getParameter(NEW_USER_SURNAME.getValue());
        String email = request.getParameter(NEW_USER_EMAIL.getValue());
        User user = new User(login, password, name, surname, email, localDate);
        if (UserStorage.isUserInBase(user)) {
            request.setAttribute(CHECK_NEW_USER.getValue(), false);
            request.setAttribute(USER_LOGIN.getValue(), user);
            return REGISTRATION_PAGE.getPath();
        } else {
            UserStorage.addNewUser(user);
            return SIGN_IN_PAGE.getPath();
        }
    }
}
