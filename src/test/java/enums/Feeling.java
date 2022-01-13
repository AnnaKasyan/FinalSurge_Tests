package enums;

public enum Feeling {

    GREAT("Great"),
    GOOD("Good"),
    NORMAL("Normal"),
    POOR("Poor"),
    TERRIBLE("Terrible");

    private final String name;

    Feeling(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Feeling fromString(String feeling) {
        for (Feeling feelings : Feeling.values()) {
            if (feelings.getName().equals(feeling)) {
                return feelings;
            }
        }
        return null;
    }
}
