import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class SimulationLog {

    public static void logCurrentTimeState(String state) {

        System.out.println(state + " " + new Timestamp(System.currentTimeMillis()));
    }

    public static void logServers(List<Server> servers) {
        System.out.println("SERVERS : ");
        System.out.println(servers.toString());
    }

    public static void logInitializeQueue(Queue<Event> pq) {
        System.out.println("INITIAL QUEUE ");
        Iterator<Event> iterator = pq.iterator();
        while (iterator.hasNext()) {
            Event next = iterator.next();
            System.out.println(next);
        }
    }

    public static void logEvent(Event event) {
        System.out.println("EVENT : " + event);
        System.out.println(new Timestamp(System.currentTimeMillis()));
    }

    public static void finishedStateList(List<Event> leavingEvents) {
        System.out.println("EVENTS ARE LEAVING .... " + leavingEvents.toString());
    }
}
