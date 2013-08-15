package es.pac.games.robowar;

import es.pac.games.framework.Image;
import es.pac.games.framework.Music;
import es.pac.games.framework.Sound;
import es.pac.games.framework.implementation.AndroidGame;

public class Assets {

	public static Image menu, splash, background, character, character2, character3, heliboy, heliboy2, heliboy3, heliboy4, heliboy5;
    public static Image tiledirt, tilegrassTop, tilegrassBot, tilegrassLeft, tilegrassRight, characterJump, characterDown;
    public static Image button;
    public static Sound click;
    public static Music theme;
    
    public static void load(AndroidGame game) {
        // TODO Auto-generated method stub
        theme = game.getAudio().createMusic("menutheme.mp3");
        theme.setLooping(true);
        theme.setVolume(0.85f);
        theme.play();
    }
}
