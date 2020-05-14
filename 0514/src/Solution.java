import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            }else {
                if (stack.empty()) {
                    return false;
                }
                char ch1 = stack.pop();
                if (!((ch1 == '(' && chars[i] == ')') || (ch1 == '[' && chars[i] == ']')
                        || (ch1 == '{' && chars[i] == '}'))) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}