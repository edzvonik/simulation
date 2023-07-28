public class Game {

    private Map map;
    private Renderer renderer;

    Game(Map map) {
        this.map = map;
        this.renderer = new Renderer();
    }

    public void startGame() {
        renderer.render(map);
    }
    
}
