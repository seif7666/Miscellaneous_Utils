package eg.cs.datastructure.finalAssignment;



public class Main {

    public static void main(String[] args) {

//        HashTableDictionary<String,String> table=new HashTableDictionary<>(0.4,10);
//
//        table.set("18010832","Seif");
//        table.set("18010720","Ziad");
//        table.set("180120","HEllo");
//        table.set("178541214","Omar");
//        table.printSize();
//        table.set("789204","Bruh");
//        System.out.println(table.get("18010832"));
//        System.out.println(table.set("18010832","1325"));
//        System.out.println(table.set("18010720","111325"));

//        TreeDictionary<String,String> tree=new TreeDictionary<>();
//        tree.set("18010832","Seif");
//        tree.set("1801720","Omar");
//        tree.printTree();
//        System.out.println();
////        System.out.println("The removed is "+tree.remove("18010832"));
//        tree.get("1801720");
//        tree.set("18010832","Added again");
//        tree.remove("18010832");
//        tree.set("1111","Dalia");
//        tree.printTree();
//        System.out.println();
//        tree.set("10000","Bruh");
//        tree.printTree();
//        System.out.println();
//        tree.set("145678","Wael");
//        tree.remove("1801720");
//        tree.printTree();
//        System.out.println();

        TreeDictionary<Integer,String> tree=new TreeDictionary<>();
        tree.set(10,"seif");
        tree.remove(10);
        tree.set(10,"seif");
        tree.set(12,"El");
        tree.set(11,"Din0");

    }
}
