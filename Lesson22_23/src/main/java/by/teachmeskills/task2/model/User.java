package by.teachmeskills.task2.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class User {
    private String email;
    private String password;

    {
        email = "user@mail.by";
        password = "12345";
    }
}
