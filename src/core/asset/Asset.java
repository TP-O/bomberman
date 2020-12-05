package core.asset;

import helper.sheet.SpriteSheet;
import helper.Helper;

public class Asset
{
    public static SpriteSheet ui;
    public static SpriteSheet obstacle;

    // Bombs
    public static SpriteSheet explosionA, explosionB, explosionC, explosionD,
            explosionE, explosionF, explosionG, explosionH, explosionJ, explosionK,
            explosionL, bomb;

    // Characters
    public static SpriteSheet kid, monk, shadow, kirito, goku, satoshi;
    public static SpriteSheet alolanPersian, shinyZygarde, scorbunny, bulbasaur,
            redBoss, blueBoss;
                                          
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
        explosionA = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions01.png"));
        explosionB = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions02.png"));
        explosionC = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions03.png"));
        explosionD = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions04.png"));
        explosionE = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions05.png"));
        explosionF = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions06.png"));
        explosionG = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions07.png"));
        explosionH = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions08.png"));
        explosionJ = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions10.png"));
        explosionK = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions11.png"));
        explosionL = Helper.createSpriteSheet(Helper.loadImage("bombs/explosions12.png"));
        bomb = Helper.createSpriteSheet(Helper.loadImage("bombs/bomb.png"));
    }
}
