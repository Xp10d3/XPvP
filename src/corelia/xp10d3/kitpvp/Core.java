package corelia.xp10d3.kitpvp;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import corelia.xp10d3.main.Commands;
import net.md_5.bungee.api.ChatColor;

public class Core extends JavaPlugin {
	
	OnDeath onDeath = new OnDeath();
	JoinLeaveMessages playerMessage = new JoinLeaveMessages();
	ItemDrop itemDrop = new ItemDrop();
	FallDamage fallDamage = new FallDamage();
	
	public static Core instance;
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(onDeath, this);
		this.getServer().getPluginManager().registerEvents(playerMessage, this);
		this.getServer().getPluginManager().registerEvents(itemDrop, this);
		this.getServer().getPluginManager().registerEvents(fallDamage, this);
		Commands cmd = new Commands();
		getCommand("kit").setExecutor(cmd);
		getLogger().info("[KitPvP] has started! Do /kits to see the commands!");
	}
    
	@Override
	public void onDisable() {
		getLogger().info(ChatColor.GOLD + "[KitPvP] is disabled. Come again!");
	}
	
	public static Core getInstance() {
		return instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				Location loc = player.getWorld().getSpawnLocation();
				player.teleport(loc);
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("archer")) {
			Player player = (Player) sender;
			player.getInventory().clear();
			player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
			player.getInventory().addItem(new ItemStack(Material.BOW));
			player.getInventory().addItem(new ItemStack(Material.ARROW, 128));
			player.getInventory().addItem(new ItemStack(Material.BAKED_POTATO, 64));
			player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
			player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
			player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
		}
		
		if (cmd.getName().equalsIgnoreCase("magicarcher")) {
			Player player = (Player) sender;
			int xp = player.getLevel();
			if (xp >= 10) {
				ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
				sword.addEnchantment(Enchantment.KNOCKBACK, 2);
				ItemStack bow = new ItemStack(Material.BOW, 1);
				bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
				bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
				ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
				ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
				chestplate.addEnchantment(Enchantment.THORNS, 1);
				chestplate.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
				ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
				leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
				player.getInventory().clear();
				player.getInventory().addItem(sword);
				player.getInventory().addItem(bow);
				player.getInventory().addItem(new ItemStack(Material.BAKED_POTATO, 64));
				player.getInventory().addItem(new ItemStack(Material.TIPPED_ARROW, 64));
				player.getInventory().setHelmet(helmet);
				player.getInventory().setChestplate(chestplate);
				player.getInventory().setLeggings(leggings);
				player.getInventory().setBoots(boots);
			} else {
				player.sendMessage("You don't have enough experience! Required experience level: 10.");
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("advancedarcher")) {
			Player player = (Player) sender;
			int xp = player.getLevel();;
			if (xp >= 30) {
				ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
				sword.addEnchantment(Enchantment.KNOCKBACK, 2);
				ItemStack bow = new ItemStack(Material.BOW, 1);
				bow.addEnchantment(Enchantment.ARROW_DAMAGE, 3);
				bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
				bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
				bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
				ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
				helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
				chestplate.addEnchantment(Enchantment.THORNS, 2);
				chestplate.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
				ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
				leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
				boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
				player.getInventory().clear();
				player.getInventory().addItem(sword);
				player.getInventory().addItem(bow);
				player.getInventory().addItem(new ItemStack(Material.BAKED_POTATO, 64));
				player.getInventory().addItem(new ItemStack(Material.TIPPED_ARROW, 64));
				player.getInventory().setHelmet(helmet);
				player.getInventory().setChestplate(chestplate);
				player.getInventory().setLeggings(leggings);
				player.getInventory().setBoots(boots);
			} else {
				player.sendMessage("You don't have enough experience! Required experience level: 30.");
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("guard")) {
			Player player = (Player) sender;
			player.getInventory().clear();
			player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
			player.getInventory().addItem(new ItemStack(Material.SHIELD));
			player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 64));
			player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
			player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
		}
		
		if (cmd.getName().equalsIgnoreCase("knight")) {
			Player player = (Player) sender;
			int xp = player.getLevel();
			if (xp >= 10) {
				ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
				sword.addEnchantment(Enchantment.KNOCKBACK, 1);
				ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
				helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
				chestplate.addEnchantment(Enchantment.THORNS, 1);
				chestplate.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
				ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
				leggings.addEnchantment(Enchantment.THORNS, 2);
				leggings.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
				ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
				boots.addEnchantment(Enchantment.PROTECTION_FALL, 3);
				boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
				player.getInventory().clear();
				player.getInventory().addItem(sword);
				player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 64));
				player.getInventory().setHelmet(helmet);
				player.getInventory().setChestplate(chestplate);
				player.getInventory().setLeggings(leggings);
				player.getInventory().setBoots(boots);
				player.getInventory().addItem(new ItemStack(Material.SHIELD));
			} else {
				player.sendMessage("You don't have enough experience! Required experience level: 10.");
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("overlord")) {
			Player player = (Player) sender;
			int xp = player.getLevel();
			if (xp >= 30) {
				ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
				sword.addEnchantment(Enchantment.SWEEPING_EDGE, 2);
				sword.addEnchantment(Enchantment.KNOCKBACK, 2);
				sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
				ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
				helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				helmet.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
				ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
				chestplate.addEnchantment(Enchantment.THORNS, 2);
				chestplate.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
				ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
				leggings.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
				leggings.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
				ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
				boots.addEnchantment(Enchantment.PROTECTION_FALL, 3);
				boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
				ItemStack shield = new ItemStack(Material.SHIELD, 1);
				player.getInventory().clear();
				player.getInventory().addItem(sword);
				player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 64));
				player.getInventory().setHelmet(helmet);
				player.getInventory().setChestplate(chestplate);
				player.getInventory().setLeggings(leggings);
				player.getInventory().setBoots(boots);
				player.getInventory().addItem(shield);
			} else {
				player.sendMessage("You don't have enough experience! Required experience level: 30.");
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("sniper")) {
			Player player = (Player) sender;
			player.getInventory().clear();
			player.getInventory().addItem(new ItemStack(Material.CROSSBOW));
			player.getInventory().addItem(new ItemStack(Material.ARROW, 128));
			player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 32));
			player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
			player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			player.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
			player.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
		}
		
		if (cmd.getName().equalsIgnoreCase("crackshot")) {
			Player player = (Player) sender;
			int xp = player.getLevel();
			if (xp >= 10) {
				ItemStack sword = new ItemStack(Material.CROSSBOW, 1);
				sword.addEnchantment(Enchantment.MULTISHOT, 1);
				sword.addEnchantment(Enchantment.QUICK_CHARGE, 2);
				ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
				helmet.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
				ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
				chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
				leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
				boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
				player.getInventory().clear();
				player.getInventory().addItem(sword);
				player.getInventory().addItem(new ItemStack(Material.ARROW, 64));
				player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
				player.getInventory().setHelmet(helmet);
				player.getInventory().setChestplate(chestplate);
				player.getInventory().setLeggings(leggings);
				player.getInventory().setBoots(boots);
			} else {
				player.sendMessage("You don't have enough experience! Required experience level: 10.");
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("scout")) {
			Player player = (Player) sender;
			int xp = player.getLevel();
			if (xp >= 30) {
				ItemStack sword = new ItemStack(Material.CROSSBOW, 1);
				sword.addEnchantment(Enchantment.MULTISHOT, 1);
				sword.addEnchantment(Enchantment.QUICK_CHARGE, 3);
				sword.addEnchantment(Enchantment.PIERCING, 4);
				ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
				helmet.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 3);
				helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
				chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
				leggings.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
				leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
				boots.addEnchantment(Enchantment.PROTECTION_FALL, 4);
				boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				player.getInventory().clear();
				player.getInventory().addItem(sword);
				player.getInventory().addItem(new ItemStack(Material.ARROW, 64));
				player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 64));
				player.getInventory().setHelmet(helmet);
				player.getInventory().setChestplate(chestplate);
				player.getInventory().setLeggings(leggings);
				player.getInventory().setBoots(boots);
			} else {
				player.sendMessage("You don't have enough experience! Required experience level: 30.");
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("enderman")) {
			Player player = (Player) sender;
			int xp = player.getLevel();
			if (xp >= 30) {
				ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
				sword.addEnchantment(Enchantment.KNOCKBACK, 2);
				ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
				helmet.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
				ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
				chestplate.addEnchantment(Enchantment.THORNS, 1);
				chestplate.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
				ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
				leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
				boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
				player.getInventory().clear();
				player.getInventory().addItem(sword);
				player.getInventory().addItem(new ItemStack(Material.CHORUS_FRUIT, 64));
				player.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 64));
				player.getInventory().setHelmet(helmet);
				player.getInventory().setChestplate(chestplate);
				player.getInventory().setLeggings(leggings);
				player.getInventory().setBoots(boots);
			} else {
				player.sendMessage("You don't have enough experience! Required experience level: 30.");
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("fisherman")) {
			Player player = (Player) sender;
			int xp = player.getLevel();
			if (xp >= 10) {
				ItemStack sword = new ItemStack(Material.WOODEN_SWORD, 1);
				sword.addEnchantment(Enchantment.KNOCKBACK, 2);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 4);
				ItemStack pole = new ItemStack(Material.FISHING_ROD, 1);
				pole.addEnchantment(Enchantment.DURABILITY, 3);
				ItemStack trident = new ItemStack(Material.TRIDENT, 1);
				trident.addEnchantment(Enchantment.LOYALTY, 3);
				trident.addEnchantment(Enchantment.IMPALING, 3);
				ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
				helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				helmet.addEnchantment(Enchantment.WATER_WORKER, 1);
				ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
				chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				chestplate.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
				ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
				leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
				boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
				player.getInventory().clear();
				player.getInventory().addItem(sword);
				player.getInventory().addItem(pole);
				player.getInventory().addItem(trident);
				player.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));
				player.getInventory().addItem(new ItemStack(Material.COOKED_COD, 64));
				player.getInventory().setHelmet(helmet);
				player.getInventory().setChestplate(chestplate);
				player.getInventory().setLeggings(leggings);
				player.getInventory().setBoots(boots);
			} else {
				player.sendMessage("You don't have enough experience! Required experience level: 10.");
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("flame")) {
			Player player = (Player) sender;
			int xp = player.getLevel();
			if (xp >= 30) {
				ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
				sword.addEnchantment(Enchantment.SWEEPING_EDGE, 2);
				sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
				ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
				helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				helmet.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
				ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
				chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				chestplate.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
				ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
				leggings.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
				ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
				boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
				boots.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
				ItemStack bow = new ItemStack(Material.BOW);
				bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
				bow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
				player.getInventory().clear();
				player.getInventory().addItem(sword);
				player.getInventory().addItem(bow);
				player.getInventory().addItem(new ItemStack(Material.ARROW, 64));
				player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
				player.getInventory().addItem(new ItemStack(Material.FLINT_AND_STEEL));
				player.getInventory().addItem(new ItemStack(Material.LAVA_BUCKET));
				player.getInventory().setHelmet(helmet);
				player.getInventory().setChestplate(chestplate);
				player.getInventory().setLeggings(leggings);
				player.getInventory().setBoots(boots);
			} else {
				player.sendMessage("You don't have enough experience! Required experience level: 30.");
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("kits")) {
			Player player = (Player) sender;
			player.sendMessage(
					ChatColor.YELLOW + " ********************** " + 
					ChatColor.YELLOW + "|       Commands       |" +
					ChatColor.YELLOW + " ********************** " +
					ChatColor.AQUA + "/spawn" + ChatColor.GREEN + " - Sends you to spawn. \n" +
					ChatColor.AQUA + "/clearinv" + ChatColor.GREEN + " - Clears your inventory. \n" +
					ChatColor.AQUA + "/guard" + ChatColor.GREEN + " - Gives the guard kit. \n" +
					ChatColor.AQUA + "/knight" + ChatColor.GREEN + " - Gives the knight kit. \n" +
					ChatColor.AQUA + "/overlord" + ChatColor.GREEN + " - Gives the overlord kit. \n" +
					ChatColor.AQUA + "/archer" + ChatColor.GREEN + " - Gives the archer kit. \n" +
					ChatColor.AQUA + "/magicarcher" + ChatColor.GREEN + " - Gives the magic archer kit. \n" +
					ChatColor.AQUA + "/advancedarcher" + ChatColor.GREEN + " - Gives the advanced archer kit. \n" +
					ChatColor.AQUA + "/sniper" + ChatColor.GREEN + " - Gives the sniper kit. \n" +
					ChatColor.AQUA + "/crackshot" + ChatColor.GREEN + " - Gives the crackshot kit. \n" +
					ChatColor.AQUA + "/scout" + ChatColor.GREEN + " - Gives the scout kit. \n" +
					ChatColor.AQUA + "/fisherman" + ChatColor.GREEN + " - Gives the fisherman kit. \n" +
					ChatColor.AQUA + "/enderman" + ChatColor.GREEN + " - Gives the enderman kit. \n" +
					ChatColor.AQUA + "/flame" + ChatColor.GREEN + " - Gives the flame kit. \n"
					);
		}
		
		if (cmd.getName().equalsIgnoreCase("network")) {
			Player player = (Player) sender;
			player.sendMessage(
					ChatColor.YELLOW + " ********************** " + 
					ChatColor.YELLOW + "|     Network Info      |" +
					ChatColor.YELLOW + " ********************** " +
					ChatColor.GREEN + "  Corelia is in a network with EndRan, owned by Mini_kyogre. " +
					ChatColor.GREEN + "EndRan is a towny server with multiple towns. If you want " +
					ChatColor.GREEN + "more info, go to " + ChatColor.DARK_PURPLE + "endran.net."
					);
		}
		
		if (cmd.getName().equalsIgnoreCase("clearinv")) {
			Player player = (Player) sender;
			player.getInventory().clear();
			player.sendMessage("Cleared the inventory!");
		}
		
		return false;
	}
}