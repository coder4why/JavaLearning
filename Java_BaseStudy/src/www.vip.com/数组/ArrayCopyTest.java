package www.vip.com.数组;

public class ArrayCopyTest {

    public static void main(String[] args) {

        String[] mans = {"A","B","C","D","E"};
        String[] womans = {"F","G","H","I","J"};

        /**
         * 数组的拷贝：
         *   从mans的0位开始copy，copy到womans的从第2位开始，拷贝mans的三个元素
         */
        System.arraycopy(mans,0,womans,2,3);
        for (String a:mans) {
            System.out.println(a);
        }
        System.out.println("-----------");
        for (String b : womans ) {
            System.out.println(b);
        }
    }

}
