package dev.banditco;

import dev.banditco.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class chrono extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        ItemManager.init();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
