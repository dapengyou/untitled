package thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lady_zhou
 * @date 创建时间: 2019/7/16
 * @Description Exchanger
 */
public class ExchangerTest {
    private static final Exchanger<String> exch = new Exchanger<>();
    private static ExecutorService threadpool = Executors.newFixedThreadPool(2);
    static String c = null;
    static String d = null;

    public static void main(String[] args) {
        threadpool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "数据A";
                    d = exch.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        threadpool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "数据B";
                    c = exch.exchange(B);
                    System.out.println("c数据是：" + c + "-------，d数据是：" + d);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadpool.shutdown();
    }
}
