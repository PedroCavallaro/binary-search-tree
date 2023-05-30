package tree;
public class Node<T>{
    private Node<T> left;
    private Node<T> right;
    private Node<T> top;
    private T info;
    
    public Node(T info) {
        this.left = null;
        this.right = null;
        this.top = null;
        this.info = info;
    }
    public Node<T> getLeft() {
        return left;
    }
    public void setLeft(Node<T> left) {
        this.left = left;
    }
    public Node<T> getRight() {
        return right;
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }
    public Node<T> getTop() {
        return top;
    }
    public void setTop(Node<T> top) {
        this.top = top;
    }
    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }



}