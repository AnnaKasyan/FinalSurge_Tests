package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PerceivedEffort {

    VERY_LIGHT1("1","1 (Very Light)"),
    LIGHT2("2","2 (Light)"),
    LIGHT3("3","3 (Light)"),
    MODERATE4("4","4 (Moderate)"),
    MODERATE5("5","5 (Moderate)"),
    MODERATE6("6","6 (Moderate)"),
    HARD7("7","7 (Hard)"),
    HARD8("8","8 (Hard)"),
    VERY_HARD9("9","9 (Very Hard)"),
    MAX_EFFORT10("10","10 (Max Effort)");


    private final String value;
    private final String name;

    public static PerceivedEffort fromString(String effort) {
        for (PerceivedEffort efforts : PerceivedEffort.values()) {
            if (efforts.getName().equals(effort)) {
                return efforts;
            }
        }
        return null;
    }

}
