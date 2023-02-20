public class LinkedList {
    private Node head;
    private Node tail;

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

    public void addNode(Node node){
        if (head == null) {
            head = node;
            tail = node;
        } else {
            addTail(node);

        }
    }

    public void addHead(Node node){
        head.setPrevious(node);
        node.setNext(head);
        head = node;
    }

    public void addTail(Node node){
        node.setPrevious(tail);
        tail.setNext(node);
        tail = tail.getNext();
    }

    public String print(){
        return print(head);
    }

    private String print(Node node){
        if(node == null){
            return "";
        }
        return node.getName() + "\n" + print(node.getNext());
    }

    public void delete(String goal){
        delete(head, goal);
    }
    private void delete(Node current, String goal){
        if(current == null){
            return;
        }
        System.out.println(current.getName());

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


}
