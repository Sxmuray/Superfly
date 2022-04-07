package aquatic.sxmuray.superfly.Commands;

import aquatic.sxmuray.superfly.Files.Config;
import aquatic.sxmuray.superfly.Main;
import aquatic.sxmuray.superfly.Tools.Sounds;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class External implements CommandExecutor {

    private Main plugin;

    public External(Main plugin) {
        this.plugin = plugin;

    }

    public External() {

    }

        public boolean onCommand(CommandSender sender, Command command, String Label, String[] args) {
            if (!(sender instanceof Player)) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&b[Superfly] &cError this command cannot be executed in console.")));
                return true;
            }
            Player p = (Player) sender;
            if (args.length == 0) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lSuperfly &fversion (2.0.1) Created by Sxmuray &7(Aquatic Studios)"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                return true;

            }

        if (args[0].equalsIgnoreCase("help")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&r                   &b&lSuperfly &7- &fCommands"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b/superfly &7- &fInformative command about the plugin"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b/superfly &ehelp &7- &fOpen this help message"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b/superfly &ereload &7- &fReload config file of the plugin"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&r  &fVersion: &e2.0.1 &7| &fAll rights reserved by &b&lAquatic Studios"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
            return true;

        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (p.hasPermission("superfly.reload") || p.hasPermission("superfly.*")) {
                Config.getConfig().reload();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("Message.Reload").replace("%prefix%", Config.getConfig().getString("Modules.Prefix"))));
                return true;
            }

            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("Message.NoPermission").replace("%prefix%", Config.getConfig().getString("Modules.Prefix"))));

        } else {

            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.getConfig().getString("Message.Error").replace("%prefix%", Config.getConfig().getString("Modules.Prefix"))));

        }
        return false;
    }
}