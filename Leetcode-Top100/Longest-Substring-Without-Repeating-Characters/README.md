
**[题目传送门](https://leetcode.com/problems/longest-substring-without-repeating-characters/)**

**题目描述**

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。



**示例1**
```html
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

**示例2:**
```html
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

**示例3:**
```html
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```


滑动窗口，定义快慢指针。利用字符种数较少的特性，可以创建一个数组来计数。

```java
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
}
```

也可以使用 set 集合来实现

```java
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
```


如果 s[j] 在 [j, i) 范围内有与 s[j] 重复的字符 s[i']，我们不需要逐渐增加 i，可以直接跳过 [i...i']。

我们可以使用一个Map来存储数组元素于下标的映射关系。但是这样就存在一个问题，那就是跳过去的那些元素仍让存在于 map 中，当我们再次碰到他们时该怎么办呢？这是我们需要判断一下，当下标值小于慢指针，说明这是我们跳过去的元素，也就是说我们不需要更新指针；当下标值大于慢指针时，说明我们发现重复元素了。

```java
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

```