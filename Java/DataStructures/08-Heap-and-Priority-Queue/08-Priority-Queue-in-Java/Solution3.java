import java.util.PriorityQueue;
import java.util.*;

/**
 * ClassName: Solution
 * Description:
 * date: 2019/10/30 19:30
 *
 * @author crwen
 * @create 2019-10-30-19:30
 * @since JDK 1.8
 */
public class Solution3 {

	public List<Integer> topKFrequent(int[] nums, int k) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (Integer n : nums) {
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else {
				map.put(n, 1);
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,  b) -> map.get(a) - map.get(b));
		for (int key : map.keySet()) {
			if (pq.size() < k) {
				pq.add(key);
			} else {
				Integer front = pq.peek();
				if (map.get(front) < map.get(key)) {
					pq.remove();
					pq.add(key);
				}
			}
		}
		LinkedList<Integer> res = new LinkedList<>();
		while (!pq.isEmpty()) {
			res.add(pq.remove());
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {4,1,-1,2,-1,2,3};
		int k = 2;
		Solution3 res = new Solution3();
		List<Integer> arr = res.topKFrequent(nums, k);
		System.out.println(arr);
	}
}
