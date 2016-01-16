package com.oba7;

import com.badlogic.gdx.math.Vector2;

/**

 */
public class Matwah extends Entity {
    private int power = 2;

    public Matwah(Vector2 pos) {
        super(Textures.MATWAH, pos, new Vector2(0, 3));
    }

    @Override
    public void update() {

        pos.add(new Vector2(-direction.x,-direction.y));
    }

    public boolean checkEnd() {
        return pos.y <= -Textures.MATWAH.getHeight();
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    public void hit(int hit) {
        this.power -= hit;
    }
}
