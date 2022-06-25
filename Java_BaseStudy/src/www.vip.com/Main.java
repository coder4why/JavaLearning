package www.vip.com;

import www.vip.com.内存分析.MallocAnalyse;
import www.vip.com.垃圾回收机制.GarbageCollectionTest;
import www.vip.com.构造器.ConstructorTest;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TestFuncs.testMethod();
        TestFuncs funcs = new TestFuncs();
        funcs.name = "ShangHai";

        MallocAnalyse malloc = new MallocAnalyse();
        malloc.testStr = "内存分析大法";
        malloc.testMe();

    }
}

class TestFuncs{

    String name;

    protected static void testMethod(){

        System.out.println("Hello Java");

    }

}
