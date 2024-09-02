package org.shakespeare.funtestplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class ResourcepackCommand implements CommandExecutor, Listener {
    private boolean enabled = true;
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (args.length == 0) {
                player.setResourcePack("https://filebin.net/u8b5gx5hudqv0hp1/flowered-vanilla-no-of.zip");
                player.sendMessage("§a§lRESOURCEPACK ENABLED!");
            } else {
                player.setResourcePack("https://example.com/empty-resourcepack.zip", null);
                player.sendMessage("§c§lRESOURCEPACK DISABLED!");
            }
        }



        return false;
    }
}
