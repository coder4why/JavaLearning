package www.vip.com.异常处理;

/**
 * 异常处理：
 *     Java采用的是面向对象的方式来处理异常；
 *     处理过程：
 *        1.抛出异常：在执行一个方法时，如果发生异常，则这个方法生成代表该异常的一个对象；
 *          停止当前执行路径，并把异常对象提交给JRE；
 *        2.捕获异常：JRE得到该异常后，寻找相应的代码来处理该异常；JRE在方法的调用栈中查找，
 *          从生成异常的方法开始回溯，直到找到相应的异常处理代码为止；
 */
public class ExceptionTest {
    public static void main(String[] args) {
       try{
           //数组越界异常：
           String[] arr =  {};
           String test = arr[2]; //抛出异常
           /**
            * 异常一旦产生，程序结束不再向下执行，异常抛出；
            */
           System.out.println("异常已抛出");
           System.out.println(test);

           // 0做除数异常
           // int a = 1/0;
           // System.out.println(a);
           /**
            * Exception:所有异常的父类
            */
       }catch (Exception e){
           System.out.println("数组越界");
           e.printStackTrace();
       }
    }

}
