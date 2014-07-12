package com.thieding.tyler;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SimplisticReloader extends JavaPlugin {
	
	Logger log;
	 
	public void onEnable(){
		log = this.getLogger();
		this.saveDefaultConfig();
		log.info("SimplisticReloader Has Been Enabled Successfully");
	}
 
	public void onDisable(){
		log.info("SimplisticReloader Has Been Disabled Successfully");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(cmd.getName().equalsIgnoreCase("reload+"))
		{
			if((sender.isOp() ==  true || sender instanceof Player == false) || sender.hasPermission("SimplisticReloader.reload+")){
				Bukkit.broadcastMessage(ChatColor.getByChar(getConfig().getString("Reload_Color")) + getConfig().getString("Reload_Message"));
				Bukkit.getServer().savePlayers();
				Bukkit.getServer().reloadWhitelist();
				Bukkit.getServer().reload();
			  	Bukkit.broadcastMessage(ChatColor.getByChar(getConfig().getString("Reload_Color")) + getConfig().getString("Reload_Complete_Message"));
			}
			else{
				sender.sendMessage("Only OPs Can Use SimplisticReloader");
			}
		}
		if(cmd.getName().equalsIgnoreCase("stop+"))
		{
			/**/
			if((sender.isOp() ==  true || sender instanceof Player == false) || sender.hasPermission("SimplisticReloader.stop+")){
				Bukkit.broadcastMessage(ChatColor.getByChar(getConfig().getString("Stop_Color")) + getConfig().getString("Stop_Message"));
				Bukkit.getServer().savePlayers();
				Bukkit.getServer().shutdown();
			}
			else{
				sender.sendMessage("Only OPs Can Use SimplisticReloader");
			}
		}
		return true;
	}
	
}
