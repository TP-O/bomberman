package modules;

import modules.camera.Camera;
import modules.keyboard.Keyboard;
import modules.mouse.Mouse;

import java.util.HashMap;
import java.util.Map;

import core.Handler;

public class Provider {

    private Handler handler;

    public Map<String, Module> modules;

    public Provider(Handler handler) {
        this.handler = handler;

        modules = new HashMap<String, Module>();
    }

    public void declare() {
        modules.put("mouse", new Mouse());
        modules.put("camera", new Camera());
        modules.put("keyboard", new Keyboard());
    }

    public void register() {
        declare();

        for (Map.Entry<String, Module> entry : modules.entrySet()) {
            entry.getValue().register(handler);
        }
    }
}
