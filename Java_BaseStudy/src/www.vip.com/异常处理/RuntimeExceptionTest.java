package www.vip.com.异常处理;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * RuntimeException ： 运行时异常（编译正常，运行后异常抛出）
 */
public class RuntimeExceptionTest {

    public static void main(String[] args) throws IOException {

        FileReader redader = null;
        try {
            /**
             * ArrayIndexOutOfBoundsException 数组越界异常
             */
            //String[] a = {};
            //System.out.println(a[1]);

            /**
             * ArithmeticException 异常
             */
            //System.out.println(1 / 0);

            /**
             * NullPointerException 空指针异常
             */
            //String test = null;
            //test.length();

            /**
             * FileNotFoundException 文件未找到异常
             */
            redader = new FileReader("/User/hupingkang/Desktop/AA");
            redader.read();

            /**
             * ClassCastException 强制类型转换异常（父类强制转换为子类）
             */
            //Max max = new Max();
            //MaxSon maxSon = (MaxSon) max;

            //System.out.println(max);
            /**
             * try catch finally：
             *      catch可以有多个，执行哪个catch，看catch里面的异常类型与抛出的异常类型是否一致
             */
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("捕获了异常--数组越界");
            e.printStackTrace();
        }catch (ArithmeticException e) {
            System.out.println("捕获了异常：0为除数");
            e.printStackTrace();
        }catch(NullPointerException e){
            System.out.println("捕获了空指针异常");
            e.printStackTrace();
        }catch(ClassCastException e){
            System.out.println("捕获了类型转换异常");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("捕获了文件未找到异常");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("捕获了文件读取异常");
            e.printStackTrace();
        } finally {
            System.out.println("编译抛出异常");
            if (redader != null){
                redader.close();
            }
        }

        /**
         * try catch finally 后，后续代码正常执行：
         */
        System.out.println("抛出异常后还执行么");

    }

}

class Max {}
class MaxSon extends Max{}