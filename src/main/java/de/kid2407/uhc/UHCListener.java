package de.kid2407.uhc;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.world.WorldLoadEvent;

public class UHCListener implements Listener {

    @EventHandler
    public void onWorldLoaded(WorldLoadEvent worldLoadEvent) {
        if (!UHC.naturalRegenerationChecked) {
            UHC.logger.info("Checking for correct game rules");
            World world = worldLoadEvent.getWorld();
            String[] gameRules = worldLoadEvent.getWorld().getGameRules();
            for (String rule : gameRules) {
                if (rule.equals(GameRule.NATURAL_REGENERATION.getName()) && Boolean.TRUE.equals(world.getGameRuleValue(GameRule.NATURAL_REGENERATION))) {
                    UHC.logger.info("Changing gamerule naturalRegenration to false, since it is currently true.");
                    worldLoadEvent.getWorld().setGameRule(GameRule.NATURAL_REGENERATION, false);
                    UHC.logger.info("Successfully changed gamerule");
                    UHC.naturalRegenerationChecked = true;
                }
            }
            UHC.logger.info("Finished checking for correct game rules");
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent playerDeathEvent) {
        Bukkit.broadcast(new TextComponent(String.format("%s is no longer with us. R.I.P.", playerDeathEvent.getPlayer().displayName())));
    }
}
