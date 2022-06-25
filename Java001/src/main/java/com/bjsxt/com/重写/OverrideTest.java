package com.bjsxt.com.重写;

public class OverrideTest {
    public static void main(String[] args) {
        Traffic tra = new Traffic();
        tra.run();
        AirPlane air = new AirPlane();
        air.run();
    }
}

class Traffic{
    public void run(){
        System.out.println("开始奔跑");
    }

}
class AirPlane extends Traffic{

    @Override
    public void run() {
        System.out.println("我要飞");
    }

    public AirPlane whichTraffic(){
        return this;
    }

}

class Car extends AirPlane{

    //重写，子类返回类型不能超过父类
    @Override
    public Car whichTraffic() {
        return this;
    }

}