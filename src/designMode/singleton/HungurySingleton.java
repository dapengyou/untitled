package designMode.singleton;

/**
 * @date 创建时间: 2019/3/11
 * @author  lady_zhou
 * @Description  饿汉模式
 */
public class HungurySingleton {
    private static final HungurySingleton mHungurySingleton = new HungurySingleton();//1
    private HungurySingleton(){//2
        System.out.println("singleton is creat");
    }
    private static HungurySingleton getHungurySingleton(){//3
        return mHungurySingleton;
    }
    public static void createString(){
        System.out.println("createString is singleton");
    }
    public static void main(String[] args) {
        HungurySingleton.createString();
    }

}