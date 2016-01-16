package com.oba7.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.oba7.Amballah;

public class DesktopLauncher {
	public static void main (String[] arg) {

		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Amballah";

		cfg.width = Amballah.WIDTH;
		cfg.height = Amballah.HEIGHT;

		new LwjglApplication(new Amballah(), cfg);
	}
}
