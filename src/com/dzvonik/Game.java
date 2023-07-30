package com.dzvonik;

public class Game {

    private Map map;
    private Renderer renderer;

    Game(Map map, Renderer renderer) {
        this.map = map;
        this.renderer = renderer;
    }

    public void startGame() {
        renderer.render(map);
    }
    
}
