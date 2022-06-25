package www.vip.com.String类;

//字符串类型：String（不可变字符序列）
public class StringTest {

    public static void main(String[] args) {

        String test = new String("Hello,String");
        String test1 = "I am String";
        String test2 = "100" + 1; //1001
        String test3 = "100" + "1";//1001

        System.out.println("------------");

        //nihao：自动存储在字符串常量池里面；
        //直接赋值：test11、test12将直接指向常量池里面的nihao,指向同一个对象;
        String test11 = "nihao";
        String test12 = "nihao";
        String test14 = "niHao";
        //初始化一个String，将分配一个新的地址；
        String test13 = new String("nihao");
        System.out.println(test11==test12);  //true
        System.out.println(test11==test13);  //false
        System.out.println(test11.equals(test12)); //true //正确用法
        System.out.println(test11.equalsIgnoreCase(test14)); //忽略大小写

        System.out.println("================");
        System.out.println(test.charAt(2)); //字符窜索引值 char
        System.out.println(test.indexOf(test.charAt(2))); //字符char所在字符串的索引值index
        if (test.startsWith("H")){ //字符串 以..开始
            System.out.println(true);
        }else {
            System.out.println(false);
        }

        if (test.endsWith("g")){ //字符串 以..结尾
            System.out.println(true);
        }else {
            System.out.println(false);
        }

        System.out.println("~~~~~~~~~~~~~~~~");
        String lenString = "ur2hfcecvbwcbw";
        System.out.println(lenString.length()); //字符串长度

        //字符串是否包含字符串；
        if (lenString.contains("ur")){
            System.out.println("字符串包含子字符串");
        }

        lenString = lenString.replace("ur","www"); //字符串替换
        System.out.println(lenString);

        if (lenString.contains("ur")){
            System.out.println("字符串包含了ur");
        }else {
            System.out.println("不包含");
        }

        lenString = lenString.toUpperCase(); //字符串转大写
        System.out.println("大写："+lenString);
        lenString = lenString.toLowerCase(); //字符串转小写
        System.out.println("小写："+lenString);

        String sub = lenString.substring(3); //从第几个index开始截取字符串
        System.out.println(sub);

        String sub1 = lenString.substring(1,3); //从第几个（包含1）开始，截取到第几个（不包含3）结束

        String space = " ---- - ---- ";
        space = space.trim(); //去除字符串首位空格，中间的空格无法去除；
        System.out.println(space);

    }

}
