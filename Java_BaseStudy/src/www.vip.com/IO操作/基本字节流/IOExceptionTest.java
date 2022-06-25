package www.vip.com.IO操作.基本字节流;

import java.io.FileOutputStream;
import java.io.IOException;

public class IOExceptionTest {

    public static void main(String[] args) {

        /**
         * 使用try-catch-finally，完成文件的输入输出操作：
         * */
        FileOutputStream output = null;
        try{
             output = new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/ioTest.txt");
             String myTest =
                     "  《可惜没有如果》 \n\t\t\t--- 林俊杰\n"+
                     "  假如把犯得起的错\n  能错的都错过\n  应该还来得及去悔过\n" +
                     "  假如没把一切说破\n  那一场小风波\n  将一笑带过\n" +
                     "  在感情面前\n  讲什么自我\n  要得过且过\n" +
                     "  才好过\n  全都怪我\n  不该沉默时沉默\n" +
                     "  该勇敢时软弱\n  如果不是我\n  误会自己洒脱\n" +
                     "  让我们难过\n  可当初的你\n  和现在的我\n" +
                     "  假如重来过\n  倘若那天\n  把该说的话好好说\n" +
                     "  该体谅的不执着\n  如果那天我\n  不受情绪挑拨";
             byte[] bytes = myTest.getBytes();
             output.write(bytes);
             /**
              * IO读写操作使用try-catch-finally的必要性：
              *     因为：如果output.write()方法抛出异常，close()方法将不会被调用；
              *     所以：这就是为什么要使用try.catch.finally语句，将colse()在finally中执行,结束资源的占用；
              * */
             output.close();

        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if (output != null) {
                try {
                    /** 关闭此文件输出流,并释放与此流相关联的任何系统资源 **/
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
