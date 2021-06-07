package factories.trap;

import components.entities.statics.traps.Trap;
import components.entities.statics.traps.children.*;

public class BasicTrapFactory implements TrapFactory {

    @Override
    public Trap createTrap(String type, float x, float y) {
        Trap trap = null;

        switch (type) {
            case "Lava":
                trap = new Lava(x, y);
                break;

            default:
                trap = null;
        }

        return trap;
    }
}
