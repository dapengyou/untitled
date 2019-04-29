package thread;

/**
 * @author lady_zhou
 * @date 创建时间: 2019/3/27
 * @Description 判断线程是否是停止状态：
 * interrupted()  当前线程是否中断
 * isInterrupted()   线程是否已经中断
 */
public class InterruptedDemo {
    public static void main(String[] args) {
        //错误演示，main线程一直在运行中，不停止
//        try {

//            MyThreadTest mThread = new MyThreadTest();
//            mThread.start();
//            Thread.sleep(1000);
//            mThread.interrupt();
//
//            System.out.println("当前线程是："+mThread.currentThread().getName()+"\t是否停止1？=" + mThread.interrupted());
//            System.out.println("当前线程是："+mThread.currentThread().getName()+"\t是否停止2？=" + mThread.interrupted());


//        } catch (InterruptedException e) {
//            System.out.println("main catch");
//            e.printStackTrace();
//        }


        //interrupted方法使用
//        Thread.currentThread().interrupt();
//
//        System.out.println("当前线程是：" + Thread.currentThread().getName() +
//                "\t是否停止1？=" + Thread.interrupted());
//        System.out.println("当前线程是：" + Thread.currentThread().getName() +
//                "\t是否停止2？=" + Thread.interrupted());
//
//        System.out.println("end!");

        //isInterrupted的使用
        try {

            MyThreadTest mThread = new MyThreadTest();
            mThread.start();
            Thread.sleep(1000);
            mThread.interrupt();

//            System.out.println("当前线程是：" + mThread.currentThread().getName() +
//                    "\t是否停止1？=" + mThread.isInterrupted());
//            System.out.println("当前线程是：" + mThread.currentThread().getName() +
//                    "\t是否停止2？=" + mThread.isInterrupted());


        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }

    }


}

class MyThreadTest extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50000; i++) {
            if(Thread.currentThread().isInterrupted()){
                System.out.println("当前线程是：" + this.currentThread().getName() +
                        "\t是否停止1？=" + this.isInterrupted());

            }
            System.out.println("i=" + (i + 1));
        }
    }
}