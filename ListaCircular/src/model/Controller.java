package model;

public class Controller {
    private CircularList circularList = new CircularList();
    public void addNodes(){
        circularList.addNode( new Node("Juan") );
        circularList.addNode( new Node("Pedro") );
        circularList.addNode( new Node("Domi") );
        circularList.addNode( new Node("Harry") );
        circularList.addNode( new Node("Pablo") );

    }

    public void editNode(String goal, String edit){
        circularList.editNode(goal, edit);
    }
    public String printNodes(){
        return circularList.print();
    }

    public void deleteNode(String goal){
        circularList.deleteNode(goal);
    }
}
