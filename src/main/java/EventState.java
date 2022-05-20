public enum EventState {

    ARRIVED("arrived"),
    SERVED("served"),
    LEAVES("leaves"),
    DONE("done"),
    WAITS("waits");

    private String value;

    EventState(String value) {
        this.value = value;
    }

    public static EventState get(String value) {

        if (value == null) return null;
        EventState[] arr$ = values();
        for (EventState val : arr$) {
            if (val.value.equals(value.trim())) {
                return val;
            }
        }

        return null;
    }

    public String getValue() {
        return value;
    }
}
