package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @date 创建时间: 2019/10/30
 * @author  lady_zhou
 * @Description  三种创建线程的方式
 */
public class CreatThread {
    public static void main(String[] args) {

        UserThread userThread = new UserThread();
        userThread.start();

        UserRun userRun = new UserRun();
        new Thread(userRun).start();

        UserCall userCall = new UserCall();
        FutureTask futureTask = new FutureTask(userCall);
        new Thread(futureTask).start();
        //拿到返回结果
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    //继承类Thread
    public static class  UserThread extends Thread{
        @Override
        public void run() {
            super.run();
             System.out.println("我是继承类Thread所开的线程");
        }
    }

    /**
     * @date 创建时间: 2019/10/30
     * @author  lady_zhou
     * @Description 实现Runnable接口，无返回值
     */
    public static class  UserRun implements Runnable{

        @Override
        public void run() {
            System.out.println("我是实现Runnable所开的线程");
        }
    }

    /**
     * @date 创建时间: 2019/10/30
     * @author  lady_zhou
     * @Description  实现Callable接口，有返回值
     */

    public  static  class  UserCall implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("我是实现Callable所开的线程");
            return "Result";
        }
    }
}
