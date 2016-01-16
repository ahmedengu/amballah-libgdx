package com.oba7;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**

 */
public class Entities {

    private final Array<Entity> entities = new Array<Entity>();
    private final Sa3ed sa3ed;

    private long zazaTimer = System.currentTimeMillis();
    private Zaza lastZaza;
    private long toktokTimer = 0;
    private BitmapFont bitmapFont;
    private BitmapFont bitmapFont2;
    private BitmapFont bitmapFont3;

    public Entities() {
        float x = MathUtils.random(140, Amballah.WIDTH - 140 - Textures.SAYED.getWidth());
        float y = MathUtils.random(0, 50);
        sa3ed = new Sa3ed(new Vector2(x, y), new Vector2(0, 0), this);


        x = MathUtils.random(140, Amballah.WIDTH - 140 - Textures.ZAZA.getWidth());
        y = MathUtils.random(Amballah.HEIGHT - 200, Amballah.HEIGHT - 100);
        float speed = MathUtils.random(1, 3);
        lastZaza = new Zaza(new Vector2(x, y), new Vector2(speed, 0), this);
        addEntity(lastZaza);

        bitmapFont = new BitmapFont();
        bitmapFont2 = new BitmapFont();
        bitmapFont.getData().scale((float) 0.5);
        bitmapFont2.getData().scale((float) 0.5);
        bitmapFont3 = new BitmapFont();
        bitmapFont3.getData().scale((float) 0.3);

    }

    public void update() {

        for (Entity e : entities)
            e.update();
        for (Fra2a3a m : getFra2a3as())
            if (m.checkEnd())
                entities.removeValue(m, false);
        for (Matwah m : getMatwahs())
            if (m.checkEnd())
                entities.removeValue(m, false);
        for (Toktok m : getToktoks())
            if (m.checkEnd()) {
                entities.removeValue(m, false);
                sa3ed.hit(5);
            }
        sa3ed.update();
        checkCollisions();

        if (entities.indexOf(lastZaza, false) == -1) {
            if (lastZaza != null) {
                lastZaza = null;
                zazaTimer = System.currentTimeMillis();
            }
            if (System.currentTimeMillis() - zazaTimer >= 5000 && entities.indexOf(lastZaza, false) == -1) {
                float x = MathUtils.random(140, Amballah.WIDTH - 140 - Textures.ZAZA.getWidth());
                float y = MathUtils.random(Amballah.HEIGHT - 200, Amballah.HEIGHT - 100);
                float speed = MathUtils.random(1, 3);

                lastZaza = new Zaza(new Vector2(x, y), new Vector2(speed, 0), this);
                addEntity(lastZaza);
                zazaTimer = System.currentTimeMillis();
            }
        }


        if (getToktoks().size < 5 && System.currentTimeMillis() - toktokTimer >= 5000) {
            int amount = MathUtils.random(5, 10);
            for (int i = 0; i < amount; i++) {
                float x = MathUtils.random(140, Amballah.WIDTH - 140 - Textures.TOKTOK.getWidth());
                float y = MathUtils.random(Amballah.HEIGHT, Amballah.HEIGHT * 5);
                float speed = MathUtils.random(1, 2);
                addEntity(new Toktok(new Vector2(x, y), new Vector2(0, -speed)));
            }
            toktokTimer = System.currentTimeMillis();
        }
    }

    public void render(SpriteBatch sb) {
        for (Entity e : entities)
            e.render(sb);
        sa3ed.render(sb);

        bitmapFont.setColor(0f, 1.0f, 1.0f, 1.0f);
        bitmapFont.draw(sb, "score: "+Integer.toString(Sa3ed.getScore()), 30, Amballah.getHEIGHT()-25);

        bitmapFont2.setColor(1.0f, 0f, 0f, 1.0f);

        bitmapFont2.draw(sb, "Health: "+Integer.toString(Sa3ed.getPower()), Amballah.getWIDTH()-120, Amballah.getHEIGHT()-25);
if (Fra2a3a.isUpgardeFlag()){
    bitmapFont2.setColor(1.0f, 0f, 0f, 1.0f);

    bitmapFont2.draw(sb, "fra2a3a upgraded ", 300,100);
}

    }

    private void checkCollisions() {
        if (sa3ed.getPower() <= 0) {

            Screens.setScreen(new Bala7());
        }
        for (Zaza e : getZazas()) {
            for (Fra2a3a m : getFra2a3as()) {
                if (overlaps(e.getBounds(), m.getBounds())) {
                    e.hit(m.getPower());
                    if (e.getPower() <= 0) {
                        entities.removeValue(e, false);
                        sa3ed.increaseScore(10);
                    }
                    entities.removeValue(m, false);


                }
            }
            if (overlaps(e.getBounds(), sa3ed.getBounds())) {
                sa3ed.hit(e.getPower());

                entities.removeValue(e, false);


            }
        }

        for (Toktok e : getToktoks()) {
            for (Fra2a3a m : getFra2a3as()) {
                if (overlaps(e.getBounds(), m.getBounds())) {
                    e.hit(m.getPower());
                    if (e.getPower() <= 0) {
                        entities.removeValue(e, false);
                        sa3ed.increaseScore(5);
                    }
                    entities.removeValue(m, false);


                }
            }
            if (overlaps(e.getBounds(), sa3ed.getBounds())) {
                sa3ed.hit(e.getPower());

                entities.removeValue(e, false);


            }
        }
        for (Matwah e : getMatwahs()) {
            for (Fra2a3a m : getFra2a3as()) {
                if (overlaps(e.getBounds(), m.getBounds())) {
                    e.hit(m.getPower());
                    if (e.getPower() <= 0) {
                        entities.removeValue(e, false);
                    }
                    entities.removeValue(m, false);
                }
            }
            if (overlaps(e.getBounds(), sa3ed.getBounds())) {
                sa3ed.hit(e.getPower());

                entities.removeValue(e, false);


            }
        }


    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    private Array<Zaza> getZazas() {
        Array<Zaza> ret = new Array<Zaza>();
        for (Entity e : entities)
            if (e instanceof Zaza)
                ret.add((Zaza) e);
        return ret;
    }

    private Array<Toktok> getToktoks() {
        Array<Toktok> ret = new Array<Toktok>();
        for (Entity e : entities)
            if (e instanceof Toktok)
                ret.add((Toktok) e);
        return ret;
    }

    private Array<Fra2a3a> getFra2a3as() {
        Array<Fra2a3a> ret = new Array<Fra2a3a>();
        for (Entity e : entities)
            if (e instanceof Fra2a3a)
                ret.add((Fra2a3a) e);
        return ret;
    }

    private Array<Matwah> getMatwahs() {
        Array<Matwah> ret = new Array<Matwah>();
        for (Entity e : entities)
            if (e instanceof Matwah)
                ret.add((Matwah) e);
        return ret;
    }



    public boolean overlaps(float[] r, float[] x) {
        return x[0] < r[0] + r[2] && x[0] + x[2] > r[0] && x[1] < r[1] + r[3] && x[1] + x[3] > r[1];
    }

    public Array<Entity> getEntities() {
        return entities;
    }

    public Sa3ed getSa3ed() {
        return sa3ed;
    }

    public long getZazaTimer() {
        return zazaTimer;
    }

    public void setZazaTimer(long zazaTimer) {
        this.zazaTimer = zazaTimer;
    }

    public Zaza getLastZaza() {
        return lastZaza;
    }

    public void setLastZaza(Zaza lastZaza) {
        this.lastZaza = lastZaza;
    }

    public long getToktokTimer() {
        return toktokTimer;
    }

    public void setToktokTimer(long toktokTimer) {
        this.toktokTimer = toktokTimer;
    }
}
