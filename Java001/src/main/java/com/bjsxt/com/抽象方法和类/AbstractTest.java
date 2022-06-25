package com.bjsxt.com.抽象方法和类;

/**
 * 抽象方法：
 *      1.使用abstract修饰的方法，没有方法体，只有声明；
 *      2.定义的是一种规范，就是要告诉子类必须要给抽象方法提供具体的实现；
 * 抽象类：
 *      1.包含抽象方法的类就是抽象类；通过abstract方法定义规范，然后要求子类必须定义具体实现；
 *      2.通过抽象类，我们就可以做到严格限制子类的设计，使子类之间更加通用；
 */
public class AbstractTest {
    public static void main(String[] args) {
        CompletedModel model = new CompletedModel("抽象子类",true);
        model.doWhat();
        model.playWhat();

        //实例化一个抽象类：
        BaseModel baseModel = new BaseModel("Java抽象类") {
            @Override
            public void doWhat() {
                System.out.println("搞什么飞机");
            }
        };
        baseModel.doWhat();
        baseModel.playWhat();
    }
}
/**
 * 抽象类的使用要点：
 *     1.有抽象方法的类只能定义成抽象类；
 *     2.抽象类可以包含属性、方法、构造方法；
 *     3.抽象方法必须被子类实现；
 *     4.抽象类可以被实例化；
 */
//抽象类；
abstract class BaseModel {
    String name;
    BaseModel(String  name){
        this.name = name;
    }
    //抽象方法：不提供具体实现，只定义方法，子类来提供具体实现；
    abstract public void doWhat();
    public void playWhat(){
        System.out.println("我不是抽象方法:"+name);
    };
}

//抽象类的子类
class CompletedModel extends BaseModel{

    boolean  isFinished;
    CompletedModel(String name,boolean isFinished){
        super(name);
        this.isFinished = isFinished;
    }
    //子类必须提供抽象类的抽象方法的实现
    @Override
    public void doWhat() {
        System.out.println("我实现了抽象方法");
    }
    @Override
    public void playWhat() {
        super.playWhat();
        System.out.println("我在玩水");
    }
}
