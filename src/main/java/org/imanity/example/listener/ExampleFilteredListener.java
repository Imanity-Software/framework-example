package org.imanity.example.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.imanity.example.Example;
import org.imanity.framework.BeanConstructor;
import org.imanity.framework.Component;
import org.imanity.framework.bukkit.listener.FilteredEventList;
import org.imanity.framework.bukkit.listener.FilteredListener;
import org.imanity.framework.bukkit.listener.annotation.IgnoredFilters;

// This tag let framework know this is a part of component, add this so framework can scan this class
// And by this you don't need to do any registerListener thing, it will be automatically scanned
@Component
public class ExampleFilteredListener extends FilteredListener<Example> { // FilteredListener<? extends Plugin>

    /**
     *
     * This is an extension of normal Listener
     *
     * basically you can add a filter to it, and every time before calling the event
     * It needs to pass the filter you put in
     *
     * Very useful for things such as minigame listeners
     *
     */

    @BeanConstructor // This annotation let's framework know that you'll be using this constructor to construct this instance
    public ExampleFilteredListener(Example plugin) { // Anything that is bean can be placed in bean constructor, it's will automatically search beans for it, and since Example is a plugin, and by default plugins will be registered as bean in framework
        this.initial(plugin, FilteredEventList.builder()
                .filter((player, event) -> player.isOp()) // In this example we want every event related to player, the player need to be an OP
                .build());
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        player.sendMessage("OMG OP YOU BREAK A BLOCK");
    }

    @IgnoredFilters // Adding this annotation will ignore any filters you pass in
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        event.getPlayer().sendMessage("OK YOU PLACED A BLOCK AND IDK IF YOU ARE AN OP OR NOT");
    }

}
