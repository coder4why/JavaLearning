package www.vip.com.File类;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类：
 *     代表文件和目录，在开发中，读取、生成、删除、修改文件的属性时经常会用到此类；
 */
public class FileTest {

    public static void main(String[] args) throws IOException {

        String filePath = "/Users/hupingkang/Desktop/JavaLearning/fileTest";

        /**
         * Mac上文件路径可能会失败，可使用以下方式：
         *        String filePath = File.separator+"Users"+File.separator+"hupingkang"+File.separator+"Desktop"+
         *                 File.separator+"JavaLearning"+File.separator+"iOS屏幕录制与截图技术要点.pdf";
         */
        File file = new File(filePath);

        /**
         *  exists:判断文件是否存在
         */
        System.out.println(file.exists());

        /**
         * isDirectory:判断文件是否是文件夹
         */
        System.out.println(file.isDirectory());

        /**
         * isFile:判断文件是否是文件
         */
        System.out.println(file.isFile());

        /**
         * lastModified：最后修改时间
         */
        System.out.println(new Date(file.lastModified()));

        /**
         * length：文件的大小
         */
        System.out.println(file.length());

        /**
         *  getName:获取文件名称
         */
        System.out.println(file.getName());

        /**
         *  getPath:文件路径
         *  getAbsoluteFile:绝对路径
         */
        System.out.println(file.getPath());
        System.out.println(file.getAbsoluteFile());

        /**
         * getParent、getParentFile:获取上一级目录
         */
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());

        /**
         * 修改文件名称、文件路径（文件移动，非copy）
         */
        file.renameTo(new File("/Users/hupingkang/Desktop/JavaLearning/fileTest01"));

        /**
         * 删除文件：
         */
        File deleteFile = new File("/Users/hupingkang/Desktop/JavaLearning/FileTest02");
        boolean isDel = deleteFile.delete();
        System.out.println(isDel);

        /**
         * 创建一个新的文件：
         */
        File createFile = new File("/Users/hupingkang/Desktop/JavaLearning/fileTest01","java.pdf");
        createFile.createNewFile();

        /**
         * 设置文件是否可写入 设置只读
         */
        // createFile.setWritable(true);
        // createFile.setReadOnly();

        /**
         * 获取当前项目类
         */
        String sysDir = System.getProperty("user.dir");
        System.out.println(sysDir);

        try{
            File cFile = new File("test.pdf");
            boolean isCreate = cFile.createNewFile();
            System.out.println(isCreate?"创建成功":"创建失败");
        }catch (IOException e){
            e.printStackTrace();
        }

        /**
         * mkdir创建目录：目录结构中有一个不存在，则不会创建整个目录树
         * mkdirs创建目录：目录结构中有一个不存在也没关系，创建整个目录树；
         */
        File mkFile = new File("/Users/hupingkang/Desktop/JavaLearning/001/雷神3.mp4");

        boolean  flag = mkFile.mkdir();
        System.out.println(flag);

        boolean  flag1 = mkFile.mkdirs();
        System.out.println(flag1);



    }

}
