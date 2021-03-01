package medium.动态规划;

/**
 * @author chenyijie
 * @Date 2021/3/1 10:39 下午
 * <p>
 * 动态规划
 * 一共n阶,最后一步有爬一步和爬两步两种走法; 即 dp[n]=dp[n-1]+dp[n-2]
 */
public class 爬楼梯 {

    public int climbStairs(int n) {

        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        //dp[i]保存第n阶台阶有几种爬法
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        爬楼梯 p = new 爬楼梯();
        System.out.println(p.climbStairs(5));
    }


}
