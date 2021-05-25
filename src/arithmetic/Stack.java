package arithmetic;

import java.util.*;

/**
 * @author lady_zhou
 * @date 创建时间: 2021/3/25
 * @Description 基于数组实现的顺序栈
 */
public class Stack {
    //数组
    private String[] arrayString;
    private int n;//栈的大小
    private int count;//栈中元素个数

    //n 创建数组的大小
    public Stack(int n) {
        arrayString = new String[n];
        this.n = n;
        this.count = 0;
    }

    //入栈
    public boolean push(String itme) {
        //判断是否有空间
        if (n == count) return false;
        //将元素放入栈
        arrayString[count] = itme;
        ++count;
        return true;
    }

    //出栈
    public String pop() {
        //判断栈是否为null
        if (count == 0) return null;
        String tempString = arrayString[count - 1];
        --count;
        return tempString;
    }

    public String peek() {
        //判断栈是否为null
        if (count == 0) return null;
        String tempString = arrayString[count - 1];
        return tempString;
    }

    public static void main(String[] args) {
        System.out.println("hello");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String name = scanner.nextLine();

        Stack stack = new Stack(name.length());
        for (int i = 0; i < name.length(); i++) {
            stack.push(String.valueOf(name.charAt(i)));
        }

        System.out.println(stack.arrayString.length);
        System.out.println(stack.peek());
        System.out.println(stack.pop() + "\t" + name);
    }

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

}
