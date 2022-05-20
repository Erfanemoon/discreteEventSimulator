import org.bson.types.ObjectId;

import java.util.Queue;

public class Server {

    private ObjectId objectId;
    private Queue<Event> sQueue;
    private int sSlotNum;

    public Server(ObjectId objectId, Queue<Event> sQueue, int sSlotNum) {
        this.objectId = objectId;
        this.sQueue = sQueue;
        this.sSlotNum = sSlotNum;
    }

    public void add(Event job) {
        this.sQueue.add(job);
    }

    public boolean isFull() {

        if (this.sSlotNum == this.sQueue.size())
            return true;
        return false;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public Queue<Event> getsQueue() {
        return sQueue;
    }

    public int getsSlotNum() {
        return sSlotNum;
    }

    @Override
    public String toString() {
        return "Server{" +
                "objectId=" + objectId +
                ", sQueue=" + sQueue +
                ", sSlotNum=" + sSlotNum +
                '}';
    }
}
