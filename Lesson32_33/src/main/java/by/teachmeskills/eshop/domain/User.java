package by.teachmeskills.eshop.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class User {
    private static int idUser;
    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private LocalDate dateOfBirth;

    public User(String login, String password, String name, String surname, String email, LocalDate dateOfBirth) {
        this.id = ++this.idUser;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
