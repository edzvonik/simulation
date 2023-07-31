package com.dzvonik;

import java.util.Arrays;

public class Renderer {
    
    public void render(Map map) {
        StringBuilder[] renderedMap = new StringBuilder[map.getHeight()];

        for (int i = 0; i < renderedMap.length; i++) {
            char[] fill = new char[map.getWidth()];
            Arrays.fill(fill, 'O');
            renderedMap[i] = new StringBuilder(String.copyValueOf(fill));
        }


        for (java.util.Map.Entry<Position, Character> entity : map.getEntities().entrySet()) {
            int x = entity.getKey().getX();
            int y = entity.getKey().getY();

            System.out.println("coord: " + x + "," + y + " value: " + entity.getValue());

            renderedMap[x].setCharAt(y, entity.getValue());
        }

        for (int i = 0; i < renderedMap.length; i++) {
            System.out.println(renderedMap[i].toString());
        }
    }

}
