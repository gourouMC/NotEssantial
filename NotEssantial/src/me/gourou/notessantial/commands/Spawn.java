package me.gourou.notessantial.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.gourou.notessantial.Main;

public class Spawn implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Main main = Main.getInstance();
		FileConfiguration config = main.getConfig();
		if(!(sender instanceof Player)) {
			if(label.equalsIgnoreCase("test")){
			if(config.getString("Langage") == "fr"){
			sender.sendMessage("Il faut etre un joueur pour envoye cette commande");
			}else {
				sender.sendMessage("mdr je suis une pute");
			}
			}
		}
		return false;
	}

}
