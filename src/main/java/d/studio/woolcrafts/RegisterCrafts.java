package d.studio.woolcrafts;

import d.studio.woolcrafts.api.Craft;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class RegisterCrafts {

    Craft api = new Craft();

    // ITEMS


    public void registerCraft() {

        // 1 ITEM
        ItemStack item = api.createItem("testItem", Material.ENDER_CHEST, 1, Arrays.asList("TEST"), new Object[][]{new Object[]{Enchantment.ARROW_INFINITE, 5}, {Enchantment.DAMAGE_ALL, 15}});

        api.createRecipe(new ShapedRecipe(item),
                new Object[][]{new Object[]
                        {'X', Material.ENDER_CHEST}
                },
                " X ");

    }


}
