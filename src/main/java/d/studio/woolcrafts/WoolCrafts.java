package d.studio.woolcrafts;

import d.studio.woolcrafts.api.Craft;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class WoolCrafts extends JavaPlugin {

    RegisterCrafts registerCrafts = new RegisterCrafts();

    @Override
    public void onEnable() {

        Bukkit.getConsoleSender().sendMessage("[Craft API] Plugin started. \n -> Author: DaniCraftingYT.");
        registerCrafts.registerCraft();

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("[Craft API] Plugin disabled. \n -> Author: DaniCraftingYT.");
    }
}
