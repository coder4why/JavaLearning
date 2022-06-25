package www.vip.com.DAO.模拟转账;

import www.vip.com.MySQL.MySQLTool;

import java.sql.SQLException;

/**
 * 模拟转账Service层：
 */
public class ServiceBankIMP {

    /**
     * 注册卡号（开户），存入Money
     */
    public static void registerUser(PersonAccount p) {

        /** 查询*/
        PersonAccount personAccount = DaoBankIMP.selectPerson(p.bank_id);
        if (personAccount == null) {
            int result = DaoBankIMP.insert(p);
            System.out.println("银行卡开户" + ((result == 1) ? "成功" : "失败"));
        } else {
            System.out.println("用户已存在");
        }
        DaoBankIMP.closeAll();

    }

    /**
     * 取Money
     */
    public static void getMoney(PersonAccount p) {

        PersonAccount personAccount = DaoBankIMP.selectPerson(p.bank_id);
        /** 判断账户是否可用 是否销毁*/
        if (personAccount != null) {
            /** 判断账户余额是否大于取额*/
            if (personAccount.bank_money > p.bank_money) {
                /** 可取*/
                personAccount.bank_money -= p.bank_money;
                int result = 0;
                try {
                    result = DaoBankIMP.update(personAccount);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                System.out.println("取钱" + ((result == 1) ? "成功" : "失败"));
            } else {
                /** 账户余额不够取*/
                System.out.println("取出金额过大，余额不足");
            }
        } else {
            System.out.println("账户已销毁");
        }
        DaoBankIMP.closeAll();

    }


    /**
     * 存Money
     */
    public static void saveMoney(PersonAccount p) {

        PersonAccount personAccount = DaoBankIMP.selectPerson(p.bank_id);
        /** 判断账户是否可用 是否销毁*/
        if (personAccount != null) {
            personAccount.bank_money += p.bank_money;
            int result = 0;
            try {
                result = DaoBankIMP.update(personAccount);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println("存钱" + ((result == 1) ? "成功" : "失败"));
        } else {
            System.out.println("账户已销毁");
        }
        DaoBankIMP.closeAll();
    }

    /**
     * 转账：账户a向账户b转账 money 人民币
     */
    public static void transferMoney(PersonAccount a, PersonAccount b, double money) {

        /** 添加事务处理，实现控制事务**/
        /** 设置当前事务的自动提交改为手动提交，开启事务 */
        MySQLTool.begin();

        PersonAccount aPerson = DaoBankIMP.selectPerson(a.bank_id);
        PersonAccount bPerson = DaoBankIMP.selectPerson(b.bank_id);
        if (aPerson != null && bPerson != null) {
            /** 两个账户都合法*/
            if (aPerson.bank_money > money) {
                /** 余额充足，可转账*/
                aPerson.bank_money -= money;
                bPerson.bank_money += money;
                int aResult = 0;
                int bResult = 0;
                try {
                    aResult = DaoBankIMP.update(aPerson);
                    /** 异常代码测试*/
//                    int k = 10/0;
                    bResult = DaoBankIMP.update(bPerson);
                    if (aResult == 1 && bResult == 1) {
                        System.out.println("转账成功");
                        /** 转账成功，提交整个事务 */
                        MySQLTool.commit();
                    } else {
                        System.out.println("转账失败");
                        /** 转账失败，回滚整个事务，不更新数据库 */
                        MySQLTool.rollback();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    System.out.println("转账失败，回滚整个事务，不更新两账户信息");
                    MySQLTool.rollback();

                } finally {
                    DaoBankIMP.closeAll();
                }
            } else {
                System.out.println("账户余额不足，无法转账");
            }
        } else {
            /** 账户有问题（不存在），无法转账*/
            System.out.println("账户异常，无法交易");
        }

        DaoBankIMP.closeAll();

    }

    /**
     * 账户销毁
     */
    public static void deleteUsers(PersonAccount p) {

        PersonAccount personAccount = DaoBankIMP.selectPerson(p.bank_id);
        if (personAccount != null) {
            int result = DaoBankIMP.delete(p.bank_id);
            System.out.println("账户销毁" + ((result == 1) ? "成功" : "失败"));
        } else {
            System.out.println("账户不存在");
        }
        DaoBankIMP.closeAll();

    }

}
