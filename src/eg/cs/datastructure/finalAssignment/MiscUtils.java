package eg.cs.datastructure.finalAssignment;

import java.util.InputMismatchException;

public class MiscUtils implements IMiscUtils {



    @Override
    public  BinaryTreeNode insert(BinaryTreeNode root,int element) {
        if (root == null) {
            root = new BinaryTreeNode(element);
            return root;
        }
        BinaryTreeNode temp = root;
        while (true) {
            int number = isNumber(temp.element);
            if (number > element)//move left
            {
                if (temp.left == null) {
                    temp.left = new BinaryTreeNode(element);
                    return root;
                }
                temp = temp.left;
            } else if (number < element) {//move right
                if (temp.right == null) {
                    temp.right = new BinaryTreeNode(element);
                    return root;
                }
                temp = temp.right;
            } else {//Equal
                throw new RuntimeException("Binary tree must not contain duplicates!");
            }
        }
    }


    /**
     * Returns the sum of the elements in the tree in
     * the specified range [low, high] inclusive.
     *
     * @param root : BST root, a valid BST of integers.
     * @param low  : range lower limit.
     * @param high : range upper limit.
     */
    @Override
    public int sumRange(BinaryTreeNode root, int low, int high) {
        if(low>=high)
            throw new RuntimeException("Enter valid Intervals!");
        if(root==null)
            return 0;
        int sum=0;
        int number=isNumber(root.element);
        if(number<low)
            sum+=sumRange(root.right, low, high);
        else if(number>high)
            sum+=sumRange(root.left, low, high);
        else{
            //Inside interval.
            sum+=number+sumRange(root.right, low, high)+sumRange(root.left, low, high);
        }
        return sum;
    }



    /**
     * Returns true if the input is a valid BST, false otherwise
     *
     * @param root : Tree root.
     */
    @Override
    public boolean isValidBST(BinaryTreeNode root) {
        if(root==null)
            throw new NullPointerException("BinaryTreeNode is not referenced!");
        boolean smaller,bigger;
        if(root.right!=null){
            if(isNumber(root.element)>isNumber(root.right.element))
                return false;
            bigger=isValidBST(root.right);
        }
        else{
            bigger=true;
        }
        if(root.left!=null){
            if(isNumber(root.element)<isNumber(root.left.element))
                return false;
            smaller=isValidBST(root.left);
        }
        else {
            smaller=true;
        }
        return smaller&&bigger;
    }

    /**
     * Given an array of integers, return an array containing
     * the indices of the next smaller number of every number
     * or -1 if the next smaller number does not exist. .
     *
     * @param array : array of numbers.
     * @throws: throws an exception in the input array is null.
     */
    @Override
    public int[] nextSmallerNumber(int[] array) {
         // First we will add the array to a binary tree of array indexes.

        if(array==null)
            throw new RuntimeException("Array is null!");
        BinaryTreeNode tree=new BinaryTreeNode(0);
        for (int i=1;i<array.length;i++){
            insert(tree,i,array);
        }
        int[] newArr=new int[array.length];
        for(int i=0;i<newArr.length;i++){
            newArr[i]=getSmaller(tree,i,array);

        }
        return newArr;
    }






    ///////////////Additional//////////////////////////////////////////
    private int isNumber(Object element){
        String x=element+"";
        int xx;
        try{
            xx=Integer.parseInt(x);
        }
        catch(InputMismatchException e){
            throw new RuntimeException("Input tree is not of integers!");
        }
        return xx;
    }

    private int getSmaller(BinaryTreeNode root,int index,int[]arr) {
        if(root==null)
            return -1;
        int number=isNumber(root.element);
        if(arr[number]<=arr[index]) {
            if(number>index&&arr[number]<arr[index])
                return number;
            int right;
            right=getSmaller(root.right,index,arr);
            if(right==-1){
                return getSmaller(root.left,index,arr);
            }
            return right;
        }
        if(arr[number]>arr[index]) {
            return getSmaller(root.left,index,arr);
        }
        return -1;
    }

    private void insert(BinaryTreeNode root,int index,int[]array) {
        BinaryTreeNode temp = root;
        while (true) {
            int number = array[isNumber(temp.element)];
            if (number >= array[index]) {// Move Left
                if (temp.left == null) {
                    temp.left = new BinaryTreeNode(index);
                    return;
                }
                temp = temp.left;
            }
            else{//Move right
                if(temp.right==null){
                    temp.right = new BinaryTreeNode(index);
                    return;
                }
                temp=temp.right;
            }
        }
    }


}
