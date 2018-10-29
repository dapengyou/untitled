package test;

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

    }

    public int bsearch(int[] a, int n, int value) {

        return bsearchWhile(a, 0, n - 1, value);
//        return bsearchInternally(a, 0, n - 1, value);

//        int low = 0;
//        int high = n - 1;
//
//        while (low <= high) {
////            int mid = (low + high) / 2; //这种写法当low和high比较大时，两者之和有可能会溢出
//            int mid = low + (high - low) / 2;
//            if (a[mid] == value) {
//                return mid;
//            } else if (a[mid] > value) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//        return -1;
    }

    //用循环来实现二分法

    public int bsearchWhile(int[] a, int low, int high, int value) {
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
    public int bsearchInternally(int[] a, int low, int high, int value) {

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
}
