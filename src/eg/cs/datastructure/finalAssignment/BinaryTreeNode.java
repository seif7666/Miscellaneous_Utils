package eg.cs.datastructure.finalAssignment;

public  class BinaryTreeNode {
    public Object element;
    public BinaryTreeNode left, right;


    public BinaryTreeNode (Object element) {
        this.element = element;
    }

    /**
     * Method to print sequence ascendingly.
     * @param root
     */
    public static void inorderPrint(BinaryTreeNode root){
        if(root.left!=null) {
            inorderPrint(root.left);
            System.out.print(" , ");
        }
        System.out.print(root.element);
        if(root.right!=null) {
            System.out.print(" , ");
            inorderPrint(root.right);
        }
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "element=" + element +
                '}';
    }
}
