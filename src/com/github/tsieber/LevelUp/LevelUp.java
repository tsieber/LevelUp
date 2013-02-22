package com.github.tsieber.LevelUp;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LevelUp extends JavaPlugin {
	
	public String lprefix;
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		PluginManager pm = getServer().getPluginManager();
		lprefix = "[" + pdfFile.getName() + "] v" + pdfFile.getVersion() + ": ";
		pm.registerEvents(new PlayerListener(), this);
		pm.registerEvents(new SignListener(), this);
	   
		log("is now enabled");
	}
	
	@Override
	public void onDisable() {
		log("is now disabled");
	}
	
	public void log(String log) {
		Bukkit.getLogger().info(lprefix + log);
	}
}
