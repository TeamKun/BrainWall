package net.kunmc.lab.brainwall;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandListener implements Listener {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if(!cmd.getName().equalsIgnoreCase("brainwall")){
            return false;
        }
        if(args.length < 1){
            sender.sendMessage("引数が足りません");
            return false;
        }else if(args.length > 1){
            sender.sendMessage("引数が多すぎます");
            return false;
        }

        String arg1 = args[0];

        if(!(arg1.equalsIgnoreCase("setup") || arg1.equalsIgnoreCase("start"))){
            sender.sendMessage("第1引数には変更したいパラメータを入力してください");
            return false;
        }
        return false;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        switch (args.length) {
            case 1:
                return Stream.of("setup", "start")
                        .filter(e -> e.startsWith(args[0]))
                        .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
