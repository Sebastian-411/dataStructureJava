package model;

public class Node {
    private Node left, right;

    String key;

    public Node(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }


    // getters and setters


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

    public void setKey(String key) {
        this.key = key;
    }
}
