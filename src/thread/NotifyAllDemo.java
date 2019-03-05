package thread;

public class NotifyAllDemo {
//    private static Object obj = new Object();

    public static void main(String[] args) {
        Object obj = new Object();

        for (int i = 0; i < 3; i++) {
            ThreadA t1 = new ThreadA(obj, "t" + i);
            t1.start();
        }
//        ThreadA t2 = new ThreadA("t2");
//        ThreadA t3 = new ThreadA("t3");
//        t1.start();
//        t2.start();
//        t3.start();

        try {
            System.out.println(Thread.currentThread().getName() + " sleep(3000)");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (obj) {
            // 主线程等待唤醒。
            System.out.println(Thread.currentThread().getName() + " notifyAll()");
            obj.notifyAll();
        }

    }

    static class ThreadA extends Thread {
        private Object obj;//使用同一个对象

        public ThreadA(Object obj, String name) {
            super(name);
            this.obj = obj;
        }

        public void run() {
            synchronized (obj) {
                try {
                    // 打印输出结果
                    System.out.println(Thread.currentThread().getName() + " wait");

                    // 唤醒当前的wait线程
                    obj.wait();

                    // 打印输出结果
                    System.out.println(Thread.currentThread().getName() + " continue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
