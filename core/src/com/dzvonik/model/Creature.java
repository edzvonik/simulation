package com.dzvonik.model;

import java.util.List;

public abstract class Creature extends Entity {

    public static final int[][] MOVE_DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int hp;
    
    public Creature(Position position, int hp) {
        super(position);
        this.hp = hp;
    }

    public abstract Position makeMove(List<Position> availablePositions);

}
