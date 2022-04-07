package aquatic.sxmuray.superfly.Events;

import aquatic.sxmuray.superfly.Files.Config;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Automatic implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if (p.hasPermission("superfly.automatic")) {
            Location location = p.getLocation();
            location.setX(location.getBlockX());
            location.setY(location.getBlockY() + Config.getConfig().getInt("Modules.Levitation"));
            location.setZ(location.getBlockZ());

            p.teleport(location);
            p.setAllowFlight(true);
            p.setFlying(true);
        }
    }
}
