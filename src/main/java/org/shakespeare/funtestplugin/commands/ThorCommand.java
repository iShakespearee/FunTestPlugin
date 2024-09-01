package org.shakespeare.funtestplugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ThorCommand implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            ItemStack hammer = new ItemStack(Material.MACE);
            ItemMeta hammerMeta = (ItemMeta) hammer.getItemMeta();
            hammerMeta.setDisplayName("§b§lTHOR'S HAMMER");

            List<String> hammerLore = new ArrayList<>();
            hammerLore.add("§3§lTHE HAMMER OF THOR");
            hammerLore.add("§3§lIS YOURS FOR THE TAKING");
            hammerLore.add("§3§lO' WORTHY ONE!");
            hammerMeta.setLore(hammerLore);

            hammer.setItemMeta(hammerMeta);
            player.getInventory().addItem(hammer);

            player.sendTitle("", "§e§lZAAAAAAP!", 20, 3, 20);
            player.getWorld().strikeLightningEffect(player.getLocation());
        }
        return false;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack hammer = player.getInventory().getItemInMainHand();

        if (hammer != null && hammer.getType().equals(Material.MACE) && hammer.hasItemMeta()) {
            ItemMeta hammerMeta = hammer.getItemMeta();

            if (hammerMeta != null && hammerMeta.getDisplayName().equals("§b§lTHOR'S HAMMER")) {
                player.getWorld().strikeLightningEffect(player.getLocation());
            }
        }

    }

}

