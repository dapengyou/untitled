package dataStructure;

public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new Queue();
        //入队
        queue.add(1);
        queue.add(3);
        queue.add(5);
        System.out.println("length=" + queue.length());
        //队列非空时出队
        while (!queue.empty()) {
            System.out.println(queue.remove());
        }
    }
}
