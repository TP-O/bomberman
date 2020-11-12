package config;

public class AppConfig
{
    public static String Name = "Boom";

    public static String AssetDir = System.getProperty("os.name").equals("Linux")
        ? System.getProperty("user.dir") + "/../res"
        : System.getProperty("user.dir") + "/boom/res";

    public static String ImageDir = AssetDir + "/image/";

    public static String MapDir = AssetDir + "/maps/";
}
