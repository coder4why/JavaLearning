

public class Strings {

    public static void main(String[] args) {
      
      //+ 运算符在 String中使用时，为字符串拼接；
      String a = "hello";
      int b = 10;
      System.out.println(a+b);

      //+ 运算符在 char中使用时，为数字运算，char类型将自动转化为int型；
      char c = 'h';
      char d = 'i';
      System.out.println(c+d);

      LogicTest.main();
      TypeCast.main();

    }


}

class LogicTest{

  //逻辑或与非优先级：非>与>或
  protected static void main(){
    boolean a = true,b = true,c = false;
    System.out.println(a||b&&c); //等价于 a||(b&&c),结果为true；
    System.out.println(!a||c);  //相当于 (!a)||c ;结果为false
  }

}

class TypeCast{

  protected static void main(){

      double a = 3.1415;
      int b = (int)a; //浮点数强制转换为整数，则小数部分直接丢失，不会四舍五入；
      System.out.println(b); 

      int c = 100;
      System.out.println((char)c);

      byte d =  (byte)200; //超出了byte的表数范围，则输出一个不同的数字；
      System.out.println(d);

      //溢出问题：
      int year = 200;
      int money = 100000000;
      long yearMoney = year * money; //正确写法:（year * (long)money）
      System.out.println(yearMoney);

      long heartBeat = 100 * 60 * 24 * 365 * 80L;
      System.out.println(heartBeat);

  }


}