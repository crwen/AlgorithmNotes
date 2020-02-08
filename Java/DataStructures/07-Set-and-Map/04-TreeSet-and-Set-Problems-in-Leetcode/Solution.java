import java.util.TreeSet;

/**
 * ClassName: Solution
 * Description: https://leetcode-cn.com/problems/unique-morse-code-words/
 * date: 2019/10/29 17:32
 *
 * @author crwen
 * @create 2019-10-29-17:32
 * @since JDK 1.8
 */
public class Solution {
	public int uniqueMorseRepresentations(String[] words) {
		TreeSet<String> set = new TreeSet<>();
		String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

		for (String word : words) {
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < word.length(); i++) {
				res.append(codes[word.charAt(i) - 'a']);
			}
			set.add(res.toString());
		}
		return set.size();
	}

}
