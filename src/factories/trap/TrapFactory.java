package factories.trap;

import components.entities.statics.traps.Trap;

public interface TrapFactory {
    public Trap createTrap(String type, float x, float y);
}
