package factories.monster;

import components.entities.dynamics.DynamicEntity;
import components.entities.dynamics.characters.monster.Monster;
import components.entities.dynamics.characters.monster.children.*;

public class BasicMonsterFactory implements MonsterFactory {

    @Override
    public Monster createMonster(String type, float x, float y) {
        Monster monster = null;

        switch (type) {
            case "AlolanPersian":
                monster = new AlolanPersian(x, y);
                break;

            case "Bulbasaur":
                monster = new Bulbasaur(x, y);
                break;

            case "Emboar":
                monster = new Emboar(x, y);
                break;

            case "Scorbunny":
                monster = new Scorbunny(x, y);
                break;

            case "ShinyEmboar":
                monster = new ShinyEmboar(x, y);
                break;

            case "ShinyZygarde":
                monster = new ShinyZygarde(x, y);
                break;

            case "Boss":
                monster = new Boss(x, y);
                break;

            case "Suicide":
                monster = new Suicide(x, y);
                break;

            default:
                monster = null;
        }

        return monster;
    }

    @Override
    public DynamicEntity createTopMonster() {
        // TODO Auto-generated method stub
        return null;
    }
}
