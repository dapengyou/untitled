package test;

import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        int[] number = new int[]{
                3, 8, 2, 4, 1, 9
        };

        selectionsort(number);
        return;

    }

    /**
     * 选择排序，无论什么数据进去都是O(n2)的时间复杂度
     *
     * @param number
     */
    private static void selectionsort(int[] number) {
        int len = number.length;
        int minIndex, temp;

        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (number[j] < number[minIndex]) {
                    minIndex = j;
                }
            }

            temp = number[i];
            number[i] = number[minIndex];
            number[minIndex] = temp;

            System.out.println(Arrays.toString(number));

        }

    }

}
