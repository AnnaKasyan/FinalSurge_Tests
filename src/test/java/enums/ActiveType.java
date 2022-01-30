package enums;

public enum ActiveType {

    RUN("Run"),
    BIKE("Bike"),
    SWIM("Swim"),
    CROSS_TRAINING("Cross Training"),
    WALK("Walk"),
    REST_DAY("Rest Day"),
    STRENGTH_TRAINING("Strength Training"),
    RECOVERY_REHAB("Recovery/Rehab"),
    OTHER("Other"),
    TRANSITION("Transition");

    private final String name;

    ActiveType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
