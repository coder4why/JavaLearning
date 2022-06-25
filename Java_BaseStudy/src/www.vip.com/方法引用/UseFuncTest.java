package www.vip.com.方法引用;

/**
 * 方法引用：
 *     "::":两个冒号符，为引用运算符，而它所在的表达式被称为方法引用；
 */
public class UseFuncTest {

    static void shwoMsg(FuncModel model){
        model.logMsg("输出了个什么 ！");
    }

    public static void main(String[] args) {

        //Lambda表达式：
        shwoMsg((s)->{
            System.out.println(s);
        });

        //方法引用：
        shwoMsg(System.out::println);

    }

}

interface FuncModel {

     void logMsg(String msg);

}
