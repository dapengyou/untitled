package test;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] number = new int[]{
                3, 8, 2, 4, 1, 9
        };

        merge_sort(number, number.length);

        System.out.println("排序结果:" + Arrays.toString(number));

        return;
    }

    public static void merge_sort(int[] number, int size) {
        merge_sort_c(number, 0, size - 1);
    }

    private static void merge_sort_c(int[] number, int first, int last) {

        //递归终止条件
        if (first >= last) {
            return;
        }

        //取到中间位置
        int middle = (first + last) / 2;

        //分治递归
        merge_sort_c(number, first, middle);
        merge_sort_c(number, middle + 1, last);

        //合并
        merge(number, first, middle, last);

    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }


        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }
    }
}
