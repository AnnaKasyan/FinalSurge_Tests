package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum DistanceType {

    MI("mi", "mi"),
    KM("km", "km"),
    ME("me", "m"),
    YD("yd", "yd");


    private final String value;
    private final String name;


    public static DistanceType fromString(String type) {
        for (DistanceType distanceType : DistanceType.values()) {
            if (distanceType.getName().equals(type)) {
                return distanceType;
            }
        }
        return null;
    }
}
