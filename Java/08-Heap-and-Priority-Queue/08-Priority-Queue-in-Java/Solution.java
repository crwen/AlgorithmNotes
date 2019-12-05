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
public class Solution {
	private class Freq implements Comparable<Freq>{
		public int e, freq;

		public Freq(int e, int freq) {
			this.e = e;
			this.freq = freq;
		}
		@Override
		public int compareTo(Freq another) {
			if (this.freq > another.freq)
				return 1;
			else if (this.freq < another.freq)
				return -1;
			else
				return 0;
		}
	}

	private class FreqComparator implements Comparator<Freq> {

		@Override
		public int compare(Freq a, Freq b) {
			return a.freq - b.freq;
		}
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (Integer n : nums) {
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else {
				map.put(n, 1);
			}
		}

		PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());

		for (int key : map.keySet()) {
			if (pq.size() < k) {
				pq.add(new Freq(key, map.get(key)));
			} else {
				Freq front = pq.peek();
				if (front.freq < map.get(key)) {
					pq.remove();
					pq.add(new Freq(key, map.get(key)));
				}
			}
		}

		LinkedList<Integer> res = new LinkedList<>();
		while (!pq.isEmpty()) {
			res.add(pq.remove().e);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {4,1,-1,2,-1,2,3};
		int k = 2;
		Solution res = new Solution();
		List<Integer> arr = res.topKFrequent(nums, k);
		System.out.println(arr);
	}
}
