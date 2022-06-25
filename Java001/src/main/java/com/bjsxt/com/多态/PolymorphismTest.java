package com.bjsxt.com.多态;

/**
 * 多态（Polymorphism）：
 *      指的是同一方法调用，由于对象不同可能会有不同的行为；
 *      现实生活中，同一方法，具体实现会完全不同；
 */
/**
 * 多态的要点：
 *      1.多态是方法的多态，不是属性的多态（多态与属性无关）；
 *      2.多态的存在有三个必要条件：继承、方法重写、父类引用指向子类对象；
 *      3.父类引用指向子类对象后，用该父类引用调用子类重写的方法，此时多态就出现了；
 */

public class PolymorphismTest {

    static void animalRun(Animal animal){
        animal.run();
    }

    public static void main(String[] args) {

        Animal animal = new Animal();
        animalRun(animal);

        Dog dog = new Dog();
        //子类传给父类,父类引用将指向子类对象（Animal->Dog）
        animalRun(dog);

        Cat cat = new Cat();
        //子类传给父类,父类引用将指向子类对象（Animal->Cat）
        animalRun(cat);

    }

}

class Animal{
    protected String name;
    protected void run(){
        System.out.println("动物在跑了");
    }
}
class Dog extends Animal{
    @Override
    protected void run() {
        System.out.println("狗在跑了");
    }
}
class Cat extends Animal{
    @Override
    protected void run() {
        System.out.println("猫在跑了");
    }
}
