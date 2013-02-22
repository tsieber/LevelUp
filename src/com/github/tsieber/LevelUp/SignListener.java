package com.github.tsieber.LevelUp;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignListener implements Listener{
	
	@EventHandler
	public void Sign(SignChangeEvent event) {
		String line1 = event.getLine(0);
		String blank = null;
		if (line1.equalsIgnoreCase("[Rank Up]")) {
			Player player = event.getPlayer();
			if (player.hasPermission("levelup.makesign")) {
				event.setLine(0, line1);
				player.sendMessage(ChatColor.GREEN + "Rank Sign setup!");
			}
			else {
				player.sendMessage(ChatColor.RED + "You do not have permission to do this.");
				event.setLine(0, blank);
				event.setLine(1, blank);
				event.setLine(2, blank);
				event.setLine(3, blank);
			}
		}
	}
}
