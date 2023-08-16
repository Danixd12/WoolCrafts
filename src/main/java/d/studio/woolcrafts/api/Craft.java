package d.studio.woolcrafts.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Craft {


    /***
     * Crea un item.
     * @param name Name of the item.
     * @param material Material of the item.
     * @param lore Description of the item.
     * @param enchant Enchantments of the item.
     * @return item
     */
    public ItemStack createItem(String name, Material material, List<String> lore , @NotNull Object[][] enchant) {

        ItemStack item = new ItemStack(material, 1);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        //itemMeta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', lore.toString())));

        lore.replaceAll(textToTranslate -> ChatColor.translateAlternateColorCodes('&', textToTranslate));

        itemMeta.setLore(lore);

        AbstractTableModel enchants = new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return 0;
            }

            @Override
            public int getColumnCount() {
                return 0;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return enchant[rowIndex][columnIndex];
            }

        };

        for (int rowIndex = 0; rowIndex < enchant.length; rowIndex++) {
            Enchantment key = (Enchantment) enchants.getValueAt(rowIndex, 0);
            int index = (int) enchants.getValueAt(rowIndex, 1);

            itemMeta.addEnchant(key, index, true);
        }

        item.setItemMeta(itemMeta);

        return item;

    }


    /***
     * Crea la receta para un item.
     * @param itemToCraft The result of the craft.
     * @param ingredient Ingredients in order to craft the item.
     * @param shape Shape of the craft.
     * @return recipe
     */
    public ShapedRecipe createRecipe(ItemStack itemToCraft, Object[][] ingredient, String... shape) {

        ShapedRecipe recipe = new ShapedRecipe(itemToCraft);

        recipe.shape(shape);

        AbstractTableModel ingredients = new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return 0;
            }

            @Override
            public int getColumnCount() {
                return 0;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return ingredient[rowIndex][columnIndex];
            }

        };

        for (int rowIndex = 0; rowIndex < ingredient.length; rowIndex++) {
            Character key = (Character) ingredients.getValueAt(rowIndex, 0);

            if (ingredients.getValueAt(rowIndex, 1) instanceof ItemStack) {
                ItemStack index = (ItemStack) ingredients.getValueAt(rowIndex, 1);

                recipe.setIngredient(key, new RecipeChoice.ExactChoice(index));
            } else {
                Material index = (Material) ingredients.getValueAt(rowIndex, 1);

                recipe.setIngredient(key,index);
            }

        }

        Bukkit.addRecipe(recipe);

        return recipe;
    }

    /***
     * Da un item a un jugador.
     * @param player Bukkit player.
     * @param item Items to give.
     */
    public void giveItem(Player player, @NotNull ItemStack... item) {

        player.getInventory().addItem(item);

    }

}