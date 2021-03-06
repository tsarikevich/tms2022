package com.tms.authorization;

/**
 * Создать статический метод "checkAuthorization" который будет вызваться из метода main и принимает на вход три параметра: login, password и confirmPassword. Поле login должен содержать:
 * - Tолько латинские буквы, цифры и знак подчеркивания.
 * - Длина login должна быть меньше 20 символов.
 * (Если не знаете как проверить первое условие, то проверяем только 2 условие - вызваем метод lenght())
 * Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
 * Password должен содержать:
 * - Только латинские буквы, цифры и знак подчеркивания.
 * -  Длина password должна быть меньше 20 символов.
 * (Если не знаете как проверить первое условие, то проверяем только 2 условие - вызваем метод lenght())
 * Также password и confirmPassword должны быть равны. Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
 * WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по умолчанию,
 * второй принимает сообщение исключения и передает его в конструктор класса Exception.
 * Обработка исключений проводится внутри метода "checkAuthorization".
 * Используем multi-catch block. Метод "checkAuthorization" возвращает true, если значения верны или false в другом случае.
 * В методе main вызваем метод checkAuthorization и печатаем на консоль результат выполнения метода.
 * <p>
 * PS: если не знаем как сделать проверку, то можно просто оставить пустую реализацию! Прорабатываем работу с исключениями
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(checkAuthorization("Max_1", "1234", "1234"));
    }

    static Boolean checkAuthorization(String login, String password, String confirmPassword) {
        Boolean loginCheck = checkInput(login);
        Boolean passwordCheck = checkInput(login);
        Boolean confirmPasswordCheck = confirmPassword.equals(password);
        try {
            if (!loginCheck) {
                throw new WrongLoginException("Введен недопустимый логин");
            }
            if (!passwordCheck) {
                throw new WrongPasswordException("Введен недопустимый пароль");
            }
            if (!confirmPasswordCheck) {
                throw new WrongPasswordException("Пароль не прошел проверку");
            }
            return true;
        } catch (WrongPasswordException |
                WrongLoginException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static Boolean checkInput(String input) {
        if (input.matches("(^[a-zA-Z0-9_]{1,20}+$)")) {
            return true;
        }
        return false;
    }

}

