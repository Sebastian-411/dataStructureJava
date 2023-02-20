package model;

public class CircularList {
    private Node head;

    // edit node
    public void editNode(String goal, String edit){
        editNode(searchNode(head, goal), edit);
    }

    private void editNode(Node node, String edit){
        if(node != null){
            node.setAttribute(edit);
        }
    }

    // print circular list
    public String print(){
        return (head != null) ? print(head) : " ";
    }

    private String print(Node node){
        if(node.getNext() == head){
            return node.getAttribute();
        } else {
            return node.getAttribute() + "\n" + print(node.getNext());
        }
    }
    // Search node
    private Node searchNode(Node node, String goal){
        if(node == head){
            return node;
        }
        if(node.getNext() != head){
            if ( node.getAttribute().equals(goal) ){
                return node;
            } else {
                return searchNode(node.getNext(), goal);
            }
        } else{
            return null;
        }
    }
    // add node
    public void addNode(Node node){
        if(head==null){
            head = node;
            node.setNext(head);
            node.setPrevious(head);
        } else {
            head.getPrevious().setNext(node);
            node.setNext(head);
            node.setPrevious(head.getPrevious());
            head.setPrevious(node);
        }
    }

    // delete
    public void deleteNode(String goal){
        if(head != null){
            deleteNode(searchNode(head, goal));
        }
    }
    private void deleteNode(Node node){
        if (node != null){
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
            if ( node == head ){
                if(head.getPrevious() == node && head.getNext() == node){
                    head = null;
                    return;
                }
                head = node.getNext();
            }
        }
    }
}
