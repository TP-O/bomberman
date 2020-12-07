package asset;

import helper.sheet.SpriteSheet;
import helper.Helper;

public class Asset
{
    public static SpriteSheet obstacle;
  
    // UI
    public static SpriteSheet ui01, ui02, ui03;
    public static SpriteSheet bg01, bg02;        

    // Bombs
    public static SpriteSheet explosionA, explosionB, explosionC, explosionD,
            explosionE, explosionF, explosionG, explosionH, explosionJ, explosionK,
            explosionL, bomb;

    // Characters
    public static SpriteSheet kid, monk, shadow, kirito, goku, satoshi;
    public static SpriteSheet alolanPersian, shinyZygarde, scorbunny, bulbasaur,
            redBoss, blueBoss;
    public static SpriteSheet kidAvatar, monkAvatar, shadowAvatar, kiritoAvatar,
            gokuAvatar, satoshiAvatar, kiritoBackground, gokuBackground, satoshiBackground;
                                          
    public static void loadImage()
    {
        // Obstacle sheets
        obstacle = Helper.createSpriteSheet(Helper.loadImage("obstacles/obstacle01.png"));

        // UI sheets
        ui01 = Helper.createSpriteSheet(Helper.loadImage("ui/ui01.png"));
        ui02 = Helper.createSpriteSheet(Helper.loadImage("ui/ui02.png"));
        ui03 = Helper.createSpriteSheet(Helper.loadImage("ui/ui03.png")); 

        // Background sheets
        bg01 = Helper.createSpriteSheet(Helper.loadImage("backgrounds/backgrounds01.jpg"));
        bg02 = Helper.createSpriteSheet(Helper.loadImage("backgrounds/backgrounds02.jpg"));

        //Characters Avatar sheets 
        kidAvatar = Helper.createSpriteSheet(Helper.loadImage("ui/kid-avatar.png")); 
        monkAvatar = Helper.createSpriteSheet(Helper.loadImage("ui/monk-avatar.png")); 
        shadowAvatar = Helper.createSpriteSheet(Helper.loadImage("ui/shadow-avatar.png")); 
        kiritoAvatar = Helper.createSpriteSheet(Helper.loadImage("ui/kirito-avatar.png")); 
        gokuAvatar = Helper.createSpriteSheet(Helper.loadImage("ui/goku-avatar.png")); 
        satoshiAvatar = Helper.createSpriteSheet(Helper.loadImage("ui/satoshi-avatar.jpg"));    
        kiritoBackground = Helper.createSpriteSheet(Helper.loadImage("ui/kirito-background.png")); 
        gokuBackground = Helper.createSpriteSheet(Helper.loadImage("ui/goku-background.jpg"));
        satoshiBackground = Helper.createSpriteSheet(Helper.loadImage("ui/satoshi-background.jpg"));   

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
