package corelia.xp10d3.core;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor {
	// NOTE: I used this: https://www.youtube.com/watch?v=JGSrJ8iiyG0
	
	boolean clearInv;
	
	// Command method.
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		
		// Guard
		if (args[0].equalsIgnoreCase("guard")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (clearInv = false) {
					player.getInventory().clear();
				}
				player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
				player.getInventory().addItem(new ItemStack(Material.SHIELD));
				player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 64));
				player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
				player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
				player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
				player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			}
		}
		
		// Archer
		if (args[0].equalsIgnoreCase("archer")) {
			Player player = (Player) sender;
			if (clearInv = false) {
				player.getInventory().clear();
			}
			player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
			player.getInventory().addItem(new ItemStack(Material.BOW));
			player.getInventory().addItem(new ItemStack(Material.ARROW, 128));
			player.getInventory().addItem(new ItemStack(Material.BAKED_POTATO, 64));
			player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
			player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
			player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
		}
		
		// MagicArcher
		if (args[0].equalsIgnoreCase("magicarcher")) {
			Player player = (Player) sender;
			int xp = player.getLevel();
			if (xp >= 10) {
				ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
				final ItemMeta swordMeta = sword.getItemMeta();
				swordMeta.setDisplayName(ChatColor.BLUE + "Magic Archer Sword");
				sword.setItemMeta(swordMeta);
				sword.addEnchantment(Enchantment.KNOCKBACK, 2);
				ItemStack bow = new ItemStack(Material.BOW, 1);
				final ItemMeta bowMeta = bow.getItemMeta();
				bowMeta.setDisplayName(ChatColor.BLUE + "Magic Archer Bow");
				bow.setItemMeta(bowMeta);
				bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
				bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
				ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
				final ItemMeta helmetMeta = helmet.getItemMeta();
				helmetMeta.setDisplayName(ChatColor.BLUE + "Magic Archer Helmet");
				helmet.setItemMeta(helmetMeta);
				ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
				final ItemMeta chestplateMeta = chestplate.getItemMeta();
				chestplateMeta.setDisplayName(ChatColor.BLUE + "Magic Archer Chestplate");
				chestplate.setItemMeta(chestplateMeta);
				chestplate.addEnchantment(Enchantment.THORNS, 1);
				chestplate.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
				ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
				final ItemMeta leggingsMeta = leggings.getItemMeta();
				leggingsMeta.setDisplayName(ChatColor.BLUE + "Magic Archer Leggings");
				leggings.setItemMeta(leggingsMeta);
				leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
				final ItemMeta bootsMeta = boots.getItemMeta();
				bootsMeta.setDisplayName(ChatColor.BLUE + "Magic Archer Boots");
				boots.setItemMeta(bootsMeta);
				if (clearInv = false) {
					player.getInventory().clear();
				}
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
		
		// AdvancedArcher
		if (args[0].equalsIgnoreCase("advancedarcher")) {
			Player player = (Player) sender;
			int xp = player.getLevel();;
			if (xp >= 30) {
				ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
				final ItemMeta swordMeta = sword.getItemMeta();
				swordMeta.setDisplayName(ChatColor.GOLD + "Advanced Archer Bow");
				sword.setItemMeta(swordMeta);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
				sword.addEnchantment(Enchantment.KNOCKBACK, 2);
				ItemStack bow = new ItemStack(Material.BOW, 1);
				final ItemMeta bowMeta = bow.getItemMeta();
				bowMeta.setDisplayName(ChatColor.GOLD + "Advanced Archer Bow");
				bow.setItemMeta(bowMeta);
				bow.addEnchantment(Enchantment.ARROW_DAMAGE, 3);
				bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
				bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
				bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
				ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
				final ItemMeta helmetMeta = helmet.getItemMeta();
				helmetMeta.setDisplayName(ChatColor.GOLD + "Advanced Archer Helmet");
				helmet.setItemMeta(helmetMeta);
				helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
				final ItemMeta chestplateMeta = chestplate.getItemMeta();
				chestplateMeta.setDisplayName(ChatColor.GOLD + "Advanced Archer Chestplate");
				chestplate.setItemMeta(chestplateMeta);
				chestplate.addEnchantment(Enchantment.THORNS, 2);
				chestplate.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
				ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
				final ItemMeta leggingsMeta = leggings.getItemMeta();
				leggingsMeta.setDisplayName(ChatColor.GOLD + "Advanced Archer Leggings");
				leggings.setItemMeta(leggingsMeta);
				leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
				final ItemMeta bootsMeta = boots.getItemMeta();
				bootsMeta.setDisplayName(ChatColor.GOLD + "Advanced Archer Boots");
				boots.setItemMeta(bootsMeta);
				boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
				if (clearInv = false) {
					player.getInventory().clear();
				}
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
		
		// Sniper
		if (args[0].equalsIgnoreCase("sniper")) {
			Player player = (Player) sender;
			if (clearInv = false) {
				player.getInventory().clear();
			}
			player.getInventory().addItem(new ItemStack(Material.CROSSBOW));
			player.getInventory().addItem(new ItemStack(Material.ARROW, 128));
			player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 32));
			player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
			player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			player.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
			player.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
		}
		
		// Scout
		if (args[0].equalsIgnoreCase("scout")) {
			Player player = (Player) sender;
			int xp = player.getLevel();
			if (xp >= 30) {
				ItemStack sword = new ItemStack(Material.CROSSBOW, 1);
				final ItemMeta swordMeta = sword.getItemMeta();
				swordMeta.setDisplayName(ChatColor.BLUE + "Scout Crossbow");
				sword.setItemMeta(swordMeta);
				sword.addEnchantment(Enchantment.MULTISHOT, 1);
				sword.addEnchantment(Enchantment.QUICK_CHARGE, 3);
				sword.addEnchantment(Enchantment.PIERCING, 4);
				ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
				final ItemMeta helmetMeta = helmet.getItemMeta();
				helmetMeta.setDisplayName(ChatColor.BLUE + "Scout Helmet");
				helmet.setItemMeta(helmetMeta);
				helmet.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 3);
				helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
				final ItemMeta chestplateMeta = chestplate.getItemMeta();
				chestplateMeta.setDisplayName(ChatColor.BLUE + "Scout Chestplate");
				chestplate.setItemMeta(chestplateMeta);
				chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
				final ItemMeta leggingsMeta = leggings.getItemMeta();
				leggingsMeta.setDisplayName(ChatColor.BLUE + "Scout Leggings");
				leggings.setItemMeta(leggingsMeta);
				leggings.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
				leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
				final ItemMeta bootsMeta = boots.getItemMeta();
				bootsMeta.setDisplayName(ChatColor.BLUE + "Scout Boots");
				boots.setItemMeta(bootsMeta);
				boots.addEnchantment(Enchantment.PROTECTION_FALL, 4);
				boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				if (clearInv = false) {
					player.getInventory().clear();
				}
				player.getInventory().addItem(sword);
				player.getInventory().addItem(new ItemStack(Material.ARROW, 64));
				player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 20));
				player.getInventory().setHelmet(helmet);
				player.getInventory().setChestplate(chestplate);
				player.getInventory().setLeggings(leggings);
				player.getInventory().setBoots(boots);
			} else {
				player.sendMessage("You don't have enough experience! Required experience level: 30.");
			}
		}
		
		// Crackshot
		if (args[0].equalsIgnoreCase("crackshot")) {
			Player player = (Player) sender;
			int xp = player.getLevel();
			if (xp >= 10) {
				ItemStack sword = new ItemStack(Material.CROSSBOW, 1);
				final ItemMeta swordMeta = sword.getItemMeta();
				swordMeta.setDisplayName(ChatColor.BLUE + "Crackshot Crossbow");
				sword.setItemMeta(swordMeta);
				sword.addEnchantment(Enchantment.MULTISHOT, 1);
				sword.addEnchantment(Enchantment.QUICK_CHARGE, 2);
				ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
				final ItemMeta helmetMeta = helmet.getItemMeta();
				helmetMeta.setDisplayName(ChatColor.BLUE + "Crackshot Helmet");
				helmet.setItemMeta(helmetMeta);
				helmet.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
				ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
				final ItemMeta chestplateMeta = chestplate.getItemMeta();
				chestplateMeta.setDisplayName(ChatColor.BLUE + "Crackshot Chestplate");
				chestplate.setItemMeta(chestplateMeta);
				chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
				final ItemMeta leggingsMeta = leggings.getItemMeta();
				leggingsMeta.setDisplayName(ChatColor.BLUE + "Crackshot Leggings");
				leggings.setItemMeta(leggingsMeta);
				leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
				final ItemMeta bootsMeta = boots.getItemMeta();
				bootsMeta.setDisplayName(ChatColor.BLUE + "Crackshot Boots");
				boots.setItemMeta(bootsMeta);
				boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
				if (clearInv = false) {
					player.getInventory().clear();
				}
				player.getInventory().addItem(sword);
				player.getInventory().addItem(new ItemStack(Material.ARROW, 64));
				player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 10));
				player.getInventory().setHelmet(helmet);
				player.getInventory().setChestplate(chestplate);
				player.getInventory().setLeggings(leggings);
				player.getInventory().setBoots(boots);
			} else {
				player.sendMessage("You don't have enough experience! Required experience level: 10.");
			}
		}
		
		// Knight
		if (args[0].equalsIgnoreCase("knight")) {
			Player player = (Player) sender;
			int xp = player.getLevel();
			if (xp >= 10) {
				ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
				final ItemMeta swordMeta = sword.getItemMeta();
				swordMeta.setDisplayName(ChatColor.BLUE + "Knight Sword");
				sword.setItemMeta(swordMeta);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
				sword.addEnchantment(Enchantment.KNOCKBACK, 1);
				ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
				final ItemMeta helmetMeta = helmet.getItemMeta();
				helmetMeta.setDisplayName(ChatColor.BLUE + "Knight Helmet");
				helmet.setItemMeta(helmetMeta);
				helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
				final ItemMeta chestplateMeta = chestplate.getItemMeta();
				chestplateMeta.setDisplayName(ChatColor.BLUE + "Knight Chestplate");
				chestplate.setItemMeta(chestplateMeta);
				chestplate.addEnchantment(Enchantment.THORNS, 1);
				chestplate.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
				ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
				final ItemMeta leggingsMeta = leggings.getItemMeta();
				leggingsMeta.setDisplayName(ChatColor.BLUE + "Knight Leggings");
				leggings.setItemMeta(leggingsMeta);
				leggings.addEnchantment(Enchantment.THORNS, 2);
				leggings.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
				ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
				final ItemMeta bootsMeta = boots.getItemMeta();
				bootsMeta.setDisplayName(ChatColor.BLUE + "Knight Boots");
				boots.setItemMeta(bootsMeta);
				boots.addEnchantment(Enchantment.PROTECTION_FALL, 3);
				boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
				if (clearInv = false) {
					player.getInventory().clear();
				}
				player.getInventory().addItem(sword);
				player.getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT, 64));
				player.getInventory().setHelmet(helmet);
				player.getInventory().setChestplate(chestplate);
				player.getInventory().setLeggings(leggings);
				player.getInventory().setBoots(boots);
				player.getInventory().addItem(new ItemStack(Material.SHIELD));
			} else {
				player.sendMessage("You don't have enough experience! Required experience level: 10.");
			}
		}
		
		// Enderman
		if (args[0].equalsIgnoreCase("enderman")) {
			Player player = (Player) sender;
			int xp = player.getLevel();
			if (xp >= 30) {
				ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
				final ItemMeta swordMeta = sword.getItemMeta();
				swordMeta.setDisplayName(ChatColor.GOLD + "Enderman Sword");
				sword.setItemMeta(swordMeta);
				sword.addEnchantment(Enchantment.KNOCKBACK, 2);
				ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
				final ItemMeta helmetMeta = helmet.getItemMeta();
				helmetMeta.setDisplayName(ChatColor.GOLD + "Enderman Helmet");
				helmet.setItemMeta(helmetMeta);
				helmet.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
				ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
				final ItemMeta chestplateMeta = chestplate.getItemMeta();
				chestplateMeta.setDisplayName(ChatColor.GOLD + "Enderman Chestplate");
				chestplate.setItemMeta(chestplateMeta);
				chestplate.addEnchantment(Enchantment.THORNS, 1);
				chestplate.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
				ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
				final ItemMeta leggingsMeta = leggings.getItemMeta();
				leggingsMeta.setDisplayName(ChatColor.GOLD + "Enderman Leggings");
				leggings.setItemMeta(leggingsMeta);
				leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
				final ItemMeta bootsMeta = boots.getItemMeta();
				bootsMeta.setDisplayName(ChatColor.GOLD + "Enderman Boots");
				boots.setItemMeta(bootsMeta);
				boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
				if (clearInv = false) {
					player.getInventory().clear();
				}
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
		
		// Overlord
		if (args[0].equalsIgnoreCase("overlord")) {
			Player player = (Player) sender;
			int xp = player.getLevel();
			if (xp >= 30) {
				ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
				final ItemMeta swordMeta = sword.getItemMeta();
				swordMeta.setDisplayName(ChatColor.GOLD + "Overlord Sword");
				sword.setItemMeta(swordMeta);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
				sword.addEnchantment(Enchantment.SWEEPING_EDGE, 2);
				sword.addEnchantment(Enchantment.KNOCKBACK, 2);
				sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
				ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
				final ItemMeta helmetMeta = helmet.getItemMeta();
				helmetMeta.setDisplayName(ChatColor.GOLD + "Overlord Helmet");
				helmet.setItemMeta(helmetMeta);
				helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				helmet.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
				ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
				final ItemMeta chestplateMeta = chestplate.getItemMeta();
				chestplateMeta.setDisplayName(ChatColor.GOLD + "Overlord Chestplate");
				chestplate.setItemMeta(chestplateMeta);
				chestplate.addEnchantment(Enchantment.THORNS, 2);
				chestplate.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
				ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
				final ItemMeta leggingsMeta = leggings.getItemMeta();
				leggingsMeta.setDisplayName(ChatColor.GOLD + "Overlord Leggings");
				leggings.setItemMeta(leggingsMeta);
				leggings.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
				leggings.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
				ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
				final ItemMeta bootsMeta = boots.getItemMeta();
				bootsMeta.setDisplayName(ChatColor.GOLD + "Overlord Boots");
				boots.setItemMeta(bootsMeta);
				boots.addEnchantment(Enchantment.PROTECTION_FALL, 3);
				boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
				ItemStack shield = new ItemStack(Material.SHIELD, 1);
				if (clearInv = false) {
					player.getInventory().clear();
				}
				player.getInventory().addItem(sword);
				player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 10));
				player.getInventory().setHelmet(helmet);
				player.getInventory().setChestplate(chestplate);
				player.getInventory().setLeggings(leggings);
				player.getInventory().setBoots(boots);
				player.getInventory().addItem(shield);
			} else {
				player.sendMessage("You don't have enough experience! Required experience level: 30.");
			}
		}
		
		// Fisherman
		if (args[0].equalsIgnoreCase("fisherman")) {
			Player player = (Player) sender;
			int xp = player.getLevel();
			if (xp >= 10) {
				ItemStack sword = new ItemStack(Material.WOODEN_SWORD, 1);
				final ItemMeta swordMeta = sword.getItemMeta();
				swordMeta.setDisplayName(ChatColor.BLUE + "Fisherman Sword");
				sword.setItemMeta(swordMeta);
				sword.addEnchantment(Enchantment.KNOCKBACK, 2);
				sword.addEnchantment(Enchantment.KNOCKBACK, 2);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 4);
				ItemStack pole = new ItemStack(Material.FISHING_ROD, 1);
				final ItemMeta poleMeta = pole.getItemMeta();
				poleMeta.setDisplayName(ChatColor.BLUE + "Fisherman Fishing Rod");
				pole.setItemMeta(poleMeta);
				pole.addEnchantment(Enchantment.DURABILITY, 3);
				ItemStack trident = new ItemStack(Material.TRIDENT, 1);
				final ItemMeta tridentMeta = trident.getItemMeta();
				tridentMeta.setDisplayName(ChatColor.BLUE + "Fisherman Trident");
				trident.setItemMeta(tridentMeta);
				trident.addEnchantment(Enchantment.LOYALTY, 3);
				trident.addEnchantment(Enchantment.IMPALING, 3);
				ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
				final ItemMeta helmetMeta = helmet.getItemMeta();
				helmetMeta.setDisplayName(ChatColor.BLUE + "Fisherman Helmet");
				helmet.setItemMeta(helmetMeta);
				helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				helmet.addEnchantment(Enchantment.WATER_WORKER, 1);
				ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
				final ItemMeta chestplateMeta = chestplate.getItemMeta();
				chestplateMeta.setDisplayName(ChatColor.BLUE + "Fisherman Chestplate");
				chestplate.setItemMeta(chestplateMeta);
				chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				chestplate.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
				ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
				final ItemMeta leggingsMeta = leggings.getItemMeta();
				leggingsMeta.setDisplayName(ChatColor.BLUE + "Fisherman Leggings");
				leggings.setItemMeta(leggingsMeta);
				leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
				final ItemMeta bootsMeta = boots.getItemMeta();
				bootsMeta.setDisplayName(ChatColor.BLUE + "Fisherman Boots");
				boots.setItemMeta(bootsMeta);
				boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
				if (clearInv = false) {
					player.getInventory().clear();
				}
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
		
		// Flame
		if (args[0].equalsIgnoreCase("flame")) {
			Player player = (Player) sender;
			int xp = player.getLevel();
			if (xp >= 30) {
				ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
				final ItemMeta swordMeta = sword.getItemMeta();
				swordMeta.setDisplayName(ChatColor.GOLD + "Flame Sword");
				sword.setItemMeta(swordMeta);
				sword.addEnchantment(Enchantment.SWEEPING_EDGE, 2);
				sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
				ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
				final ItemMeta helmetMeta = helmet.getItemMeta();
				helmetMeta.setDisplayName(ChatColor.GOLD + "Flame Helmet");
				helmet.setItemMeta(helmetMeta);
				helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				helmet.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
				ItemStack chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
				final ItemMeta chestplateMeta = chestplate.getItemMeta();
				chestplateMeta.setDisplayName(ChatColor.GOLD + "Flame Chestplate");
				chestplate.setItemMeta(chestplateMeta);
				chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				chestplate.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
				ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
				final ItemMeta leggingsMeta = leggings.getItemMeta();
				leggingsMeta.setDisplayName(ChatColor.GOLD + "Flame Leggings");
				leggings.setItemMeta(leggingsMeta);
				leggings.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
				ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
				final ItemMeta bootsMeta = boots.getItemMeta();
				bootsMeta.setDisplayName(ChatColor.GOLD + "Flame Boots");
				boots.setItemMeta(bootsMeta);
				boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
				boots.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
				ItemStack bow = new ItemStack(Material.BOW);
				final ItemMeta bowMeta = bow.getItemMeta();
				bowMeta.setDisplayName(ChatColor.GOLD + "Flame Bow");
				bow.setItemMeta(bowMeta);
				bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
				bow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
				if (clearInv = false) {
					player.getInventory().clear();
				}
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
		
		// Kits command
		if (args[0].equalsIgnoreCase("commands")) {
			Player player = (Player) sender;
			player.sendMessage(
					ChatColor.YELLOW + " ********************** " + 
					ChatColor.YELLOW + "|       Commands       |" +
					ChatColor.YELLOW + " ********************** " +
					ChatColor.AQUA + "/spawn" + ChatColor.GREEN + " - Sends you to spawn. \n" +
					ChatColor.AQUA + "/compass" + ChatColor.GREEN + " - Gives you a compass. \n" +
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
					ChatColor.AQUA + "/flame" + ChatColor.GREEN + " - Gives the flame kit. \n" + 
					ChatColor.AQUA + "/info" + ChatColor.GREEN + " - Plugin info. \n" +
					ChatColor.RED + "/clearinv" + ChatColor.BLUE + " - Sets clear inventory for kits to true or false. \n"
					);
		}
		
		// Network command
		if (args[0].equalsIgnoreCase("info")) {
			Player player = (Player) sender;
			player.sendMessage(
					ChatColor.YELLOW + " ********************** " + 
					ChatColor.YELLOW + "|     Plugin Info      |" +
					ChatColor.YELLOW + " ********************** " +
					ChatColor.GREEN + "\n  XPvP is a plugin created by Xp10d3, meant to be for the server Corelia. \n" +
					ChatColor.GREEN + "The plugin was originally command based, but you can also use the compass to access the kits. \n" +
					ChatColor.GREEN + "For more info, go to " + ChatColor.DARK_PURPLE + "https://dev.bukkit.org/projects/xpvp/."
					);
		}
		
		// Compass command I guess
		if (args[0].equalsIgnoreCase("compass")) {
			Player player = (Player) sender;
			if (clearInv = false) {
				player.getInventory().clear();
			}
			player.getInventory().addItem(new ItemStack(Material.COMPASS));
			player.sendMessage("Where did your compass go??? Well, here's a new one I guess...");
		}

		/*
		// Report command (helpful: https://bukkit.org/threads/multiple-command-arguments.49992/)
		if (args[0].equalsIgnoreCase("report")) {
			Player player = (Player) sender;
			if (args.length == 2) {
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if (target == null) {
					player.sendMessage(ChatColor.RED + "Couldn't find that player :/ Try again.");
				} else {
					target.sendMessage("You have been reported for:");
					target.sendMessage(args[2]);
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.isOp()) {
							p.sendMessage(target + " has been reported for " + args[2] + ".");
						}
					}
				}
			}
		}
		*/
		
		/*
		// Clear Inventory Command
		if (args[0].equalsIgnoreCase("true")) {
			Player player = (Player) sender;
			clearInv = true;
			player.sendMessage("Set clear inventory to false.");
		}
		
		if (args[0].equalsIgnoreCase("false")) {
			Player player = (Player) sender;
			clearInv = false;
			player.sendMessage("Set clear inventory to true.");
		}
		*/
		if (args[0].equalsIgnoreCase("clearinv")) {
			Player player = (Player) sender;
			player.getInventory().clear();
		}
		
		if (args[0].equalsIgnoreCase("kit") ) {
			Player player = (Player) sender;
			player.sendMessage(
					ChatColor.YELLOW + " ********************** " + 
					ChatColor.YELLOW + "|     Official Kits     |" +
					ChatColor.YELLOW + " ********************** " +
					ChatColor.WHITE + "\nTIER ONE: 0 Levels Required \n" +
					ChatColor.WHITE + "Guard \n" +
					ChatColor.WHITE + "Archer \n" +
					ChatColor.WHITE + "Sniper \n" +
					ChatColor.WHITE + " \n" +
					ChatColor.BLUE + "TIER TWO: 10 Levels Required\n" +
					ChatColor.BLUE + "Knight \n" +
					ChatColor.BLUE + "Magic Archer \n" +
					ChatColor.BLUE + "Crackshot \n" +
					ChatColor.BLUE + "Fisherman \n" +
					ChatColor.BLUE + " \n" +
					ChatColor.GOLD + "TIER THREE: 30 Levels Required \n" +
					ChatColor.GOLD + "Overlord \n" +
					ChatColor.GOLD + "Advanced Archer \n" +
					ChatColor.GOLD + "Scout \n" +
					ChatColor.GOLD + "Enderman \n" +
					ChatColor.GOLD + "Flame \n"
					);
		}
		
		return false;
	}
}
