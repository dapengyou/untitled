package javaTest;

import java.util.HashMap;

/**
 * @date 创建时间: 2019/5/17
 * @author  lady_zhou
 * @Description  执行 continue next； 语句，跳转到 next： 标号标记的外层循环，也就是结束外层循环
 * 的当次循环，进入外层循环的下一次循环；执行 break next; 语句，则跳转到next标记的外层循环，结束外层循环
 *
 * next  这个标记名可以自己任意取名，相互对应即可
 */
public class ForTest {
    public static void main(String[] args) {
        for (int i = 1; i < 2; i++) {
            System.out.println("第一层循环");
            for (int j = 1; j < 3; j++) {
                System.out.println("第二层循环");
            next:
                for (int k = 1; k < 3; k++) {
                    System.out.println("第三层循环");
                    for (int l = 1; l < 3; l++) {
                        System.out.println("第四层循环");

                        break next;
//                        continue next;
                    }
                }
            }
        }
    }
}
