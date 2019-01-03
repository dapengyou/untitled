package arithmetic;


import java.util.Arrays;

/**
 * @author lady_zhou
 * @date 创建时间: 2019/1/3
 * @Description 有两个排序的数组A1和A2，内存在A1的尾部有足够多的空间去容纳A2。实现一个函数是A2插入A1是有序的，且时间复杂度最小
 */
public class Class_01 {
    public static void main(String[] args) {
        int[] a = new int[]{10, 129, 379, 478, 890};
        int[] b = new int[]{20, 127, 479, 578, 690};

        int lena = a.length;
        int lenb = b.length;
        long startTime = System.nanoTime();
        merge(a, lena, b, lenb);

//        String string = replaceSpace(new StringBuffer("We Are Happy"));

        long endTime = System.nanoTime();

//        System.out.print("\n" + (endTime - startTime) + "\n" + string);
        System.out.print("\n" + (endTime - startTime) );

    }

    public static String replaceSpace(StringBuffer str) {

        return str.toString().replaceAll(" ", "%20");
    }

    private static void merge(int[] a, int lena, int[] b, int lenb) {

        int i = lena + lenb;
        int[] tmp = new int[i];
        int indexA = lena - 1;
        int indexB = lenb - 1;


        while (indexA >= 0 && indexB >= 0) {
            if (a[indexA] >= b[indexB]) {
                tmp[i - 1] = a[indexA];
                i--;
                indexA--;
            } else {
                tmp[i - 1] = b[indexB];
                i--;
                indexB--;
            }
        }

        while (indexA >= 0) {
            tmp[i] = a[indexA];
            i--;
            indexA--;

        }
        while (indexB >= 0) {
            tmp[i - 1] = b[indexB];
            i--;
            indexB--;
        }

        a = tmp;
        System.out.print(Arrays.toString(a));

    }

}
