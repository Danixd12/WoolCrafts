package d.studio.woolcrafts.example;

import d.studio.woolcrafts.api.Craft;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class RegisterCrafts {

    Craft api = new Craft();

    // ITEMS


    public void registerCraft() {

        // 1 ITEM
        ItemStack item = api.createItem(
                "testItem", Material.ENDER_CHEST, 1,
                Arrays.asList("&aasd", "&3test"),
                new Object[][]{new Object[]
                        {Enchantment.ARROW_INFINITE, 5},
                        {Enchantment.DAMAGE_ALL, 15},
                        {Enchantment.ARROW_FIRE, 25}
        });


        api.createRecipe(item,
                 new Object[][]{new Object[]
                         {'X', Material.ACACIA_LOG}
                 },
                " X ");

        //api.giveItem("DaniCraftingYT", item);

    }


}
