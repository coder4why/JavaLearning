package www.vip.com.IO操作.特殊操作符;

import java.io.*;

public class ObjectStreamTest {

    /**
     * 对象输入流(ObjectOutputStream)：创建文件对象，写入文件
     */
    protected static void outputStream() throws IOException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(PrintStreamTest.ROOT_PATH+"练习ObjectStream.txt")
        );
        MyStream myStream = new MyStream("上海",10086);
        MyStream myStream1 = new MyStream("北京",10010);
        MyStream myStream2 = new MyStream("深圳",10001);

        /**
         * writeChars() ： 在文件中插入字符数组（字符串）
         */
        objectOutputStream.writeChars("\r\n");
        /**
         * writeObject()：在文件中插入Object对象
         */
        objectOutputStream.writeObject(myStream);
        objectOutputStream.writeChars("\r\n");
        objectOutputStream.writeObject(myStream1);
        objectOutputStream.writeChars("\r\n");
        objectOutputStream.writeChars("测试一下"); //添加测试代码；
        objectOutputStream.writeChars("\r\n");
        objectOutputStream.writeObject(myStream2);
        objectOutputStream.close();

    }

    /**
     * 对象输出流(ObjectInputStream) ：读取文件，并输出；
     */
    protected static void inputStream() throws IOException{

        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(PrintStreamTest.ROOT_PATH+"练习ObjectStream.txt")
        );
        while (true){
            try{
                Object object = objectInputStream.readObject();
                MyStream stream = (MyStream)object;
                System.out.println(stream.name+":"+stream.id);
            }catch (ClassNotFoundException o){
                System.out.println("未找到匹配对象");
                /** 当前获取的对象非指定对象 **/
                continue;
            }catch (EOFException  e){
                /** 数据读取完毕 **/
                break;
            }
        }

    }


    public static void main(String[] args)  throws IOException{

        outputStream();
        inputStream();

    }

}

/**
 * 要被序列化的类 需要实现 Serializable接口（该接口没有具体实现方法）；
 */
class MyStream implements Serializable{

    /** 所有要被序列化（Serializable）到文件中的类都要声明的唯一ID ： */
    private static final long serialVersionUID = 22L;
    String name;
    /** transient修饰的属性，不能被序列化到文件 **/
    transient int id;

    MyStream(String name,int id){
        this.name = name;
        this.id =  id;
    }

    @Override
    public String toString() {
        return "MyStream{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}