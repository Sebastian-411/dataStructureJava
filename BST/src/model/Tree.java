package model;

public class Tree {
    private Node root;



    // add data

    public void addNode(Node node){
        if(root==null){
            root = node;
        } else {
            addNode(root, node);
        }
    }

    private void addNode(Node current, Node node){
        if(node.getKey().compareToIgnoreCase(current.getKey())<0){
            if(current.getLeft() == null){
                current.setLeft(node);
                return;
            } else {
                addNode(current.getLeft(), node);
            }
        } else {
            if(current.getRight() == null){
                current.setRight(node);
                return;
            } else {
                addNode(current.getRight(), node);
            }
        }
    }

    // print data
    public String inOrder(){
        return inOrder(root);
    }

    private String inOrder(Node current){
        if(current == null){
            return "";
        }
        return inOrder( current.getRight())  + current.getKey()  + " " + inOrder(current.getLeft()) ;
    }


    // deep

    public int deep(){
        return deep(root, 1);
    }

    private int deep(Node current, int n){
        if(current != null){
            int l = deep(current.getRight(), n + 1);
            int d = deep(current.getLeft(), n + 1);
            return Math.max(l, d);
        } else{
            return n-1;
        }
    }
    
}
