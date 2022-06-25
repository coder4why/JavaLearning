package www.vip.com.枚举;

/**
 * 枚举的使用:
 *    尽量不要使用枚举的高级特性，高级特性事实上都可以使用普通类来实现，没必要引入枚举
 */
public class EnumTest {
    /**
     * 声明创建一个枚举类型
     */
    enum Season{
        SPRING,SUMMER,AUTUMN,WINNER
    }
    /**
     * 枚举类型的使用
     */
    static void whichSeason(Season sea){
        switch (sea){
            case SPRING:
                System.out.println("春季");
                break;
            case SUMMER:
                System.out.println("夏季");
                break;
            case AUTUMN:
                System.out.println("秋季");
                break;
            case WINNER:
                System.out.println("冬季");
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        /**
         * 使用枚举
         */
        whichSeason(Season.AUTUMN);

    }

}
