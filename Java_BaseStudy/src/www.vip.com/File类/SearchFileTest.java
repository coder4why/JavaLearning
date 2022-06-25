package www.vip.com.File类;
import java.io.File;

/**
 * 递归算法查找文件
 */
public class SearchFileTest {
    public static void main(String[] args) {
        File file = new File("/Users/hupingkang/Desktop/ReplayDemo");
        printFile(file,0);
    }

    /**
     * 递归查找
     */
    static void printFile(File file,int level){

        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }

        System.out.println(file.getName());

        if (file.isDirectory()){
            /**
             * listFiles：获取所有子文件
             */
            File[] files = file.listFiles();
            for (File temp:files) {
                printFile(temp,level+1);
            }
        }
    }

}

