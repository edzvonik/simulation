package com.dzvonik;

import java.util.HashMap;

public class Map {

    private java.util.Map<Integer[], Character> entities;
    private int width = 0;
    private int height = 0;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        entities = initialize();
    }

    private java.util.Map<Integer[], Character> initialize() {
        java.util.Map<Integer[], Character> entities = new HashMap<>();
        int size = width * height;
        // grass, rock, tree counters
        int rockCount = (int) Math.round(size * 0.2);
        int treeCount = (int) Math.round(size * 0.2);
        int grassCount = (int) Math.round(size * 0.4);

        // rocks
        for (int i = 0; i < rockCount; i++) {
            Integer[] randomPosition = getRandomPosition(width, height, entities);
            entities.put(randomPosition, 'R');
        }

        // tries
        for (int i = 0; i < rockCount; i++) {
            Integer[] randomPosition = getRandomPosition(width, height, entities);
            entities.put(randomPosition, 'T');
        }

        // grass
        for (int i = 0; i < rockCount; i++) {
            Integer[] randomPosition = getRandomPosition(width, height, entities);
            entities.put(randomPosition, 'G');
        }

        // System.out.println("rocks: " + rockCount + ", " + "tries: " + treeCount + ", " + "grass: " + grassCount);
        return entities;

    }

    private Integer[] getRandomPosition(int width, int height, java.util.Map<Integer[], Character> entities) {
        // Получение случайных координат для позиции объекта на карте
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);

        Integer[] position = new Integer[]{x, y};

        // Проверка на занятость ячейки
        while (entities.containsKey(position)) {
            x = (int) (Math.random() * width);
            y = (int) (Math.random() * height);
            position = new Integer[]{x, y};
        }

        return position;
    }

    public java.util.Map<Integer[], Character> getEntities() {
        return entities;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
