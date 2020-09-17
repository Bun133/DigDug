package com.bun133.digdug.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Orders {

    public static final Order NullOrder = new Order(0, Material.AIR, 1);

    // PIXES
    public static final Order WOOD_PIX = new Order(10, Material.WOODEN_PICKAXE, 1);
    public static final Order GOLD_PIX = new Order(50, Material.GOLDEN_PICKAXE, 1);
    public static final Order STONE_PIX = new Order(70, Material.STONE_PICKAXE, 1);
    public static final Order IRON_PIX = new Order(150, Material.IRON_PICKAXE, 1);
    public static final Order DIAMOND_PIX = new Order(1000, Material.DIAMOND_PICKAXE, 1);

    public static final Order EFFICIENCY_STONE_PIX = new Order.OrderBuilder(300, 1, Material.STONE_PICKAXE)
            .setMeta((it) -> {
                ItemMeta meta = it.getItemMeta();
                meta.setDisplayName(ChatColor.GREEN + "Efficiency Stone Pickaxe");
                meta.addEnchant(Enchantment.DIG_SPEED, 15, true);
                return meta;
            }).build();

    // SHOVELS
    public static final Order WOOD_SHOVEL = new Order(10, Material.WOODEN_SHOVEL, 1);
    public static final Order GOLD_SHOVEL = new Order(50, Material.GOLDEN_SHOVEL, 1);
    public static final Order STONE_SHOVEL = new Order(70, Material.STONE_SHOVEL, 1);
    public static final Order IRON_SHOVEL = new Order(150, Material.IRON_SHOVEL, 1);
    public static final Order DIAMOND_SHOVEL = new Order(1000, Material.DIAMOND_SHOVEL, 1);

    public static final Order EFFICIENCY_STONE_SHOVEL = new Order.OrderBuilder(300, 1, Material.STONE_SHOVEL)
            .setMeta((it) -> {
                ItemMeta meta = it.getItemMeta();
                meta.setDisplayName(ChatColor.GREEN + "Efficiency Stone Shovel");
                meta.addEnchant(Enchantment.DIG_SPEED, 15, true);
                return meta;
            }).build();

    // AXES
    public static final Order WOOD_AXE = new Order(10, Material.WOODEN_AXE, 1);
    public static final Order GOLD_AXE = new Order(50, Material.GOLDEN_AXE, 1);
    public static final Order STONE_AXE = new Order(70, Material.STONE_AXE, 1);
    public static final Order IRON_AXE = new Order(150, Material.IRON_AXE, 1);
    public static final Order DIAMOND_AXE = new Order(1000, Material.DIAMOND_AXE, 1);

    public static final Order EFFICIENCY_STONE_AXE = new Order.OrderBuilder(300, 1, Material.STONE_AXE)
            .setMeta((it) -> {
                ItemMeta meta = it.getItemMeta();
                meta.setDisplayName(ChatColor.GREEN + "Efficiency Stone Axe");
                meta.addEnchant(Enchantment.DIG_SPEED, 15, true);
                return meta;
            }).build();
    // Swords
    public static final Order WOOD_SWORD = new Order(20,Material.WOODEN_SWORD,1);
    public static final Order GOLD_SWORD = new Order(100,Material.GOLDEN_SWORD,1);
    public static final Order STONE_SWORD = new Order(140,Material.STONE_SWORD,1);
    public static final Order IRON_SWORD = new Order(300,Material.IRON_SWORD,1);
    public static final Order DIAMOND_SWORD = new Order(2000,Material.DIAMOND_SWORD,1);




    // Equipment
    public static final Order LEATHER_HEAD = new Order(100, Material.LEATHER_HELMET, 1);
    public static final Order LEATHER_BODY = new Order(100, Material.LEATHER_CHESTPLATE, 1);
    public static final Order LEATHER_LEGGING = new Order(100, Material.LEATHER_LEGGINGS, 1);
    public static final Order LEATHER_BOOTS = new Order(100, Material.LEATHER_BOOTS, 1);

    public static final Order IRON_HEAD = new Order(500, Material.IRON_HELMET, 1);
    public static final Order IRON_BODY = new Order(500, Material.IRON_CHESTPLATE, 1);
    public static final Order IRON_LEGGING = new Order(500, Material.IRON_LEGGINGS, 1);
    public static final Order IRON_BOOTS = new Order(500, Material.IRON_BOOTS, 1);

    public static final Order GOLD_HEAD = new Order(300, Material.GOLDEN_HELMET, 1);
    public static final Order GOLD_BODY = new Order(300, Material.GOLDEN_CHESTPLATE, 1);
    public static final Order GOLD_LEGGING = new Order(300, Material.GOLDEN_LEGGINGS, 1);
    public static final Order GOLD_BOOTS = new Order(300, Material.GOLDEN_BOOTS, 1);

    public static final Order DIAMOND_HEAD = new Order(700, Material.DIAMOND_HELMET, 1);
    public static final Order DIAMOND_BODY = new Order(700, Material.DIAMOND_CHESTPLATE, 1);
    public static final Order DIAMOND_LEGGING = new Order(700, Material.DIAMOND_LEGGINGS, 1);
    public static final Order DIAMOND_BOOTS = new Order(700, Material.DIAMOND_BOOTS, 1);

    public static final Order DIAMOND_ENCHANTED_HEAD = new Order.OrderBuilder(1000, 1, Material.DIAMOND_HELMET)
            .setMeta((it) -> {
                ItemMeta meta = it.getItemMeta();
                meta.setDisplayName(ChatColor.RED + "Super Diamond Head");
                meta.addEnchant(Enchantment.OXYGEN, 1, true);
                return meta;
            }).build();

    public static final Order DIAMOND_ENCHANTED_BODY = new Order.OrderBuilder(1000, 1, Material.DIAMOND_CHESTPLATE)
            .setMeta((it) -> {
                ItemMeta meta = it.getItemMeta();
                meta.setDisplayName(ChatColor.RED + "Super Diamond Body");
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                return meta;
            }).build();

    public static final Order DIAMOND_ENCHANTED_LEGGING = new Order.OrderBuilder(1000, 1, Material.DIAMOND_LEGGINGS)
            .setMeta((it) -> {
                ItemMeta meta = it.getItemMeta();
                meta.setDisplayName(ChatColor.RED + "Super Diamond Leggings");
                meta.addEnchant(Enchantment.PROTECTION_FIRE, 3, true);
                return meta;
            }).build();

    public static final Order DIAMOND_ENCHANTED_BOOT = new Order.OrderBuilder(1000, 1, Material.DIAMOND_BOOTS)
            .setMeta((it) -> {
                ItemMeta meta = it.getItemMeta();
                meta.setDisplayName(ChatColor.RED + "Super Diamond Boots");
                meta.addEnchant(Enchantment.PROTECTION_FALL, 3, true);
                return meta;
            }).build();

    //Food
    public static final Order OBSIDIAN = new Order(100,Material.OBSIDIAN,1);
    public static final Order BEEF = new Order(100, Material.COOKED_BEEF, 10);
    public static final Order CHICKEN = new Order(100, Material.COOKED_CHICKEN, 10);
    public static final Order TORCH = new Order(20, Material.TORCH, 10);


    //POTIONS
    public static final Order NON_VISIBLE_POTION = new Order.OrderBuilder(500,1,Material.POTION)
                                                    .setMeta((it) -> {
                                                        PotionMeta meta = (PotionMeta) it.getItemMeta();
                                                        meta.addCustomEffect(new PotionEffect(
                                                                PotionEffectType.INVISIBILITY,
                                                                20 * 45,
                                                                1
                                                        ),false);
                                                        return meta;
                                                    }).build();

    public static final List<Order> orders = Arrays.asList(
            WOOD_PIX, STONE_PIX, IRON_PIX, GOLD_PIX, DIAMOND_PIX, EFFICIENCY_STONE_PIX, NullOrder, WOOD_SWORD, STONE_SWORD,
            WOOD_SHOVEL, STONE_SHOVEL, IRON_SHOVEL, GOLD_SHOVEL, DIAMOND_SHOVEL, EFFICIENCY_STONE_SHOVEL, NullOrder, IRON_SWORD, GOLD_SWORD,
            WOOD_AXE, STONE_AXE, IRON_AXE, GOLD_AXE, DIAMOND_AXE, EFFICIENCY_STONE_AXE, NullOrder, DIAMOND_SWORD, NON_VISIBLE_POTION,
            LEATHER_HEAD, LEATHER_BODY, LEATHER_LEGGING, LEATHER_BOOTS, NullOrder, IRON_HEAD, IRON_BODY, IRON_LEGGING, IRON_BOOTS,
            GOLD_HEAD, GOLD_BODY, GOLD_LEGGING, GOLD_BOOTS, NullOrder, DIAMOND_HEAD, DIAMOND_BODY, DIAMOND_LEGGING, DIAMOND_BOOTS,
            DIAMOND_ENCHANTED_HEAD, DIAMOND_ENCHANTED_BODY, DIAMOND_ENCHANTED_LEGGING, DIAMOND_ENCHANTED_BOOT, NullOrder, OBSIDIAN, BEEF, CHICKEN, TORCH
    );

    public static List<ItemStack> getOrdersStacks() {
        List<ItemStack> stacks = new ArrayList<>();
        for (Order order : orders) {
            stacks.add(order.getStack());
        }
        return stacks;
    }

    public static Order getOrder(ItemStack result) {
        for (Order order : orders) {
            if (order.getStack().equals(result)) {
                return order;
            }
        }
        return null;
    }
}
