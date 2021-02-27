package medium;

import java.util.Arrays;

/**
 * @author chenyijie
 * @Date 2021/2/24 9:33 上午
 * 合并两个已经排序过的数组
 */
public class 合并已排序数组 {

    public static void main(String[] args) {
        int[] a = {1, 3, 4};
        int[] b = {0, 5, 7, 9};

        int offsetA = 0;
        int offsetB = 0;

        int length = a.length + b.length;
        int[] c = new int[length];

        for (int i = 0; i < length; i++) {

            if (i - offsetA >= a.length) {
                c[i] = b[i - offsetB];
                continue;
            }
            if (i - offsetB >= b.length) {
                c[i] = a[i - offsetA];
                continue;
            }


            if (a[i - offsetA] <= b[i - offsetB]) {
                c[i] = a[i-offsetA];
                offsetB = offsetB + 1;
                continue;
            }
            if (b[i - offsetB] < a[i - offsetA]) {
                c[i] = b[i-offsetB];
                offsetA = offsetA + 1;

            }

        }
        System.out.println(Arrays.stream(c));
    }
}
