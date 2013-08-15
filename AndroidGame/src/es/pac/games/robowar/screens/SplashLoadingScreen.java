package es.pac.games.robowar.screens;

import es.pac.games.framework.Game;
import es.pac.games.framework.Graphics;
import es.pac.games.framework.Screen;
import es.pac.games.framework.Graphics.ImageFormat;
import es.pac.games.robowar.Assets;

public class SplashLoadingScreen extends Screen {
	public SplashLoadingScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		Assets.splash = g.newImage("splash.jpg", ImageFormat.RGB565);

		game.setScreen(new LoadingScreen(game));

	}

	@Override
	public void paint(float deltaTime) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void backButton() {

	}
}