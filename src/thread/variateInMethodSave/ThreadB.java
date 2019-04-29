package thread.variateInMethodSave;

public class ThreadB extends Thread {
    private HasSelfPrivateNum numPef;

    public ThreadB(HasSelfPrivateNum numPef) {
        super();
        this.numPef = numPef;
    }

    @Override
    public void run() {
        super.run();
        numPef.addI("b");
    }
}
