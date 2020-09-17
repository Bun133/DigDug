package com.bun133.digdug.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    public int point;
    private Material material;
    public int count;
    private ItemStack stack = null;

    public Order(int point, Material item, int count) {
        this.count = count;
        this.material = item;
        this.point = point;
    }

    public Order(int point, ItemStack stack) {
        this.point = point;
        this.stack = stack;
    }

    public ItemStack getStack() {
        if(!getStackLegacy().getType().equals(Material.AIR)){
            return modValue(getStackLegacy());
        }else return getStackLegacy();
//        if (stack != null) return modValue(stack.clone());
//        return modValue(new ItemStack(material, count));
    }

    private ItemStack getStackLegacy(){
        if(stack!=null) return stack;
        return new ItemStack(material,count);
    }

    private ItemStack modValue(ItemStack before) {
        ItemMeta meta = before.getItemMeta();
        List<String> lores;
        if (meta.hasLore()) {
            lores = meta.getLore();
        }else lores = new ArrayList<>();
        if(lores == null) System.out.println("Lore is Null");
        if(!lores.contains(ChatColor.BOLD + "Price:" + point)) {
            meta.setLore(
                    addEntry(lores, ChatColor.BOLD + "Price:" + point)
            );
        }
        before.setItemMeta(meta);
        return before;
    }

    private List<String> addEntry(List<String> list, String s) {
        list.add(s);
        return list;
    }


    public interface OrderMetaSupplier {
        ItemMeta get(ItemStack stack);
    }

    public static class OrderBuilder {
        public ItemStack stack;
        public int point;
        public OrderBuilder(int point, int amount, Material m) {
            this(point, new ItemStack(m, amount));
        }

        public OrderBuilder(int point, ItemStack stack) {
            this.stack = stack;
            this.point = point;
        }

        public OrderBuilder setMeta(OrderMetaSupplier metaSupplier) {
            stack.setItemMeta(metaSupplier.get(stack));
            return this;
        }

        public Order build() {
            return new Order(point, stack);
        }
    }
}
