package Tree;

public class Test {
    public static void main(String[] args) {
        //create a BST
        BST tree = new BST();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        //traverse tree
        System.out.println("Inorder (sorted): ");
        tree.inorder();
        System.out.println();
        tree.delete("Adam");
        tree.inorder();
    }
}
