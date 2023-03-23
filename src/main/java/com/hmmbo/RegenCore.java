package com.hmmbo;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class RegenCore extends JavaPlugin {
    Regions regions;
    Commands commands;
    WandListener wandListener;

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
        YamlConfiguration modifyfile = YamlConfiguration.loadConfiguration(file);
        regions = new Regions(modifyfile,this,file,this);
        commands = new Commands(this,this);
        wandListener = new WandListener();

        Bukkit.getPluginManager().registerEvents(wandListener,this);
        Bukkit.getPluginManager().registerEvents(new FarmProtect(this,this),this);
        Bukkit.getPluginManager().registerEvents(new BreakListener(this),this);
        Objects.requireNonNull(getCommand("regen")).setExecutor(commands);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
