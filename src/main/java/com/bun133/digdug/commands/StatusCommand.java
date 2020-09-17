package com.bun133.digdug.commands;

import com.bun133.digdug.DigDugGamer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatusCommand implements CommandExecutor {
    public DigDugGamer gamer;
    public StatusCommand(DigDugGamer gamer){
        this.gamer=gamer;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            sendStatus(sender,(Player)sender);
            return true;
        }else{
            if(args.length!=1){
                sender.sendMessage("/status <Player>");
            }else{
                sendStatus(sender, Bukkit.getPlayerExact(args[0]));
                return true;
            }
        }
        return false;
    }

    public void sendStatus(CommandSender sender,Player p){
        sender.sendMessage("Your point is "+gamer.getPoint(p));
    }
}
