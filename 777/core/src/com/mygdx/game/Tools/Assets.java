package com.mygdx.game.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.mygdx.game.GameUI.JoystickArea;

public class Assets {
    // фон MainMenu
    public static Texture texture_back;
    public static Sprite sprite_back;
    //gameover фон
    public static Texture texture_gameover;
    public static Sprite sprite_gameover;
    // экран паузы
    public static Texture texture_pausescreen;
    public static Sprite pauseScreen;
    // иконка паузы
    public static Texture texture_pausebutton;
    public static Sprite pausebutton;
    // главный герой
    public static Texture texture_sam;
    public static Sprite Samurai;
    // враг собака
    public static Texture texture_dog1;
    public static Sprite dog1;
    public static Texture texture_dog2;
    public static Sprite dog2;
    public static Texture texture_dog3;
    public static Sprite dog3;
    // дверь
    public static Texture texture_dtuw;
    public static Sprite doortouw;
    public static Texture texture_CEgate;
    public static Sprite CEgate;
    //мечь
    public static Texture texture_sword;
    public static Sprite Sword;
    //смерть
    public static Texture texture_grave;
    public static Sprite Grave;
    // карта орода
    public static TiledMap townmap;
    public static TmxMapLoader mapLoader;
    // карта пригорода
    public static TiledMap uverworld;
    // карта входа в замок
    public static TiledMap Enterance;

    public static JoystickArea joystickArea;


    public static void load() {
        texture_back = new Texture(Gdx.files.internal("Backgrounds/MM-for-TLG.png"));
        texture_back.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        sprite_back = new Sprite(texture_back);

        texture_gameover = new Texture(Gdx.files.internal("Backgrounds/GameoverScreen.png"));
        sprite_gameover = new Sprite(texture_gameover);

        texture_pausescreen = new Texture(Gdx.files.internal("Backgrounds/pausescreen.png"));
        pauseScreen = new Sprite(texture_pausescreen);

        texture_pausebutton = new Texture(Gdx.files.internal("Buttons/PauseIcon.png"));
        pausebutton = new Sprite(texture_pausebutton);

        texture_sam = new Texture(Gdx.files.internal("Samurai1.png"));
        Samurai = new Sprite(texture_sam);

        texture_dog1 = new Texture(Gdx.files.internal("Enemies/Dog1.png"));
        dog1 = new Sprite(texture_dog1);
        texture_dog2 = new Texture(Gdx.files.internal("Enemies/Dog1.png"));
        dog2 = new Sprite(texture_dog2);
        texture_dog3 = new Texture(Gdx.files.internal("Enemies/Dog1.png"));
        dog3 = new Sprite(texture_dog3);

        texture_dtuw = new Texture(Gdx.files.internal("dtuw.png"));
        doortouw = new Sprite(texture_dtuw);

        texture_CEgate = new Texture(Gdx.files.internal("CEgate.png"));
        CEgate = new Sprite(texture_CEgate);

        texture_sword = new Texture(Gdx.files.internal("sword.png"));
        Sword = new Sprite(texture_sword);

        texture_grave = new Texture(Gdx.files.internal("dead.png"));
        Grave = new Sprite(texture_grave);

        Texture circle = new Texture("Buttons/jcircle.png");
        Texture curJoystick = new Texture("Buttons/JoyStickKrug.png");
        joystickArea = new JoystickArea(circle, curJoystick);

        mapLoader = new TmxMapLoader();
        townmap = mapLoader.load("Maps/town.tmx");
        uverworld = mapLoader.load("Maps/uverworld.tmx");
        Enterance = mapLoader.load("Maps/CastleEntry.tmx");
    }
}
