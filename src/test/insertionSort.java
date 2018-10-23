package test;

import java.util.Arrays;

/**
 * @author lady_zhou
 * @date 创建时间: 2018/10/10
 * @Description 插入排序
 */
public class insertionSort {
    public static void main(String[] args) {
        int[] number = new int[]{
                3, 8, 2, 4, 1, 9
        };

        insertionSort(number);
        return;

    }

    /**
     * 插入排序，
     *
     * @param number
     */
    private static void insertionSort(int[] number) {
        int len = number.length;
        int preIndex, current;

        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = number[i];
            while (preIndex >= 0 && number[preIndex] > current) {
                number[preIndex + 1] = number[preIndex];
                preIndex--;
            }

            number[preIndex + 1] = current;

            System.out.println(Arrays.toString(number));

        }

    }


}
