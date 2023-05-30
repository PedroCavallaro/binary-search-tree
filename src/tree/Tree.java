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

                if(temp.getInfo().compareTo(info) == 1){
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

    public String recursiveSearch(Node<T> start, T info) {
       Node<T> temp = start;

        if(temp.getInfo() == info){
            steps += temp.getInfo();
            return steps;

        }else{

            if(temp.getInfo().compareTo(info) == 1){
                temp = temp.getRight();  
                steps += temp.getInfo() + " - ";
                
                recursiveSearch(temp, info);

            }else{
                temp = temp.getLeft();
                steps += temp.getInfo() + " - ";
                recursiveSearch(temp, info);    
            
            }
        }
        return steps;
    }
}