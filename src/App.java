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
        

        System.out.println("Maximo: " + tree.findB2(null));
        System.out.println("Minimo: " + tree.findS2(null));
        System.out.println(tree.search(18));
        tree.remove(60, null);
        // System.out.println(tree.findB2(null));
        System.out.println("Direita: " + tree.printLeft());
        System.out.println("Esquerda: "+ tree.printRight());

        
    }
}
