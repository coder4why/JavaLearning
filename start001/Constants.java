

public class Constants {

    public static void main(String[] args) {
      
      //final 定义常量，不可重新赋值；也叫做符号常量
      final double pi = 3.14; 
      //定义变量，可重新赋值；也叫做字符常量
      double r = 10;
      r = 100;
      System.out.println("pi的值为："+pi+",r的值为："+r);
      byte age = 10; 
      int a = 44124040;
      int b = 07;
      int c = 0xafdc;
      int d = 0b0101001;
      System.out.println(b);
      System.out.println(c);
      System.out.println(d);

      NumberTest.numberTest();
      BoolTest.main();
      OperatorTest.main();
    }


}

class NumberTest{

  protected static void numberTest() {
    
    double a = 3.14E2;
    float b = 3.14F;
    double c = 3.14D;
    float f1 = 1.65F; //会报错，1.65是double类型的浮点常量，不能直接赋值给float
    System.out.println(a);

  }

}

class BoolTest{

    protected static void main(){
      boolean b1 = true;
      boolean b2 = false;
      if(b1){
        System.out.println(b1);
      }
      if(b2){
        System.out.println(b2);
      }else{
        System.out.println("不能使用0或者1代表false和true");
      }

    }

}

class OperatorTest{

  protected static void main(){
    int a = 10;
    int b = a++;  //先赋值再自增 ；先把a的值赋给b，a再自增；
    System.out.println(a);
    System.out.println(b);

    int c = ++a; //先自增再赋值，a先自增，再赋值给b；
    System.out.println(a);
    System.out.println(c);

    c *= a+3; //等价于c = c * (a+3);
    System.out.println(c);

    char h = 'h';
    System.out.println((int)h); //int 强制类型转化char为int类型

    boolean x = false;
    boolean y = true; 
    System.out.println(x^y); //^：异或，值相同为false，不同为true

    //位运算符（针对二进制的运算）：<<左移，>>右移
    //a<<b:a连续乘以几个2；
    //a>>b:a连续除以几个2；
    int z = 5<<3; //相当于5*2*2*2 = 40
    int xo = 400>>4; //相当于400/2/2/2/2 = 25
    System.out.println(z);
    System.out.println(xo);

    // 5:0101 << 3 :原理 0101 --> 0101000 = 1*2*2*2*2*2 + 1*2*2*2 = 32 + 8 = 40;
    // 400 = 256 + 128 + 16 = 2的8次方+2的7次方+2的4次方 = 110010000 
    // 400:110010000 >> 4 => 11001 = 16+8+1 = 25

    
  }


}