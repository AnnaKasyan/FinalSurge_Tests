package enums;

public enum DistTypeForCalculator {
    MILES("m"),
    KILOMETERS("k");

    private final String value;

    DistTypeForCalculator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
