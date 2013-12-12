package com.comze_instancelabs.coloredleather;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import net.minecraft.server.v1_7_R1.AttributeInstance;
import net.minecraft.server.v1_7_R1.EntityInsentient;
import net.minecraft.server.v1_7_R1.GenericAttributes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftLivingEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;


/**
 * 
 * @author InstanceLabs
 *
 */

public class Main extends JavaPlugin implements Listener {
	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

    	if(cmd.getName().equalsIgnoreCase("coloredleather")){
    		if(sender.hasPermission("coloredleather.spawn")){
	    		if(sender instanceof Player){
	    			Player p = (Player)sender;
	    			
	    			ItemStack lhelmet = new ItemStack(Material.LEATHER_HELMET, 1);
	    		    LeatherArmorMeta lam = (LeatherArmorMeta)lhelmet.getItemMeta();
	    		    
	    		    ItemStack lboots = new ItemStack(Material.LEATHER_BOOTS, 1);
	    		    LeatherArmorMeta lam1 = (LeatherArmorMeta)lboots.getItemMeta();
	    		    
	    		    ItemStack lchestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
	    		    LeatherArmorMeta lam2 = (LeatherArmorMeta)lchestplate.getItemMeta();
	    		    
	    		    ItemStack lleggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
	    		    LeatherArmorMeta lam3 = (LeatherArmorMeta)lleggings.getItemMeta();

	    		    if(args.length > 0){
	    		    	if(args[0].length() > 6 && args[0].length() < 8){
		    		    	Color c = hexToRgb(args[0]);
		    		    	lam3.setColor(c);
			    		    lam2.setColor(c);
			    		    lam1.setColor(c);
			    		    lam.setColor(c);	
	    		    	}else{
	    		    		sender.sendMessage("§cThe Color code seems to be invalid! Try #FF8899 for example.");
	    		    	}
	    		    }else{
		    		    lam3.setColor(Color.fromRGB(0, 0, 0));
		    		    lam2.setColor(Color.fromRGB(0, 0, 0));
		    		    lam1.setColor(Color.fromRGB(0, 0, 0));
		    		    lam.setColor(Color.fromRGB(0, 0, 0));	
	    		    }
	    		    
	    		    lhelmet.setItemMeta(lam);
	    		    lboots.setItemMeta(lam1);
	    		    lchestplate.setItemMeta(lam2);
	    		    lleggings.setItemMeta(lam3);
	    		    
	    		    p.getInventory().addItem(lboots);
	    		    p.getInventory().addItem(lleggings);
	    		    p.getInventory().addItem(lchestplate);
	    		    p.getInventory().addItem(lhelmet);
	    		}
	    		return true;	
    		}
    	}
    	return false;
    }
    
    
    public Color hexToRgb(String colorStr) {
    	return Color.fromRGB(Integer.valueOf( colorStr.substring( 1, 3 ), 16 ), Integer.valueOf( colorStr.substring( 3, 5 ), 16 ), Integer.valueOf( colorStr.substring( 5, 7 ), 16 ));
    }
    

}
