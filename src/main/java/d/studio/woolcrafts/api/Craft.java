package d.studio.woolcrafts.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Objects;


public class Craft {


    /***
     * Crea un item.
     * @param name
     * @param material
     * @param amount
     * @param lore
     * @param enchant
     * @return
     */
    public ItemStack createItem(String name, Material material, int amount, List<String> lore , @NotNull Object[][] enchant) {

        ItemStack item = new ItemStack(material, amount);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
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
     * @param recipe
     * @param ingredient
     * @param shape
     * @return
     */
    public ShapedRecipe createRecipe(ShapedRecipe recipe, Object[][] ingredient, String shape) {

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

                recipe.setIngredient(key, Objects.requireNonNull(index.getData()));
            } else {
                Material index = (Material) ingredients.getValueAt(rowIndex, 1);

                recipe.setIngredient(key,index);
            }

        }

        Bukkit.addRecipe(recipe);

        return recipe;

    }

}