package www.vip.com.DAO.模拟转账;

/** 模拟转账实体类Entity：数据模型Model*/
public class PersonAccount {

    String name;
    String bank_id;
    double bank_money;

    public PersonAccount(String name, String bank_id, double bank_money) {
        this.name = name;
        this.bank_id = bank_id;
        this.bank_money = bank_money;
    }

    @Override
    public String toString() {
        return "PersonAccount{" +
                "name='" + name + '\'' +
                ", bank_id='" + bank_id + '\'' +
                ", bank_money=" + bank_money +
                '}';
    }

}
