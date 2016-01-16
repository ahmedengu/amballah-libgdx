package com.oba7;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**

 */
public abstract class Entity {
    protected Texture texture;
    protected Vector2 pos, direction;

    public Entity(Texture texture, Vector2 pos, Vector2 direction) {
        this.texture = texture;
        this.pos = pos;
        this.direction = direction;
    }

    public abstract void update();

    public void render(SpriteBatch sb) {
        sb.draw(texture, pos.x, pos.y);
    }

    public Vector2 getPosition() {
        return pos;
    }

    public float[] getBounds() {
        return new float[]{pos.x, pos.y, texture.getWidth(), texture.getHeight()};
    }

    public void setDirection(float x, float y) {
        direction.set(x, y);
        direction.scl(Gdx.graphics.getDeltaTime());
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public void setDirection(Vector2 direction) {
        this.direction = direction;
    }
}
