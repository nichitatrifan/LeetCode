import java.util.*;
import Easy.TwoSum;


public class Test {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{1,2,3,4,5};
        int[] result = twoSum.twoSum(nums,7);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    } // main
}
