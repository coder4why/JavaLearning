package www.vip.com.方法引用;

/**
 * 引用对象的实例方法：
 *     其实就是引用类中的成员方法；
 *     格式：对象::成员方法
 *     范例："HelloWorld"::toUpperCase;
 */
public class UseObjectFuncTest {

    private static void usePrinter(Printer p){
        p.upperCase("fyf love hpk");
    }

    public static void main(String[] args) {

        /** 使用Lambda表达式实现：*/
        usePrinter((s)->{
            System.out.println(s.toUpperCase());
        });
        /** 省略版：Lambda表达式*/
        usePrinter(s-> System.out.println(s.toUpperCase()));

        /** 引用类的对象的实例方法*/
        PrintString printString = new PrintString();
        usePrinter(printString::printUpper);

        /** Lambda表达式被对象的实例方法替代的时候，它的形式参数全部传递给该方法作为参数*/


    }

}

class PrintString{
    void printUpper(String s){
        System.out.println(s.toUpperCase());
    }
}

interface Printer {

    void upperCase(String s);

}

