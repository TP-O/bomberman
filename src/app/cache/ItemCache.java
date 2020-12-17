package app.cache;

import java.util.ArrayList;
import java.util.List;

import components.entities.fixed.item.Item;

public class ItemCache implements Cache<Item>
{
    private static List<Item> data = new ArrayList<Item>();   

    @Override
    public List<Item> get()
    {
        return data;
    }

    @Override
    public void store(List<Item> data)
    {
        ItemCache.data = data;
    }

    @Override
    public void insert(Item data)
    {
        ItemCache.data.add(data);
    }

    @Override
    public void insert(List<Item> data)
    {
        ItemCache.data.addAll(data);
    }

    @Override
    public void delete(Item data)
    {
        ItemCache.data.remove(data);
    }   
}
