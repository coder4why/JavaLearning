//包名package：域名倒着写即可，再加上模块名，便于内部管理类；
package www.vip.com.包机制;

//表示导入了MallocAnalyse类：
import www.vip.com.内存分析.MallocAnalyse;

//导入包里面的所有的类(MallocAnalyse.java 和 Analyse.java)
//import www.vip.com.内存分析.*; //*号导入所有，容易降低编译速度，不降低运行速度；

//导入的package包里面包含多个同名类的解决方法：
import java.util.Date;
import java.sql.*; //也包含Date；

//静态导入：导入某一类下的所有静态方法和属性
import static java.lang.Math.*;

public class PackageTest {

    //包机制是Java中管理类的重要手段；
    //包对于类，相当于文件夹对于文件的作用；

    public static void main(String[] args) {
        //使用当前包package没有的类，需要导入对应类的package
        MallocAnalyse malloc = new MallocAnalyse();
        //不导入package的写法：
//        www.vip.com.内存分析.MallocAnalyse mallocs  = new www.vip.com.内存分析.MallocAnalyse();

//        Analyse anlyse = new Analyse();

        //默认指向的java.util里面的Date;
        Date date = new Date();
        //导入的package包里面包含多个同名类的解决方法：直接使用指向包的类
        java.sql.Date date1 = new java.sql.Date(10);
        System.out.println(cos(PI));

    }


}
