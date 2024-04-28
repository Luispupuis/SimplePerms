package de.luispupuis.simpleperms;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import de.luispupuis.simpleperms.Listeners.LeavePacketListener;
import de.luispupuis.simpleperms.commands.addPermissioncmd;
import de.luispupuis.simpleperms.commands.hasPermission;
import de.luispupuis.simpleperms.commands.removePermissioncmd;
import de.luispupuis.simpleperms.permissions.PermissionJoiner;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimplePerms extends JavaPlugin {
    public static SimplePerms instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getCommand("addpermission").setExecutor(new addPermissioncmd());
        getCommand("removePermisssion").setExecutor(new removePermissioncmd());
        getCommand("hasperm").setExecutor(new hasPermission());
        Bukkit.getPluginManager().registerEvents(new PermissionJoiner(), this);
        ProtocolManager manager = ProtocolLibrary.getProtocolManager();
        manager.addPacketListener(new PacketAdapter(this, ListenerPriority.NORMAL, PacketType.Play.Server.KICK_DISCONNECT) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
                LeavePacketListener.call(event);
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SimplePerms getInstance() {
        return instance;
    }
}
