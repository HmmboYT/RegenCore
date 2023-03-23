package com.hmmbo;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Regions{
    Plugin plugin;
    File file;
    RegenCore regenCore;
    YamlConfiguration modifyfile;
    Cuboid cuboid[] = new Cuboid[100];

    public Regions(YamlConfiguration modifyfile, Plugin plugin, File file, RegenCore regenCore) {
        this.modifyfile = modifyfile;
        this.plugin = plugin;
        this.file = file;
        this.regenCore=regenCore;
    }
    public void reloadreg(World world) {

        Arrays.stream(cuboid).iterator().hasNext();
        int index=1;
        while (modifyfile.getString("Regions."+index+".x1") != null) {
            cuboid[index] = new Cuboid(
                    new Location(world, modifyfile.getDouble("Regions."+index+".x1"),
                            modifyfile.getInt("Regions."+index+".y1"),
                            modifyfile.getInt("Regions."+index+".z1")),
                    new Location(world, modifyfile.getInt("Regions."+index+".x2"),
                            modifyfile.getInt("Regions."+index+".y2"),
                            modifyfile.getInt("Regions."+index+".z2")));
            index++;
        }
        cuboids();
    }
    public Cuboid[] cuboids(){
        return cuboid;
    }
}
