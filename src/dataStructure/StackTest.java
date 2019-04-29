package dataStructure;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        //进栈
        stack.push(1);
        stack.push(3);
        stack.push(5);

        //取栈顶元素
        int top = stack.getTop();
        System.out.println("getTop:" + top);

        System.out.println("POP:");
        //栈非空时，依次出栈
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
