package enums;


public enum DistanceType {

    MI("mi", "mi"),
    KM("km", "km"),
    ME("me", "m"),
    YD("yd", "yd");


    private final String value;
    private final String name;

    DistanceType(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }


    public static DistanceType fromString(String type) {
        for (DistanceType distanceType : DistanceType.values()) {
            if (distanceType.getName().equals(type)) {
                return distanceType;
            }
        }
        return null;
    }
}
