
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/9 23:08
 *
 * @author crwen
 * @create 2020-03-09-23:08
 * @since JDK 1.8
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)) + 1, j);
            }
            map.put(s.charAt(i), i);
            ans = Math.max(ans, i - j +1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution solution = new Solution();
        int len = solution.lengthOfLongestSubstring(s);
        System.out.println(len);
    }
}
