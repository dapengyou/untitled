package extend;

/**
 * @date 创建时间: 2019/5/8
 * @author  lady_zhou
 * @Description  多态
 */
public class StaticFun {
    public static void main(String[] args) {
        Father2 f = new Son2();
        f.h();
        f.test();
    }
}

class Father2{
    public Father2(){
         System.out.println("Father构造函数");
    }
    static  void h(){
         System.out.println("Father的静态方法h()");
    }
    void test(){
         System.out.println("Father.Box()");
    }
}

class Son2 extends Father2{
    public Son2(){
         System.out.println("son构造函数");
    }
    static  void h(){
         System.out.println("son的静态方法h()");
    }

    void test() {
         System.out.println("son.Box()");
    }
}