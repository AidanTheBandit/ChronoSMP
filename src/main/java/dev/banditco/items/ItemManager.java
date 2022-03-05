package dev.banditco.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack ChronoMeter;

    public static void init(){
        createChronoMeter();

    }

    private static void createChronoMeter() {
        ItemStack item = new ItemStack(Material.CLOCK, 1);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add("§cCrafted by the enchanted people of the past");
        lore.add("§cThe §aChronoMeter §cis a powerful device that can control time.");
        lore.add("§cBeware! Time is of the essence.");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        ChronoMeter = item;

        //Recipe
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("ChronoMeter"), item);
        sr.shape(" G ", "GCG", " G ");
        sr.setIngredient('G', Material.GOLD_INGOT);
        sr.setIngredient('C', Material.CLOCK);
        Bukkit.getServer().addRecipe(sr);

    }
    @EventHandler
    public void onEatBook(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        ItemStack item = p.getItemInHand();

        if(item == null || item.getType() == Material.AIR)
            return;
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(e.getPlayer().getInventory().getItemInMainHand() == ItemManager.ChronoMeter) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 1));
            }
        }
    }
}
