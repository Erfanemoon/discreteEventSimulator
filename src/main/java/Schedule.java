import java.util.Timer;

public class Schedule {

    Timer timer;
    private Event event;

    public Schedule(Event event) {
        this.event = event;
        timer = new Timer();
    }

    public void eventSchedule(Server server, int serverNum) {

        double v = event.countTermination(server, serverNum);
        event.setTerminationTime(v);
        event.setState(EventState.SERVED);

        timer.scheduleAtFixedRate(event, event.countTermination(server, serverNum), 1000);
        //timer.cancel();
    }

    public void checkStates() {

    }

}
