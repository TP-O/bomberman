package app.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import core.main.Handler;

public abstract class Model<T>
{
    protected T data;

    protected Handler handler;

    protected String path = "";

    public T get()
    {
        return data;
    }

    public JSONArray read(int phase)
    {
        JSONParser jsonParser = new JSONParser();

        // Open file
        try (FileReader reader = new FileReader(path))
        {   
            // Read JSON file
            Object obj = jsonParser.parse(reader);
            
            // Convert Object to JSONArray
            JSONArray jsonArray = (JSONArray) obj;

            return (JSONArray) jsonArray.get(phase - 1);
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
