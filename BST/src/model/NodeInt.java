package model;

public class NodeInt extends Node{
    private int key;

    public NodeInt(ScoreRegistry score, int key) {
        super(score);
        this.key = key;
    }
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
