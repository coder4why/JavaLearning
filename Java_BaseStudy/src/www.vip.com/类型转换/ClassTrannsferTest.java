package www.vip.com.类型转换;

public class ClassTrannsferTest {

    public static void main(String[] args) {

        AutoCar car = new AutoCar();
        car.brand();
        Bezi bz = new Bezi();
        bz.brand();
        BMW bmw = new BMW();
        bmw.brand();

        //向上转型：父类引用指向子类对象
        AutoCar autoCar = new BMW();
        autoCar.brand();

        //强制向下转型:编译成功，运行失败
        BMW baoMa = (BMW)autoCar;
        baoMa.brand();

    }

}

class AutoCar{
    protected void brand(){
        System.out.println("我是汽车");
    }
}
class Bezi extends AutoCar{
    @Override
    protected void brand() {
        System.out.println("我是奔驰");
    }
}
class BMW extends AutoCar{
    @Override
    protected void brand() {
        System.out.println("我是宝马");
    }
}
