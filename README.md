# WoolCrafts - Crea tus crafteos personalizados de forma facil!

*Esta api fue creada con el propósito de facilitar la creación de crafteos personalizados para tu servidor, al soportar el crafteo de items usando otros items previamente personalizados.* 

Cualquier error al usar esta API, debe ser reportado al creador, dani33y, en su discord.

# Guía

Primero lo instalaremos incluyendolo en nuestro proyecto.

```java
//Para crear un item basico, y su posterior receta podemos usar lo siguiente.

Craft api = new Craft();

ItemStack item = api.createItem(
                "testItem", Material.ENDER_CHEST, 1,
                Arrays.asList("asd"),
                new Object[][]{new Object[]
                        {Enchantment.ARROW_INFINITE, 5},
                        {Enchantment.DAMAGE_ALL, 15},
                        {Enchantment.ARROW_FIRE, 25}
        });

api.createRecipe(item,
                new Object[][]{new Object[]
                {'I', item},
                {'X', Material.ACACIA_LOG}},
                " IX");

```

# Métodos

Métodos, por ejemplo:

`api.giveItem` Retorna el item que deseemos dar a X persona.

`api.createRecipe` Retorna la receta creada.

`api.createItem` Retorna el item que hayamos creado.
