package org.shakespeare.funtestplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ToggleCommand implements CommandExecutor, Listener {
    private boolean enabled = true;
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (args.length < 0) {
                player.sendMessage("§c§lINVALID USAGE! §c/toggle");
            }

            if (enabled) {
                enabled = false;
                player.sendTitle("", "§c§lDISABLED CHAT!", 20, 3, 20);
            } else {
                enabled = true;
                player.sendTitle("", "§a§lENABLED CHAT!", 20, 3, 20);
            }

        }

        return true;
    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        if (!enabled) {
            e.setCancelled(true);
            e.getPlayer().sendMessage("§c§lYOU CANNOT SPEAK WHILE CHAT IS DISABLED!");
        }
    }
}
