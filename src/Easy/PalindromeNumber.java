package Easy;

// Runtime: 14 ms, faster than 60.41% of Java online submissions for Palindrome Number.
// Memory Usage: 44 MB, less than 78.12% of Java online submissions for Palindrome Number.

public class PalindromeNumber {
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0)
                return false;
            else if (x<10)
                return true;

            int number = 0;
            int initialValue = x;

            while(x!=0){;
                // we multiply by 10 to create a placeholder
                // we modulo the 'x' to get the last digit of the number
                number = number * 10 + x % 10;
                x = x/10;
            }

            return initialValue == number;
        } // isPalindrome
    } // Solution

    public boolean isPalindrome(int x){
        PalindromeNumber.Solution solution = new PalindromeNumber.Solution();
        return solution.isPalindrome(x);
    } // isPalindrome
} // PalindromeNumber
