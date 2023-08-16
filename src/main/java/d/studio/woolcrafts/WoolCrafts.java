package d.studio.woolcrafts;

import d.studio.woolcrafts.api.Craft;
import d.studio.woolcrafts.example.RegisterCrafts;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class WoolCrafts extends JavaPlugin {

    RegisterCrafts registerCrafts = new RegisterCrafts();

    @Override
    public void onEnable() {

        Craft api = new Craft();
        registerCrafts.registerCraft();
        Bukkit.getConsoleSender().sendMessage("[Craft API] Plugin started. \n -> Author: DaniCraftingYT.");

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("[Craft API] Plugin disabled. \n -> Author: DaniCraftingYT.");
    }
}
