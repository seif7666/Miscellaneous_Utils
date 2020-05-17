package eg.cs.datastructure.finalAssignment;

import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class MiscUtilsTest {

    private static MiscUtils utils=new MiscUtils();

    private static BinaryTreeNode tree,anotherTree;

    @BeforeClass
    public static void beforeClass(){
        tree=utils.insert(tree,10);
        utils.insert(tree,15);
        utils.insert(tree,12);
        utils.insert(tree,11);
        utils.insert(tree,9);
        utils.insert(tree,0);
        utils.insert(tree,3);
        BinaryTreeNode.inorderPrint(tree);
        System.out.println();
        //0 , 3 , 9 , 10 , 11 , 12 , 15
        anotherTree=new BinaryTreeNode(0);//0
        anotherTree.left=new BinaryTreeNode(-5);//-5,0
        anotherTree.left.left=new BinaryTreeNode(-7);//-7,-5,0
        anotherTree.left.left.left=new BinaryTreeNode(-6);//-6,-7,-5,0
    }

    @org.junit.Test
    public void insert() {
       assertNotNull(tree);

       assertEquals(tree.right.element,15);
       assertEquals(tree.right.left.element,12);
       assertEquals(tree.right.left.left.element,11);
       assertEquals(tree.left.left.right.element,3);
       try{
           utils.insert(tree,3);
       }
       catch (RuntimeException e){
           System.out.println("(In insert): It tests correct for not accepting duplicates!");
       }
    }

    @org.junit.Test
    public void sumRange() {
        int sum;
        sum=utils.sumRange(tree,3,10);
        assertEquals(sum,22);

        sum=utils.sumRange(tree,-100,100);
        assertEquals(sum,60);

        try{
            utils.sumRange(tree,10,10);
        }
        catch (RuntimeException ignored){}

        assertEquals(0,utils.sumRange(null,0,10));
    }

    @org.junit.Test
    public void isValidBST() {
        assertFalse(utils.isValidBST(anotherTree));
        assertTrue(utils.isValidBST(tree));
        try{
            utils.isValidBST(null);
        }catch (NullPointerException ignored){}
    }
    @org.junit.Test
    public void nextSmallerNumber() {
        int[] array=new int[]{10, 9, 2, 7, 6, 1, 2};
        assertArrayEquals(new int[]{1, 2, 5, 4, 5, -1, -1},utils.nextSmallerNumber(array));
        array=new int[]{3,5,7,4};
        assertArrayEquals(new int[]{-1,3,3,-1},utils.nextSmallerNumber(array));

        array=new int[]{3,5,7,4,2};
        assertArrayEquals(new int[]{4,3,3,4,-1},utils.nextSmallerNumber(array));

        try{
            utils.nextSmallerNumber(null);
            fail();
        }catch (RuntimeException ignored){}
    }

}