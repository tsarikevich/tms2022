import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class Person {
    public static final String MALE = "male";
    public static final String FEMALE = "female";
    private String name;
    private Integer age;
    private String sex = FEMALE;
    private List<String> stringList;

    public Person(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }


    public List<String> getStringList() {
        if (stringList == null) {
            return new ArrayList<>();
        }
        return stringList;
    }

}
