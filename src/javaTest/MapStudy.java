package javaTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapStudy {
    public static void main(String[] args) {
        int[] arr = new int[]{1,9,28,24};
        int value  = 25;
        getNumber(arr,value);
    }

    private static void getNumber(int[] arr, int value) {
        Map map = new HashMap();
        for (int i = 0; i < arr.length ; i++) {
            map.put(value - arr[i], i);

        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            System.out.println(key + "　：" + map.get(key)+ map.keySet());
        }
    }
}

