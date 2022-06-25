package www.proxy.Entity;

public class FDProxy implements FDService {

    private FDService fdService = new FDServiceImpl();
    @Override
    public void zufang() {
        System.out.println("中介出租");
        fdService.zufang();
    }
}
