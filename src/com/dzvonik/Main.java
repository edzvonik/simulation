package com.dzvonik;

public class Main {

    public static void main(String[] args) {
        Map map = new Map(5, 5);
        Renderer renderer = new Renderer();
        Game game = new Game(map, renderer);
        game.startGame();
    }
    
}
