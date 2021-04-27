package net.kunmc.lab.brainwall;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class CommandListener implements @NotNull Listener {


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

        if(arg1.equalsIgnoreCase("on")){
            WallTask.isEnabled = true;
            sender.sendMessage("プラグインをオンにしました");
            return true;
        } else if(arg1.equalsIgnoreCase("off")){
            WallTask.isEnabled = false;
            sender.sendMessage("プラグインをオフにしました");
            return true;
        } else {
            sender.sendMessage("「on」または「off」と入力してください");
            return false;
        }
    }
}
