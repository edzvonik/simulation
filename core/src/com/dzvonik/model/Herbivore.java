package com.dzvonik.model;

import java.util.List;

public class Herbivore extends Creature {

    private boolean isHungry;
    
    public Herbivore(Position position, int hp) {
        super(position, hp);
        isHungry = false;
    }

    @Override
    public Position makeMove(List<Position> availablePositions) {
        if (!isHungry) {
            Position newPosition = getRandomPosition(availablePositions);
            setPosition(newPosition);
            return newPosition;
        }

        return this.getPosition();
        // Бродить по полю, если HP > 50%
        // Если 50% и меньше - начать искать себе еду
        // Из поля зрения взять рандомный ближайший объект и идти к нему при помощи bfs
        // Повторять до тех пор, пока HP не станет 100%
    }

    private Position getRandomPosition(List<Position> positions) {
        int random = (int) (Math.random() * positions.size());
        return positions.get(random);
    }

}
