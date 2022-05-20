import org.bson.types.ObjectId;

public class Customer {
    private ObjectId objectId;
    private int customerNum;
    private double time;
    private double waitTime;

    public Customer(ObjectId objectId, int customerNum, double time, double waitTime) {
        this.objectId = objectId;
        this.customerNum = customerNum;
        this.time = time;
        this.waitTime = waitTime;
    }
}
