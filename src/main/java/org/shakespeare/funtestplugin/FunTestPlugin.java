package org.shakespeare.funtestplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.shakespeare.funtestplugin.commands.StatsCommand;
import org.shakespeare.funtestplugin.commands.ThorCommand;

public final class FunTestPlugin extends JavaPlugin implements Listener {
        ToggleCommand toggleCommand = new ToggleCommand();
    @Override
    public void onEnable() {
        // Events
        getServer().getPluginManager().registerEvents(new ThorCommand(), this);
        getServer().getPluginManager().registerEvents(new FunBruhCommand(), this);
        getServer().getPluginManager().registerEvents(toggleCommand, this);
        getServer().getPluginManager().registerEvents(new StatsCommand(), this);
        // Commands
        getCommand("thor").setExecutor(new ThorCommand());
        getCommand("fun").setExecutor(new FunBruhCommand());
        getCommand("toggle").setExecutor(toggleCommand);
        getCommand("mystats").setExecutor(new StatsCommand());

    }
}
