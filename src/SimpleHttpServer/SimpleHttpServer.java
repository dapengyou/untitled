package SimpleHttpServer;

import java.io.IOException;
import java.net.ServerSocket;

public class SimpleHttpServer extends Thread {
    public static final int HTTP_PORT = 8000;
    ServerSocket mServerSocket = null;

    public SimpleHttpServer() {
        try {
            mServerSocket = new ServerSocket(HTTP_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (mServerSocket == null) {
            throw new RuntimeException("服务器Socket初始化失败");
        }
    }

    @Override
    public void run() {
        try {
            //进入等待连接状态
            while (true) {
                System.out.println("等待连接中");

                //收到连接请求后，构建一个线程来处理
                new DeliverThread(mServerSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}