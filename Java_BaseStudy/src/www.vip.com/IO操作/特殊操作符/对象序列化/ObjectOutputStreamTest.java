package www.vip.com.IO操作.特殊操作符.对象序列化;

import www.vip.com.IO操作.特殊操作符.PrintStreamTest;

import java.io.*;
import java.util.TreeSet;

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

public class ObjectOutputStreamTest {

    //使用之前的方法：
    private static void unSerizalition01() throws IOException{

        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(PrintStreamTest.ROOT_PATH+"treeSet.txt")
        );

        String line;
        TreeSet<Student> treeSets = new TreeSet<Student>();
        while((line = bufferedReader.readLine())!=null){

            System.out.println(line);
            String[] infos = line.split("   ");
            String name = infos[0];
            float chinese = Float.parseFloat(infos[1]);
            float math = Float.parseFloat(infos[2]);
            float english = Float.parseFloat(infos[3]);
            float score = Float.parseFloat(infos[4]);

            Student student = new Student(name,chinese,math,english,score);
            treeSets.add(student);
        }

        bufferedReader.close();

        for (Student std :
                treeSets) {
            System.out.println(std.toString());
        }

    }

    /**
     * 使用ObjectOutputStream（对象序列化流）对象；
     *     将Java对象的原始数据类型和图形写入OutputStream，
     *  可以使用ObjectInputStream读取（重构）对象，可以通过使用流的文件来实现对象的持久存储；
     */
    private static void outputStream() throws IOException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(PrintStreamTest.ROOT_PATH+"对象序列化流.txt")
        );

        Student student = new Student("郑伊健",100,100,100,300);
        Student student1 = new Student("陈小春",90,110,150,350);
        Student student2 = new Student("张宇",99,111,120,330);

        objectOutputStream.writeObject(student);
        objectOutputStream.writeObject(student1);
        objectOutputStream.writeObject(student2);

        objectOutputStream.close();


    }

    public static void main(String[] args) throws IOException {

        unSerizalition01();
        outputStream();


    }
}

/**
 * 使用 对象输出流 输出对象需要实现Serializable接口；
 */
class Student implements Comparable<Student>,Serializable {

    String name;
    float chinese;
    float math;
    float english;
    /** transient修饰的属性，是不能被序列化的； **/
    transient float score;

    //序列化对象必须要设置 serialVersionUID，作为唯一表示；
    private static final long  serialVersionUID = 42L;

    Student(){}
    Student(String name,float chinese,float math,float english,float score){
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.score = score;
    }

     @Override
     public String toString() {
         return  "name='" + name + '\'' +
                 ", chinese=" + chinese +
                 ", math=" + math +
                 ", english=" + english +
                 ", score=" + score;
     }

     @Override
     public int compareTo(Student o) {
         if (this.score > o.score) {
             return -1;
         } else {
             return 1;
         }
     }
 }
