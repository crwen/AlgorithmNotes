
import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return res;
        boolean[] used = new boolean[nums.length];
        find(nums, 0, new ArrayList<Integer>(), used);
        return res;
    }

    private void find(int[] nums, int len, List<Integer> prefix, boolean[] used) {
        if (len >= nums.length) {
            res.add(prefix);
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                ArrayList<Integer> list = new ArrayList<>(prefix);
                list.add(nums[i]);
                used[i] = true;
                find(nums, len + 1, list, used);
                used[i] = false;
            }
            
        }
    }
}