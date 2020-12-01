package core.asset;

import helper.sheet.SpriteSheet;
import helper.Helper;

public class Asset
{
    public static SpriteSheet ui;
    public static SpriteSheet obstacle;
    public static SpriteSheet flameExplosion, fireExplosion, mineExplosion, bigExplosion, nuclearExplosion,
            poisonExplosion, smallExplosion, bomb;
    public static SpriteSheet kid, monk, shadow, kirito, goku, satoshi;
    public static SpriteSheet alolanPersian, shinyZygarde, scorbunny, bulbasaur, redBoss, blueBoss;
                                          
    public static void loadImage()
    {
        // Obstacle sheets
        obstacle = Helper.createSpriteSheet(Helper.loadImage("obstacles/obstacle01.png"));

        // UI sheets
        ui = Helper.createSpriteSheet(Helper.loadImage("ui/ui02.jpg"));

        // Player sheets
        kid = Helper.createSpriteSheet(Helper.loadImage("characters/characters01.png"));
        monk = Helper.createSpriteSheet(Helper.loadImage("characters/characters02.png"));
        shadow = Helper.createSpriteSheet(Helper.loadImage("characters/characters03.png"));
        kirito = Helper.createSpriteSheet(Helper.loadImage("characters/characters04.png"));
        goku = Helper.createSpriteSheet(Helper.loadImage("characters/characters05.png"));
        satoshi = Helper.createSpriteSheet(Helper.loadImage("characters/characters06.png"));

        // Monster sheets
        alolanPersian = Helper.createSpriteSheet(Helper.loadImage("characters/monsters01.png"));
        shinyZygarde = Helper.createSpriteSheet(Helper.loadImage("characters/monsters02.png"));
        scorbunny  = Helper.createSpriteSheet(Helper.loadImage("characters/monsters03.png"));
        bulbasaur = Helper.createSpriteSheet(Helper.loadImage("characters/monsters04.png"));
        redBoss = Helper.createSpriteSheet(Helper.loadImage("characters/monsters05.png"));
        blueBoss = Helper.createSpriteSheet(Helper.loadImage("characters/monsters05.png"));

        // Bomb sheets
        flameExplosion = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions01.png"));
        mineExplosion = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions02.png"));
        fireExplosion = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions03.png"));
        bigExplosion = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions04.png"));
        nuclearExplosion = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions05.png"));
        smallExplosion = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions06.png"));
        poisonExplosion = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions08.png"));
        bomb = Helper.createSpriteSheet(Helper.loadImage("bombs/bomb.png"));
    }
}
