package www.vip.com.IO操作.IO小节;

import www.vip.com.IO操作.特殊操作符.PrintStreamTest;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * 需求：
 *      使用Properties类,集合IO流,编写游戏小程序；
 *      要求：编写程序实现猜数字小游戏只能试玩3此，如果还想玩，提示：游戏试玩已结束，想玩请充值；
 *      思路：
 *          1.写一个游戏类，里面有一个猜数字的小游戏；
 *          2.三局两胜
 */
public class PropertiesGameTest {

    static String COUNT = "count";
    static String  ROOT_GAME_PATH = PrintStreamTest.ROOT_PATH+"properties小游戏.txt";

    /**
     * 创建本地文件，并设置初始值
     */
    protected static void createCount() throws IOException{

        Properties properties = new Properties();
        properties.setProperty(COUNT,String.valueOf(0));
        FileWriter fileWriter = new FileWriter(ROOT_GAME_PATH);
        properties.store(fileWriter,null);
        fileWriter.flush();
        fileWriter.close();
    }

    protected static boolean play(){

        System.out.println("请输入数字：");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int myScore = number%6;
        if ((myScore+1)>3){
            System.out.println("恭喜你,本轮成功✌️");
            return true;
        }else {
            System.out.println("抱歉了,本轮失败😭️");
            return false;
        }
    }

    protected static void playGame() throws IOException {

        /**
         * 1.先读取文件中的属性值count,判断属性值，为2，则游戏结束；
         */
        Properties properties = new Properties();
        FileReader fileReader = new FileReader(ROOT_GAME_PATH);
        properties.load(fileReader);
        fileReader.close();
        String number = properties.getProperty(COUNT);
        if (number==null){
            number = "0";
        }
        int count = Integer.parseInt(number);

        if (count<2){
            boolean isWin = play();
            if (isWin){
                count++;
                FileWriter fileWriter = new FileWriter(ROOT_GAME_PATH);
                properties.setProperty(COUNT,String.valueOf(count));
                properties.store(fileWriter,null);
                fileWriter.flush();
                fileWriter.close();
                if (count<2){
                    playGame();
                }else{
                    System.out.println("游戏试玩已结束，想玩请充值");
                }
            }else {
                playGame();
            }
        }else {
            System.out.println("游戏试玩已结束，想玩请充值");
        }

    }
    /**
     * 具体实现：
     *    1.创建Properties对象并设置初始值count，写入到文件；
     *    2.开始玩游戏；
     *       a.读取文件中count值，如果小于2，可继续玩游戏,否则游戏结束，已胜出；
     *       count记录的是胜利的次数：
     *          每次由程序产生一个随机数，对数字6做%运算，大于3则胜，本地文件中的count+1，否则失败继续玩；
     */
    public static void main(String[] args) throws IOException {

        createCount();
        playGame();

    }

}


