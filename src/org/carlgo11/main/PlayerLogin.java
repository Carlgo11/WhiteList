package org.carlgo11.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;





public class PlayerLogin implements Listener{
	Main plugin;
	public PlayerLogin(Main plug) {
        super();
        this.plugin = plug;
}
	@EventHandler
	  public void onPlayerLogin(PlayerLoginEvent e)
	  {
		PlayerLoginEvent.Result r = e.getResult();
		if(Bukkit.hasWhitelist() == true){
	    

	    
	    if (r == PlayerLoginEvent.Result.KICK_WHITELIST) {
	    	e.setKickMessage(ChatColor.YELLOW + "====== Not WhiteListed ====== \n " + ChatColor.GRAY +
	    			"English: " + ChatColor.RED + "You'r not Whitelisted!\n" + ChatColor.GRAY + 
	    					"Svenska: "  + ChatColor.RED + "Du är inte Whitelisted!\n\n\n\n\n" +
	    							ChatColor.YELLOW +  "To join please visit " + ChatColor.GOLD + "http://www.portalcraft.se/index.php?forums/Whitelist_apply/create-thread/");
	    	Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "[" + plugin.getDescription().getName() + "] " + ChatColor.RED + e.getPlayer().getName() + ChatColor.YELLOW + " tryed to join but isn't Whitelisted!");
	    	
	    }
		}
	  }
}
