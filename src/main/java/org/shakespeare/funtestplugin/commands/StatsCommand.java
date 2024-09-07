package org.shakespeare.funtestplugin.commands;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class StatsCommand implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (args.length != 1) {
                player.sendMessage("§c§lINVALID USAGE!");
                return true;
            }
            // MAKE A /MYSTATS GUI LATER ON!
            // MAKE A /MYSTATS GUI LATER ON!
            // MAKE A /MYSTATS GUI LATER ON!

            String statType = args[0].toLowerCase();

            switch (statType) {
                case "cake":
                    player.getStatistic(Statistic.CAKE_SLICES_EATEN);
                    player.sendMessage("§e§lCAKE EATEN IS " + player.getStatistic(Statistic.CAKE_SLICES_EATEN) + "!");
                    break;
                case "anvil":
                    player.getStatistic(Statistic.INTERACT_WITH_ANVIL);
                    player.sendMessage("§b§lYOU HAVE USED AN ANVIL " + player.getStatistic(Statistic.INTERACT_WITH_ANVIL) + " TIMES!");
                    break;
                case "sword":
                    int diamondSwordsCrafted = player.getStatistic(Statistic.CRAFT_ITEM, Material.DIAMOND_SWORD);
                    int netheriteSwordsCrafted = player.getStatistic(Statistic.CRAFT_ITEM, Material.NETHERITE_SWORD);
                    int ironSwordsCrafted = player.getStatistic(Statistic.CRAFT_ITEM, Material.IRON_SWORD);
                    int goldSwordsCrafted = player.getStatistic(Statistic.CRAFT_ITEM, Material.GOLDEN_SWORD);
                    int woodSwordCrafted = player.getStatistic(Statistic.CRAFT_ITEM, Material.WOODEN_SWORD);
                    int totalSwordsCrafted = diamondSwordsCrafted + netheriteSwordsCrafted + ironSwordsCrafted + goldSwordsCrafted + woodSwordCrafted;

                    player.sendMessage("§6§lYOUR TOTAL SWORDS CRAFTED AMOUNT IS " + totalSwordsCrafted + "!");

                    break;
                default:
                    player.sendMessage("§c§lTHIS MYSTATS TYPE DOESN'T EXIST YET!");

            }


            return true;
        }
    return false;
    }


}