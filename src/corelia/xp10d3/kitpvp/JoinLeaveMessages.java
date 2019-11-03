package corelia.xp10d3.kitpvp;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.md_5.bungee.api.ChatColor;

public class JoinLeaveMessages implements Listener {
	@EventHandler
	void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		String playerName = player.getName();
		Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "Welcome to the server, " + playerName + "!");
		e.setJoinMessage(null);
	}
	@EventHandler
	void onQuit(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		String playerName = player.getName();
		Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + playerName + " has quit! See ya, " + playerName + "!");
		e.setQuitMessage(null);
	}
}
