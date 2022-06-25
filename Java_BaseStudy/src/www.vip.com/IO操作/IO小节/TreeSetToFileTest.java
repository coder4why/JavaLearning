package www.vip.com.IO操作.IO小节;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 复习：
 *      HashSet: 无序不可重复
 *      TreeSet：有序不可重复，自增排列
 *  需求：
 *      键盘输入5个学生信息，将学生信息（姓名，语文，数学，英语成绩）数组写入到本地文件，以总分由高到低排序；
 */

public class TreeSetToFileTest {

    static class Student implements Comparable<Student>{

        String name;
        float chinese;
        float math;
        float english;
        float score;

        @Override
        public String toString() {
            return   name +
                    "   " + chinese +
                    "   " + math +
                    "   " + english +
                    "   " + score ;
        }

        Student(String name,float chinese,float math,float english){
            this.name = name;
            this.chinese = chinese;
            this.english = english;
            this.math = math;
            this.score = chinese+english+math;
        }

        @Override
        public int compareTo(Student o) {
            if (this.score>o.score){
                return -1;
            }else {
                return 1;
            }
        }
    }

    static void treeSetToFile() throws IOException {

        TreeSet<Student> treeSet = new TreeSet<Student>();
        for (int i = 0; i < 5; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请录入第"+(i+1)+"个学生信息");
            System.out.println("姓名：");
            String name = scanner.nextLine();
            System.out.println("语文成绩：");
            float chinese = scanner.nextFloat();
            System.out.println("数学成绩：");
            float math = scanner.nextFloat();
            System.out.println("英语成绩：");
            float english = scanner.nextFloat();

            Student jcw = new Student(name,chinese,math,english);
            treeSet.add(jcw);
        }

        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("./src/com/bjsxt/com/IO操作/测试文件/treeSet.txt")
        );
        for (Student s:treeSet
             ) {
            String message = s.toString();
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedWriter.close();

    }

    public static void main(String[] args) throws IOException {
        treeSetToFile();
    }

}
