package me.naif.plugincolors;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

public final class PluginColors extends JavaPlugin {
    @Override public void onEnable() {
        saveDefaultConfig();
        loadColors();
        getLogger().info("PluginColors v1.0.1 enabled.");
    }
    private void loadColors() {
        ConfigurationSection section = getConfig().getConfigurationSection("plugins");
        if (section == null) {
            getLogger().warning("No 'plugins' section found in config.yml.");
            return;
        }
        for (String pluginName : section.getKeys(false)) {
            String color = section.getString(pluginName + ".color", "&f");
            getLogger().info(pluginName + " -> " + color);
        }
    }
    public String color(String text) { return ChatColor.translateAlternateColorCodes('&', text); }
}
