package dev.banditco;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class Data implements Listener {

    @EventHandler
    public void onPlayerKilled(PlayerDeathEvent e) {

        Player p = e.getEntity();
        int deaths = p.getStatistic(Statistic.DEATHS);
        


        if (p.getKiller() instanceof Player) {
            Player killer = p.getKiller();

        }
    }


    }

