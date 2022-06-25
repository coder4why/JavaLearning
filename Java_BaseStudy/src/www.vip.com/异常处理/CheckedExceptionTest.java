package www.vip.com.异常处理;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedExceptionTest {
    public static void main(String[] args) throws FileNotFoundException {

        /**
         * CheckedException 异常 ：编译检测异常
         *      此处把异常（ throws FileNotFoundException）抛给了main函数
         */
        FileReader reader = new FileReader("qeqe");

    }
}
