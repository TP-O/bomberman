package helper.file;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.imageio.ImageIO;

public class FileLoader
{
    public static BufferedImage loadImage(String path)
    {
        try {
            File f = new File("/home/TP-O/Desktop/repo/Games/boom/res" + path);
            
            return ImageIO.read(f);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    public static String loadFileAsString(String path)
    {
        String line;
        StringBuilder SBuilder = new StringBuilder();

        try {
            FileReader f = new FileReader("/home/TP-O/Desktop/repo/Games/boom/res" + path);

            BufferedReader BReader = new BufferedReader(f);
            
            while ((line = BReader.readLine()) != null) {
                SBuilder.append(line + "\n");
            }

            BReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return SBuilder.toString();
    }
}
