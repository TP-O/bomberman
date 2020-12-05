package core.entity.character.builder;

import app.controller.GameController;
import core.entity.character.Character;

public interface CharacterBuilder
{
    public CharacterBuilder type(String type);

    public CharacterBuilder setX(float x);

    public CharacterBuilder setY(float y);

    public CharacterBuilder setWidth(int width);

    public CharacterBuilder setHeight(int height);

    public CharacterBuilder setHealth(int health);

    public CharacterBuilder setDamge(int damge) throws Exception;

    public CharacterBuilder setSpeed(float speed);

    public CharacterBuilder setGame(GameController gameController);

    public Character build();
}
