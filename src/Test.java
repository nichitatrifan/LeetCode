import Easy.TwoSum;
import Easy.PlusOne;


public class Test {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        PlusOne plusOne = new PlusOne();
        int[] nums = new int[]{1,2,3,4,5};
        int[] result = plusOne.plusOne(new int[]{9,9});
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    } // main
}
