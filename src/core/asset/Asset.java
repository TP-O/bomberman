package core.asset;

import java.awt.image.BufferedImage;
import helper.sheet.SpriteSheet;
import helper.Helper;

public class Asset
{
    public static BufferedImage rock, tree, grass, mushroom, cherry, maple, player;
    
    public static void init()
    {
        SpriteSheet obstacleSheet = Helper.createSpriteSheet(Helper.loadImage("obstacles/obstacle01.png"));
        SpriteSheet charactersSheet = Helper.createSpriteSheet(Helper.loadImage("characters/characters01.png"));

        rock = obstacleSheet.crop(153, 31, 38, 38);
        tree = obstacleSheet.crop(9, 23, 56, 64);
        grass = obstacleSheet.crop(0, 0, 25, 25);
        mushroom = obstacleSheet.crop(312, 15, 34, 33);
        cherry = obstacleSheet.crop(306, 119, 49, 58);
        maple = obstacleSheet.crop(167, 81, 47, 58);

        player = charactersSheet.crop(0, 0, 190, 280);
    }
}
