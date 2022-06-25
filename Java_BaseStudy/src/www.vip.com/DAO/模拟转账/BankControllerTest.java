package www.vip.com.DAO.模拟转账;

/**
 * 模拟转账Controller层：业务实现层
 */
public class BankControllerTest {

    public static void main(String[] args) {

        PersonAccount hpk = new PersonAccount("胡平康","6217 0033 8000 3929 517",885000.0);
        PersonAccount fyf = new PersonAccount("樊玉芳","6217 8000 9237 3929 808",126000.0);
        PersonAccount hpa = new PersonAccount("胡平安","6217 3929 9237 3929 309",1220000.0);

        /** 开户 */
        ServiceBankIMP.registerUser(hpk);
        ServiceBankIMP.registerUser(fyf);
        ServiceBankIMP.registerUser(hpa);

        /** 存钱*/
        hpk.bank_money = 23580000.0;
        ServiceBankIMP.saveMoney(hpk);

        /** 取钱*/
        fyf.bank_money = 12000.0;
        ServiceBankIMP.getMoney(fyf);

        /** 转账*/
        ServiceBankIMP.transferMoney(hpk,fyf,1314.0);

        /** 销户*/
        ServiceBankIMP.deleteUsers(fyf);


    }

}
