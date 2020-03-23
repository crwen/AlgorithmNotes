
/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/23 16:45
 *
 * @author crwen
 * @create 2020-03-23-16:45
 * @since JDK 1.8
 */

/*
对于每根柱子，找到其左边的最大值，右边的最大值，
然后两者中的较小的减去本根柱子的高度，就是本根柱子上能存放的雨水。
 */
public class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 0; i < height.length; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < size; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }

        return ans;
    }
}
