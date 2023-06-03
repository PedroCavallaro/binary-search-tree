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
                
                if(info.compareTo(temp.getInfo()) > 0   ){
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

                if(info.compareTo(temp.getInfo()) > 0){
                    temp = temp.getRight();  
                    steps += temp.getInfo() + "  ";
                    
                    recursiveSearch(temp, info);

                }else{
                    temp = temp.getLeft();
                    steps += temp.getInfo() + "  ";
                    
                    
                    recursiveSearch(temp, info);    
                
                }
            }
        }
        return steps;
    }
    // Maior e menor de forma recursiva
    // public Node<T> findTheSmallestCall(Node<T> start){
    //     return findTheSmallest(start);
    // }
    // private Node<T> findTheSmallest(Node<T> start){
    //     String value = "";
    //     Node<T> temp = start;

    //     if(temp.getLeft() == null){
    //         System.out.println(temp.getInfo());
    //         value += temp.getInfo();
    //         return temp;
        
    //     }else{
    //         temp = temp.getLeft();
    //         findTheSmallest(temp);
    //     }
        
    //     return temp;
    // } 
    // public Node<T> findTheBiggestCall(Node<T> start){
    //     return findTheBiggest(start);
    // }
    // public Node<T> findTheBiggest(Node<T> start){
    //     String value = "";
    //     if(start == null){
    //         start = this.root;
    //     }
    //     Node<T> temp = start;

    //     if(temp.getRight() == null){
    //         System.out.println(temp.getInfo());
    //         value += temp.getInfo();
    //         return temp;
        
    //     }else{
    //         temp = temp.getRight();
    //         findTheBiggest(temp);
    //     }
        
    //     return temp;
    // } 

    public Node<T> remove(T info, Node<T> temp){
        if(this.root == null){
            return null;
        }
        if(temp == null){
            temp = this.root;
        }

        if(info.compareTo(temp.getInfo()) < 0){
            temp.setLeft(remove(info, temp.getLeft()));
        
        }else if(info.compareTo(temp.getInfo()) > 0){
            temp.setRight(remove(info, temp.getRight()));
        
        }else{

            if(temp.getLeft() == null){
                return temp.getRight();

            }else if(temp.getRight() == null){
                return temp.getLeft();
            }else{
                Node<T> sub = new Node<T>(this.findB2(temp.getLeft()));
                temp.setInfo(sub.getInfo());
                temp.setRight(remove(sub.getInfo(), temp.getRight()));
            }
        }

        return temp;
    }

    public T findB2(Node<T> start){
        if(start == null){
            start = this.root;
        }
        Node<T> temp = start;

        while(temp.getRight() != null){
            temp = temp.getRight();
        }
        return temp.getInfo();
    }

    public T findS2(Node<T> start){
        if(start == null){
            start = this.root;
        }
        Node<T> temp = start;

        while(temp.getLeft() != null){
            temp = temp.getLeft();
        }
        return temp.getInfo();
    }
    public String printLeft(){
        String values = "" + this.root.getInfo() + " ";
        if(this.root == null){
            return "Não há nenhum elemento a ser removido";
        }
        Node<T> temp = this.root;
        while(temp.getLeft() != null){
            temp = temp.getLeft();
            values += temp.getInfo() + " ";
        }
        return values;
    }
    public String printRight(){
        String values = "" + this.root.getInfo() + " ";
        if(this.root == null){
            return "Não há nenhum elemento a ser removido";
        }
        Node<T> temp = this.root;
        while(temp.getRight() != null){
            temp = temp.getRight();
            values += temp.getInfo() + " ";
        }
        return values;
    }
    
}



