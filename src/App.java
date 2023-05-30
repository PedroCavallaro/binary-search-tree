import tree.*;

public class App {
    public static void main(String[] args) throws Exception {
        Tree<Integer> tree = new Tree<Integer>();

        tree.insert(50);
        tree.insert(40);
        tree.insert(60);
        tree.insert(45);
        tree.insert(39);
        tree.insert(65);
        tree.insert(100);
        tree.insert(75);
        tree.insert(20);
        tree.insert(23);
        tree.insert(19);
        tree.insert(18);
        
        System.out.println(tree.findTheSmallestCall());
        System.out.println(tree.findTheBiggestCall());
        System.out.println(tree.search(100));
    }
}
