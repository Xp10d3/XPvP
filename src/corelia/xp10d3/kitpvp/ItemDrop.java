package corelia.xp10d3.kitpvp;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDrop implements Listener {
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e){
        e.setCancelled(true);
        e.getPlayer().sendMessage(ChatColor.RED + "You can't drop items!");
	}
}
