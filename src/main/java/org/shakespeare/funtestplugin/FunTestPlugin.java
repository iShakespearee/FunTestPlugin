package org.shakespeare.funtestplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.shakespeare.funtestplugin.commands.ResourcepackCommand;
import org.shakespeare.funtestplugin.commands.ThorCommand;

public final class FunTestPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ThorCommand(), this);

        getCommand("thor").setExecutor(new ThorCommand());

    }
}
