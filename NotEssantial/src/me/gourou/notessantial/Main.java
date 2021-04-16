package me.gourou.notessantial;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
 
import me.gourou.notessantial.commands.Spawn;

public class Main extends JavaPlugin implements Listener{
	private static Main instance;
	
	
	
	@Override
	public void onEnable() {
		
		System.out.println("-------------Not Essantial est actif-------------");
		getCommand("test").setExecutor(new Spawn());
		
		createFile("config");
		FileConfiguration config = YamlConfiguration.loadConfiguration(getFile("config"));
		config.set("Langage", "fr");
		try {
			config.save(getFile("config"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Main getInstance() {
		return instance;
	}
	
	
	
	
	private void createFile(String fileName) {
		
		if(!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}
		
		File file = new File(getDataFolder(), fileName + " .yml");
		if(!file.exists()) {
			
			try {
			file.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	public File getFile(String fileName) {
		return new File(getDataFolder(), fileName + " .yml");
	}
	
	public String getLangage() {
		return this.getConfig().getString("Langage");
	}
}


