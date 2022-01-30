package enums;

public enum WeightType {
    LBS("l"),
    KG("k");

    private final String value;

    WeightType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
