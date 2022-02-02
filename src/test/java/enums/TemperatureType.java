package enums;

public enum TemperatureType {
    F("F"),
    C("C");

    private final String value;

    TemperatureType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
