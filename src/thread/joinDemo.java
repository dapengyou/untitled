package thread;

public class joinDemo {
    public static void main(String[] args) {
        Worker worker1 = new Worker("worker1");
        Worker worker2 = new Worker("worker2");
        worker1.start();

        System.out.println("启动线程1");

        try {
            worker1.join();//等待worker1执行完才能继续执行主线程2
            System.out.println("启动线程2");
            worker2.start();
            worker2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
         System.out.println("主线程继续执行");
    }

    static class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            try {

                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("work in\t" + getName());
        }
    }
}
