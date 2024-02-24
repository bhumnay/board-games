package org.example.othello.entities;


import lombok.Getter;

@Getter()
public class Move {
    private final int x;
    private final int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
