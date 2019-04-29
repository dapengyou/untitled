package thread.variateInMethodSave;

public class ThreadA extends Thread {
    private HasSelfPrivateNum numPef;

    public ThreadA(HasSelfPrivateNum numPef) {
        super();
        this.numPef = numPef;
    }

    @Override
    public void run() {
        super.run();
        numPef.addI("a");
    }
}
