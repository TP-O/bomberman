package asset;

import java.util.HashMap;
import java.util.Map;

import helper.Helper;
import helper.sheet.SpriteSheet;

public class Asset {

    private static AssetMap assets;

    private static Map<String, SpriteSheet> sheets;

    public static void init() {
        bind(

            /**
             * Explsion images
             */
            "explosion01@explosions/explosion01.png",
            "explosion02@explosions/explosion02.png",
            "explosion03@explosions/explosion03.png",
            "explosion04@explosions/explosion04.png",
            "explosion05@explosions/explosion05.png",
            "explosion06@explosions/explosion06.png",
            "explosion07@explosions/explosion07.png",
            "explosion08@explosions/explosion08.png",
            "explosion09@explosions/explosion09.png",
            "explosion10@explosions/explosion10.png",
            "explosion11@explosions/explosion11.png",
            "explosion12@explosions/explosion12.png",

            /**
             * Background images
             */
            "bg01@backgrounds/character-selection-background.jpg",
            "bg02@backgrounds/menu-background.jpg",

            /**
             * Bomb images
             */
            "bomb01@bombs/bomb01.png",

            /**
             * Item images
             */
            "life@items/heart.png",
            "heal-potion@items/heal-potion.png",
            "damage-potion@items/damage-potion.png",
            "speed-potion@items/speed-potion.png",

            /**
             * Monster images
             */
            "alolanpersian@characters/monsters/monster01.png",
            "monster2@characters/monsters/monster02.png",
            "scorbunny@characters/monsters/monster03.png",
            "bulbasaur@characters/monsters/monster04.png",
            "emboar@characters/monsters/monster05.png",
            "shinyzygarde@characters/monsters/monster05.png",
            "suicide@characters/monsters/suicide.png",
            "gastly@characters/monsters/gastly.png",
            "gengar@characters/monsters/gengar.png",
            "yveltal@characters/monsters/yveltal.png",

            /**
             * Player images
             */
            "goku@characters/players/goku.png",
            "kid@characters/players/kid.png",
            "kirito@characters/players/kirito.png",
            "monk@characters/players/monk.png",
            "satoshi@characters/players/satoshi.png",
            "shadow@characters/players/shadow.png",

            /**
             * UI images
             */
            "ui01@user-interfaces/button01.png",
            "ui02@user-interfaces/button02.png",
            "ui03@user-interfaces/frame01.png",
            "kid-avatar@user-interfaces/kid-avatar.png",
            "monk-avatar@user-interfaces/monk-avatar.png",
            "shadow-avatar@user-interfaces/shadow-avatar.png",
            "kirito-avatar@user-interfaces/kirito-avatar.png",
            "goku-avatar@user-interfaces/goku-avatar.png",
            "satoshi-avatar@user-interfaces/satoshi-avatar.jpg",
            "kirito-background@user-interfaces/kirito-background.png",
            "goku-background@user-interfaces/goku-background.jpg",
            "satoshi-background@user-interfaces/satoshi-background.jpg",

            /**
             * Tile images
             */
            "tile01@tiles/tiles01.jpg",

            /**
             * Obstacle images
             */
            "rock@obstacles/rock.png",

            /**
             * Trap images
             */
            "lava@traps/lava.png",

            /**
             * Block images
             */
            "block01@blocks/block01.png"
        );
    }

    public static SpriteSheet get(String key) {
        return sheets.get(key) == null
                ? load(key)
                : sheets.get(key);
    }

    private static SpriteSheet load(String key) {
        sheets.put(key, Helper.createSpriteSheet(Helper.loadImage(assets.get(key))));

        return sheets.get(key);
    }

    private static void bind(String... value) {
        assets = new AssetMap(value);
        sheets = new HashMap<String, SpriteSheet>();
    }
}
