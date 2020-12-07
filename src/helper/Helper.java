package helper;

import helper.event.EventCalling;

import java.awt.image.BufferedImage;

import tile.Tile;
import app.event.event.Event;
import helper.file.FileLoader;
import helper.sheet.SpriteSheet;

public class Helper
{
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

    public static int getXOfTile(float x)
    {
        return (int) x / Tile.WIDTH;
    }

    public static int getYOfTile(float y)
    {
        return (int) y / Tile.HEIGHT;
    }

    public static boolean inSquare(float x, float y, float qx, float qy, int width, int height)
    {
        return x >= qx
            && x <= qx + width
            && y >= qy
            && y <= qy + height;
    }

    public static void event(Event event)
    {
        EventCalling.event(event);
    }
}
