package www.vip.com.异常处理;

/**
 * 自定义异常：
 *      1.自定义异常如果继承Exception类，则为检查异常（CheckedException）,必须对其进行处理；
 *      2.自定义异常如果继承为RuntimeException，则为运行时异常，编译成功，运行异常；
 */
public class ExceptionCustomTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(-10);
    }
}

class Person{
    int age;

     void setAge(int age) {
        System.out.println(age);
        if (age < 0 || age> 130){
            try{
                throw new ExeOne("年龄不合乎规范");
            }catch(Exception e){
                e.printStackTrace();
            }finally {
            }
        }
        this.age = age;
    }
}

class ExeOne extends Exception{
    ExeOne(){}
    ExeOne(String a){
        super(a);
    }

}