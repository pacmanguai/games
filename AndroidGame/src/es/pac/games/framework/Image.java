package es.pac.games.framework;

import es.pac.games.framework.Graphics.ImageFormat;

public interface Image {
	public int getWidth();

	public int getHeight();

	public ImageFormat getFormat();

	public void dispose();

}
