package www.vip.com.Lambda表达式;

/**
 * 使用Lambda的注意事项：
 *    1.使用Lambda表达式必须有接口，并且要求接口中有且仅有一个抽象方法；
 *    2.必须要有上下文环境，才能推导出Lambda对应的接口：
 *      a.根据局部变量的赋值得知Lambda对应的接口：
 *          Runnable  r = ()-> System.out.println("输出一句话"); （此处对应接口为Runnable）
 *      b.根据调用方法的参数得知Lambda对应的接口：
 *          new Thread(()-> System.out.println("输出一句话")).start();（此处对应接口为Runnable）
 *
 */
public class LambdaTipsTest {

    private static void showMsg(LambdaModel model){
        model.show();
        System.out.println("=========================");
    }
    public static void main(String[] args) {

        showMsg(()-> System.out.println("好好学习天天向上"));

        /**
         * 必须有上下文环境，才能推导出Lambda对应的接口；
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类输出一句话");
            }
        }).start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类输出一句话");
            }
        };

        new Thread(runnable).start();

        Runnable  r = ()-> System.out.println("输出一句话");
        new Thread(r).start();

        new Thread(()-> System.out.println("输出一句话")).start();

    }

}

interface LambdaModel {
    void show();

//    void doWhat();

}
