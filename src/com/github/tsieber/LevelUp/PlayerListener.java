package com.github.tsieber.LevelUp;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener{
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if ((event.getAction()!= Action.LEFT_CLICK_AIR)&&(event.getAction()!= Action.RIGHT_CLICK_AIR)) {
			Player player = event.getPlayer();
			//Action action = event.getAction();
			//Material block = event.getClickedBlock().getType();
			if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (event.getClickedBlock().getType() == Material.SIGN_POST || event.getClickedBlock().getType() == Material.WALL_SIGN) {
					Sign sign = (Sign)event.getClickedBlock().getState();
					String line1 = sign.getLine(0);
					String line2 = sign.getLine(1);
					 if (line1.contains("[Rank Up]")) {
						 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() +" group set " + line2);
						 player.sendMessage("You have been promoted!");
					 }	
				}return;
			}return;
		}return;
	}
}
