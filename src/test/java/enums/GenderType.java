package enums;

public enum GenderType {
    MALE("m"),
    FEMALE("f");

    private final String value;

    GenderType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
