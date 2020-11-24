package core.asset;

import java.awt.image.BufferedImage;

import javax.crypto.spec.ChaCha20ParameterSpec;

import helper.sheet.SpriteSheet;
import helper.Helper;

public class Asset
{
    public static BufferedImage rock, tree, grass, mushroom, cherry, maple;
    public static BufferedImage[] player_down, 
                                   player_up, 
                                   player_left,     
                                   player_right,   
                                   player_stand;
                                          

    public static void init()
    {
        SpriteSheet obstacleSheet = Helper.createSpriteSheet(Helper.loadImage("obstacles/obstacle01.png"));
        SpriteSheet charactersSheet = Helper.createSpriteSheet(Helper.loadImage("characters/characters01.png"));

            player_down = new BufferedImage[2];
            player_up = new BufferedImage[2];
            player_left = new BufferedImage[2];
            player_right = new BufferedImage[2];
            player_stand = new BufferedImage[1];
           



       // player_down [0] = charactersSheet.crop(0, 0, 190, 280);
        player_down [0] = charactersSheet.crop(250, 0, 190, 280);
        player_down [1] = charactersSheet.crop(500, 0, 190, 280);
       

       // player_up[0] = charactersSheet.crop(0, 300, 190, 280);
        player_up[0] = charactersSheet.crop(250, 300, 190, 280);
        player_up[1] = charactersSheet.crop(500, 300, 190, 280);
      

      //  player_left[0] = charactersSheet.crop(0, 580, 190, 280);
        player_left[0] = charactersSheet.crop(250, 580, 190, 280);
        player_left[1] = charactersSheet.crop(510, 580, 190, 280);
        

      //  player_right[0] = charactersSheet.crop(0, 850, 190, 280);
        player_right[0] = charactersSheet.crop(280, 850, 190, 280);
        player_right[1] = charactersSheet.crop(525, 850, 190, 280);

        player_stand[0] = charactersSheet.crop(0, 0, 190, 280);
       

        
        rock = obstacleSheet.crop(153, 31, 38, 38);
        tree = obstacleSheet.crop(9, 23, 56, 64);
        grass = obstacleSheet.crop(0, 0, 25, 25);
        mushroom = obstacleSheet.crop(312, 15, 34, 33);
        cherry = obstacleSheet.crop(306, 119, 49, 58);
        maple = obstacleSheet.crop(167, 81, 47, 58);

        
    }
}
