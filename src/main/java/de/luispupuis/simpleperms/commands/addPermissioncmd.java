package de.luispupuis.simpleperms.commands;

import de.luispupuis.simpleperms.permissions.PermManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class addPermissioncmd implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 2){
            Player p = (Player) Bukkit.getOfflinePlayer(args[0]).getPlayer();
            PermManager.addPermission(p, args[1]);
            sender.sendMessage("Hinzugefügt!");
        }
        return false;
    }
}
