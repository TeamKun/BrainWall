package net.kunmc.lab.brainwall;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Brainwall extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new CommandListener(), this);
        getLogger().info("脳カベプラグインが有効になりました");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



    @Override
    public @Nullable List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        switch (args.length) {
            case 1:
                return Stream.of("on", "off")
                        .filter(e -> e.startsWith(args[0]))
                        .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

}
