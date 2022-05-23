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
public class Car extends Transport {
    private String model;

    public Car(Car car) {
        super(car);
        if (Optional.ofNullable(car).isPresent()) {
            this.model = car.model;
        }
    }

    @Override
    public Transport clone() {
        return new Car(this);
    }
}
