package dev.banditco;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Registry.ENCHANTMENT;

public final class chrono extends JavaPlugin {

    @Override
    public void onEnable() {
        ItemStack item = new ItemStack(Material.CLOCK);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("ChronoMeter");
        item.setItemMeta(meta);
        NamespacedKey key = new NamespacedKey(this,"chronometer");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape(" G ", "GCG", " G ");
        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('C', Material.CLOCK);
        Bukkit.addRecipe(recipe);
        //item.addEnchantment(ENCHANTMENT., 1);
    }

    @Override
    public void onDisable() {
        /// Plugin shutdown logic
    }
}
