package app.models;

public interface Model<T>
{
    public T get();

    public Model<T> whereType(String type);

    public Model<T> wherePhase(int phase);
}
