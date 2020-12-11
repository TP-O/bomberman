package app.model;

import java.util.ArrayList;

import entity.item.Item;

public class ItemModel 
{
    private static ArrayList<Item> data = new ArrayList<Item>();    

    public static ArrayList<Item> all()
    {
        return data;
    }

    public static void insert(Item item) 
    {
        data.add(item);
    }

    public static void delete(Item item)
    {
        data.remove(item);
    }
}