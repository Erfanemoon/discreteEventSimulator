import org.bson.types.ObjectId;

import java.sql.Timestamp;
import java.util.TimerTask;

public class Event extends TimerTask {

    private EventState eventState;
    private ObjectId serverId;
    private ObjectId eventId;
    private double terminationTime;
    private Timestamp insertTime;
    private int treshold = 0;

    public Event(EventState eventState, ObjectId eventId, Timestamp insertTime) {
        this.eventState = eventState;
        this.eventId = eventId;
        this.insertTime = insertTime;
    }

    public EventState getState() {
        return eventState;
    }

    public void setState(EventState eventState) {
        this.eventState = eventState;
    }

    public ObjectId getServerId() {
        return serverId;
    }

    public void setServerId(ObjectId serverId) {
        this.serverId = serverId;
    }

    public ObjectId getEventId() {
        return eventId;
    }

    public void setEventId(ObjectId eventId) {
        this.eventId = eventId;
    }


    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }

    public double getTerminationTime() {
        return terminationTime;
    }

    public void setTerminationTime(double terminationTime) {
        this.terminationTime = terminationTime;
    }

    @Override
    public void run() {
        treshold++;

        if (treshold > this.terminationTime) {

            this.eventState = EventState.DONE;
            System.out.println(this.toString());
        }

    }

    public long countTermination(Server server, int serverNum) {
        int i = server.getsSlotNum();
        double slotNum = new Double(i);
        double num = new Double(serverNum);
        double ceil = slotNum / serverNum;
        double val = Math.ceil(ceil);
        return Double.valueOf(val).longValue();
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventState=" + eventState +
                ", server=" + serverId +
                ", eventId=" + eventId +
                ", terminationTime=" + terminationTime +
                ", insertTime=" + insertTime +
                ", treshold=" + treshold +
                '}';
    }
}
