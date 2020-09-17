package com.bun133.digdug.commands;

import com.bun133.digdug.DigDugGamer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class addPointCommand implements CommandExecutor {
    public DigDugGamer gamer;
    public addPointCommand(DigDugGamer gamer){
        this.gamer=gamer;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length!=2) return false;
        if(sender instanceof Player){
            if(((Player)sender).isOp()){
                addPoint(Bukkit.getPlayer(args[0]), Integer.valueOf(args[1]));
                return true;
            }
        }else{
            addPoint(Bukkit.getPlayer(args[0]), Integer.valueOf(args[1]));
        }
        return false;
    }

    public void addPoint(Player p, Integer points){
        gamer.addPoint(p,points);
    }
}
