package com.bun133.digdug;

import com.bun133.digdug.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("SpellCheckingInspection")
public final class Digdug extends JavaPlugin {

    public DigDugGamer gamer;
    public ShopCommand shop;
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.gamer=new DigDugGamer(this);
        this.shop=new ShopCommand(gamer);
        Bukkit.getPluginManager().registerEvents(gamer,this);
        Bukkit.getPluginManager().registerEvents(shop,this);
        gamer.runTaskTimer(this,10,1);
        getCommand("rank").setExecutor(new RankCommand(gamer));
        getCommand("status").setExecutor(new StatusCommand(gamer));
        getCommand("game").setExecutor(new GameCommand(gamer));
        getCommand("shop").setExecutor(shop);
        getCommand("addPoint").setExecutor(new addPointCommand(gamer));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
