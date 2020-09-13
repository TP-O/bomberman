package core.asset;

import java.awt.image.BufferedImage;

import helper.file.FileLoader;
import helper.sheet.SpriteSheet;

public class Asset
{
    public static BufferedImage rock, tree, grass, player;
    
    public static void init()
    {
        SpriteSheet obstacleSheet = new SpriteSheet(FileLoader.loadImage("/image/obstacles/obstacle01.png"));
        SpriteSheet charactersSheet = new SpriteSheet(FileLoader.loadImage("/image/characters/characters01.png"));

        rock = obstacleSheet.crop(42, 84, 40, 42);
        tree = obstacleSheet.crop(10, 20, 60, 65);
        grass = obstacleSheet.crop(0, 0, 25, 25);

        player = charactersSheet.crop(0, 0, 190, 280);
    }
}
