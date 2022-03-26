package dev.banditco;


import org.bukkit.Bukkit;
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


public final class chrono extends JavaPlugin implements Listener {
    public HashMap<String, Long> cooldowns = new HashMap<String, Long>();

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

        if (item == null || item.getType() == Material.AIR)
            return;
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (item.getType() == Material.CLOCK) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, secondsPlayed, 2));
                p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, secondsPlayed, 2));
                p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, secondsPlayed, 2));
                int cooldownTime = 60; // Get number of seconds from wherever you want
                if(cooldowns.containsKey(p.getName())) {
                    long secondsLeft = ((cooldowns.get(p.getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
                    if(secondsLeft>0) {
                        // Still cooling down
                        p.sendMessage("You cant use that commands for another "+ secondsLeft +" seconds!");
                    }
                }
                // No cooldown found or cooldown has expired, save new cooldown
                cooldowns.put(p.getName(), System.currentTimeMillis());
                // Do Command Here
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
        if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            if(item.getType() == Material.CLOCK) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, secondsPlayed, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, secondsPlayed, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, secondsPlayed, 1));
                int cooldownTime = 60; // Get number of seconds from wherever you want
                if(cooldowns.containsKey(p.getName())) {
                    long secondsLeft = ((cooldowns.get(p.getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
                    if(secondsLeft>0) {
                        // Still cooling down
                        p.sendMessage("You cant use that commands for another "+ secondsLeft +" seconds!");
                    }
                }
                // No cooldown found or cooldown has expired, save new cooldown
                cooldowns.put(p.getName(), System.currentTimeMillis());
                // Do Command Here
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
