
import java.util.*;

public class Solution {
    
   private class Freq{

        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }
    }

    private class FreqComparator implements Comparator<Freq> {

        @Override
        public int compare(Freq a, Freq b){
            return a.freq - b.freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());
        for(int key: map.keySet()){
            if(pq.size() < k)
                pq.add(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.peek().freq){
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(!pq.isEmpty())
            res.add(pq.remove().e);
        return res;
    }


}