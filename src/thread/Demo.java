package thread;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

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
//        Demo demo = new Demo();
//        if (demo.getPeople() instanceof xiaoming) {
//            xiaoming xi = (xiaoming) demo.getPeople();
//            System.out.println("is xiaoming" + xi.age);
//        }
//        String str = "5234";
//        String a = "11";
//        String b = "1";
////        int ii = Integer.parseInt(String.valueOf(str.charAt(1)));
//        int ii = str.length();
//        System.out.println(a.length() + "---" + b.length());
//        System.out.println((a.charAt(1) - '0') + "-----" + '0');
//
//        StringBuilder sb = new StringBuilder(str);
//        sb.insert(1,"hellox");
//         System.out.println(sb);
//
//         StringBuffer

//        dateDemo();//日期demo

        StringUser();//        StringBuilder.insert()方法的使用

        System.out.println(assBinary("11", "1"));


    }

    /**
     * @date 创建时间: 2019/6/25
     * @author lady_zhou
     * @Description 二进制计算
     */
    private static String assBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;// 进位

        StringBuilder sb = new StringBuilder();

        while (i > -1 || j > -1) {

            int abit = i > -1 ? a.charAt(i) - '0' : 0;
            int bbit = j > -1 ? b.charAt(j) - '0' : 0;

            int sum = abit + bbit + carry;// 00, 01, 10, 11

            sb.insert(0, sum & 1);
            carry = (sum >>> 1) & 1;

            i--;
            j--;
        }
        if (carry == 1)
            sb.insert(0, 1);
        return sb.toString();

    }

    private static void StringUser() {
        StringBuilder str = new StringBuilder("zhoutingtingdetestwebsite");
        System.out.println("string = " + str);

        // insert string value at offset 9
        str.insert(9, "ceshi");

        // prints StringBuilder after insertion
        System.out.print("After insertion = ");
        System.out.println(str.toString());

    }

    /**
     * @date 创建时间: 2019/6/25
     * @author lady_zhou
     * @Description 日期展示
     */
    private static void dateDemo() {
        String key = "aa";
        int h = key.hashCode();
        System.out.println(h);
        System.out.println((h) ^ (h >>> 16));

        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(Calendar.getInstance().getTime());

        Date date = new Date();
        System.out.println(date.getTime());

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String str = "2019-6-1";
            date = sdf.parse(str);

            System.out.println("date是：" + date + "\tlong" + date.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("测试：" + Calendar.getInstance().get(Calendar.MONTH));
    }
}
