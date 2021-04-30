package net.kunmc.lab.brainwall;

import org.bukkit.plugin.java.JavaPlugin;

public final class BrainWall extends JavaPlugin {

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

}
