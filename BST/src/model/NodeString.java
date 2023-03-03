package model;

public class NodeString extends Node{
    String key;

    public NodeString(ScoreRegistry score, String key) {
        super(score);
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
