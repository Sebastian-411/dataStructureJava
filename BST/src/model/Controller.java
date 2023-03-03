package model;

public class Controller {
    private Tree bst = new Tree();


    public boolean addNode(String name){
        String[] tmp;
        int tmp1 = 0;
        String[] names = name.split(" ");
        if(names.length == 1){
            bst.addNode(new Node(names[0]));
        } else if ( names.length == 2){
            addNode(names[0]);
            addNode(names[1]);
        } else {
            if(names.length % 2 == 1){
              tmp1 = ( (int) Math.ceil((double) names.length/ 2.0)) - 1;
            } else {
              tmp1 = (names.length / 2) - 1;
            }
            bst.addNode(new Node(names[tmp1]));
            tmp = name.split(" " + names[tmp1] + " ");
            addNode(tmp[0]);
            addNode(tmp[1]);
        }
        return true;
    }


    public String print(){
        return bst.inOrder();
    }


    public int deep(){
        return bst.deep();
    }



}
