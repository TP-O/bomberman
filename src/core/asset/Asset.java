package core.asset;

import java.awt.image.BufferedImage;
import helper.sheet.SpriteSheet;
import helper.Helper;

public class Asset
{
    public static BufferedImage rock, tree, grass, mushroom, cherry, maple;
    public static SpriteSheet kid, monk, shadow, kirito, goku, satoshi;
    public static SpriteSheet cat, dog, bird, turtle, boss;
    public static SpriteSheet ui;

                                          
    public static void init()
    {
        kid = Helper.createSpriteSheet(Helper.loadImage("characters/characters01.png"));
        monk = Helper.createSpriteSheet(Helper.loadImage("characters/characters02.png"));
        shadow = Helper.createSpriteSheet(Helper.loadImage("characters/characters03.png"));
        kirito = Helper.createSpriteSheet(Helper.loadImage("characters/characters04.png"));
        goku = Helper.createSpriteSheet(Helper.loadImage("characters/characters05.png"));
        satoshi = Helper.createSpriteSheet(Helper.loadImage("characters/characters06.png"));
        cat = Helper.createSpriteSheet(Helper.loadImage("characters/monsters01.png"));
        dog = Helper.createSpriteSheet(Helper.loadImage("characters/monsters02.png"));
        bird = Helper.createSpriteSheet(Helper.loadImage("characters/monsters03.png"));
        turtle = Helper.createSpriteSheet(Helper.loadImage("characters/monsters04.png"));
        boss = Helper.createSpriteSheet(Helper.loadImage("characters/monsters05.png"));
        ui = Helper.createSpriteSheet(Helper.loadImage("ui/ui02.jpg"));
        SpriteSheet obstacleSheet = Helper.createSpriteSheet(Helper.loadImage("obstacles/obstacle01.png"));
        
        initObstacle(obstacleSheet);
    }

    static void initObstacle(SpriteSheet obstacleSheet)
    {
        tree = obstacleSheet.crop(9, 23, 56, 64);
        grass = obstacleSheet.crop(0, 0, 25, 25);
        rock = obstacleSheet.crop(153, 31, 38, 38);
        maple = obstacleSheet.crop(167, 81, 47, 58);
        cherry = obstacleSheet.crop(306, 119, 49, 58);
        mushroom = obstacleSheet.crop(312, 15, 34, 33);
    }
}
