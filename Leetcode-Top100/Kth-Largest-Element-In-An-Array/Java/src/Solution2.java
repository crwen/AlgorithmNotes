
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/13 12:28
 *
 * @author crwen
 * @create 2020-03-13-12:28
 * @since JDK 1.8
 */
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k)
            throw new IllegalArgumentException("argument is illegal");
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.peek();
    }
}
