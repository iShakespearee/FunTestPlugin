package org.shakespeare.funtestplugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class FunBruhCommand implements CommandExecutor, Listener {

    private boolean enabled = true;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (args.length == 0) {
                player.sendMessage("§c§lINVALID USAGE!");
                return true;
            }

            String funType = args[0].toLowerCase();


            switch (funType) {
                case "stick":

                    ItemStack stick = new ItemStack(Material.STICK);
                    ItemMeta stickMeta = (ItemMeta) stick.getItemMeta();

                    stickMeta.addEnchant(Enchantment.KNOCKBACK, 10, true);
                    stickMeta.setDisplayName("§3§lKNOCK 'EM OUT!");

                    List<String>stickLore = new ArrayList<>();
                    stickLore.add("§b§lTHROW THEM BACK FAR");
                    stickLore.add("§b§lSO SO SO FAR!");
                    stickMeta.setLore(stickLore);

                    stick.setItemMeta(stickMeta);
                    player.getInventory().addItem(stick);

                    player.sendTitle("","§b§lEQUIPPED THE STICKY STICK!", 20, 3, 20);

                    break;
                case "bow":

                    ItemStack bow = new ItemStack(Material.BOW);
                    ItemMeta bowMeta = (ItemMeta) bow.getItemMeta();

                    bowMeta.setDisplayName("§c§lTHE BOW OF APOLLO");
                    bowMeta.addEnchant(Enchantment.PUNCH, 5, true);
                    bowMeta.addEnchant(Enchantment.FLAME, 5, true);
                    bowMeta.addEnchant(Enchantment.POWER, 10, true);

                    List<String>bowLore = new ArrayList<>();
                    bowLore.add("§c§lTHIS BOW WAS GIVEN TO YOU");
                    bowLore.add("§c§lBY THE APOLLO");
                    bowLore.add("§c§lUSE IT WISELY");
                    bowLore.add("§c§lOR BE SLAIN HORRIBLY");

                    bowMeta.setLore(bowLore);
                    bow.setItemMeta(bowMeta);
                    player.getInventory().addItem(bow);

                    player.sendTitle("", "§c§lEQUPPED APOLLO'S BOW!", 20, 3, 20);

                    break;
                case "sword":

                    ItemStack sword = new ItemStack(Material.GOLDEN_SWORD);
                    ItemMeta swordMeta = (ItemMeta) sword.getItemMeta();
                    swordMeta.setDisplayName("§e§lSWORD OF ZEUS");
                    swordMeta.addEnchant(Enchantment.SHARPNESS, 10, true);
                    swordMeta.addEnchant(Enchantment.UNBREAKING, 10, true);
                    swordMeta.addEnchant(Enchantment.KNOCKBACK, 5, true);
                    swordMeta.addEnchant(Enchantment.MENDING, 10, true);
                    swordMeta.addEnchant(Enchantment.FIRE_ASPECT, 3, true);

                    List<String>swordLore = new ArrayList<>();
                    swordLore.add("§6§lTHIS IS THE SWORD OF ZEUS");
                    swordLore.add("§6§lUSE IT WISELY OR GO");
                    swordLore.add("§6§lTO THE DEPTHS OF TARTARUS");

                    swordMeta.setLore(swordLore);
                    sword.setItemMeta(swordMeta);
                    player.getInventory().addItem(sword);

                    player.sendTitle("", "§6§lEQUIPPED THE SWORD OF ZEUS!", 20, 3, 20);
                    player.getWorld().strikeLightningEffect(player.getLocation());

                    break;
                default:
                    player.sendMessage("§c§lTHIS ITEM TYPE DOES NOT EXIST YET!");
                    break;
            }

        }

        return true;
    }
}
