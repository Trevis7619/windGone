package medium.动态规划;

public class 买卖股票 {

    public static void main(String[] args) {

        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        //历史最低价
        int min = prices[0];
        //dp数组最大值
        int max = 0;
        for (int i = 1; i <= prices.length; i++) {

            min = Math.min(min, prices[i - 1]);
            max = Math.max(max, prices[i - 1] - min);
        }

        System.out.println(max);


    }
}
