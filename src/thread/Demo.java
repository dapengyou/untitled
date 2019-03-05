package thread;


public class Demo {
    public people getPeople() {

        return new xiaoming(12);
    }

    class people {
        public String name;

        people() {
            name = "13";
        }

    }

    class xiaoming extends people {
        xiaoming(int age) {
            this.age = age;
        }

        public int age;
    }

    interface callback {
        void run();
    }

    class xiaoming1 implements callback {
        public int age;

        @Override
        public void run() {

        }
    }

    public callback getPeople1() {
        return new xiaoming1();
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        if (demo.getPeople() instanceof xiaoming) {
            xiaoming xi = (xiaoming) demo.getPeople();
            System.out.println("is xiaoming" + xi.age);
        }

    }
}
