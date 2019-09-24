package com.battleship;

public class Player {
    private String Name;
    private int numberBoxesLeft = 20;
    private int numberBoxesHitLeft = 20;
    private boolean hit;

    public Player(String name, boolean hit) {
        Name = name;
        this.hit = hit;
    }

    public String getName() {
        return Name;
    }

    public int getNumberBoxesHitLeft() {
        return numberBoxesHitLeft;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNumberBoxesHitLeft(int numberBoxesHitLeft) {
        this.numberBoxesHitLeft = numberBoxesHitLeft;
    }

    public boolean isHIT() {
        return hit;
    }

    public void setHIT(boolean HIT) {
        this.hit = HIT;
    }

    public int getNumberBoxesLeft() {
        return numberBoxesLeft;
    }

    public void setNumberBoxesLeft(int numberBoxesLeft) {
        this.numberBoxesLeft = numberBoxesLeft;
    }
}