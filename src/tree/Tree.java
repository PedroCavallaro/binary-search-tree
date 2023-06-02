package tree;
public class Tree<T extends Comparable<T>>{
    private Node<T> root;
    private int size;
    public String steps = "";
    public Tree(){
        this.root = null;
        this.size = 0;
    }

    public void insert(T info){
        if(this.root == null){
            this.root = new Node<T>(info);
        }else{
            Node<T> temp = this.root;
            while(true){
                
                if(info.compareTo(temp.getInfo()) == 1){
                    if(temp.getRight() == null){
                        temp.setRight(new Node<T>(info));
                        temp.getRight().setTop(temp);
                        break;

                    }else{
                        temp = temp.getRight();
                    
                    }

                }else{
                    if(temp.getLeft() == null){
                        temp.setLeft(new Node<T>(info));
                        temp.getLeft().setTop(temp);

                        break;
                    }else{
                        temp = temp.getLeft();
                    } 
                }
            }
            this.size ++;
        }
    }
    public String search(T info){
        return recursiveSearch(this.root, info); 
    }

    private String recursiveSearch(Node<T> start, T info) {
       Node<T> temp = start;

        if((temp != null) && (info != null)){    
            if(temp.getInfo() == info){
            
                return steps;

            }else{

                if(info.compareTo(temp.getInfo()) == 1){
                    temp = temp.getRight();  
                    steps += temp.getInfo() + " - ";
                    
                    recursiveSearch(temp, info);

                }else{
                    temp = temp.getLeft();
                    steps += temp.getInfo() + " - ";
                    
                    
                    recursiveSearch(temp, info);    
                
                }
            }
        }
        return steps;
    }
    public T remove(T info, Node<T> start){
        Node<T> temp = start;

        if(temp.getInfo() == info){
            if(temp.getRight() != null);

        }
        return null;
    }
    public String findTheSmallestCall(){
        return findTheSmallest(this.root);
    }
    private String findTheSmallest(Node<T> start){
        String value = "";
        Node<T> temp = start;

        if(temp.getLeft() == null){
            System.out.println(temp.getInfo());
            value += temp.getInfo();
            return value;
        
        }else{
            temp = temp.getLeft();
            findTheSmallest(temp);
        }
        
        return value;
    } 
    public String findTheBiggestCall(){
        return findTheBiggest(this.root);
    }
    private String findTheBiggest(Node<T> start){
        String value = "";
        Node<T> temp = start;

        if(temp.getRight() == null){
            System.out.println(temp.getInfo());
            value += temp.getInfo();
            return value;
        
        }else{
            temp = temp.getRight();
            findTheBiggest(temp);
        }
        
        return value;
    } 
}



