package com.bun133.digdug.commands;

import com.bun133.digdug.DigDugGamer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShopCommand implements CommandExecutor, Listener {
    public DigDugGamer gamer;

    public ShopCommand(DigDugGamer gamer) {
        this.gamer = gamer;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            showShop((Player) sender);
            return true;
        } else {
            sender.sendMessage("This command is only for Player!");
        }
        return false;
    }

    private void showShop(Player sender) {
        Inventory shopInventory = Bukkit.createInventory(sender, Math.max(9, Math.min(54, Orders.orders.size())), "Shop");
        shopInventory.setContents(Orders.getOrdersStacks().toArray(new ItemStack[0]));
        sender.openInventory(shopInventory);
    }


    @EventHandler
    public void onInventoryClicked(InventoryClickEvent e) {
//        System.out.println("Title:"+e.getView().getTitle());
        if (e.getView().getTitle().equals("Shop")) {
            e.setCancelled(true);
            if(e.getCurrentItem().getType().equals(Material.AIR)) return;
            Order order = Orders.getOrder(e.getCurrentItem());
            if (order == null) return;
//            if (gamer.getPoint((Player) e.getWhoClicked()) < order.point) {
//                e.getWhoClicked().sendMessage(ChatColor.RED + "You don't have enough money!");
//                return;
//            }
            gamer.addPoint((Player) e.getWhoClicked(), -order.point);
            e.getWhoClicked().getInventory().addItem(order.getStack());
        }
    }
}
