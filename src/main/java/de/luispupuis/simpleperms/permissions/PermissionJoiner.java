package de.luispupuis.simpleperms.permissions;

import de.luispupuis.simpleperms.SimplePerms;
import de.luispupuis.simpleperms.hasmap.Config;
import jdk.internal.jmod.JmodFile;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.util.Map;

public class PermissionJoiner implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = (Player) e.getPlayer();
        p.getEffectivePermissions().clear();
        File configFile = new File("permission.yml");
        Config config = new Config("permissions.yml", SimplePerms.getInstance().getDataFolder());
        ConfigurationSection configurationSection = config.toFileconfiguration().getConfigurationSection(p.getUniqueId().toString());
        if (configurationSection != null) {
            for (String permission : configurationSection.getKeys(false)) {
                Boolean b = (Boolean) configurationSection.get(permission);
                p.addAttachment(SimplePerms.getInstance(), permission, b);
            }
        }
    }
}
