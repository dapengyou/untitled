package dataStructure;

public class StackTest {
    public static void main(String[] args) {
        //数字进栈、出栈
        Stack stack = new Stack();
        //进栈
        stack.push(1);
        stack.push(3);
        stack.push(5);

        //取栈顶元素
        Object top = stack.getTop();
        System.out.println("getTop:" + top);

        System.out.println("POP:");
        //栈非空时，依次出栈
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

        //字符串类型进栈、出栈

        Stack stack2 = new Stack();
        //进栈
        stack2.push("java");
        stack2.push("c++");
        stack2.push("android");

        //取栈顶元素
        Object top2 = stack2.getTop();
        System.out.println("getTop:" + top2);

        System.out.println("POP:");
        //栈非空时，依次出栈
        while (!stack2.empty()) {
            System.out.println(stack2.pop());
        }

    }
}
