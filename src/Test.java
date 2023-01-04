import Easy.ValidParentheses;
public class Test {
    public static void main(String[] args) {
        String s = "()[]{}";
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.isValid(s));
        s = "((";
        System.out.println(solution.isValid(s));
    }
}
