package by.teachmeskills.prototype;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Optional;

@Getter
@EqualsAndHashCode
@SuperBuilder
@ToString
public abstract class Transport {
    private int numberWheels;
    private String color;
    private int price;

    public Transport(Transport transport) {
        if (Optional.ofNullable(transport).isPresent()) {
            this.numberWheels = transport.numberWheels;
            this.color = transport.color;
            this.price = transport.price;
        }
    }

    public abstract Transport clone();
}
