package designMode.observe;

public class RealizeObserver {
    public static void main(String[] args) {
        String message = "重大消息：有部分商品降价!";

        Observerable observerable = new ShopObserverable();
        Observer kuka = new UserObserver("库卡");
        Observer bedi = new UserObserver("贝蒂");
        Observer samu = new UserObserver("萨姆");
        Observer lain = new UserObserver("莱恩");

        observerable.addObserve(kuka);
        observerable.addObserve(bedi);
        observerable.addObserve(samu);
        observerable.addObserve(lain);

        observerable.pushMessage(message);
    }
}
