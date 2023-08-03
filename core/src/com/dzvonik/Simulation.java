package com.dzvonik;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dzvonik.model.Game;
import com.dzvonik.model.Map;

public class Simulation extends ApplicationAdapter implements InputProcessor {

	private int numRows;
	private int numCols;
	private Map map;
	private char[][] printableMap;
	private Game game;
	private SpriteBatch batch;
	private Texture whiteTexture; // Текстура для рисования клеток

	@Override
	public void create() {
		batch = new SpriteBatch();

		Gdx.input.setInputProcessor(this);

		numRows = 20;
		numCols = 20;
		map = new Map(numCols, numRows); // заменить на width, height
		game = new Game(map);
		printableMap = game.getMap().getPrintableMap();

		// Создаем белую текстуру размером 1x1 пиксель
		Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		whiteTexture = new Texture(pixmap);
		pixmap.dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		float cellSize = 30; // Размер каждой клетки на экране
		float boardWidth = numCols * cellSize; // Ширина доски на экране
		float boardHeight = numRows * cellSize; // Высота доски на экране

		float startX = (Gdx.graphics.getWidth() - boardWidth) / 2;
		System.out.println("startX:" + startX);	
	
		float startY = (Gdx.graphics.getHeight() - boardHeight) / 2;
		System.out.println("startY:" + startY);

		for (int i = 0; i < printableMap.length; i++) {
			for (int j = 0; j < printableMap[i].length; j++) {
				float x = startX + j * cellSize;
				float y = startY + i * cellSize;
				float width = cellSize;
				float height = cellSize;

				// Рисуем клетки в зависимости от их значения в матрице
				switch (printableMap[i][j]) {
					case 'G':
						batch.setColor(Color.GREEN);
						batch.draw(whiteTexture, x, y, width, height);
						break;
					case 'R':
						batch.setColor(Color.GRAY);
						batch.draw(whiteTexture, x, y, width, height);
						break;
					case 'T':
						batch.setColor(Color.FOREST);
						batch.draw(whiteTexture, x, y, width, height);
						break;
					case 'H':
						batch.setColor(Color.BLUE);
						batch.draw(whiteTexture, x, y, width, height);
						break;
					case 'P':
						batch.setColor(Color.RED);
						batch.draw(whiteTexture, x, y, width, height);
						break;
					default:
						batch.setColor(Color.GOLD);
						batch.draw(whiteTexture, x, y, width, height);
						break;
				}
			}
		}

		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		whiteTexture.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'keyDown'");
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'keyUp'");
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (button == Input.Buttons.LEFT) {
			game.nextStep();
		
			// game.getMap().update();
			printableMap = game.getMap().getPrintableMap();
			render();
			return true;
		}

		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'touchUp'");
	}

	@Override
	public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'touchCancelled'");
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'touchDragged'");
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'mouseMoved'");
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'scrolled'");
	}

}
