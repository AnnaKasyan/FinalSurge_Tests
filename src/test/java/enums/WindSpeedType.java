package enums;

public enum WindSpeedType {
    MPH("mph"),
    KPH("kph");

    private final String value;

    WindSpeedType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
