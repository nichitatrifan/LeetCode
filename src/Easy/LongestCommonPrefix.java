package Easy;

public class LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            // if there are no strings in the array return empty string
            if (strs.length == 0)
                return "";

            // initializing prefix as the first element of the array
            String prefix = strs[0];
            int minLen;
            int k;
            for (int i = 1; i < strs.length; i++){
                minLen = Math.min(prefix.length(), strs[i].length());
                k = 0;
                while (k < minLen){
                    if (prefix.charAt(k) == strs[i].charAt(k))
                        k += 1;
                    else
                        break;
                }
                prefix = prefix.substring(0, k);
                if (prefix.equals(""))
                    return "";
            }

            return prefix;
        }
    }

    public String longestCommonPrefix(String[] strs){
        Solution solution = new Solution();
        return solution.longestCommonPrefix(strs);
    }
}
