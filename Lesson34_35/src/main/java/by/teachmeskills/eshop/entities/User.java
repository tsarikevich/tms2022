package by.teachmeskills.eshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class User extends BaseEntity {
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;
    private BigDecimal balance;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
