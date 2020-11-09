//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 深度优先搜索 
// 👍 563 👎 0

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        if (s == null || s == "")
            return s;
        Stack<String> strStack = new Stack<>();
        Stack<Integer> digitalStack = new Stack<>();
        char[] arr = s.toCharArray();
        int digital = 0;
        for (int i = 0; i < arr.length; i ++) {

            while (arr[i] >= '0' && arr[i] <= '9') {
                digital = digital * 10 + (arr[i] - '0');
                i++;
            }

            if (digital !=  0) {
                digitalStack.push(digital);
                digital = 0;
            }
            char ch = arr[i];

            if (ch != ']'){
                strStack.push(ch + "");
            } else { // ']'
                StringBuffer sb = new StringBuffer();
                String str = "";
                while (!(str = strStack.pop()).equals("[")) {
                    sb.append(str);
                }
                //System.out.println(sb.toString());
                //sb = sb.reverse();
                StringBuffer res = new StringBuffer();
                int mult = digitalStack.pop();
                //System.out.println(mult);
                for (int j = 0; j < mult; j++) {
                    res.append(sb);
                }
                //System.out.println(res.toString());
                strStack.push(res.toString());
            }
        }
        StringBuffer res = new StringBuffer();
        while (!strStack.isEmpty()) {
            res.append(strStack.pop());
        }

        return res.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
