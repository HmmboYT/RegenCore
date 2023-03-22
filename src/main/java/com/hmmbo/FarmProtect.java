package com.hmmbo;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class FarmProtect implements Listener {
    RegenCore regenCore;
    Plugin plugin;
    public FarmProtect(RegenCore regenCore,Plugin plugin){
        this.plugin=plugin;
        this.regenCore= regenCore;
    }

    @EventHandler
    public void onEntityInteract(EntityInteractEvent event) {
        if (regenCore.getConfig().getBoolean("Farm_Protect"))
        {
            Block block = event.getBlock();
            if (block != null && block.getType() == Material.FARMLAND) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (regenCore.getConfig().getBoolean("Farm_Protect")){
            if (event.getAction() == Action.PHYSICAL) {
                if (event.getClickedBlock().getType() == Material.FARMLAND) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
