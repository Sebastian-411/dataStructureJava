package model;

public class Player {
    private String name;
    private int points;

    private String history;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.history = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
