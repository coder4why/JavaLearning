package www.vip.com.方法引用;

/**
 * 引用构造器：
 *    其实就是引用构造方法；
 * 格式：
 *    类名::new
 * 范例：
 *    Student::new
 */
public class UseConstructorsTest {

    private static void useStudentBuilder(StudentBuilder s){
        StudentModel model = s.build("LOVE",20);
        System.out.println(model.name+":"+model.age);
    }
    public static void main(String[] args) {

        /**  使用匿名内部类实现：*/
        useStudentBuilder(new StudentBuilder() {
            @Override
            public StudentModel build(String name, int age) {
                StudentModel student = new StudentModel(name,age);
                return student;
            }
        });

        /** 使用Lambda表达式实现：*/
        useStudentBuilder(((name, age) -> new StudentModel(name,age)));

        /** 使用引用构造器实现*/
        useStudentBuilder(StudentModel::new);

        /**
         * Lambda表达式被构造器替代的时候，它的形式参数全部传递给构造器作为参数；
         */
    }

}

class StudentModel{
    String name;
    int age;
//    StudentModel(){}
    StudentModel(String name,int age){
        this.name = name;
        this.age = age;
    }
}
interface StudentBuilder{
    StudentModel build(String name,int age);
}