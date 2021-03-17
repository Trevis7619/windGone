package easy;

/**
 *@author chenyijie
 *@Date  2021/3/14 8:07 下午
 *
 * 优化:直接使用原数组减少内存使用
 */
public class 一维数组动态和 {

    public int[] runningSum(int[] nums) {

        int[] result = new int[nums.length];

        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }
}
