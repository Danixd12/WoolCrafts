# WoolCrafts - Create your own custom crafts the easy way!

*This api was created with the purpose of facilitating the creation of custom crafters for your server, by supporting the crafting of items using other previously customized items..* 

Any errors when using this API should be reported to the creator, dani33y, in his discord.

# How to use

First we will install it by including it in our project. We can use maven or gradle. (Bukkit 1.13+)

```xml
<repositories>
  <repository>
	<id>jitpack.io</id>
	<url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
	<groupId>com.github.Danixd12</groupId>
	<artifactId>WoolCrafts</artifactId>
	<version>VERSION</version>
</dependency>
```

Then, to create a basic item, and its subsequent recipe we can use the following

```java

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

# Methods

`api.giveItem` Returns the item we want to give to X person.

`api.createRecipe` Returns the created recipe.

`api.createItem` Returns the item we have created.
