package com.dzvonik.model;

public abstract class Entity {

    private char sign;
    private Position position;

    public Entity(Position position) {
        this.sign = getClass().getSimpleName().charAt(0);
        this.position = position;
    }

    public char getSign() {
        return sign;
    }

    public Position getPosition() {
        return position;
    }

}
