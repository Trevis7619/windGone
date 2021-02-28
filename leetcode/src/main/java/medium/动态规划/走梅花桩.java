package medium.动态规划;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 动态规划 上升子序列 最长递增子序列
 * <p>
 * 动态规划条件:
 * 1.将大问题拆分为子问题
 * 2.大问题最终解依赖于子问题最终解
 * <p>
 * <p>
 * demo
 * 2 7 3 9
 * <p>
 * 2 -> dp=1
 * 7 -> 7>2  dp=dp[0]+1 = 2
 * 3 -> 3<7  dp=dp[1] = 2
 * 9 -> 9>3 dp=dp[2]+1 = 3
 */
public class 走梅花桩 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = null;
        while ((str = br.readLine()) != null) {

            String[] array = br.readLine().split(" ");

            int length = array.length;

            int[] dp = new int[length];
            int max = 1;
            for (int i = 0; i < length; i++) {

                if (i == 0) {
                    dp[0] = 1;
                } else {
                    dp[i] = 1;
                    for (int j = 0; j < i; j++) {
                        int temp;
                        if (Integer.parseInt(array[j]) < Integer.parseInt(array[i])) {
                            temp = dp[j] + 1;
                            dp[i] = Math.max(dp[i], temp);
                        }
                    }

                }
                max = Math.max(max, dp[i]);
            }

            System.out.println(max);
        }


    }
}
