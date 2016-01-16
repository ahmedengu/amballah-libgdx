package com.oba7;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**

 */
public class Fra2a3a extends Entity{
    private  int power = 5;
    private static long upgradeTime = System.currentTimeMillis();
private static boolean upgardeFlag = false;
    public Fra2a3a(Vector2 pos) {
        super(Textures.FAR2A3A, pos, new Vector2(0, 5));

        if(System.currentTimeMillis()-upgradeTime>= MathUtils.random(1000,3000)){
            upgardeFlag=true;
            if(Math.random()*30<3) {
                upgradeTime = System.currentTimeMillis();
                upgardeFlag=false;
            }

            power=10;
            this.setTexture(Textures.FAR2A3A2);
        }else{
            power=5;
            this.setTexture(Textures.FAR2A3A);
        }


    }

    @Override
    public void update() {

        pos.add(direction);

    }

    public boolean checkEnd() {
        return pos.y >= Amballah.HEIGHT-Textures.FAR2A3A.getHeight();
    }

    public  int getPower() {
        return power;
    }

    public  void setPower(int p) {
        power = p;
    }

    public  void hit(int hit) {
        power -= hit;
    }

    public static long getUpgradeTime() {
        return upgradeTime;
    }

    public static void setUpgradeTime(long upgradeTime) {
        Fra2a3a.upgradeTime = upgradeTime;
    }

    public static boolean isUpgardeFlag() {
        return upgardeFlag;
    }

    public static void setUpgardeFlag(boolean upgardeFlag) {
        Fra2a3a.upgardeFlag = upgardeFlag;
    }
}
