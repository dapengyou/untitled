package test;

import java.util.*;

public class listDemo {
    public static void main(String[] args) {
        distinct1();
        distinct2();
        distinct3();
        distinct4();
        distinct5();
        distinct6();
    }


    /**
     * list循环双重去重
     * <p>
     * 先遍历原数组，然后遍历结束集，通过每个数组的元素和结果集中的元素进行比对，
     * <p>
     * 若相同则break。
     * <p>
     * 若不相同，则存入结果集，两层循环进行遍历得出最终结果。
     */
    private static void distinct1() {
        String[] array = {"a", "b", "c", "c", "d", "e", "e", "e", "a"};
        List<String> result = new ArrayList<>();
        boolean flag;
        for (int i = 0; i < array.length; i++) {
            flag = false;
            for (int j = 0; j < result.size(); j++) {
                if (array[i].equals(result.get(j))) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result.add(array[i]);
            }
        }
        String[] arrayResult = (String[]) result.toArray(new String[result.size()]);
        System.out.println("distinct1" + Arrays.toString(arrayResult));
    }

    /**
     * 使用indexOf方法进行判断结果集中是否存在了数组元素去重
     */
    private static void distinct2() {
        String[] array = {"a", "b", "c", "c", "d", "e", "e", "e", "a"};
        List<String> list = new ArrayList<>();
        list.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            // 返回列表中首次出现指定元素的索引,如果列表不包含此元素,则返回 -1
            if (list.toString().indexOf(array[i]) == -1) {
                list.add(array[i]);
            }
        }
        String[] arrayResult = (String[]) list.toArray(new String[list.size()]);
        System.out.println("distinct2" + Arrays.toString(arrayResult));
    }

    /**
     * 嵌套循环去重
     */
    private static void distinct3() {
        String[] array = {"a", "b", "c", "c", "d", "e", "e", "e", "a"};
        List<String> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    j = ++i;
                }
            }
            list.add(array[i]);
        }
        String[] arrayResult = (String[]) list.toArray(new String[list.size()]);
        System.out.println("distinct3" + Arrays.toString(arrayResult));
    }

    /**
     * sort排序，相邻比较去重
     */
    private static void distinct4() {
        String[] array = {"a", "b", "c", "c", "d", "e", "e", "e", "a"};
        Arrays.sort(array);
        List<String> list = new ArrayList<>();
        list.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (!array[i].equals(list.get(list.size() - 1))) {
                list.add(array[i]);
            }
        }
        String[] arrayResult = (String[]) list.toArray(new String[list.size()]);
        System.out.println("distinct4" + Arrays.toString(arrayResult));

    }

    /**
     * set方法无序排列去重
     */
    private static void distinct5() {
        String[] array = {"a", "b", "c", "c", "d", "e", "e", "e", "a"};
        Set<String> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        String[] arrayResult = (String[]) set.toArray(new String[set.size()]);
        System.out.println("distinct5" + Arrays.toString(arrayResult));

    }

    /**
     * 利用Iterator遍历，remove方法移除去重
     */
    private static void distinct6() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(1);
        List<Integer> listTemp = new ArrayList<Integer>();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int a = it.next();
            if (listTemp.contains(a)) {
                it.remove();
            } else {
                listTemp.add(a);
            }
        }
        System.out.println("-----------distinct6-----------");

        for (Integer i : list) {
            System.out.println(i);
        }

    }


}
