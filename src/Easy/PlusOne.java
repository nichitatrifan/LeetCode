package Easy;

/*
* You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
* The digits are ordered from most significant to least significant in left-to-right order.
* The large integer does not contain any leading 0's.
* Increment the large integer by one and return the resulting array of digits.
*
* 1 <= digits.length <= 100
* 0 <= digits[i] <= 9
* digits does not contain any leading 0's
* */



public class PlusOne {

    class Solution {
        public int[] plusOne(int[] digits) {

            int carry = 1;
            int index = digits.length - 1;

            while (carry == 1 && index >= 0){
                digits[index]++;
                carry = digits[index] / 10;
                digits[index] = digits[index] % 10;

                if (carry == 1 && index - 1 < 0){
                    int[] newArray = new int[digits.length + 1];
                    System.arraycopy(digits,0,newArray,1,digits.length);
                    digits = newArray;
                    digits[index] = carry;
                }
                index--;
            }

            return digits;
        }
    }

    public int[] plusOne(int[] digits){
        PlusOne.Solution solution = new PlusOne.Solution();
        return solution.plusOne(digits);
    } //

} // PlusOne
