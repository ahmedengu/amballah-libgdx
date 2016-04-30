package com.oba7;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**

 */
public class El7ara extends Screen{

    private OrthoCamera camera;
    private Entities entities;

    @Override
    public void create() {
        camera = new OrthoCamera();
        entities = new Entities();
    }

    @Override
    public void update() {
        camera.update();
        entities.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        entities.render(sb);
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

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }
}
