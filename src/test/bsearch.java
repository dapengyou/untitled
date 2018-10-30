package test;

import java.util.Arrays;

/**
 * @author lady_zhou
 * @date 创建时间: 2018/10/29
 * @Description 二分法查找
 * <p>
 * 二分法查找只能用在有序的数组，并且插入、删除操作不频繁一次排序多次查找的场景中，数量小和大都不适合用二分法
 * 数量小用顺序查找就可以了，数量大需要连续的内存空间
 */
public class bsearch {
    public static void main(String[] args) {
        int[] number = new int[]{
                6, 9, 30, 2, 56, 4, 2, 1, 7, 3, 99, 32, 44
        };

        int mid = bsearch(quickSort(number), number.length, 2);

        System.out.println("查到的下标为：" + mid);
    }

    /**
     * 快排
     *
     * @param number
     */
    private static int[] quickSort(int[] number) {
        qsort(number, 0, number.length - 1);

        System.out.println(Arrays.toString(number));
        return number;
    }

    /**
     * @param arr  :数组
     * @param low  :第一位下标
     * @param high :最后一位下标
     * @return : void
     * @date 创建时间: 2018/10/30
     * @author lady_zhou
     * @Description 快排递归
     */
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

    /**
     * @param a     : 数组
     * @param n     : 数组长度
     * @param value : 给定值
     * @return : int
     * @date 创建时间: 2018/10/30
     * @author lady_zhou
     * @Description 二分法
     */
    public static int bsearch(int[] a, int n, int value) {
        //二分法变体1  查找第一个值等于给定值的元素
//        return bsearchChange1(a, 0, n - 1, value);
        //二分法变体2 查找最后一个值等于给定值的元素
//        return bsearchChange2(a, 0, n - 1, value);

        //二分法变体3 查找第一个大于等于给定值的元素
//        return bsearchChange3(a, 0, n - 1, value);

        //二分法变体4
        return bsearchChange4(a, 0, n - 1, value);

        //简单的二分法
//        return bsearchWhile(a, 0, n - 1, value);
//        return bsearchInternally(a, 0, n - 1, value);

    }

    //用循环来实现二分法

    public static int bsearchWhile(int[] a, int low, int high, int value) {
        while (low <= high) {
//            int mid = (low + high) / 2; //这种写法当low和high比较大时，两者之和有可能会溢出
            int mid = low + (high - low) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //用递归的方法来实现二分法
    public static int bsearchInternally(int[] a, int low, int high, int value) {

        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
//        int mid = low + ((high - low) >> 1);//这样写可以将性能优化到极致，但是我没看懂位运算

        if (a[mid] == value) {
            return mid;
        } else if (a[mid] > value) {
            return bsearchInternally(a, low, mid - 1, value);
        } else {
            return bsearchInternally(a, mid + 1, high, value);
        }

    }

    //查找第一个值等于给定值的元素
    public static int bsearchChange1(int[] a, int low, int high, int value) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || (a[mid - 1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;

    }

    //查找最后一个值等于给定值的元素
    public static int bsearchChange2(int[] a, int low, int high, int value) {

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == high || (a[mid + 1] != value)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }


        return -1;

    }

    //查找第一个大于等于给定值的元素
    public static int bsearchChange3(int[] a, int low, int high, int value) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((a[mid - 1] < value) || (mid == 0)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    //查找最后一个小于等于给定值的元素
    public static int bsearchChange4(int[] a, int low, int high, int value) {

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((a[mid + 1] > value) || (mid == high)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
}
