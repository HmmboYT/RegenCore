package com.hmmbo;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class Regions{
    Plugin plugin;
    File file;
    RegenCore regenCore;
    YamlConfiguration modifyfile;
    
    public Regions(YamlConfiguration modifyfile, Plugin plugin, File file, RegenCore regenCore) {
        this.modifyfile = modifyfile;
        this.plugin = plugin;
        this.file = file;
        this.regenCore=regenCore;
    }
}
