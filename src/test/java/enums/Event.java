package enums;

public enum Event {
    MILE("Mile", "MILE"),
    FIVEK("5Km", "FIVEK"),
    TENK("10Km", "TENK"),
    HALFMAR("Half Marathon", "HALFMAR"),
    MARATHON("Marathon", "MARATHON");

    private final String name;
    private final String value;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    Event(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
