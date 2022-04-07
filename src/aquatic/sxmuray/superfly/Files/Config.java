package aquatic.sxmuray.superfly.Files;

import aquatic.sxmuray.superfly.Main;
import java.io.File;
import org.bukkit.configuration.ConfigurationOptions;
import org.bukkit.configuration.MemoryConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Config extends YamlConfiguration {
    private static Config Config;

    private final Plugin plugin;

    private final File configFile;

    public static Config getConfig() {
        if (Config == null)
            Config = new Config();
        return Config;
    }

    private Plugin P() {
        return (Plugin)Main.getInstance();
    }

    public Config() {
        this.plugin = P();
        this.configFile = new File(this.plugin.getDataFolder(), "config.yml");
        saveDefault();
        reload();
    }

    public void reload() {
        try {
            load(this.configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            save(this.configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveDefault() {
        this.plugin.saveResource("config.yml", false);
    }
}
