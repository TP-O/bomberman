package helper.config;

public class Config
{
    public static String[] split(String str)
    {
        String[] result = str.split("\\.");

        try {
            if (result.length != 2) {
                throw new Exception("Config value is invalid!");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String get(String name)
    {
        try {
            String[] result = Config.split(name);
            Class cls = Class.forName("config." + result[0] +"Config");
            String val = (String) (cls.getField(result[1]).get(null));

            return val;
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
