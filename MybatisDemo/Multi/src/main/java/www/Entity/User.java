package www.Entity;
import java.util.List;

public class User {

    private long id;
    /** 一个用户有多个订单*/
    private List<Order> orders;
    /** 用户名称*/
    private String username;
    /** 用户账号*/
    private String password;
    /** 用户唯一id*/
    private String uid;

    public User() {
    }

    public User(long id, List<Order> orders, String username, String password, String uid) {
        this.id = id;
        this.orders = orders;
        this.username = username;
        this.password = password;
        this.uid = uid;
    }

    public User(List<Order> orders, String username, String password, String uid) {
        this.orders = orders;
        this.username = username;
        this.password = password;
        this.uid = uid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "User{" +
                "orders=" + orders +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
