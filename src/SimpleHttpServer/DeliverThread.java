package SimpleHttpServer;


import org.apache.bsf.util.IOUtils;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lady_zhou
 * @date 创建时间: 2019/6/1
 * @Description 连接处理线程
 */
public class DeliverThread extends Thread {
    Socket mClientSocket;

    //输入流
    BufferedReader mInputReader;

    //输出流
    PrintWriter mOutputWriter;

    //请求方法Get、post 等
    String httpMethod;

    //子路径
    String subPath;

    //分隔符
    String boundary;

    //请求参数
    Map<String, String> mParams = new HashMap<>();

    //是否已经解析完Header
    boolean isParseHeader = false;

    public DeliverThread(Socket socket) {
        mClientSocket = socket;
    }

    @Override
    public void run() {
        try {
            //获取输入流
            mInputReader = new BufferedReader(new InputStreamReader(mClientSocket.getInputStream()));
            //获取输出流
            mOutputWriter = new PrintWriter(new OutputStreamWriter(mClientSocket.getOutputStream()));
            //解析请求
            parseRequest();
            //返回Response
            handleResponse();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流和Socket
            try {
                mInputReader.close();
                mOutputWriter.close();
                mClientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return : void
     * @date 创建时间: 2019/6/2
     * @author lady_zhou
     * @Description 解析请求
     */
    private void parseRequest() throws IOException {
        String line;
        int lineNum = 0;
        while ((line = mInputReader.readLine()) != null) {
            //第一行为请求行
            if (lineNum == 0) {
                parseRequestLines(line);
            }

            //判断是否是数据的结束行
            if (isEnd(line)) {
                break;
            }

            //解析header参数
            if (lineNum != 0 && !isParseHeader) {
                parseHeaders(line);
            }

            //解析请求参数
            if (isParseHeader) {
                parseRequestParams(line);
            }
            lineNum++;
        }
    }

    /**
     * @param line :
     * @return : void
     * @date 创建时间: 2019/6/2
     * @author lady_zhou
     * @Description 解析请求参数
     */
    private void parseRequestParams(String line) throws IOException {
        if (line.equals("--" + boundary)) {
            //读取Content-Disposition行
            String contentDisposition = mInputReader.readLine();
            //解析参数名
            String paramName = parseSecondField(contentDisposition);
            //读取参数header与参数值之间的空行
            mInputReader.readLine();
            //读取参数值
            String paramValue = mInputReader.readLine();
            mParams.put(paramName, paramValue);
            System.out.println("参数名：" + paramName + ",参数值：" + paramValue);
        }

    }

    private void parseHeaders(String line) {
        //header区域的结束符
        if (line.equals("")) {
            isParseHeader = true;
            System.out.println("--------------->header解析完成\n");
            return;
        } else if (line.contains("boundary")) {
            boundary = parseSecondField(line);
            System.out.println("分隔符：" + boundary);
        } else {
            //解析普通header参数
            parseHeaderParam(line);
        }

    }


    /**
     * @param line :
     * @return : void
     * @date 创建时间: 2019/6/2
     * @author lady_zhou
     * @Description 解析单个header
     */
    private void parseHeaderParam(String line) {
        String[] keyvalue = line.split(":");
        mParams.put(keyvalue[0].trim(), keyvalue[1].trim());
        System.out.println("header参数名：" + keyvalue[0].trim() + ",参数值：" + keyvalue[1].trim());

    }

    /**
     * @param line :
     * @return : void
     * @date 创建时间: 2019/6/2
     * @author lady_zhou
     * @Description 解析header中的第二个参数
     */
    private String parseSecondField(String line) {
        String[] headerArray = line.split(";");
        parseHeaderParam(headerArray[0]);
        if (headerArray.length > 1) {
            return headerArray[1].split("=")[1];
        }
        return "";

    }

    private boolean isEnd(String line) {
        boolean isEnd = false;
        if (line.equals("\r")) {
            isEnd = false;
        } else {
            isEnd = true;
        }
        return isEnd;

    }

    /**
     * @param line :
     * @return : void
     * @date 创建时间: 2019/6/2
     * @author lady_zhou
     * @Description 解析请求行
     */
    private void parseRequestLines(String line) {
        //将没有空格的文字分离出来
        String[] tempString = line.split(" ");
        //第一个是请求方式
        httpMethod = tempString[0];
        subPath = tempString[1];

        System.out.println("请求方式：" + tempString[0]);
        System.out.println("子路径：" + tempString[1]);
        System.out.println("HTTP版本：" + tempString[2]);

    }

    /**
     * @date 创建时间: 2019/6/2
     * @author  lady_zhou
     * @Description  通过socket输出流 向客户端写入数据
     * @return : void
     */
    private void handleResponse() {
        //模拟处理耗时
        sleep();

        //向输出流写数据
        mOutputWriter.println("HTTP/1.1 200 OK");
        mOutputWriter.println("Content-Type:application/json");
        mOutputWriter.println();
        mOutputWriter.println("{\"stCode\":\"success\"}");

    }
    private void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
