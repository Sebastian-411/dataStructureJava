package model;

public class ScoreRegistry {
    private String name;
    private int score;

    public ScoreRegistry(String name, int score) {
        this.name = name;
        this.score = score;
    }


    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
