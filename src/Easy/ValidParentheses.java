package Easy;

import java.util.ArrayList;

public class ValidParentheses {
    /*
    * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']'.
    * Determine if the input string is valid.
    * */
    class Solution {
        public boolean isValid(String s) {
            int strLen = s.length();

            if (strLen % 2 != 0)
                return false;

            int stackLen = 0;
            ArrayList<Character> stack = new ArrayList<Character>();
            Character topChar;

            for(int i = 0; i < strLen; i++){
                if (s.charAt(i) == '(')
                    stack.add(')');
                else if (s.charAt(i) == '{') {
                    stack.add('}');
                } else if (s.charAt(i) == '[') {
                    stack.add(']');
                } else {
                    stackLen = stack.size();
                    if (stackLen == 0)
                        return false;
                    topChar = stack.remove(stackLen - 1);
                  if (s.charAt(i) != topChar.charValue())
                      return false;
                }

            }
            stackLen = stack.size();
            if (stackLen != 0)
                return false;
            else
                return true;
        }
    }

    public boolean isValid(String s){
        Solution solution = new Solution();
        return solution.isValid(s);
    }
}
