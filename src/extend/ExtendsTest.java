package extend;

/**
 * @date 创建时间: 2019/5/10
 * @author  lady_zhou
 * @Description 继承
 */
public class ExtendsTest {
    public static void main(String[] args) {
        Son son = new Son();
    }
}
class Son extends Father{
    public Son(){
        super(12);
        System.out.println("son");
    }
}
class Father extends Grandpa{
    public Father(int age){
        System.out.println("Father");
    }
}
class Grandpa {
    public Grandpa(){
        System.out.println("Grandpa");
    }
}

