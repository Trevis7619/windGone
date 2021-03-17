package easy.数组;

/**
 *@author chenyijie
 *@Date  2021/3/14 8:33 下午
 *
 * 优化:异或 位运算
 *
 * 交换律/结合率
 * x^x=0 x^0=x
 */
public class 消失的数字 {

    public int missingNumber(int[] nums) {

        int length = nums.length;
        int sum = ((1+length)*length)/2;

        for(int temp:nums){
            sum=sum-temp;
        }
        return  sum;
    }

    public static void main(String[] args) {
        System.out.println(3 ^ 1);
    }
}
