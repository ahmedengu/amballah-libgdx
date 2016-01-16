package com.oba7;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

/**

 */
public class Textures {

   public static Texture SAYED = new Texture(Gdx.files.internal("sa3eed.png"));
    public static Texture SAYED2 = new Texture(Gdx.files.internal("char2.png"));

 public static Texture FAR2A3A = new Texture(Gdx.files.internal("fr23a.png"));
 public static Texture FAR2A3A2 = new Texture(Gdx.files.internal("fr23aupgrade.png"));

 public static Texture MATWAH = new Texture(Gdx.files.internal("matwah.png"));

    public static Texture ZAZA = new Texture(Gdx.files.internal("zaza.png"));
    public static Texture TOKTOK = new Texture(Gdx.files.internal("TOKOK1.png"));
    public static Texture TOKTOK1 = new Texture(Gdx.files.internal("TOKOK2.png"));
    public static int WARAPADDING = 140;
    public static int WARAPADDING2 = 140;

    public static Texture WARA = new Texture(Gdx.files.internal("background.png"));
    public static Texture WARA2 = new Texture(Gdx.files.internal("background1.png"));

    public static Texture GAME_OVER = new Texture(Gdx.files.internal("gameover.png"));
    public  static Music MUSIC = Gdx.audio.newMusic(Gdx.files.internal("sound.mp3"));

    public static Texture getSAYED() {
        return SAYED;
    }

    public static void setSAYED(Texture SAYED) {
        Textures.SAYED = SAYED;
    }

    public static Texture getSAYED2() {
        return SAYED2;
    }

    public static void setSAYED2(Texture SAYED2) {
        Textures.SAYED2 = SAYED2;
    }

    public static Texture getFAR2A3A() {
        return FAR2A3A;
    }

    public static void setFAR2A3A(Texture FAR2A3A) {
        Textures.FAR2A3A = FAR2A3A;
    }

    public static Texture getFAR2A3A2() {
        return FAR2A3A2;
    }

    public static void setFAR2A3A2(Texture FAR2A3A2) {
        Textures.FAR2A3A2 = FAR2A3A2;
    }

    public static Texture getMATWAH() {
        return MATWAH;
    }

    public static void setMATWAH(Texture MATWAH) {
        Textures.MATWAH = MATWAH;
    }

    public static Texture getZAZA() {
        return ZAZA;
    }

    public static void setZAZA(Texture ZAZA) {
        Textures.ZAZA = ZAZA;
    }

    public static Texture getTOKTOK() {
        return TOKTOK;
    }

    public static void setTOKTOK(Texture TOKTOK) {
        Textures.TOKTOK = TOKTOK;
    }

    public static Texture getTOKTOK1() {
        return TOKTOK1;
    }

    public static void setTOKTOK1(Texture TOKTOK1) {
        Textures.TOKTOK1 = TOKTOK1;
    }

    public static Texture getWARA() {
        return WARA;
    }

    public static void setWARA(Texture WARA) {
        Textures.WARA = WARA;
    }

    public static Texture getGameOver() {
        return GAME_OVER;
    }

    public static void setGameOver(Texture gameOver) {
        GAME_OVER = gameOver;
    }

    public static Music getMUSIC() {
        return MUSIC;
    }

    public static void setMUSIC(Music MUSIC) {
        Textures.MUSIC = MUSIC;
    }


    public static int getWARAPADDING() {
        return WARAPADDING;
    }

    public static void setWARAPADDING(int WARAPADDING) {
        Textures.WARAPADDING = WARAPADDING;
    }

    public static int getWARAPADDING2() {
        return WARAPADDING2;
    }

    public static void setWARAPADDING2(int WARAPADDING2) {
        Textures.WARAPADDING2 = WARAPADDING2;
    }

    public static Texture getWARA2() {
        return WARA2;
    }

    public static void setWARA2(Texture WARA2) {
        Textures.WARA2 = WARA2;
    }
}
