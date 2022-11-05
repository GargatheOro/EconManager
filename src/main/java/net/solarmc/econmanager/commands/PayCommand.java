package net.solarmc.econmanager.commands;

import net.solarmc.econmanager.processing.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PayCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
        } else {
            System.out.println(Main.prefix + ChatColor.RED + " This command only operates when used by a player");
        }
        return false;
    }
}