package www.qf.controller;

import www.qf.cate.Student;
import www.qf.cate.Teacher;
import www.qf.factory.GlobalFactory;

public class Test {

    public static void main(String[] args) {

        /** 创建工厂对象 */
        GlobalFactory factory = new GlobalFactory("./config.properties");
        /** 使用工厂创造对象 */
        Student student = (Student) factory.getBean("student");
        Teacher teacher = (Teacher) factory.getBean("teacher");

        student.doWhat();
        teacher.doWhat();

    }


}
