package com.oba7;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Bala7 extends Screen {

    private OrthoCamera camera;
    private Texture texture;
    private BitmapFont bitmapFont;
//    private BitmapFont bitmapFont2;

    public Bala7() {

            texture = Textures.GAME_OVER;
    }

    @Override
    public void create() {
        camera = new OrthoCamera();
        camera.resize();
        bitmapFont = new BitmapFont();
        bitmapFont.getData().scale((float) 0.5);
//        bitmapFont2 = new BitmapFont();
//        bitmapFont2.getData().scale((float) 0.3);
    }

    @Override
    public void update() {
        camera.update();
//        if(Gdx.input.isKeyPressed(Input.Keys.S)){
//            System.out.println("oeueoueouoeuoeoeuoe oeueu oeueou");
//
//            new Replay();
//        }

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);
        sb.begin();

        sb.draw(texture, Amballah.WIDTH / 2 - texture.getWidth() / 2, Amballah.HEIGHT / 2 - texture.getHeight() / 2);
        bitmapFont.setColor(0f, 0f, 1.0f, 1.0f);
        bitmapFont.draw(sb, "your score: "+Integer.toString(Sa3ed.getScore()),330, 170);
//        bitmapFont2.setColor(1f, 0f, 0f, 1.0f);
//        bitmapFont2.draw(sb, "Press 's' to play again",300, 180);
        sb.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.resize();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    public OrthoCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthoCamera camera) {
        this.camera = camera;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}
