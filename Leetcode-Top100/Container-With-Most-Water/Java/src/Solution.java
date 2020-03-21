
/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/22 0:33
 *
 * @author crwen
 * @create 2020-03-22-0:33
 * @since JDK 1.8
 */
public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int len = j - i;
                int h = height[i] < height[j] ? height[i] : height[j];
                res = res > len * h ? res : len * h;
            }
        }
        return res;
    }
}
