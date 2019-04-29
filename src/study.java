import kotlintojava.Particle;

/**
 * @author lady_zhou
 * @date 创建时间: 2019/4/29
 * @Description 这个例子证明  每new一个对象都会在堆内存中新分配一块地址
 */
public class study {
    public static void main(String[] args) {
        Particle particle1 = new Particle();
        Particle particle2 = new Particle();
        Particle particle3 = new Particle();

        particle1 = particle2;


        //输出的是引用在栈区内存储的 指向的堆区的 内存地址
        System.out.println(System.identityHashCode(particle1));
        System.out.println(System.identityHashCode(particle2));
        System.out.println(System.identityHashCode(particle3));

        System.out.println("------------------hashcode-----------------------");

        System.out.println(particle1.hashCode());
        System.out.println(particle2.hashCode());
        System.out.println(particle3.hashCode());
    }
}
