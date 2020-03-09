
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Solution3
 * Description:
 * date: 2020/3/9 23:21
 *
 * @author crwen
 * @create 2020-03-09-23:21
 * @since JDK 1.8
 */
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, res = 0;
        Set<Character> set = new HashSet<Character>();

        for (int j = 0; j < s.length(); ) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                res = Math.max(res, j - i);
            }
        }
        return res;
    }
}