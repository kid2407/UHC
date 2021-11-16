package de.kid2407.uhc;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class UHC extends JavaPlugin {

    public static UHC    instance;
    public static Logger logger;
    public static boolean naturalRegenerationChecked = false;

    @Override
    public void onEnable() {
        instance = this;
        logger = getLogger();
        logger.info("Registering Handler");
        getServer().getPluginManager().registerEvents(new UHCListener(), this);
        logger.info("Registered Handler");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
