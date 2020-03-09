
/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/9 22:28
 *
 * @author crwen
 * @create 2020-03-09-22:28
 * @since JDK 1.8
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] sub = new int[256];
        int len = 0;

        int j = 0;
        int i = 0;
        for (; i < s.length(); ) {
            if ( sub[s.charAt(i)] == 0)
                sub[s.charAt(i ++)] ++;
            else
                sub[s.charAt(j ++)] --;

            len = (i - j) > len ? (i - j) : len;
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution solution = new Solution();
        int len = solution.lengthOfLongestSubstring(s);
        System.out.println(len);
    }
}
