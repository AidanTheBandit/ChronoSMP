package dev.banditco;

import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.*;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


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
                int mili = 100;
                p.setNoDamageTicks(1);
                p.setCooldown(Material.CLOCK, secondsPlayed - 20);
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, secondsPlayed, 2));
                p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, secondsPlayed, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, secondsPlayed, 1));
                p.removePotionEffect(PotionEffectType.SLOW);
                p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
                p.removePotionEffect(PotionEffectType.SLOW_FALLING);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 10, 1);
                try {
                    Thread.sleep(mili);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 10, 2);
                try {
                    Thread.sleep(mili);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 10, 2);
                try {
                    Thread.sleep(mili);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 10, 3);
                try {
                    Thread.sleep(mili);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 10, 5);
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
                int mili = 100;
                p.setNoDamageTicks(6);
                p.setCooldown(Material.CLOCK, secondsPlayed - 20);
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, secondsPlayed, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, secondsPlayed, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, secondsPlayed, 1));
                p.removePotionEffect(PotionEffectType.SPEED);
                p.removePotionEffect(PotionEffectType.JUMP);
                p.removePotionEffect(PotionEffectType.FAST_DIGGING);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 10, 1);
                try {
                    Thread.sleep(mili);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 10, 2);
                try {
                    Thread.sleep(mili);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 10, 2);
                try {
                    Thread.sleep(mili);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 10, 1);
                try {
                    Thread.sleep(mili);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 10, 1);
                try {
                    Thread.sleep(mili);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 10, 0);
                try {
                    Thread.sleep(mili);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 10, 0);
            }
        }
    }
    @EventHandler
    public void onCancel(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        int secondsPlayed = p.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
        ItemStack item = p.getItemInHand();

        if(item == null || item.getType() == Material.AIR)
            return;
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK && p.isSneaking() || e.getAction() == Action.RIGHT_CLICK_AIR && p.isSneaking()) {
            if(item.getType() == Material.CLOCK) {
                p.removePotionEffect(PotionEffectType.SLOW);
                p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
                p.removePotionEffect(PotionEffectType.SLOW_FALLING);
                p.removePotionEffect(PotionEffectType.SPEED);
                p.removePotionEffect(PotionEffectType.JUMP);
                p.removePotionEffect(PotionEffectType.FAST_DIGGING);
            }
        }
        if(e.getAction() == Action.LEFT_CLICK_BLOCK && p.isSneaking() || e.getAction() == Action.LEFT_CLICK_AIR && p.isSneaking()) {
            if(item.getType() == Material.CLOCK) {
                p.removePotionEffect(PotionEffectType.SLOW);
                p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
                p.removePotionEffect(PotionEffectType.SLOW_FALLING);
                p.removePotionEffect(PotionEffectType.SPEED);
                p.removePotionEffect(PotionEffectType.JUMP);
                p.removePotionEffect(PotionEffectType.FAST_DIGGING);
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
