package com.oba7;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**

 */
public class Zaza extends Entity{
    private final Entities entities;
    private int power = 30;

    boolean right = (Math.random()*10<5)?false:true;
    private long lastFire;

    public Zaza(Vector2 pos, Vector2 direction,Entities entities) {
        super(Textures.ZAZA, pos, direction);
        this.entities=entities;
    }

    @Override
    public void update() {
        if(right){
            pos.add(direction);
        }else{
            pos.add(new Vector2(-direction.x,0));
        }

        if (pos.x <=140){
            right=true;
        }else if(pos.x>= (Amballah.WIDTH-140)-Textures.ZAZA.getWidth()) {
            right=false;
        }



        if (System.currentTimeMillis() - lastFire >= 1000) {

                entities.addEntity(new Matwah(pos.cpy().add(25, -Textures.ZAZA.getHeight()/2)));

            lastFire = System.currentTimeMillis();

        }
    }

    public Entities getEntities() {
        return entities;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public long getLastFire() {
        return lastFire;
    }

    public void setLastFire(long lastFire) {
        this.lastFire = lastFire;
    }

    public void hit(int hit) {
        this.power -= hit;
    }

}
