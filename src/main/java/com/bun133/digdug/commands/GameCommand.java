package com.bun133.digdug.commands;

import com.bun133.digdug.DigDugGamer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameCommand implements CommandExecutor {
    public DigDugGamer gamer;
    public GameCommand(DigDugGamer gamer){
        this.gamer=gamer;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length!=1) return false;
        if(sender instanceof Player){
            if(!sender.isOp()) return false;
        }
        switch (args[0]){
            case "start":
                gamer.start();
                return true;
            case "stop":
                gamer.end();
                return true;
        }
        return false;
    }
}
