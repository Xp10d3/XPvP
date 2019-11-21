package corelia.xp10d3.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

// Listeners class. Includes special events like player join messages, disabling item dropping, etc.

public class PlayerListeners implements Listener {
	
	boolean clearInv;
	
	// Disables Item Dropping.
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e){
        e.setCancelled(true);
        e.getPlayer().sendMessage(ChatColor.RED + "You can't drop items!");
	}
	
	// Custom player join messages.
	@EventHandler
	void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		String playerName = player.getName();
		player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.3f, 1.7f);
		Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "Welcome to the server, " + playerName + "!");
		e.setJoinMessage(null);
	}
	
	// Custom player quit messages.
	@EventHandler
	void onQuit(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		String playerName = player.getName();
		Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + playerName + " has left the server.");
		e.setQuitMessage(null);
	}
	
	// Disables fall damage.
	@EventHandler
	public void onFallDamage(EntityDamageEvent e) {
		Entity tookDamage = e.getEntity();
		
		DamageCause cause = e.getCause();
		
		if (cause == DamageCause.FALL) {
			e.setCancelled(true);
			System.out.print(tookDamage);
		}
	}
	
	// Check if player has joined before and gives them a compass.
	@EventHandler
	public void onJoinBefore(PlayerJoinEvent player) {
		Player p = player.getPlayer();
		
		boolean hasPlayed = p.hasPlayedBefore();
		
		if (!hasPlayed) {
			p.sendMessage(ChatColor.LIGHT_PURPLE + "Welcome to the server! To see kit commands, do /kits. You can also right click the compass. Hope you enjoy your stay :D");
			String playerName = p.getName();
			Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + playerName + "has joined for the first time!");
			p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 0.3f, 1.7f);
			p.getInventory().addItem(new ItemStack(Material.COMPASS));
		}
	}
	
	// Sends kill message.
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player k = p.getKiller();
		String killerName = k.getName();
		String playerName = p.getName();
		if (clearInv = false) {
			p.getInventory().clear();
		}
		p.getInventory().addItem(new ItemStack(Material.COMPASS));
		k.giveExp(10);
		p.sendMessage(ChatColor.RED + killerName + " has killed you!");
		k.sendMessage(ChatColor.GREEN + "You have killed " + playerName + "! You have gained 10 xp.");
	}
	
	// KitGUI method.
	public Inventory kitGUI(Player player) {
		final Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.DARK_RED + "Kits");
		final ItemStack guard = new ItemStack(Material.SHIELD);
		final ItemMeta guardMeta = guard.getItemMeta();
		final ItemStack knight = new ItemStack(Material.IRON_SWORD);
		final ItemMeta knightMeta = knight.getItemMeta();
		final ItemStack overlord = new ItemStack(Material.DIAMOND_CHESTPLATE);
		final ItemMeta overlordMeta = overlord.getItemMeta();
		final ItemStack archer = new ItemStack(Material.BOW);
		final ItemMeta archerMeta = archer.getItemMeta();
		final ItemStack magicarcher = new ItemStack(Material.CHAINMAIL_HELMET);
		final ItemMeta magicarcherMeta = magicarcher.getItemMeta();
		final ItemStack advancedarcher = new ItemStack(Material.ARROW);
		final ItemMeta advancedarcherMeta = advancedarcher.getItemMeta();
		final ItemStack sniper = new ItemStack(Material.CROSSBOW);
		final ItemMeta sniperMeta = sniper.getItemMeta();
		final ItemStack crackshot = new ItemStack(Material.LEATHER_HELMET);
		final ItemMeta crackshotMeta = crackshot.getItemMeta();
		final ItemStack scout = new ItemStack(Material.OAK_PLANKS);
		final ItemMeta scoutMeta = scout.getItemMeta();
		final ItemStack enderman = new ItemStack(Material.ENDER_PEARL);
		final ItemMeta endermanMeta = enderman.getItemMeta();
		final ItemStack fisherman = new ItemStack(Material.FISHING_ROD);
		final ItemMeta fishermanMeta = fisherman.getItemMeta();
		final ItemStack flame = new ItemStack(Material.FIRE_CHARGE);
		final ItemMeta flameMeta = flame.getItemMeta();
		
		guardMeta.setDisplayName(ChatColor.WHITE + "Guard");
		guard.setItemMeta(guardMeta);
		knightMeta.setDisplayName(ChatColor.BLUE + "Knight");
		knight.setItemMeta(knightMeta);
		overlordMeta.setDisplayName(ChatColor.GOLD + "Overlord");
		overlord.setItemMeta(overlordMeta);
		archerMeta.setDisplayName(ChatColor.WHITE + "Archer");
		archer.setItemMeta(archerMeta);
		magicarcherMeta.setDisplayName(ChatColor.BLUE + "Magic Archer");
		magicarcher.setItemMeta(magicarcherMeta);
		advancedarcherMeta.setDisplayName(ChatColor.GOLD + "Advanced Archer");
		advancedarcher.setItemMeta(advancedarcherMeta);
		sniperMeta.setDisplayName(ChatColor.WHITE + "Sniper");
		sniper.setItemMeta(sniperMeta);
		crackshotMeta.setDisplayName(ChatColor.BLUE + "Crackshot");
		crackshot.setItemMeta(crackshotMeta);
		scoutMeta.setDisplayName(ChatColor.GOLD + "Scout");
		scout.setItemMeta(scoutMeta);
		fishermanMeta.setDisplayName(ChatColor.BLUE + "Fisherman");
		fisherman.setItemMeta(fishermanMeta);
		endermanMeta.setDisplayName(ChatColor.GOLD + "Enderman");
		enderman.setItemMeta(endermanMeta);
		flameMeta.setDisplayName(ChatColor.GOLD + "Flame");
		flame.setItemMeta(flameMeta);
		
		inventory.setItem(0, guard);
		inventory.setItem(9, knight);
		inventory.setItem(18, overlord);
		inventory.setItem(2, archer);
		inventory.setItem(11, magicarcher);
		inventory.setItem(20, advancedarcher);
		inventory.setItem(4, sniper);
		inventory.setItem(13, crackshot);
		inventory.setItem(22, scout);
		inventory.setItem(8, fisherman);
		inventory.setItem(17, enderman);
		inventory.setItem(26, flame);
		return inventory;
	}
	
	// GUI Handler using InventoryClickEvent.
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		if ((event.getCurrentItem().getType() == Material.SHIELD)) {
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
			player.closeInventory();
		} else if ((event.getCurrentItem().getType() == Material.IRON_SWORD)) {
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
				player.closeInventory();
			} else {
				player.closeInventory();
				player.sendMessage("You don't have enough experience! Required experience level: 10.");
			}
		} else if ((event.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE)) {
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
				player.closeInventory();
			} else {
				player.closeInventory();
				player.sendMessage("You don't have enough experience! Required experience level: 30.");
			}
		} else if ((event.getCurrentItem().getType() == Material.BOW)) {
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
			player.closeInventory();
		} else if ((event.getCurrentItem().getType() == Material.CHAINMAIL_HELMET)) {
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
				player.closeInventory();
			} else {
				player.closeInventory();
				player.sendMessage("You don't have enough experience! Required experience level: 10.");
			}
		} else if ((event.getCurrentItem().getType() == Material.ARROW)) {
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
				player.closeInventory();
			} else {
				player.closeInventory();
				player.sendMessage("You don't have enough experience! Required experience level: 30.");
			}
		} else if ((event.getCurrentItem().getType() == Material.CROSSBOW)) {
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
			player.closeInventory();
		} else if ((event.getCurrentItem().getType() == Material.LEATHER_HELMET)) {
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
				player.closeInventory();
			} else {
				player.closeInventory();
				player.sendMessage("You don't have enough experience! Required experience level: 10.");
			}
		} else if ((event.getCurrentItem().getType() == Material.OAK_PLANKS)) {
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
				player.closeInventory();
			} else {
				player.closeInventory();
				player.sendMessage("You don't have enough experience! Required experience level: 30.");
			}
		} else if ((event.getCurrentItem().getType() == Material.ENDER_PEARL)) {
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
				player.closeInventory();
			} else {
				player.closeInventory();
				player.sendMessage("You don't have enough experience! Required experience level: 30.");
			}
		} else if ((event.getCurrentItem().getType() == Material.FISHING_ROD)) {
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
				player.closeInventory();
			} else {
				player.closeInventory();
				player.sendMessage("You don't have enough experience! Required experience level: 10.");
			}
		} else if ((event.getCurrentItem().getType() == Material.FIRE_CHARGE)) {
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
				player.closeInventory();
			} else {
				player.closeInventory();
				player.sendMessage("You don't have enough experience! Required experience level: 30.");
			}
		}
	}
	
	// KitGUI right click compass event.
	@EventHandler
	public void onRightClickCompass(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (event.getItem() != null && event.getItem().getType() == Material.COMPASS && (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR))) {
			player.openInventory(kitGUI(player));
		}
	}
}