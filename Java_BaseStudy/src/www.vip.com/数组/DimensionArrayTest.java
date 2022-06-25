package www.vip.com.数组;

//多维数组
public class DimensionArrayTest {
    public static void main(String[] args) {
        int[] a = new int[3];

        int[][] b =  new int[3][];
        b[0] = new int[]{10,20};
        b[1] = new int[]{30,40};
        b[2] = new int[]{50,60};

        int[][] c = {
                {1,2,3},{4,5},{6,7,8,9,10}
        };

        System.out.println(b[1][1]);
        System.out.println(c[2][3]);

    }
}
