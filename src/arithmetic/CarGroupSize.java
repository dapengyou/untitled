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

        if (deck.length <= 1)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : deck) {
            if (!map.containsKey(x))
                map.put(x, 1);
            else
                map.put(x, map.get(x) + 1);

        }
        int p = map.get(deck[0]);
        for (int y : map.keySet()) {
            p = help(p, map.get(y));
        }
        if (p >= 2)
            return true;
        return false;

    }

    private static int help(int a, int b) {
        int temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        return b == 0 ? a : help(b, a % b);
    }
}
