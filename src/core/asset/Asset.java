package core.asset;

import java.awt.image.BufferedImage;

import helper.sheet.SpriteSheet;
import helper.Helper;

public class Asset
{
    public static BufferedImage rock, tree, grass, mushroom, cherry, maple;
    public static SpriteSheet kid;
                                          
    public static void init()
    {
        kid = Helper.createSpriteSheet(Helper.loadImage("characters/characters01.png"));
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
