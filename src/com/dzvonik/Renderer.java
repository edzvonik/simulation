package com.dzvonik;

public class Renderer {
    
    public void render(Map map) {
        StringBuilder[] renderedMap = new StringBuilder[map.getHeight()];

        for (java.util.Map.Entry<Integer[], Character> entity : map.getEntities().entrySet()) {
            int x = entity.getKey()[0];
            int y = entity.getKey()[1];

            if (entity.getValue() != null) {
                if (renderedMap[x] == null) {
                    renderedMap[x] = new StringBuilder();
                }
                renderedMap[x].insert(y, entity.getValue());
            }
            renderedMap[x].insert(y, '.');
        }

        for (int i = 0; i < renderedMap.length - 1; i++) {
            renderedMap[i].toString();
        }
    }

}
