import org.bson.types.ObjectId;

import java.sql.Timestamp;
import java.util.*;

public class SimulationManager {

    private Queue<Event> pq;
    private int serverNum;
    private int eventNum;
    private List<Server> servers;
    private List<Event> leavingEvents;


    public SimulationManager(int serverNum, int eventNum) {
        this.serverNum = serverNum;
        this.eventNum = eventNum;
        initializeQueue();
        initializeServers();
        distributeEvents();
        beginSimulation();
        finishSimulation();
    }

    private void beginSimulation() {

        SimulationLog.logCurrentTimeState(SimulationState.BEGIN.getValue());

        for (Server server : this.servers) {
            Queue<Event> sQueue = server.getsQueue();
            for (Event event : sQueue) {
                SimulationLog.logEvent(event);
                Schedule sd = new Schedule(event);
                sd.eventSchedule(server, serverNum);

            }
        }
    }

    private void finishSimulation() {

        this.leavingEvents = new ArrayList<>();

        for (Server server : servers) {
            Queue<Event> events = server.getsQueue();
            while (!events.isEmpty()) {

                Event poll = events.poll();
                SimulationLog.logEvent(poll);
                poll.setState(EventState.LEAVES);
                this.leavingEvents.add(poll);
            }
        }
        SimulationLog.logCurrentTimeState(SimulationState.DONE.getValue());
        SimulationLog.finishedStateList(leavingEvents);
    }

    private void initializeQueue() {

        this.pq = new LinkedList<Event>();
        int count = 0;
        while (eventNum >= count) {
            Event event = new Event(EventState.ARRIVED, ObjectId.get(), new Timestamp(System.currentTimeMillis()));
            this.pq.add(event);
            count++;
        }

        SimulationLog.logInitializeQueue(this.pq);
    }

    private void initializeServers() {

        this.servers = new ArrayList<>();
        for (int i = 0; i < serverNum; i++) {

            Server server = new Server(new ObjectId(), new LinkedList<Event>(), Math.round(this.eventNum / serverNum));
            servers.add(server);
        }
    }


    public void distributeEvents() {

        for (Server server : servers) {
            if (!server.isFull()) {

                int slotNum = server.getsSlotNum();
                for (int i = 0; i < slotNum; i++) {

                    if (!this.pq.isEmpty()) {
                        Event pqEvent = this.pq.poll();
                        pqEvent.setState(EventState.WAITS);
                        pqEvent.setServerId(server.getObjectId());
                        server.add(pqEvent);
                    }
                }
            }
        }

        SimulationLog.logServers(servers);
    }
}
