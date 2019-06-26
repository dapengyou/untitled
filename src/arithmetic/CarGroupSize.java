package arithmetic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lady_zhou
 * @date 创建时间: 2019/6/25
 * @Description 力扣  914. 卡牌分组
 */
public class CarGroupSize {
    private static int mCheck = 2;

    public static void main(String[] args) {

//        int[] num = {1, 2, 3, 4, 4, 3, 2, 1};
        int[] num = {1, 1, 1, 2, 2, 2, 3, 3};
//        int[] num = {0, 0, 0, 1, 1, 1, 2, 2, 2};
//        int[] num = {1, 1, 2, 2, 2, 2};
//        int[] num = {1, 1};

        System.out.println(hasGroupsSizeX(num));
    }

    public static boolean hasGroupsSizeX(int[] deck) {

        boolean isTrue = false;

        HashMap<Integer, Integer> map = new HashMap<>();

        int tempNum = 0;
        if (deck == null || deck.length < 2) {
            return false;
        }

        //将数组存入对应map
        for (int num : deck) {
            if (map.containsKey(num)) {
                tempNum = map.get(num) + 1;
                map.put(num, tempNum);
            } else {
                map.put(num, 1);
            }
        }


//        int size = map.size();
//        int[] tempvalues = new int[size];

        //判断是否符合条件
//        for (int key : map.keySet()) {
//            int value = map.get(key);
//            //存入数组
//            if (size > 0) {
//                tempvalues[size - 1] = value;
//                size--;
//            }
//
//            //数组排序
//            Arrays.sort(tempvalues);
//
//        }
//
//        for (int num : tempvalues) {
//            //递归求最大公约数
//            tempNum = getNum(num, tempvalues[0]);
//            if (tempNum >=2) {
//                isTrue = true;
//            } else {
//                isTrue = false;
//            }
//        }


        int tempKey = map.get(deck[0]);

        //判断是否符合条件
        for (int key : map.keySet()) {
            //递归求最大公约数
            tempNum = getNum(tempKey, map.get(key));

        }
        if (tempNum >= 2)
            return true;
        return false;

    }

    static int getNum(int m, int n)//递归实现
    {
//        int k, y;
//        if (m < n) {
//            k = m;
//            m = n;
//            n = k;
//        }
//        y = m % n;
//        if (y == 0) {
//            return n;
//        } else {
//            m = n;
//            n = y;
//            return getNum(m, n);
//        }

        int temp;
        if (m < n) {
            temp = m;
            m = n;
            n = temp;
        }

        return n == 0 ? m : getNum(n, m % n);
    }
}
