package enums;

public enum RaceDistance {
    FIVE_KM("5"),
    TEN_KM("10"),
    Half_Marathon("21.0974537664"),
    Marathon("42.1949075328");

    private final String value;

    public String getValue() {
        return value;
    }

    RaceDistance(String value) {
        this.value = value;
    }
}
