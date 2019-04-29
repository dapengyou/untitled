package dataStructure;

public class Stack {
    private Integer[] data;//数据域
    private int top;//栈顶指针，始终指向栈顶元素的下一位
    private int size = 50;//预设空间大小

    public Stack() {
        this.data = new Integer[this.size];
        top = 0;
    }

    //判定栈空
    public boolean empty() {
        return top > 0 ? false : true;
    }

    //进栈，将新元素添加到top指针指向的位置，然后top指针加1
    public boolean push(Integer e) {
        if (this.top >= this.size) {
            return false;
        }
        this.data[top++] = e;
        return true;
    }

    //出栈，top指针减1，返回栈顶元素
    public Integer pop() {
        if (top == 0) {
            return null;
        }
        return this.data[--top];
    }

    //取栈顶元素
    public Integer getTop() {
        if (top == 0) {
            return null;
        }
        return this.data[top - 1];
    }
}
