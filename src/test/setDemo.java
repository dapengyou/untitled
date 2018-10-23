package test;

import java.text.Collator;
import java.util.*;

public class setDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("李辉");
        set.add("王建");
        set.add("恒龙");
        set.add("紫熏");
        set.add("华宇");
        set.add("华宇");
        set.add("千雪");

//        circulation(set);

        dataSort(set);

    }

    /**
     * 两种排序
     *
     * @param set
     */
    private static void dataSort(Set<String> set) {
        List<String> list = new ArrayList<>();

        //使用循环将set中的值添加入list中
        for (String str : set) {
            list.add(str);
        }

        // Collator 类是用来执行区分语言环境的 String 比较的，这里选择使用CHINA
        Comparator comparator = Collator.getInstance(java.util.Locale.CHINA);

        //排序list
        Collections.sort(list,comparator);
        System.out.println(list);

        System.out.println("------------显示另一种排序的方法--------------");

        TreeSet treeSet = new TreeSet(set);
        treeSet.comparator();
        System.out.println(treeSet);
    }

    /**
     * 两种循环方法
     */
    private static void circulation(Set<String> set) {

        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }

        System.out.println("------------显示另一种循环的方法--------------");

        for (String str : set) {
            System.out.println(str);
        }
    }
}
