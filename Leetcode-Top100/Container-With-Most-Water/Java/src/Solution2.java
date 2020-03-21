
/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/22 0:34
 *
 * @author crwen
 * @create 2020-03-22-0:34
 * @since JDK 1.8
 */
public class Solution2 {
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0, j = height.length - 1; i < j ; ) {
            maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return maxarea;
    }
}
