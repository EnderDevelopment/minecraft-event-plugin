package com.enderdevelopment.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import com.enderdevelopment.plugin.commands.EventCommand;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("EventPlugin has been enabled!");
        this.getCommand("evento").setExecutor(new EventCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("EventPlugin has been disabled!");
    }
}