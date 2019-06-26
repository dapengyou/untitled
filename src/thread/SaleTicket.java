package thread;

class Ticket implements Runnable {
    private int tickets = 15;

    @Override
    public void run() {
        for (int i = 1; i < 15; i++) {
            String threadName = Thread.currentThread().getName();//获取当前线程名称
            if (this.tickets > 0) {
                System.out.println(threadName + "售出车票" + this.tickets--);
            } else {
                System.out.println(threadName + "车票已售完");
            }
            try {
                System.out.println(threadName + "线程准备先休眠2秒");
                Thread.sleep(2000);//休眠2000毫秒
                System.out.println(threadName + "休眠完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(threadName + "时间没到，被唤醒");
            }

            System.out.println(threadName + "售票结束");
        }
    }
}

public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        System.out.println("开始售票");

        Thread thread1 = new Thread(ticket, "窗口1");
        thread1.start();
//        thread1.interrupt();


        Thread thread2 = new Thread(ticket, "窗口2");
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread2.start();
//        thread2.interrupt();//中断


//        new Thread(ticket, "窗口2").start();
//        new Thread(ticket, "窗口3").start();

    }
}
