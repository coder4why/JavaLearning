package www.vip.com.IO操作.IO小节;
import java.io.*;

/**
 *  复制单级文件夹（文件夹下只有文件，没有文件夹）；
 *
 */
public class DirecotoryMoveTest {

    static void singleMove(File currentFile,File finalFile) throws IOException{

        if (currentFile.isDirectory()){
            File[] files = currentFile.listFiles();
            if (finalFile.exists()==false){
                finalFile.mkdirs();
            }
            for (File me :files) {
//                String desPath = finalFile.getPath()+"/"+me.getName();
                /** 自动拼接路径"/" **/
                File desFile = new File(finalFile.getPath(),me.getName());
                /** 递归复制 **/
                singleMove(me,desFile);
            }
        }else if(currentFile.isFile()) {

            copyFile(currentFile,finalFile);

        }else {
            System.out.println("既不是文件，也不是文件夹");
        }

    }

    //多级文件复制：递归算法
    static void mutableDirectoryMove() throws IOException{

        File file = new File("/Users/hupingkang/Desktop/file/玩");
        String destinationDir = "./src/com/bjsxt/com/IO操作/测试文件/多级文件测试";
        File desFile = new File(destinationDir);
        if (desFile.exists() == false){
            desFile.mkdirs();
        }

        singleMove(file,desFile);

    }

    static void copyFile(File currentFile,File destinationFile) throws IOException{

        System.out.println(currentFile.getPath());

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(currentFile));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destinationFile));
        byte[] bys =  new byte[8192];
        int len;
        while ((len = bufferedInputStream.read(bys)) != -1){
            bufferedOutputStream.write(bys,0,bys.length);
            bufferedOutputStream.flush();
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    //单级文件复制
    static void singleDirectoryMove() throws IOException {

        File file = new File("/Users/hupingkang/Desktop/file/玩");
        File[] files = file.listFiles();

        String destinationDir = "./src/com/bjsxt/com/IO操作/测试文件/单级文件测试/";
        File desFile = new File(destinationDir);
        if (desFile.exists() == false){
            desFile.mkdirs();
        }

        for (File fi : files) {

            /** 如果是文件夹，跳过 **/
            if (fi.isDirectory()){
                continue;
            }

            File finalFile = new File(destinationDir,fi.getName());
            copyFile(fi,finalFile);

        }

    }

    public static void main(String[] args)  throws IOException{
        singleDirectoryMove();
        mutableDirectoryMove();

    }


}
