package de.luispupuis.simpleperms.permissions;

import de.luispupuis.simpleperms.SimplePerms;
import de.luispupuis.simpleperms.hasmap.Config;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;

import java.io.File;

public class PermManager {
    public static void addPermission(Player p, String permission){
        if(!p.hasPermission(permission)) {
            updatemap(permission, true, p);
            p.addAttachment(SimplePerms.getInstance(), permission, true);
        }
    }



    public static void removePermission(Player p, String permission){
        if (p.hasPermission(permission)) {
            for (PermissionAttachmentInfo attachmentInfo : p.getEffectivePermissions()) {
                if (attachmentInfo.getPermission().equalsIgnoreCase(permission)) {
                    PermissionAttachment attachment = attachmentInfo.getAttachment();
                    p.removeAttachment(attachment);
                    break;
                }
            }
        }
    }
    private static void updatemap(String permission, boolean b, Player p) {
        Config config = new Config("permissions.yml", SimplePerms.getInstance().getDataFolder());
        config.set(p.getUniqueId().toString() + "." + permission, b);
        config.save();
    }

}
