package com.bun133.digdug;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointSet {
    private static final Map<Material, Integer> points = new HashMap<>();
    private static final List<Material> Ignorable = new ArrayList<>();
    static {
        init();
        ignoreInit();
    }

    private static void init() {
        // Woods
        points.put(Material.OAK_LOG,10);
        points.put(Material.SPRUCE_LOG,10);
        points.put(Material.BIRCH_LOG,10);
        points.put(Material.JUNGLE_LOG,10);
        points.put(Material.ACACIA_LOG,10);
        points.put(Material.DARK_OAK_LOG,10);
        points.put(Material.STRIPPED_OAK_LOG,10);
        points.put(Material.STRIPPED_SPRUCE_LOG,10);
        points.put(Material.STRIPPED_BIRCH_LOG,10);
        points.put(Material.STRIPPED_JUNGLE_LOG,10);
        points.put(Material.STRIPPED_ACACIA_LOG,10);
        points.put(Material.STRIPPED_DARK_OAK_LOG,10);

        // Over World
        points.put(Material.DIRT, 1);
        points.put(Material.STONE, 1);
        points.put(Material.COBBLESTONE, 1);
        points.put(Material.MELON, 5);
        points.put(Material.CACTUS, 5);
        points.put(Material.PUMPKIN, 5);
        points.put(Material.RAIL, 5);
        points.put(Material.ACTIVATOR_RAIL, 10);
        points.put(Material.DETECTOR_RAIL, 10);
        points.put(Material.POWERED_RAIL, 10);
        points.put(Material.PRISMARINE,15);
        points.put(Material.PRISMARINE_BRICKS,15);
        points.put(Material.DARK_PRISMARINE,15);
        points.put(Material.SEA_LANTERN,15);
        points.put(Material.COAL_ORE, 10);
        points.put(Material.IRON_ORE, 10);
        points.put(Material.GOLD_ORE, 20);
        points.put(Material.IRON_BLOCK, 10 * 9);
        points.put(Material.COAL_BLOCK, 10 * 9);
        points.put(Material.GOLD_BLOCK, 20 * 9);
        points.put(Material.REDSTONE_ORE, 25);
        points.put(Material.LAPIS_ORE, 100);
        points.put(Material.DIAMOND_ORE, 150);
        points.put(Material.EMERALD_ORE, 200);
        points.put(Material.OBSIDIAN, 200);

        // Neather
        points.put(Material.NETHER_BRICK, 5);
        points.put(Material.NETHER_BRICK_SLAB, 5);
        points.put(Material.NETHER_BRICK_WALL, 5);
        points.put(Material.NETHER_BRICK_STAIRS, 5);
        points.put(Material.NETHER_BRICK_FENCE, 5);
        points.put(Material.NETHERRACK, 5);
        points.put(Material.NETHER_QUARTZ_ORE, 15);
        points.put(Material.GLOWSTONE, 15);
        points.put(Material.SOUL_SAND, 5);
        points.put(Material.MAGMA_BLOCK, 15);
        points.put(Material.NETHER_WART_BLOCK, 15);

        // END
        points.put(Material.END_STONE,20);
        points.put(Material.END_STONE_BRICKS,20);
        points.put(Material.CHORUS_PLANT,20);
        points.put(Material.CHORUS_FLOWER,20);
        points.put(Material.CHORUS_FRUIT,20);
        points.put(Material.PURPUR_BLOCK,20);
        points.put(Material.PURPUR_STAIRS,20);
        points.put(Material.PURPUR_SLAB,20);

        // OTHER
        points.put(Material.SPAWNER,100);
    }

    public static Integer getPoint(Material m) {
        return points.getOrDefault(m, 1);
    }


    public static boolean isIgnorable(Material m){
        return Ignorable.contains(m);
    }

    private static void ignoreInit() {
        Ignorable.add(Material.TORCH);
        Ignorable.add(Material.CHEST);
        Ignorable.add(Material.ENDER_CHEST);
    }
}
