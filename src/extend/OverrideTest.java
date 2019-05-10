package extend;

/**
 * @date 创建时间: 2019/5/10
 * @author  lady_zhou
 * @Description  方法重写
 */
public class OverrideTest {
    public static void main(String[] args) {
        Son1 son = new Son1();
        son.show();

        Father1 father1 = new Son1();
        father1.show();

    }

}

class Father1 {
    public void show() {
        System.out.println("father.show()");
    }

}
class Son1 extends Father1{
    @Override
    public void show() {
//        super.show();
         System.out.println("son.show()");
    }
}