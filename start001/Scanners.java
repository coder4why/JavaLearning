

import java.util.Scanner;
public class Scanners {

    public static void main(String[] args) {
      
      System.out.println("请输入用户名");
      Scanner s = new Scanner(System.in);
      String uname = s.nextLine();
      System.out.println("请输入年龄");
      int age = s.nextInt();
      System.out.println("请输入月薪");
      double salary = s.nextDouble();
      
      System.out.println("程序运行结束！");
      System.out.println("键盘输入的用户名为："+uname+"\n年龄："+age+"\n月薪："+salary);

      s.close();

    }

}
