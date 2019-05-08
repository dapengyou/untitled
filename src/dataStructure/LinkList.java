package dataStructure;

public class LinkList {
    class Node {  //内部类
        private Integer data;   // 保存结点的名字
        private Node next;     // 保存下一个结点

        public Node() {
        }

        public Node(Integer data) {
            this.data = data;
        }

        public Node(Integer e, Node next) {
            this.data = e;
            this.next = next;
        }
    }

    //头结点，第0个结点
    private Node head;

    //初始化头结点
    public LinkList() {
        this.head = new Node();
    }

    //在头结点后加入一个新结点
    public void addFirst(Integer data) {
        Node s = new Node(data);
        s.next = head.next;  //在外部类中，可以方便地访问内部类的私有成员
        head.next = s;
    }

    //在尾结点后加入一个新结点
    public void addLast(Integer data) {
        Node s = new Node(data);
        Node p = head.next;
        if (head.next == null) head.next = s;
        else { //查找尾结点
            while (p.next != null)p = p.next;
            p.next = s;
        }
    }

    //设置指定索引位置的结点值
    public void set(int index, Integer data) {
        int i;
        Node p = this.head;
        for (i = 0; i < index && p.next != null; i++)p = p.next;
        if (i == index) p.data = data;
    }

    //取指定索引位置的值
    public Integer get(int index) {
        int i;
        Node p = this.head;
        //查找第i个结点
        for (i = 0; i < index && p.next != null; i++)p = p.next;
        if (i == index) return p.data;
        return null;
    }

    //链表长度
    public int size() {
        int i;
        Node p = head.next;
        for (i = 0; p != null; i++)p = p.next;  //遍历链表
        return i;
    }

    //在第index个结点前插入
    public void insert(int index, Integer data) {
        int i;
        Node p, q;
        p = head;
        q = p.next;
        for (i = 0; i < index - 1 && q != null; i++){ //查找第index-1个结点
            p = q;
            q = q.next;
        }
        if (i != index - 1){
            System.out.println("插入失败！");
            return;
        }
        Node s = new Node(data);
        s.next = q;
        p.next = s;
    }

    //删除第index个结点
    public boolean delete(int index) {
        if (index <= 0) return false;
        int i = 0;
        Node p = head;
        while (p.next != null && i < index - 1){
            p = p.next;
            i++;
        }
        if (p.next == null || i > index - 1) return false;
        p.next = p.next.next;
        return true;
    }

    //把链表L追加到当前链表尾部
    public void append(LinkList L) {
        Node p = this.head;
        while (p.next != null)p = p.next;
        p.next = L.head.next;
        L.head = null;  //L的头结点自动回收
    }

    //输出链表
    public void print() {
        if (head == null || head.next == null)
            System.out.println("空链表！");
        else {
            System.out.print("-->");
            for (Node p = head.next; p != null; p = p.next)
            System.out.print(p.data + "-->");
            System.out.println("null");
        }
    }
}