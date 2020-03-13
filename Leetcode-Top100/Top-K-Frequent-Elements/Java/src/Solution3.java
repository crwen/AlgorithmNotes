
import java.util.*;

/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/13 13:49
 *
 * @author crwen
 * @create 2020-03-13-13:49
 * @since JDK 1.8
 */
public class Solution3 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        for (int key : map.keySet()) {
            queue.add(key);
        }

        List<Integer> topK = new ArrayList<>();
        while (k-- > 0) {
            topK.add(queue.poll());
        }

        return topK;
    }

}
