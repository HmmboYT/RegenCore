package com.hmmbo;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Arrays;

public class BreakListener implements Listener {
    RegenCore regenCore;

    public BreakListener(RegenCore regenCore) {
        this.regenCore = regenCore;

    }

    @EventHandler
    public void blockboken(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Location blocklocation = event.getBlock().getLocation();
        Cuboid cuboid[] = regenCore.regions.cuboids();
        for (Cuboid cub : cuboid) {
            if (cub != null) {
                if (cub.contains(blocklocation)) {
                    event.setCancelled(true);
                }

            }
        }
    }
}
