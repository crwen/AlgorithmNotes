
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.empty()) return false;
                char peek = stack.pop();
                if (!match(peek, ch)) return false;
            }
        }
        if (!stack.empty())
            return false;
        return true;
    }
    
    public static boolean match(char ch1, char ch2) {
        if (ch1 == '(' && ch2 != ')')
            return false;
        if (ch1 == '[' && ch2 != ']')
            return false;
        if (ch1 == '{' && ch2 != '}')
            return false;
        
        return true;
    }
}