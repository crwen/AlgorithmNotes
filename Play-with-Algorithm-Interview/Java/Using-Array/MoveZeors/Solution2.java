package movezeros;

/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/7 20:46
 *
 * @author crwen
 * @create 2020-03-07-20:46
 * @since JDK 1.8
 */
public class Solution2 {
    public void moveZeroes(int[] nums) {
        int k = 0; //指向第一个非零元素

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i <nums.length; i++) {
            nums[i] = 0;
        }
    }
}
