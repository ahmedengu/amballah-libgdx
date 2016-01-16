package com.oba7;

/**

 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Sa3ed extends Entity{
    private final Entities entities;
    private long lastFire;
    private static int power = 100;
    private static int  score;

    public Sa3ed(Vector2 pos, Vector2 direction, Entities entities) {
        super(Textures.SAYED, pos, direction);
        this.entities = entities;
    }

    @Override
    public void update() {
        if(pos.x<=140)
            pos.set(140,pos.y);
        if(pos.x>=Amballah.WIDTH -140- Textures.SAYED.getWidth())
            pos.set(Amballah.WIDTH -140- Textures.SAYED.getWidth(),pos.y);
        if(pos.y>=Amballah.getHEIGHT()- Textures.SAYED.getHeight())
            pos.set(pos.x,Amballah.getHEIGHT()- Textures.SAYED.getHeight());
        if(pos.y<= 0)
            pos.set(pos.x,0);
        pos.add(direction);


        if (Gdx.input.isKeyPressed(Keys.A)||Gdx.input.isKeyPressed(Keys.LEFT)) {
            setDirection(-200, 0);
            this.setTexture(Textures.SAYED2);
        }else if (Gdx.input.isKeyPressed(Keys.D) ||Gdx.input.isKeyPressed(Keys.RIGHT) ) {
            setDirection(200, 0);
            this.setTexture(Textures.SAYED2);

        }else if (Gdx.input.isKeyPressed(Keys.W) ||Gdx.input.isKeyPressed(Keys.UP) ) {
            setDirection(0, 200);
            this.setTexture(Textures.SAYED2);

        }else if (Gdx.input.isKeyPressed(Keys.S) ||Gdx.input.isKeyPressed(Keys.DOWN) ) {
            setDirection(0, -200);
            this.setTexture(Textures.SAYED2);

        }else {
            setDirection(0, 0);
            this.setTexture(Textures.SAYED);
        }

        if (Gdx.input.isKeyPressed(Keys.SPACE)) {

            if (System.currentTimeMillis() - lastFire >= 200) {
                entities.addEntity(new Fra2a3a(pos.cpy().add(10, Textures.SAYED.getHeight())));
                lastFire = System.currentTimeMillis();

            }

        }
    }

    public Entities getEntities() {
        return entities;
    }

    public long getLastFire() {
        return lastFire;
    }

    public void setLastFire(long lastFire) {
        this.lastFire = lastFire;
    }

    public static int getPower() {
        return power;
    }

    public static void setPower(int p) {
       power = p;
    }

    public static void hit(int hit) {
        power -= hit;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int s) {
        score = s;
    }

    public static void increaseScore(int s) {
        score += s;
    }
}
