package thread;

public class synchronizedDemo {
    public static void main(String[] args) {
//        synchronizedMethod syn = new synchronizedMethod();
//        syn.do1();
//        syn.do2();
//
//        syn.syncA();
//        syn.syncB();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public synchronized void run() {

                for(int i=1; i<4; i++) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread1 still alive, " + i);
                }
            }
        });
        new Thread(thread1).start();

    }

    public synchronized void syncA() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + "-A-" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void syncB() {
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + "-B-" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void do1() {
        synchronized (this) {
            for (int i = 0; i < 4; i++) {
                System.out.println(Thread.currentThread().getName() + "-do1-" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void do2() {
        synchronized (this) {
            for (int i = 0; i < 4; i++) {
                System.out.println(Thread.currentThread().getName() + "-do2-" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
