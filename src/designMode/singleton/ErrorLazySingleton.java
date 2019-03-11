package designMode.singleton;

public class ErrorLazySingleton extends Thread {
    @Override
    public void run() {
        System.out.println(LazySingleton.getInstance().hashCode());
    }

    public static void main(String[] args) {
        ErrorLazySingleton[] thread = new ErrorLazySingleton[10];
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new ErrorLazySingleton();
        }

        for (int j = 0; j < thread.length; j++) {
            thread[j].start();
        }
    }
}
