import org.bson.types.ObjectId;

public enum SimulationState {

    BEGIN("begin simulation"),
    DONE("end simulation");

    private String value;

    SimulationState(String value) {
        this.value = value;
    }

    public static SimulationState get(String value) {

        if (value == null) return null;
        SimulationState[] arr$ = values();
        for (SimulationState val : arr$) {
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
