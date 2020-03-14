
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] bucket = new int[nums.length + 1];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]] = 1;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (bucket[i] != 1)
                list.add(i);
        }

        return list;        
    }
}