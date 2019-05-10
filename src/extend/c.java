package extend;

/**
 * @date 创建时间: 2019/5/10
 * @author  lady_zhou
 * @Description  子类继承后使用变量
 *
 */
interface A{
    int x = 0;
}
class B{
   static int x =1;
}
class C extends B implements A {
    public void pX(){
        System.out.println(B.x);
    }
    public static void main(String[] args) {
        new C().pX();
    }
}

