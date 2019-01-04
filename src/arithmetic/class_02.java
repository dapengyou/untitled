package arithmetic;

import java.util.ArrayList;

/**
 * @author lady_zhou
 * @date 创建时间: 2019/1/3
 * @Description 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class class_02 {
    private int size;
    private static ListNode head;
    private static ArrayList list = new ArrayList();
    private static class_02 listNode = new class_02();


    public static void main(String[] args) {
        listNode.addHead(50);
        listNode.addHead(150);
        listNode.addHead(80);
        listNode.addHead(590);
        listNode.addHead(390);
        listNode.addHead(240);
        listNode.addHead(90);

        listNode.display();


        System.out.print(listNode.printListFromTailToHead(head));

    }

    public  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            this.printListFromTailToHead(listNode.next);
            list.add(listNode.data);
        }
        return list;
    }


    public class_02() {
        size = 0;
        head = null;
    }

    //在链表头添加元素
    public Object addHead(Object obj) {
        ListNode newHead = new ListNode(obj);
        if (size == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        size++;
        return obj;
    }


    public class ListNode {
        Object data;
        ListNode next = null;

        ListNode(Object data) {
            this.data = data;
        }
    }

    //显示节点信息
    public void display() {
        if (size > 0) {
            ListNode node = head;
            int tempSize = size;
            if (tempSize == 1) {//当前链表只有一个节点
                System.out.println("[" + node.data + "]");
                return;
            }
            while (tempSize > 0) {
                if (node.equals(head)) {
                    System.out.print("[" + node.data + "->");
                } else if (node.next == null) {
                    System.out.print(node.data + "]");
                } else {
                    System.out.print(node.data + "->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        } else {//如果链表一个节点都没有，直接打印[]
            System.out.println("[]");
        }

    }

}
