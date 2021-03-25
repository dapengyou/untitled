package generics;

/**
 * 泛型
 */

public class Box<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public <U extends Number> void inspect(U u) {  //限定的类型参数
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public <T extends Comparable<T>> int countGreaterThan(T[] array, T elem) {
        int count = 0;
        for (T e : array) {
            if (e.compareTo(elem) > 0) {
                ++count;
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        Box<Integer> integerBox = new Box<>();
//        integerBox.setT(10);
//        integerBox.inspect(20);
//        integerBox.inspect("some text");
        Box box = new Box();
        Integer[] number = new Integer[]{1,2,3};
        box.countGreaterThan(number,10);


    }
}

