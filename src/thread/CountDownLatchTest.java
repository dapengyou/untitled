package thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author lady_zhou
 * @date 创建时间: 2019/7/15
 * @Description 使用CountDownLatch
 */
public class CountDownLatchTest {
    static CountDownLatch countDownLatch = new CountDownLatch(3);
    static int threadA = 0;
    static int threadB = 0;
    static int threadC = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadA = 1;
                System.out.println("线程A的数字------" + threadA);
                countDownLatch.countDown();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadB = 2;
                System.out.println("线程B的数字------" + threadB);
                countDownLatch.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadC = 3;
                System.out.println("线程C的数字------" + threadC);
                countDownLatch.countDown();
            }
        }).start();

        countDownLatch.await();

        int countAll = threadA + threadB + threadC;
        System.out.println("总的数量-------" + countAll);
    }
}
