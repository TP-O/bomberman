package app.cache;

import java.util.List;

public interface Cache<T>
{
    public List<T> get();

    public void store(List<T> data);

    public void insert(T data);

    public void insert(List<T> data);

    public void delete(T data);
}
