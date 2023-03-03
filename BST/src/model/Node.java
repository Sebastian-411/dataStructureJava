package model;

public abstract class Node {
    private Node left, right;

    private ScoreRegistry score;



    // getters and setters

    public Node(ScoreRegistry score) {
        this.score = score;
    }

    public ScoreRegistry getScore() {
        return score;
    }

    public void setScore(ScoreRegistry score) {
        this.score = score;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
