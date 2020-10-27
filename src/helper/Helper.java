package helper;

import helper.config.Config;
import java.awt.image.BufferedImage;
import helper.file.FileLoader;
import helper.sheet.SpriteSheet;

public class Helper
{
    public static String config(String name)
    {
        return Config.get(name);
    }

    public static BufferedImage loadImage(String path)
    {
        return FileLoader.loadImage(path);
    }

    public static String loadFileAsString(String path)
    {
        return FileLoader.loadFileAsString(path);
    }

    public static SpriteSheet createSpriteSheet(BufferedImage sheet)
    {
        return new SpriteSheet(sheet);
    }
}
