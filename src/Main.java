package aquatic.sxmuray.superfly;

import aquatic.sxmuray.superfly.Commands.External;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import aquatic.sxmuray.superfly.Commands.Superfly;
import aquatic.sxmuray.superfly.Events.Automatic;

import java.io.File;

public class Main extends JavaPlugin {
    public static Main instance;
    public String ruta;
    public String Aquatic;

    public static Main getInstance() {
        return instance;
    }

        public void onEnable() {
        instance = this;
        int pluginId = 14112;
        Metrics metrics = new Metrics(this, pluginId);
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&8")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&b[AS] &b&lSuperfly &7- &ePublic Plugin")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&8")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&fStatus: &aEnabled")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&fVersion: &e2.0.1")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&fCreator: &bSxmuray")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&8")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&fAll rights reserved by &b&lAquatic Studios")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&8")));
        registercommands();
        registerevents();
        loadconfig();
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&8")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&b[AS] &b&lSuperfly &7- &ePublic Plugin")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&8")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&fStatus: &cDisabled")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&fVersion: &e2.0.1")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&fCreator: &bSxmuray")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&8")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&fAll rights reserved by &b&lAquatic Studios")));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ("&8")));
    }

    public void registerevents() {
        Bukkit.getServer().getPluginManager().registerEvents(new Automatic(), this);
    }

    public void registercommands() {
        this.getCommand("fly").setExecutor(new Superfly());
        this.getCommand("superfly").setExecutor(new External());
    }

    public void loadconfig() {
        File config = new File(getDataFolder(), "config.yml");
        this.ruta = config.getPath();
        if (!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }
    }
}