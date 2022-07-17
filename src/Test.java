import Easy.TwoSum;
import Easy.PlusOne;
import Trees.ArrayTree;

public class Test {
    public static void main(String[] args) {
        ArrayTree testTree = new ArrayTree(10);
        testTree.addValue(0);
        testTree.addValue(1);
        testTree.addValue(2);
        testTree.addValue(3);
        testTree.addValue(4);
        try {
            System.out.println(testTree.getLeftChild(0));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    } // main
}
