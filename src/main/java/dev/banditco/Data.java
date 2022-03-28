package dev.banditco;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


public class Data extends JavaPlugin implements Listener {



    @EventHandler
    public void onPlayerKilled(PlayerEvent e) {

        Player p = e.getPlayer();

        if(p.isDead()) {
            int secondsPlayed = p.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;
            int sum = secondsPlayed - 5;
            //p.setStatistic(Statistic.PLAY_ONE_MINUTE());
        }

        /*
        Player p = e.getPlayer();
        int deaths = p.getStatistic(Statistic.DEATHS);

        File file = new File(getDataFolder(),"");
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException ea){
                System.out.println("Can't load file! Ooops!");
                return;
            }
        }
        YamlConfiguration modifyFile = YamlConfiguration.loadConfiguration(file);
        modifyFile.set("UUID",p.getUniqueId());
        modifyFile.set("Deaths",deaths);

        try{
            modifyFile.save(file);
        }catch (IOException ea){
            System.out.println("Couldn't edit file!");
            return;
        }


        if (p.getKiller() instanceof Player) {
            Player killer = p.getKiller();

        }
*/
    }


    }

