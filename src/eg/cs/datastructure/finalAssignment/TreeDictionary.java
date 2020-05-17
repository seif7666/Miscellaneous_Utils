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

    @Override
    public V remove(K key) {
        checkNullity(key);
        ComparableBinaryTreeNode temp = getTree(key);
        if (temp != null) {
            V element = temp.value;
            temp.value = null;
            size--;
            System.out.println("Element returned is " + element + "\t new tree is " + temp);
            return element;
        }
        return null;
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
