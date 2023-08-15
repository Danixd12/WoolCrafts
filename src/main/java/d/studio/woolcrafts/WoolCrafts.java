package d.studio.woolcrafts;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class WoolCrafts extends JavaPlugin {

    RegisterCrafts registerCrafts = new RegisterCrafts();

    @Override
    public void onEnable() {

        Bukkit.getConsoleSender().sendMessage("Starting...");
        registerCrafts.registerCraft();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
