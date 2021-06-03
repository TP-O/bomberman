package helper;

import helper.event.EventCalling;

import java.awt.image.BufferedImage;

import org.json.simple.JSONArray;

import components.tiles.Tile;
import app.events.Event;
import helper.file.FileLoader;
import helper.sheet.SpriteSheet;

public class Helper {

    public static BufferedImage loadImage(String path) {
        return FileLoader.loadImage(path);
    }

    public static String loadFileAsString(String path) {
        return FileLoader.loadFileAsString(path);
    }

    public static JSONArray readJsonArray(String path) {
        return FileLoader.readJSON(path);
    }

    public static SpriteSheet createSpriteSheet(BufferedImage sheet) {
        return new SpriteSheet(sheet);
    }

    public static int getXOfTile(float x) {
        return (int) x / Tile.WIDTH;
    }

    public static int getYOfTile(float y) {
        return (int) y / Tile.HEIGHT;
    }

    public static boolean checkOverlap(float x1, float y1, int w1, int h1, float x2, float y2, int w2, int h2) {
        return ((x2 - x1 > 0 && x2 - x1 <= w1) || (x2 - x1 < 0 && x2 - x1 >= -w2))
                && ((y2 - y1 > 0 && y2 - y1 <= h1) || (y2 - y1 < 0 && y2 - y1 >= -h2));
    }

    public static void event(Event event) {
        EventCalling.event(event);
    }
}
