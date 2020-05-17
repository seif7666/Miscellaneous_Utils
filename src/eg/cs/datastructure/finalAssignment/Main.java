package eg.cs.datastructure.finalAssignment;


public class Main {

    public static void main(String[] args) {

        HashTableDictionary<String,String> table=new HashTableDictionary<>(0.4,10);

        table.set("18010832","Seif");
        table.set("18010720","Ziad");
        table.set("180120","HEllo");
        table.set("178541214","Omar");
        table.printSize();
        table.set("789204","Bruh");
        System.out.println(table.get("18010832"));
        System.out.println(table.set("18010832","1325"));
        System.out.println(table.set("18010720","111325"));

    }
}
