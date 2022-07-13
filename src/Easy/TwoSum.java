package Easy;

import java.util.*;

public class TwoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

            for(int i = 0; i < nums.length; i++){
                if (hashMap.containsKey(nums[i]) && hashMap.get(nums[i]) != null){
                    return new int[]{hashMap.get(nums[i]), i};
                } else {
                    hashMap.put(target - nums[i], i);
                }
            }

            return new int[]{0,0};
        } // twoSum

    } // Solution

    public int[] twoSum(int[] nums, int target){
        Solution solution = new Solution();
        return solution.twoSum(nums, target);
    }

} // TwoSum
