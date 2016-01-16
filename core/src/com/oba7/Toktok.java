package com.oba7;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**

 */
public class Toktok extends Entity {
    private int power = 10;
    public Toktok(Vector2 pos, Vector2 direction) {
        super((Math.random()*10<5)?Textures.TOKTOK:Textures.TOKTOK1, pos, direction);
    }

    @Override
    public void update() {

            pos.add(direction);

    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void hit(int power) {
        this.power -= power;
    }

    public boolean checkEnd() {
        return pos.y <= -Textures.TOKTOK.getHeight();
    }
}
