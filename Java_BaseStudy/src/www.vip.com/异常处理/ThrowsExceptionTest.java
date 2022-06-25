package www.vip.com.异常处理;

import java.io.FileReader;
import java.io.IOException;

/**
 * throws 异常向上抛出 最终抛给JRE
 */
public class ThrowsExceptionTest {
    /**
     * 使用throws 抛出异常
     */
    public static void main(String[] args) throws IOException {

        /**
         * 代码将异常抛给 main 方法，main方法抛给JRE，JRE来最终处理；
         */

        /**
         * throws 异常 FileNotFoundException 给 main方法
         */
        FileReader reader = new FileReader("qq");

        /**
         * throws 异常 IOException 给 main方法
         */
        reader.read();
        reader.close();

    }
}
