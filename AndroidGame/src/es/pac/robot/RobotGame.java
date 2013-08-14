package es.pac.robot;

import es.pac.framework.Screen;
import es.pac.framework.implementation.AndroidGame;

public class RobotGame extends AndroidGame {

	@Override
	public Screen getInitScreen() {
		return new LoadingScreen(this);
	}

	@Override
	public void onBackPressed() {
		getCurrentScreen().backButton();
	}

}
