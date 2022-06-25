package www.vip.com.IO操作.特殊操作符.对象序列化;

import www.vip.com.IO操作.特殊操作符.PrintStreamTest;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 对象序列化流（ObjectOutputStream）：就是将对象保存到磁盘中，或者在网络中传输；
 *      这种机制就是使用一个字节序列表示一个对象，该字节序列包含：对象的类型、对象的数据和对象中存储的属性等信息；
 *      字节序列写到文件后，相当于文件中持久保存了一个对象的信息；
 *      反之，该字节序列还可以从文件中读取出来，重构对象，对他进行反序列化；
 * 对象反序列化流（ObjectInputStream）：就是将保存到磁盘中的数据解析输出成为对象；
 *
 */
/**
 *     只有支持java.io.Serializable接口的对象才能写入流中，每个可序列化对象的类编码，
 *  包括类的类名和签名，对象的字段和数组的值以及从初始对象引用的任何其他对象的关闭
 *
 */
public class ObjectInputStreamTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException{

        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(PrintStreamTest.ROOT_PATH+"对象序列化流.txt")
        );

        /**
         * 循环遍历读取 对象输入流（ObjectInputStream） 文件对象；
         */
        while(true){
            try{
                Student student = (Student)objectInputStream.readObject();
                /** score属性没有被序列化写入文件，所以读出出来的是默认值0 */
                System.out.println(student.name+":"+student.score);
            }catch(EOFException e){
                break;
            }catch(NullPointerException ee){
                continue;
            }
        }

        objectInputStream.close();

    }

}
