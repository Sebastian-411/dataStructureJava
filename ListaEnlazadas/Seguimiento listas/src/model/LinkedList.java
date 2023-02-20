package model;

public class LinkedList {
    private Node head;
    private Node tail;

    // constructor


    // setters and getters

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }


    // add

    public void addNode(Node node){
        if (head == null) {
            head = node;
            tail = node;
        } else {
            addTail(node);

        }
    }


    public void addTail(Node node){
        node.setPrevious(tail);
        tail.setNext(node);
        tail = tail.getNext();
    }


    // print


    public String print(){
        return print(head);
    }

    private String print(Node node){
        if(node == null){
            return "";
        }
        return "[" + node.getName() + ((node.getPlayer()!=null) ? "*" : "")  + "]  " + print(node.getNext());
    }

    // delete

    public void delete(String goal){
        delete(head, goal);
    }
    private void delete(Node current, String goal){
        if(current == null){
            return;
        }
        if((current.getName()).equals(goal)){
            //Eliminar
            Node prev = current.getPrevious();
            Node next = current.getNext();
            if ( prev == null ){
                return;
            }
            else {
                prev.setNext(next);
            }
            if ( next == null ){
                return;
            } else {
                next.setPrevious(prev);
            }
            return;
        }
        delete(current.getNext(), goal);

    }
    // getNodeP
    public Node getN(){
        return getN(head);
    }
    private Node getN(Node current){
        if(current == null){
            return null;
        }
        if((current.getPlayer() != null)){
            return current;
        }
        return getN(current.getNext());
    }

    // setStatus
    public String setA(int n){
        return setA(head, n);
    }
    private String setA(Node current, int n){
        if(current == null){
            return "";
        }
        if((current.getPlayer() != null)){
            switch (n){
                case 1:
                    current.setStatus("Correcto!");
                    current.setName("+");
                    current.getPlayer().setPoints(current.getPlayer().getPoints() + 1);
                    break;
                case 2:
                    current.setStatus("Incorrecto :(");
                    current.setName("x");
                    break;
            }
        }
        return setA(current.getNext(), n);
    }

    // getAnswer

    public int getA(){
        return getA(head);
    }
    private int getA(Node current){
        if(current == null){
            return 0;
        }
        if((current.getPlayer() != null)){
            return current.getQuestion().getAnswer();
        }
        return getA(current.getNext());
    }


    // getQuestion
    public String getQ(){
        return getQ(head);
    }
    private String getQ(Node current){
        if(current == null){
            return "";
        }
        if((current.getPlayer() != null)){
            return current.getQuestion().getQuestion();
        }
        return getQ(current.getNext());
    }

    // search player:
    public boolean searchP(){
        return searchP(head);
    }
    private boolean searchP(Node current){
        if((current.getPlayer() != null)){
            return current.getStatus().equals("");
        }
        return searchP(current.getNext());
    }

    // next level
    public void nextP(){
        nextP(head);
    }
    private void nextP(Node current){
        if(current == null){
            return;
        }
        if((current.getPlayer() != null)){
            if(current.getNext() != null){
                (current.getNext()).setPlayer(current.getPlayer());
                current.setPlayer(null);
                return;
            }
        }
        nextP(current.getNext());
    }
}
