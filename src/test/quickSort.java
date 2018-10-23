package test;

import java.util.Arrays;

/**
 * 快排
 */
public class quickSort {
    public static void main(String[] args) {
        int[] number = new int[]{
                3, 8, 2, 4, 1, 9
        };

        quickSort(number);
        return;

    }

    /**
     * 快排
     *
     * @param number
     */
    private static void quickSort(int[] number) {
        qsort(number, 0, number.length - 1);

        System.out.println(Arrays.toString(number));
    }

    private static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot - 1);                   //递归排序左子数组
            qsort(arr, pivot + 1, high);                  //递归排序右子数组

        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];     //枢轴记录

        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];             //交换比枢轴小的记录到左端
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }
}
