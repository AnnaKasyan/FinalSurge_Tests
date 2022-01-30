package enums;

public enum GenderType {
    MALE("M"),
    FEMALE("F");

    private final String value;

    GenderType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
