package www.vip.com.接口;

public class InterfaceTest {

    public static void main(String[] args) {
        //
        ImpGetStudents std = new ImpGetStudents();
        std.allStudents();

        ImpSchool school = new ImpSchool();
        school.allStudents();
        school.allTeachers();

        WhichSchool wSchool = new WhichSchool();
        wSchool.allStudents();;
        wSchool.allTeachers();;
        wSchool.whichSchool();

        //接口本身的初始化
        GetStudents allStds = new GetStudents() {
            @Override
            public void allStudents() {
                System.out.println("查找在校所有学生");
            }
        };
        allStds.allStudents();
    }

}

//接口里面所有的方法都是抽象方法，不提供实现，由子类实现；
interface GetStudents{

    //接口定义的属性都是常量，不可修改，默认修饰符为public static final，不写也是；
    //接口常量不可修改，为只读属性；
    String allStudents[] = {"小芳","小胡"};
    //接口定义的方法默认修饰为：public abstract，子类必须实现；
    void allStudents();

}

interface GetTeachers{
    //接口定义的方法默认修饰为：public abstract，子类必须实现；
    void allTeachers();
}

//接口本身实现多继承：
interface School extends GetTeachers,GetStudents{
    void whichSchool();
}
//
class ImpGetStudents implements GetStudents{
    @Override
    public void allStudents() {
        //allStudents[0] = "你好"; //编译不报错，运行报错；接口常量不可修改，为只读属性；
        System.out.println("查找所有在校学生");
        for (String m:allStudents
             ) {
            System.out.println(m);
        }
    }
}

//接口可以实现多继承、类不能实现多继承（类可以继承多个接口、不能继承多个父类）
class ImpSchool implements GetStudents,GetTeachers{
    @Override
    public void allStudents() {
        System.out.println("查询在校学生");
    }

    @Override
    public void allTeachers() {
        System.out.println("查询在校老师");
    }
}

class WhichSchool implements School{
    @Override
    public void allTeachers() {
        System.out.println("查找在校教师");
    }

    @Override
    public void allStudents() {
        System.out.println("查找在校生");
    }

    @Override
    public void whichSchool() {
        System.out.println("查找哪个学校");
    }
}