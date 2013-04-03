package org.carlgo11.main;
 
 
import java.util.ArrayList;
import java.util.logging.Logger;
 
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.carlgo11.Lain2.Lain2;
import com.carlgo11.Lain2.PlayerJoin;
 
 
 
public class Main extends JavaPlugin implements Listener {
        int var = 10;
        public static Main plugin;
       static public boolean Update = false;
       static String d = null;
       static String motd = null;
        public final static Logger logger = Logger.getLogger("Minercraft");
        static String search_usage = ChatColor.WHITE + "Usage: /wh search <name>";
        String 
        badperm = 
        ChatColor.LIGHT_PURPLE + 
        "[Whitelist] " +
        		ChatColor.RED + "Error: You don't have permission";
        


            public void onEnable() {
                plugin = this;
                new Main();
                plugin.getServer().getPluginManager().registerEvents(this, plugin);
          
                makeConfig();
                Bukkit.getServer().getPluginManager()
                                .registerEvents(new PlayerLogin(this), this);
                getLogger().info(
                                getDescription().getName() + getDescription().getVersion()
                                                + " Is Enabled!");
                
                System.out.println("plon: " + plon);
                Config();
                Script();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){

					@Override
					public void run() {
						if(Bukkit.getPluginManager().getPlugin("Lain").isEnabled()){
							plugin.logger.info("[" + getDescription().getName() + "] " +  "Found my sister Lain :D");
						} else {
							Main.logger.info("[" + getDescription().getName() + "] " + "To enable everything please install Lain!");
						}
						
					}
                	
                }, 5L);
                if(Main.plugin.getConfig().getString("on").equalsIgnoreCase("true")){
                    Bukkit.setWhitelist(true);
                    } else if(Main.plugin.getConfig().getString("on").equalsIgnoreCase("false")){
                    	Bukkit.setWhitelist(false);
                    }
        }
        public void Config(){
             
                if(!Main.plugin.getConfig().getString("on").equalsIgnoreCase("no") || !Main.plugin.getConfig().getString("on").equalsIgnoreCase("true")){
                	System.out.println("Config: " + getConfig().getString("on"));
                	
                }
        }
 
        public void onDisable() {
                getLogger().info(
                                "[" + getDescription().getName() + "] "
                                                + getDescription().getName()
                                                + getDescription().getVersion() + " Is Disabled!");
        }
     
        private void makeConfig() {
                getConfig().addDefault("on", true);
                getConfig().options().copyDefaults(true);
                saveConfig();
        }
        public static boolean plon = true;
 
       
             
        public boolean onCommand(CommandSender sender, Command cmd, String label,
                        String[] args) {
                if (cmd.getName().equalsIgnoreCase("Wh")) {
                        if (args.length == 0) {
                                sender.sendMessage("/Whitelist <on|off>");
                                sender.sendMessage("/Whitelist <add|remove> <namn>");
                                sender.sendMessage("Config: " + getConfig().getString("on"));
                               
                        }
                        if(sender.hasPermission("Whitelist.use")){
                        if (args.length == 1) {
                                if (args[0].equalsIgnoreCase("on")) {
                                        if (Bukkit.hasWhitelist() == true) {
                                                sender.sendMessage(ChatColor.LIGHT_PURPLE + "[" +  getDescription().getName() + "] " + ChatColor.RED + "Whitelist is already on!");
                                        } else {
                                                plon = true;
                                                Bukkit.setWhitelist(true);
                                                Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "["
                                                                + getDescription().getName() + "] "
                                                                + ChatColor.RED + sender.getName()
                                                                + ChatColor.YELLOW + " turned on Whitelist!");
                                                sender.sendMessage(ChatColor.LIGHT_PURPLE + "[" + getDescription().getName()
                                                                + "] " + ChatColor.YELLOW
                                                                + "Whitelist is now on!");
                                                
                                        }
                                }
                                if (args[0].equalsIgnoreCase("off")) {
                                        if (Bukkit.hasWhitelist() == true) {
                                                plon = false;
                                                Bukkit.setWhitelist(false);
                                                Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "["
                                                                + getDescription().getName() + "] "
                                                                + ChatColor.RED + sender.getName()
                                                                + ChatColor.YELLOW + " turned off Whitelist!");
                                                sender.sendMessage(ChatColor.LIGHT_PURPLE + "[" + getDescription().getName()    + "] " + ChatColor.YELLOW
                                                                + "Whitelist is now off!");
 
                                        } else {
                                                sender.sendMessage(ChatColor.LIGHT_PURPLE + "[" +  getDescription().getName() + "] " + ChatColor.RED + "Whitelist is already off!");
                                        }
                                       
                                }
                                if(args[0].equalsIgnoreCase("add")){
                                        sender.sendMessage("/Whitelist <add|remove> <namn>");
                                }
                                if(args[0].equalsIgnoreCase("remove")){
                                        sender.sendMessage("/Whitelist <add|remove> <namn>");
                                }
                                if(args[0].equalsIgnoreCase("reload")){
                                	
                                    plugin.reloadConfig();
                            }
                                if(args[0].equalsIgnoreCase("list")){
                                         StringBuilder result = new StringBuilder();
                                       
                                         for (OfflinePlayer player : Bukkit.getWhitelistedPlayers()) {
                                                                        if (result.length() > 0) {
                                                                            result.append(ChatColor.RESET + ", ");
                                                                        }
                                                   
                                                                        result.append(ChatColor.GREEN + player.getName());
                                                                    }
                                                   
                                                                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "[" +  getDescription().getName() + "] " + ChatColor.AQUA + "Whitelisted players" + ChatColor.RESET + ": " + ChatColor.RESET + result.toString());
                                                                    return true;
                                                             }

                                                           
                               
                                if(!(args[0].equalsIgnoreCase("remove") || args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("del") || args[0].equalsIgnoreCase("delete") || args[0].equalsIgnoreCase("on") || args[0].equalsIgnoreCase("på") || args[0].equalsIgnoreCase("off") || args[0].equalsIgnoreCase("av"))){
                                	    sender.sendMessage("Whitelist <search> <name>");
                                        sender.sendMessage("/Whitelist <on|off>");
                                        sender.sendMessage("/Whitelist <add|remove> <namn>");
                                }
                               
                        }
                        }
                        else {
                                sender.sendMessage(badperm);
                        }
                        if(args.length == 2){
                                if(sender.hasPermission("Whitelist.use")){
                                if(args[0].equalsIgnoreCase("add")){
                                        if(!Bukkit.getOfflinePlayer(args[1]).isWhitelisted()){
                                        Bukkit.getOfflinePlayer(args[1]).setWhitelisted(true);
                                        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "[" + getDescription().getName() + "] " +      ChatColor.RED + args[1] + ChatColor.YELLOW + " is now whitelied by " + ChatColor.RED + sender.getName());
                                        if(Bukkit.getOfflinePlayer(args[1]).isOnline()){
                                                sender.sendMessage(ChatColor.LIGHT_PURPLE + "[" +  getDescription().getName() + "] " + ChatColor.YELLOW + "You are now Whitelisted!");
                                        }
                                        } else {
                                                sender.sendMessage(ChatColor.LIGHT_PURPLE + "[" + getDescription().getName() + "] " +      ChatColor.RED + args[1] + " is already whitelisted!");
                                               
                                        }
                                }
                                if(args[0].equalsIgnoreCase("remove") || args[0].equalsIgnoreCase("del") || args[0].equalsIgnoreCase("delete")){
                                        if(Bukkit.getOfflinePlayer(args[1]).isWhitelisted()){
                                        Bukkit.getOfflinePlayer(args[1]).setWhitelisted(false);
                                        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "[" + getDescription().getName() + "] " +      ChatColor.RED + args[1] + ChatColor.YELLOW + " is no longer whitelisted!");
                                        if(Bukkit.getOfflinePlayer(args[1]).isOnline()){
                                                sender.sendMessage(ChatColor.LIGHT_PURPLE + "[" +  getDescription().getName() + "] " + ChatColor.YELLOW + "You are no longer Whitelisted!");
                                        }
                                        } else {
                                                sender.sendMessage(ChatColor.LIGHT_PURPLE + "[" + getDescription().getName() + "] " +      ChatColor.RED + args[1] + " is no longer Whitelisted!");
                                        }
                                }
                                if(args[0].equalsIgnoreCase("search")){
                               		 if(Bukkit.getOfflinePlayer(args[1]).isWhitelisted()){
                               			 sender.sendMessage(ChatColor.LIGHT_PURPLE + "[" +  getDescription().getName() + "] " + ChatColor.RED + args[1] + ChatColor.YELLOW + " is whitelisted!");
                               	 } else {
                               		sender.sendMessage(ChatColor.LIGHT_PURPLE + "[" +  getDescription().getName() + "] " + ChatColor.RED + args[1] + ChatColor.RED + " is not whitelisted!");
                               	 }
                               }

                                if(!(args[0].equalsIgnoreCase("remove") || args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("del") || args[0].equalsIgnoreCase("delete") || args[0].equalsIgnoreCase("search"))){
                                        sender.sendMessage("/Whitelist <on|off>");
                                        sender.sendMessage("/Whitelist <add|remove> <namn>");
                                }
                       
                        }
                                else {
                                        sender.sendMessage(badperm);
                        }
                        }
                        if(args.length == 3 || args.length > 3){
                                sender.sendMessage("/Whitelist <on|off>");
                                sender.sendMessage("/Whitelist <add|remove> <namn>");
                           
                        }
                       
                }
                if(cmd.getName().equalsIgnoreCase("Update")){
                	if(!(sender instanceof Player)){
                		if(args.length > 0){
                			Update=true;
                    		d = args[0];

                		Main.logger.info("[Whitelist] server is at lockdown now!");
                		Main.logger.info("[Whitelist] Reasone: " + d);
                		

                		} else {
                			sender.sendMessage("Usage: /Update <reasone> ");
                		}
                		
                	} else {
                		sender.sendMessage("[Whitelist] only the CONSOLE can use this command!");
                	}
                	
                }
                return true;
        }
 
        public void Script() {
                if (plon == true) {
                        msg();
                        System.out.println("Plugin on: " + plon);
 
                } else {
                        System.out
                                        .print("["
                                                        + getDescription().getName()
                                                        + "] "
                                                        + "WhiteList off!");
                        
                        Shutdown();
 
                }
                
        }
 
        public void Shutdown() {
                System.out.println("[" + getDescription().getName() + "] "
                                + getDescription().getName() + getDescription().getVersion()
                                + " Is Disabled!");
                Bukkit.getPluginManager().disablePlugin(this);
        }
 
        public void msg() {
                Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "[Whitelist] "
                                + ChatColor.YELLOW + "ConnectWall online!");
                Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "[Whitelist] "
                                + ChatColor.YELLOW
                                + "No players that's not whitelisted can join now!");
        }
        public void clean(){
               
                Main.logger.info(Bukkit.getWhitelistedPlayers().toString() + "");
               
        }
        
        
        @EventHandler
        public void onServerPing(ServerListPingEvent e){
        	if(Bukkit.getPluginManager().getPlugin("Lain").isEnabled()){
        	System.out.println("ServerPing: " + e.getAddress());
        	e.setMaxPlayers(Lain2.joins);
        	if(Update == true){
            e.setMotd(ChatColor.RED + "Server at Lockdown!");
        	}else {
        		if(Update == false){
        		if(PlayerJoin.owner_online == true){
        			e.setMotd(ChatColor.YELLOW + Bukkit.getMotd() + ChatColor.GREEN + " [Owner Online]");
        		} else {
        			e.setMotd(ChatColor.YELLOW + Bukkit.getMotd() + ChatColor.RED + " [Owner Offline]");
        		}
        		} else {
        			
        		}
        	}
        	if(Bukkit.getOnlinePlayers().length == 0){
        		e.setMaxPlayers(99999);
        		
        		
        	}
        	}
        }
}