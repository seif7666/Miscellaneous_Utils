package eg.cs.datastructure.finalAssignment;


public class TreeDictionary<K extends Comparable<K>,V> implements IDictionary<K,V> {
    private ComparableBinaryTreeNode root;
    private int size;

    @Override
    public V get(K key) {
        checkNullity(key);
        ComparableBinaryTreeNode temp = getTree(key);
        if (temp != null) {
            System.out.println("Element returned is " + temp.value);
            return temp.value;
        }

        return null;
    }

    @Override
    public V set(K key, V value) {
        checkNullity(key);
        checkNullity(value);
        if (root == null) {
            root = new ComparableBinaryTreeNode(key, value);
            size++;
            System.out.println("\n\n");
            return null;
        }
        ComparableBinaryTreeNode temp = root;
        while (true) {
            int comparison = temp.key.compareTo(key);//x.compare(y)---->(x>y)or(x<y)
            if (comparison > 0) {//we move left
                if (temp.left == null) {
                    temp.left = new ComparableBinaryTreeNode(key, value);
                    System.out.println("Made on the Left of " + temp + "\n\n");
//                    System.out.println(temp.left);
                    size++;
                    return null;
                }
                temp = temp.left;
            } else if (comparison < 0) {
                if (temp.right == null) {
                    temp.right = new ComparableBinaryTreeNode(key, value);
                    System.out.println("Made on the right of " + temp + "\n\n");
//                    System.out.println(temp.right);
                    size++;
                    return null;
                }
                temp = temp.right;
            } else {//Equal
                V element = temp.value;
                temp.value = value;
                System.out.println("Element returned is " + element + "\t new tree is " + temp);
                return element;
            }
        }
    }

    /**
     * We need to get the parent tree for the node carrying the key.
     * Get the tree to be removed.
     * Get the right tree of that tree get it's leftmost.
     * If no right get left rightmost.
     *
     * @param key: key
     * 
     */
    @Override
    public V remove(K key) {
        checkNullity(key);
        if(root==null)
            return null;
        ComparableBinaryTreeNode parent=root;
        while(true){
            int comparison=parent.key.compareTo(key);
            if(comparison>0){
                if(parent.left==null)
                    return null;//Not found.
                if(parent.left.key.equals(key)){//Left is required
                    ComparableBinaryTreeNode toBeRemoved=parent.left;
                    if(toBeRemoved.right!=null){
                        ComparableBinaryTreeNode temp=toBeRemoved.right.getLeftMost();
                        temp.left=toBeRemoved.left;
                        parent.left=temp;//Most smaller branch in right of removed will carry in its left the left of removed.
                    }
                    else if(toBeRemoved.left!=null){
                        parent.left=toBeRemoved.left;
                    }
                    else{
                        parent.left=null;
                    }
                    return toBeRemoved.value;
                }
                else
                    parent=parent.left;
            }
            else if(comparison<0){//smaller
                if(parent.right==null)
                    return null;
                if(parent.right.key.equals(key)){
                    ComparableBinaryTreeNode toBeRemoved=parent.right;
                    if(toBeRemoved.right!=null){
                        ComparableBinaryTreeNode temp=toBeRemoved.right.getLeftMost();
                        temp.left=toBeRemoved.left;
                        parent.right=temp;//Most smaller branch in right of removed will carry in its left the left of removed.
                    }
                    else if(toBeRemoved.left!=null){
                        parent.right=toBeRemoved.left;
                    }
                    else{
                        parent.right=null;
                    }
                    return toBeRemoved.value;
                }
                else{
                    parent=parent.right;
                }
            }


            else{//Equal to each other
                V element=parent.value;
                if(parent.right!=null){
                    ComparableBinaryTreeNode temp= parent.right.getLeftMost();
                    temp.left= parent.left;
                    parent=parent.right;
                }
                else if(parent.left!=null){
                    parent=parent.left;
                }
                else{
                    parent=null;
                }
                return element;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    //////////////////////////////NodeClass//////////////////////////////////////////////////////////

    /**
     * The class for nodes of tree.
     */
    class ComparableBinaryTreeNode {
        /*
         * We need each node to carry a pointer to left,right.
         * 2 fields:Value and Key.
         */
        private K key;
        private V value;
        private ComparableBinaryTreeNode left, right;

        public ComparableBinaryTreeNode(K key, V value) {
            this.key = key;
            this.value = value;
            System.out.print("New tree of key= " + key + "\t value of " + value + "\t\t");
        }

        public void inorderPrint(ComparableBinaryTreeNode root) {
            if (root.left != null) {
                inorderPrint(root.left);
                System.out.print(" , ");
            }
            System.out.print(root);
            if (root.right != null) {
                System.out.print(" , ");
                inorderPrint(root.right);
            }
        }

        private  ComparableBinaryTreeNode getRightMost(){
            ComparableBinaryTreeNode temp=root;
            while(temp!=null){
                temp=temp.right;
            }
            return temp;

        }
        private ComparableBinaryTreeNode getLeftMost(){
            ComparableBinaryTreeNode temp=root;
            while(temp!=null){
                temp=temp.left;
            }
            return temp;

        }

        @Override
        public String toString() {
            return "ComparableBinaryTreeNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
    /////////////////////////ADDITIONAL////////////////////////////////////////////////////////////

    private void checkNullity(Object x) {
        if (x == null)
            throw new RuntimeException("Argument is null!");
    }

    private ComparableBinaryTreeNode getTree(K key) {
        ComparableBinaryTreeNode temp = root;
        while (temp != null) {
            int comparison = temp.key.compareTo(key);
            if (comparison > 0)
                temp = temp.left;

            else if (comparison < 0)
                temp = temp.right;
            else
                return temp;
        }
        return null;
    }

    public int size(){
        return size;
    }

}
