package Trees;

/*
*   For a Complete Binary Tree Only
*
* 1. The data from the root always appears in the [0] component of the array.
* 2. Then the data for [i] node's parent is always at location [(i-1)/2] (using integer division).
* 3. [i] node's children (if they exist) always have their data at these locations:
*        Left child at component [2i+1]
*        Right child at component [2i+2]
*
*
* */

public class ArrayTree {
    int [] tree;
    int used;

    public ArrayTree(int size) throws IllegalArgumentException{
        if (size <= 0 ){
            throw new IllegalArgumentException("Tree size is invalid!");
        }

        this.tree = new int[size];
        this.used = 0;
    }

    public void doubleTreeSize(){
        int[] newTree = new int[this.tree.length*2];
        System.arraycopy(this.tree,0,newTree,0,this.tree.length);
        this.tree = newTree;
    } // doubleSize

    public int getParent(int child) throws IllegalArgumentException {
        if (child <= 0 || child >= this.used){
            throw new IllegalArgumentException("Invalid child's location");
        }
        return this.tree[(child-1)/2];
    } // getParent

    public int getLeftChild(int parent) throws Exception {
        if (parent < 0 || parent >= this.used){
            throw new IllegalArgumentException("Invalid parent's location");
        }

        if (2*parent+1 >= this.used){
            throw new Exception("This parent does not have a left child!");
        }

        return this.tree[2*parent+1];
    } // getLeftChild

    public int getRightChild(int parent) throws Exception {
        if (parent < 0 || parent >= this.used){
            throw new IllegalArgumentException("Invalid parent's location");
        }

        if (2*parent+2 >= this.used){
            throw new Exception("This parent does not have a right child!");
        }

        return this.tree[2*parent+2];
    } // getRightChild

    public void addValue(int target){
        if (this.used + 1 >= this.tree.length){
            this.doubleTreeSize();
        }

        this.tree[this.used] = target;
        this.used++;
    } // addValue

} // ArrayTree
