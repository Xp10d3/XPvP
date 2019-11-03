package corelia.xp10d3.kitpvp;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnDeath implements Listener {
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		Player k = p.getKiller();
		String killerName = k.getName();
		String playerName = p.getName();
		k.giveExp(10);
		p.sendMessage(killerName + " has killed you!");
		k.sendMessage("You have killed " + playerName + "! You have gained 10 xp.");
	}
}