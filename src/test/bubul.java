package test;

import java.util.Arrays;

/**
 * @date 创建时间: 2019/3/18
 * @author  lady_zhou
 * @Description  冒泡排序（自己编写）
 */
public class bubul {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 77, 8, 6, 9, 1, 20};
        sort(nums);
        sort2(nums);
    }

    private static void sort2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
                System.out.println("从小到大" + i + Arrays.toString(nums));
            }

        }
    }

    private static void sort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length - 1; j++) {
                if (num[i] > num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
                System.out.println("从大到小" + i + Arrays.toString(num));
            }
        }

    }


}
