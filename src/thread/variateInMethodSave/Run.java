package thread.variateInMethodSave;

/**
 * @date 创建时间: 2019/3/27
 * @author  lady_zhou
 * @Description  验证方法内的变量为线程安全
 */
public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum numPef  = new HasSelfPrivateNum();
        ThreadA athread = new ThreadA(numPef);
        athread.start();
        ThreadB bthread = new ThreadB(numPef);
        bthread.start();
    }
}
