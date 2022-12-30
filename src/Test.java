import Easy.LongestCommonPrefix;
public class Test {
    public static void main(String[] args) {
        String[] arr = new String[]{"flower", "floor", "fool"};
        String prefix = new LongestCommonPrefix().longestCommonPrefix(arr);
        System.out.println(prefix);
    }
}
