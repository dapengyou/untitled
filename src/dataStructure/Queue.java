package dataStructure;

public class Queue {
    private int maxSize = 100;//默认数组长度

    private Object[] data;//数据域

    private int front;//队头指针
    private int rear;//队尾指针

    public Queue() {
        data = new Object[maxSize];
        front = rear = 0;
    }

    public Queue(int maxSize) {
        if (maxSize < this.maxSize) {
            maxSize = this.maxSize;
        }
        data = new Object[maxSize];
        front = rear = 0;
    }

    //判定队空
    public boolean empty() {
        return front == rear ? true : false;
    }

    //求队长
    public int length() {
        return (rear - front + maxSize) % maxSize;
    }

    //入队，添加元素
    public boolean add(Object  e) {
        if ((rear + 1) % maxSize == front) {
            return false;
        }
        data[rear] = e;//在队尾入队
        rear = (rear + 1) % maxSize;
        return true;

    }

    //出队，移除元素
    public Object remove() {
        if (rear == front) {
            return null;
        }
        Object e = data[front];//在队头移除

        front = (front + 1) % maxSize;
        return e;
    }
}
