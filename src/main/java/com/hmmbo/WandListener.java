package com.hmmbo;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class WandListener implements Listener {
    Location pos1,pos2;
    @EventHandler
    public void wandselection(PlayerInteractEvent event){

        Player player = event.getPlayer();
        if(event.getAction().equals(Action.LEFT_CLICK_BLOCK))
        {
            pos1=event.getClickedBlock().getLocation();
            player.sendMessage("Pos1 ="+pos1.toString());
            setPos1(pos1);
        }
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
        {
            pos2=event.getClickedBlock().getLocation();
            player.sendMessage("Pos2 ="+pos2.toString());
            setPos2(pos2);
        }

    }
    public void setPos1(Location pos){pos1=pos;}
    public void setPos2(Location pos){pos2=pos;}
    public Location getPos1(){return pos1;}
    public Location getPos2(){return pos2;}
}
