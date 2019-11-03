package corelia.xp10d3.kitpvp;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class FallDamage implements Listener {
	@EventHandler
	public void onFallDamage(EntityDamageEvent e) {
		Entity tookDamage = e.getEntity();
		
		DamageCause cause = e.getCause();
		
		if (cause == DamageCause.FALL) {
			e.setCancelled(true);
			System.out.print(tookDamage);
		}
	}
}
