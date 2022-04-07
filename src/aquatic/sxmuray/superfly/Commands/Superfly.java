package aquatic.sxmuray.superfly.Commands;

import aquatic.sxmuray.superfly.Files.Config;
import aquatic.sxmuray.superfly.Tools.Sounds;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import aquatic.sxmuray.superfly.Main;

import java.util.ArrayList;

public class Superfly implements CommandExecutor {
    public static ArrayList<String> flytoggle = new ArrayList<String>();

    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        Player p = (Player) sender;

        if (sender instanceof ConsoleCommandSender) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&b[Superfly] &cError this command cannot be executed in console.")));
        }

        if (p.hasPermission("superfly.command") || p.hasPermission("superfly.*")) {
            if (flytoggle.contains(p.getName())) {

                p.setAllowFlight(false);
                p.setFlying(false);
                flytoggle.remove(p.getName());
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("Message.Disabled").replace("%prefix%", Config.getConfig().getString("Modules.Prefix"))));
                if (Config.getConfig().getBoolean("Superfly.Disabled.Active")) {
                    p.sendTitle(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("Superfly.Disabled.Title")), ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("Superfly.Disabled.Subtitle")));
                }


            } else {

                Location location = p.getLocation();
                location.setX(location.getBlockX());
                location.setY(location.getBlockY() + Config.getConfig().getInt("Modules.Levitation"));
                location.setZ(location.getBlockZ());

                p.setAllowFlight(true);
                flytoggle.add(p.getName());
                p.setFlying(true);
                p.teleport(location);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("Message.Enabled").replace("%prefix%", Config.getConfig().getString("Modules.Prefix"))));
                if (Config.getConfig().getBoolean("Superfly.Enabled.Active")) {
                    p.sendTitle(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("Superfly.Enabled.Title")), ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("Superfly.Enabled.Subtitle")));
                    Sounds.APISounds(p, Config.getConfig().getString("Superfly.Enabled.Sound"));
                }

            }

        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("Message.Permission").replace("%prefix%", Config.getConfig().getString("Modules.Prefix"))));
            if (Config.getConfig().getBoolean("Superfly.Permission.Active")) {
                p.sendTitle(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("Superfly.Permission.Title")), ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("Superfly.Permission.Subtitle")));
                Sounds.APISounds(p, Config.getConfig().getString("Superfly.Permission.Sound"));
                return true;
            }
        }
        return false;
    }
}