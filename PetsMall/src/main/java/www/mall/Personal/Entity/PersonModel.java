package www.mall.Personal.Entity;

public class PersonModel {

    private String account;
    private String password;
    private String userId;
    private String nickName;
    private String atavar;

    public PersonModel(String account, String password, String userId, String nickName, String atavar) {
        this.account = account;
        this.password = password;
        this.userId = userId;
        this.nickName = nickName;
        this.atavar = atavar;
    }

    public PersonModel() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAtavar() {
        return atavar;
    }

    public void setAtavar(String atavar) {
        this.atavar = atavar;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", userId='" + userId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", atavar='" + atavar + '\'' +
                '}';
    }
}
