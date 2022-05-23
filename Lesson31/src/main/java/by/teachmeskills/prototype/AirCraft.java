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
public class AirCraft extends Transport {
    private String model;

    public AirCraft(AirCraft airCraft) {
        super(airCraft);
        if (Optional.ofNullable(airCraft).isPresent()) {
            this.model = airCraft.model;
        }
    }

    @Override
    public Transport clone() {
        return new AirCraft(this);
    }
}
