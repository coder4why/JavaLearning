package www.vip.com.重写;

public class OverrideObject {

    public static void main(String[] args) {

        OverrideObject test = new OverrideObject();
        System.out.println(test.toString());

    }

    //重写Object toString
    public String toString(){
        return "重写Object toString";
    }

}
