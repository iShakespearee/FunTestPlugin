package org.shakespeare.funtestplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.shakespeare.funtestplugin.commands.ThorCommand;

public final class FunTestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new ThorCommand(), thi);

        getCommand("thor").setExecutor(new ThorCommand());

    }

}
