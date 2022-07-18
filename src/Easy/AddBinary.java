package Easy;

/*
*
* Given two binary strings a and b, return their sum as a binary string.
*
* 1 <= a.length, b.length <= 104
* a and b consist only of '0' or '1' characters.
* Each string does not contain leading zeros except for the zero itself.
*
*
* */

public class AddBinary {
    class Solution {
        public String addBinary(String a, String b) {

            char carry = '0';
            int i = a.length() - 1;
            int j = b.length() - 1;
            String result = "";

            while (i>=0 || j>=0){
                if (i>=0 && j>=0){
                    result = ((char)(a.charAt(i) ^ b.charAt(j) ^ carry)) + result;
                    //carry = (char) ( a.charAt(i) & b.charAt(j));
                    carry = (char) ( ((a.charAt(i) ^ b.charAt(j)) & carry) | (a.charAt(i) & b.charAt(j)));
                } else if (i>=0){
                    // j < 0
                    result = (a.charAt(i) ^ carry) + result;
                    carry = (char) (a.charAt(i) & carry);
                } else {
                    // i < 0
                    result = (b.charAt(j) ^ carry) + result;
                    carry = (char) (b.charAt(j) & carry);
                }

                j--;
                i--;
            }

            if (carry == '1')
                result = '1' + result;

            return result;
        } // addBinary

    } // Solution

    public String addBinary(String a, String b) {
        Solution solution = new Solution();
        return solution.addBinary(a,b);
    } // addBinary
}
