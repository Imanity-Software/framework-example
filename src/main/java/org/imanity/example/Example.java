package org.imanity.example;

import org.imanity.example.handler.ExampleBoardHandler;
import org.imanity.example.handler.ExampleBossBarHandler;
import org.imanity.example.handler.ExampleMovementHandler;
import org.imanity.example.handler.ExampleTablistHandler;
import org.imanity.framework.Autowired;
import org.imanity.framework.bukkit.Imanity;
import org.imanity.framework.bukkit.plugin.ImanityPlugin;
import org.imanity.framework.plugin.Plugin;
import org.imanity.framework.plugin.PluginDependency;
import org.imanity.framework.plugin.PluginLoadOrder;
import org.imanity.framework.plugin.PluginType;

@Plugin(
        name = "example",                                     // Plugin Name
        version = "1.0.0",                                    // Version
        description = "The example description",              // Descriptions
        load = PluginLoadOrder.POSTWORLD,                     // Plugin Load Order
        authors = "LeeGod",                                   // Authors
//      depends = @PluginDependency("MyDependency")           // Dependency
//      @PluginDependency("MySoftDependency", soft = true)    // For Soft Dependency
//      loadBefore = "SomePlugin",
        type = PluginType.BUKKIT                              // Type
)
public class Example extends ImanityPlugin {

    @Override
    public void preEnable() {
        // Before Imanity Framework boot up
    }

    @Override
    public void postEnable() {
        // After Imanity Framework boot up, most of things are recommend to be done in here

        Imanity.registerMovementListener(new ExampleMovementHandler());
        Imanity.registerTablistHandler(new ExampleTablistHandler());
        Imanity.registerBoardHandler(new ExampleBoardHandler());
        Imanity.registerBossBarHandler(new ExampleBossBarHandler());
    }

    @Override
    public void preDisable() {
        // Before Imanity Framework shut down, most of things are recommend to be done in here
    }

    @Override
    public void postDisable() {
        // After Imanity Framework shut down
    }
}
