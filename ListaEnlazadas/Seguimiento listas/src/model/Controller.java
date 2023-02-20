package model;


import java.util.Random;

public class Controller {
    public Player actualPlayer;
    public LinkedList linkedList;

    private Random rd = new Random();


    public Controller() {
        this.linkedList = new LinkedList();
    }

    public void createPlayer(String name){
        actualPlayer = new Player(name);
    }
    public void createLevels(int n, int d){
        if(d == n){
            linkedList.addNode(new Node(String.valueOf(d), makeQuestion()));
            linkedList.getHead().setPlayer(actualPlayer);
        }
        else {
            linkedList.addNode(new Node(String.valueOf(d), makeQuestion()));
            createLevels(n, d+1);
        }
    }


    public boolean answer(int n){
        if( n == linkedList.getA()){
            linkedList.setA(1);
            actualPlayer.setHistory(actualPlayer.getHistory() + linkedList.getN().getQuestion().getQuestion() + ": " + linkedList.getN().getStatus() + "\n");
            linkedList.nextP();
            return true;
        } else {
            linkedList.setA(2);
            actualPlayer.setHistory(actualPlayer.getHistory() + linkedList.getN().getQuestion().getQuestion() + ": " + linkedList.getN().getStatus() + "\n");
            linkedList.nextP();
            return false;
        }
    }

    public String getQuestion(){
        return (linkedList.getQ());
    }
    public boolean canStillPlay(){
        return linkedList.searchP();
    }

    public String print(){
        return linkedList.print();
    }



    private Question makeQuestion(){
        String question = "";
        int answer = 0;
        int num1 = rd.nextInt(0,99);
        int num2 = rd.nextInt(0,99);
        switch (rd.nextInt(1,3)){
            case 1:
                question = num1 + " + " + num2;
                answer = num1 + num2;

                break;
            case 2:
                question = num1 + " - " + num2;
                answer = num1 - num2;
                break;
        }
        return new Question(question, answer);
    }

    public String statistics(){
        return actualPlayer.getHistory() + actualPlayer.getName() + ", tu puntaje es de " + actualPlayer.getPoints();
    }

    public void pass(){
        actualPlayer.setHistory(actualPlayer.getHistory() + linkedList.getN().getQuestion().getQuestion() + ": Pasaste" + "\n");
        linkedList.nextP();
        linkedList.delete(linkedList.getN().getPrevious().getName());
        actualPlayer.setPoints(actualPlayer.getPoints() - 3);

    }
}
