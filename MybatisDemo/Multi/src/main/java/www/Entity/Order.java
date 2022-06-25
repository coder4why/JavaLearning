package www.Entity;
public class Order {
    private long id;
    private String uid;
    private String order_id;

    public Order(long id, String uid, String order_id) {
        this.id = id;
        this.uid = uid;
        this.order_id = order_id;
    }

    public Order(String uid, String order_id) {
        this.uid = uid;
        this.order_id = order_id;
    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "uid='" + uid + '\'' +
                ", order_id='" + order_id + '\'' +
                '}';
    }
}
