package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaceType {

    MIN_MI("mi", "min/mi"),
    MIN_KM("km", "min/km"),
    MPH("mp", "mph"),
    KPH("kp", "kph"),
    MIN_100M("me", "min/100m"),
    MIN_100Y("yd", "min/100y"),
    MIN_1500M("mm", "min/1500m");

    private final String value;
    private final String name;

    public static PaceType fromString(String type) {
        for (PaceType paceType : PaceType.values()) {
            if (paceType.getName().equals(type)) {
                return paceType;
            }
        }
        return null;
    }

}
