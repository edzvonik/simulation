package com.dzvonik.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private Map map;

    public Game(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }

    public void nextStep() {
        for (java.util.Map.Entry<Position, Entity> entry : map.getEntities().entrySet()) {
            String entityName = entry.getValue().getClass().getSimpleName();
            if (entityName.equals("Herbivore") || entityName.equals("Predator")) {
                Creature creature = (Creature) entry.getValue();
                List<Position> availablePositions = checkAvailablePostions(creature);
                Position oldPosition = creature.getPosition();
                Position newPosition = creature.makeMove(availablePositions);
                map.getEntities().put(newPosition, creature);
                map.getEntities().remove(oldPosition);
            }
        }
    }

    private List<Position> checkAvailablePostions(Creature creature) {
        List availablePositions = new ArrayList();
        
        for (int[] direction : creature.MOVE_DIRECTIONS) {
            // Свободно? Не дерево или камень? Не за пределами карты?
            int newX = creature.getPosition().getX() + direction[0];
            int newY = creature.getPosition().getY() + direction[1];
            Position position = new Position(newX, newY);
            
            if (map.checkMapOutside(position) || map.checkPositionAvailability(position)) {
                availablePositions.add(position);
            }
        }

        return availablePositions;
    }

}
