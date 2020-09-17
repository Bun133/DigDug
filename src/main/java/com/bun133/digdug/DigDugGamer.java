package com.bun133.digdug;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DigDugGamer extends BukkitRunnable implements Listener{
    public JavaPlugin plugin;
    public DigDugGamer(JavaPlugin plugin){this.plugin=plugin;}

    public boolean isStarting=false;

    @EventHandler
    public void onPlayerDigged(BlockBreakEvent e){
        if(!isStarting) return;
        if(PointSet.isIgnorable(e.getBlock().getType())) return;
        e.setDropItems(false);
        addPoint(e.getPlayer(),PointSet.getPoint(e.getBlock().getType()));
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        e.getEntity().sendMessage("YourPoint sat to 0");
        setPoint(e.getEntity(),0);
    }

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().stream().filter(Objects::nonNull)
                .forEach((it) -> {
                    sendTitle(it,"Your Point:"+getPoint(it));
                });
    }

    public static void sendTitle(Player p, String data) {
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(data));
    }

    public void setPoint(Player p,Integer i){
        pointMap.put(p, i);
    }

    public Integer getPoint(Player p){
        if(!pointMap.containsKey(p))pointMap.put(p,0);
        return pointMap.get(p);
    }

    public Map<Player,Integer> pointMap = new HashMap<>();

    public void addPoint(Player p,Integer i){
        setPoint(p,getPoint(p)+i);
    }

    public void start(){
        pointMap=new HashMap<>();
        isStarting=true;
        Bukkit.broadcastMessage("Game Start!");
    }

    public void end(){
        isStarting=false;
        Bukkit.broadcastMessage("Game End!");
    }
}
