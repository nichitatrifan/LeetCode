package Trees;

public class BinaryTree {
    Node root;

    /*
     * if the new node's value is lower than the current node's, we go to the left child
     * if the new node's value is greater than the current node's, we go to the right child
     * when the current node is null, we've reached a leaf node and we can insert the new node in that position
     * */
    private Node addNodeRecursive(int targetValue, Node current){
        if (current == null){
            return new Node(targetValue);
        }

        if (targetValue < current.value){
            current.left = this.addNodeRecursive(targetValue, current.left);
        } else if (targetValue > current.value) {
            current.right = this.addNodeRecursive(targetValue, current.right);
        }

        return current;
    }

    public void insertNode(int value){
        Node current = root;
        this.addNodeRecursive(value, current);
    }
}
