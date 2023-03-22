package com.hmmbo;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class RegenCore extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        File file = new File(getDataFolder(),"Regions.yml");
        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("File Error Loading");
            }
        }
        Bukkit.getPluginManager().registerEvents(new WandListener(),this);
        Bukkit.getPluginManager().registerEvents(new FarmProtect(this,this),this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
