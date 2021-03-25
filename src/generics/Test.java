package generics;

public class Test {
    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        box1.setT(1);
        box1.setT(2);

        System.out.println(box1.getT());
    }
}
