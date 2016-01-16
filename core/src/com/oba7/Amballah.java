package com.oba7;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.org.apache.xpath.internal.operations.String;

public class Amballah extends ApplicationAdapter {
    public static int WIDTH = 800, HEIGHT = 600;
    private SpriteBatch batch;
    private Texture wara;
        private Music music;

    @Override
    public void create() {
        batch = new SpriteBatch();

        wara = (Math.random()*10<5)?Textures.WARA:Textures.WARA2;
        Screens.setScreen(new El7ara());
        music=Textures.MUSIC;


    }

    @Override
    public void dispose() {
        if (Screens.getCurrentScreen() != null)
            Screens.getCurrentScreen().dispose();
        batch.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        music.setLooping(true);
        music.play();
        batch.begin();

        batch.draw(wara, 0, 0, 800, 600, 0, 0, 800, 600, false, false);



        batch.end();
        if (Screens.getCurrentScreen() != null)
            Screens.getCurrentScreen().update();

        if (Screens.getCurrentScreen() != null)
            Screens.getCurrentScreen().render(batch);
    }

    @Override
    public void resize(int width, int height) {
        if (Screens.getCurrentScreen() != null)
            Screens.getCurrentScreen().resize(width, height);
    }

    @Override

    public void pause() {
        if (Screens.getCurrentScreen() != null)
            Screens.getCurrentScreen().pause();
    }

    @Override
    public void resume() {
        if (Screens.getCurrentScreen() != null)
            Screens.getCurrentScreen().resume();
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setWIDTH(int WIDTH) {
        Amballah.WIDTH = WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setHEIGHT(int HEIGHT) {
        Amballah.HEIGHT = HEIGHT;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public Texture getWara() {
        return wara;
    }

    public void setWara(Texture wara) {
        this.wara = wara;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }


}
