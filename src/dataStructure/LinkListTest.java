package dataStructure;

public class LinkListTest {
    public static void main(String[] args) {
        //构造单链表LA和LB
        LinkList LA = new LinkList();

        //从LA的表头插入若干奇数结点
        for (int i = 0; i < 7; i++)
            LA.addFirst(2 * i + 1);
        //输出LA的长度和LA链表
        System.out.println("LA.size:" + LA.size());
        System.out.print("链表LA:");
        LA.print();

        //删除第5个结点
        LA.delete(5);
        //设置第3个结点的值为100
        LA.set(3, 100);

        //重新输出LA
        System.out.print("修改后的链表LA:");
        LA.print();

        //构造一个新的链表
        LinkList LB = new LinkList();
        //从LA的表头插入若干偶数结点
        for (int i = 0; i < 5; i++)
            LB.addLast(2 * i);
        System.out.print("链表LB:");
        LB.print();

        //把LB连接到LA后面
        LA.append(LB);
        System.out.println("连接后链表LA和LB:");
        LA.print();
        LB.print();

    }
}
