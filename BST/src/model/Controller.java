package model;

public class Controller {
    private TreeInt bstInt = new TreeInt();
    private TreeString bstString = new TreeString();


    public boolean addNode(String name, int score){
        ScoreRegistry tmp = new ScoreRegistry(name, score);
        // SCORE
        if(bstInt.search(score) == null && bstString.search(name) == null){
            // SCORE
            bstInt.addNode(new NodeInt(tmp, score));
            // NAME
            bstString.addNode(new NodeString(tmp, name));
            return true;
        }
        return false;
    }

    public void addssss(){
        bstString.addNode(new NodeString(new ScoreRegistry("A", 2),     "A"));
        bstString.addNode(new NodeString(new ScoreRegistry("B", 13),    "B"));
        bstString.addNode(new NodeString(new ScoreRegistry("C", 1),     "C"));
        bstString.addNode(new NodeString(new ScoreRegistry("D", 123),   "D"));
        bstString.addNode(new NodeString(new ScoreRegistry("E", 11),    "E"));
        bstString.addNode(new NodeString(new ScoreRegistry("F", 23),    "F"));
        bstInt.addNode(new NodeInt(new ScoreRegistry("A", 2), (2)));
        bstInt.addNode(new NodeInt(new ScoreRegistry("B", 13), (13)));
        bstInt.addNode(new NodeInt(new ScoreRegistry("C", 1), (1)));
        bstInt.addNode(new NodeInt(new ScoreRegistry("D", 123), (123)));
        bstInt.addNode(new NodeInt(new ScoreRegistry("E", 11), (11)));
        bstInt.addNode(new NodeInt(new ScoreRegistry("F", 23), (23)));

    }

    public String printScores(){
        return bstInt.inOrder();
    }

    public String printNames(){
        return bstString.inOrder();
    }


    public void delete(String goal){
        NodeString tmp = bstString.search(goal);
        if(tmp!=null){
            System.out.println(bstInt.delete(bstString.search(goal).getScore().getScore()));
        }
        System.out.println(bstString.delete(goal));
    }
}
