package com.dzvonik.model;

import java.util.Arrays;
import java.util.HashMap;

public class Map {

    private java.util.Map<Position, Character> entities;
    private int width;
    private int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        entities = initialize();
    }

    private java.util.Map<Position, Character> initialize() {
        java.util.Map<Position, Character> entities = new HashMap<>();
        int size = width * height;
        
        // grass, rock, tree counters
        int rockCount = (int) Math.round(size * 0.2);
        int treeCount = (int) Math.round(size * 0.2);
        int grassCount = (int) Math.round(size * 0.4);

        // grass
        for (int i = 0; i < grassCount; i++) {
            Position randomPosition = getRandomPosition(width, height, entities);
            entities.put(randomPosition, 'G');
        }

        // rocks
        for (int i = 0; i < rockCount; i++) {
            Position randomPosition = getRandomPosition(width, height, entities);
            entities.put(randomPosition, 'R');
        }

        // tries
        for (int i = 0; i < treeCount; i++) {
            Position randomPosition = getRandomPosition(width, height, entities);
            entities.put(randomPosition, 'T');
        }

        Position randomPosition = getRandomPosition(width, height, entities);
        entities.put(randomPosition, 'H');
        randomPosition = getRandomPosition(width, height, entities);
        entities.put(randomPosition, 'P');

        // System.out.println("rocks: " + rockCount + ", " + "tries: " + treeCount + ", " + "grass: " + grassCount);
        return entities;
    }

    public void update() {
        entities = initialize();
    }

    private Position getRandomPosition(int width, int height, java.util.Map<Position, Character> entities) {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);

        Position position = new Position(x, y);

        while (entities.containsKey(position)) {
            x = (int) (Math.random() * width);
            y = (int) (Math.random() * height);
            position = new Position(x, y);
        }

        return position;
    }

    public char[][] getPrintableMap() {
        char[][] printableMap = new char[height][width];
    
        for (int i = 0; i < printableMap.length; i++) {
            Arrays.fill(printableMap[i], 'O');
        }
    
        for (java.util.Map.Entry<Position, Character> entity : entities.entrySet()) {
            int x = entity.getKey().getX();
            int y = entity.getKey().getY();
            char value = entity.getValue();
    
            printableMap[x][y] = value;
        }

        return printableMap;
    }

    public java.util.Map<Position, Character> getEntities() {
        return entities;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
