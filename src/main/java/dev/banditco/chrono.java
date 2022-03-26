package dev.banditco;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public final class chrono extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }
    //Checks For Clock Right Click
    @EventHandler
    public void onBoopClock(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        int secondsPlayed = p.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
        ItemStack item = p.getItemInHand();
        UUID uuid = p.getUniqueId();



        if (item == null || item.getType() == Material.AIR)
            return;
        if (e.getAction() == Action.RIGHT_CLICK_AIR && p.getCooldown(Material.CLOCK) == 0 || e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getCooldown(Material.CLOCK) == 0) {
            if (item.getType() == Material.CLOCK) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, secondsPlayed, 2));
                p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, secondsPlayed, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, secondsPlayed, 1));
                p.setCooldown(Material.CLOCK, secondsPlayed + 60);
            }
        }
    }
    //Checks For Clock Left Click
    @EventHandler
    public void onBopClock(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        int secondsPlayed = p.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
        ItemStack item = p.getItemInHand();

        if(item == null || item.getType() == Material.AIR)
            return;
        if(e.getAction() == Action.LEFT_CLICK_AIR && p.getCooldown(Material.CLOCK) == 0 || e.getAction() == Action.LEFT_CLICK_BLOCK && p.getCooldown(Material.CLOCK) == 0) {
            if(item.getType() == Material.CLOCK) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, secondsPlayed, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, secondsPlayed, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, secondsPlayed, 1));
                p.setCooldown(Material.CLOCK, secondsPlayed + 60);
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
