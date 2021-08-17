package test;

import java.util.Arrays;

import static jdk.nashorn.internal.objects.Global.println;

/**
 * @author lady_zhou
 * @date 创建时间: 2019/3/11
 * @Description 冒泡排序
 */
public class bubbleSort {

    public static void main(String[] args) {
        int[] number = new int[]{
                3, 8, 2, 4, 1, 9
        };

        long startTime = System.currentTimeMillis();   //获取开始时间
        //冒泡排序
//        bubbleSort(number);

//        bubbleSort2(number);

        bubbleSort3(number, number.length);

        long endTime = System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

        return;
    }

    /**
     * 从大到小排列
     *
     * @param number
     */
    private static void bubbleSort2(int[] number) {
        boolean bChange = false; // 交换标志

        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number.length - 1; j++) {
                if (number[i] > number[j]) {
                    int temp = number[i];
                    number[i] = number[j];
                    number[j] = temp;
                    bChange = true;

                }
            }
            // 如果标志为false，说明本轮遍历没有交换，已经是有序数列，可以结束排序
            if (false == bChange)
                break;

            System.out.format("从大到小第 %d 趟：\n ", i);

            System.out.println(Arrays.toString(number));
        }

    }

    /**
     * 从小到大排列
     *
     * @param number
     */
    private static void bubbleSort(int[] number) {
        int temp = 0; // 用来交换的临时数
        boolean bChange = false; // 交换标志

        // 要遍历的次数
        for (int i = 0; i < number.length - 1; i++) {
            bChange = false;
            // 从后向前依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = number.length - 1; j > i; j--) {
                // 比较相邻的元素，如果前面的数大于后面的数，则交换
                if (number[j - 1] > number[j]) {
                    temp = number[j - 1];
                    number[j - 1] = number[j];
                    number[j] = temp;
                    bChange = true;
                }
            }

            // 如果标志为false，说明本轮遍历没有交换，已经是有序数列，可以结束排序
            if (false == bChange)
                break;

            System.out.format("从小到大第 %d 趟：\n ", i);

            System.out.println(Arrays.toString(number));
        }
    }


    private static void bubbleSort3(int[] number, int n) {
        boolean bChange = false; // 交换标志

        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            bChange = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (number[j] > number[j + 1]) {
                    int temp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = temp;
                    bChange = true;
                }
            }
            if (!bChange) break;
            System.out.format("从小到大第 %d 趟：\n ", i);

            System.out.println(Arrays.toString(number));
        }
    }
}
