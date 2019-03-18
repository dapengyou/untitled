package test;

import java.util.Arrays;

/**
 * @date 创建时间: 2019/3/18
 * @author  lady_zhou
 * @Description  快速排序（自己编写）
 */
public class quit {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 77, 8, 6, 9, 1, 20};
        sorts(nums);
    }

    private static void sorts(int[] nums) {
        qsort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    private static void qsort(int[] nums, int low, int hight) {
        if (low >= hight) {
            return;
        }

        int pivot = partition(nums, low, hight);        //将数组分为两部分
        qsort(nums, low, pivot - 1);                   //递归排序左子数组
        qsort(nums, pivot + 1, hight);                  //递归排序右子数组
    }

    private static int partition(int[] nums, int low, int hight) {
        int pivot = nums[hight];
        int i = low;

        for(int j = low; j < hight; ++j) {
            if (nums[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = nums[i];
                    nums[i++] = nums[j];
                    nums[j] = tmp;
                }
            }
            System.out.println(Arrays.toString(nums));

        }

        int tmp = nums[i];
        nums[i] = nums[hight];
        nums[hight] = tmp;

        System.out.println("i=" + i);
        return i;
    }
}
