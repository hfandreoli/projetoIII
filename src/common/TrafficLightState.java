package common;

public enum TrafficLightState {
    REGISTERED("Registered"),
    GREEN("Green"),
    YELLOW("Yellow"),
    RED("Red"),
    FINALIZED("Finalized");

    private String description;

    TrafficLightState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public TrafficLightState getNextState() {
        return switch (this) {
            case REGISTERED -> TrafficLightState.GREEN;
            case GREEN -> TrafficLightState.YELLOW;
            case YELLOW -> TrafficLightState.RED;
            case RED -> TrafficLightState.GREEN;
            default -> null;
        };
    }
}
