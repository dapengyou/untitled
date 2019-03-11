package designMode.singleton;

/**
 * @author lady_zhou
 * @date 创建时间: 2019/3/11
 * @Description 懒汉模式/懒汉线程安全
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("singleton is creat");
    }

    public static synchronized LazySingleton getInstance() {//懒汉线程安全方法一
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

//    public static LazySingleton getInstance() {//懒汉线程安全方法二
//        synchronized (LazySingleton.class) {
//            if (instance == null) {
//                instance = new LazySingleton();
//            }
//        }
//        return instance;
//    }

    public static void createString() {
        System.out.println("createString is singleton");
    }

    public static void main(String[] args) {
        LazySingleton.createString();
    }
}
