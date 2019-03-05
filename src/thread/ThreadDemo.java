package thread;

/**
 * @date 创建时间: 2019/3/4
 * @author  lady_zhou
 * @Description  start() 和 Run（）的区别，run只是一个普通的方法单独调用它，还是在主线程中，start是开启另一个线程
 *
 */
public class ThreadDemo {

    public static void main(String[] args) {
        Thread mythread = new MyThread("mythread");

        System.out.println(Thread.currentThread().getName() + " call mythread.run()");
        mythread.run();

        System.out.println(Thread.currentThread().getName() + " call mythread.start()");
        mythread.start();
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
};
