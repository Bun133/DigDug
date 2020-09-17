package com.bun133.digdug.commands;

import com.bun133.digdug.DigDugGamer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class RankCommand implements CommandExecutor {
    public DigDugGamer gamer;

    public RankCommand(DigDugGamer gamer) {
        this.gamer = gamer;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            sendRankings(sender,getRank((Player)sender));
            return true;
        } else {
            if (args.length != 1) {
                sender.sendMessage("onServer,");
                sender.sendMessage("/rank <PlayerName>");
            }else{
                sendRankings(sender,getRank(Bukkit.getPlayer(args[0])));
                return true;
            }
        }
        return false;
    }

    public void sendRankings(CommandSender sender,int rank){
        sender.sendMessage("All is : "+ Bukkit.getOnlinePlayers().size());
        sender.sendMessage("Your Rank is : "+rank);
        List<Map.Entry<Player,Integer>> list = getRanking();
        for (int i = 0; i < list.size(); i++) {
            sender.sendMessage(""+(i+1)+" : "+list.get(i).getKey().getDisplayName()+" "+list.get(i).getValue()+"pt");
        }
    }

    public int getRank(Player p) {
        List<Map.Entry<Player, Integer>> list = new ArrayList<>(gamer.pointMap.entrySet());
        System.out.println("list length is"+list.size());
        list.sort((o1, o2) -> {return o1.getValue() - o2.getValue();});

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(p)) {
                return i+1;
            }
        }
        return -1;
    }

    public List<Map.Entry<Player, Integer>> getRanking() {
        List<Map.Entry<Player, Integer>> list = new ArrayList<>(gamer.pointMap.entrySet());

        list.sort((o1, o2) -> {return o1.getValue() - o2.getValue();});

        return list;
    }
}
