package helper.file;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import config.AppConfig;

public class FileLoader {

    public static BufferedImage loadImage(String path) {
        try {
            File f = new File(AppConfig.IMAGE_DIR + path);

            return ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    public static String loadFileAsString(String path) {
        String line;
        StringBuilder SBuilder = new StringBuilder();

        try {
            FileReader f = new FileReader(path);

            BufferedReader BReader = new BufferedReader(f);

            while ((line = BReader.readLine()) != null) {
                SBuilder.append(line + "\n");
            }

            BReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return SBuilder.toString();
    }

    public static JSONArray readJSON(String path) {
        JSONParser jsonParser = new JSONParser();

        // Open file
        try (FileReader reader = new FileReader(path)) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            // Convert Object to JSONArray
            JSONArray jsonArray = (JSONArray) obj;

            return jsonArray;

            // return (JSONArray) jsonArray.get(phase - 1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        throw new Error("JSON file doesn't exist");
    }
}
