package enums;

public enum HeightType {
    INCHES("i"),
    CENTIMETERS("m");

    private final String value;

    HeightType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
