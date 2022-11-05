package net.solarmc.econmanager.commands;

import net.solarmc.econmanager.processing.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EconCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length >= 1) {
                switch (args[0].toLowerCase()) {
                    case "mint": //Puts money into the economy

                        break;
                    case "unmint": //Pulls money from the economy

                        break;
                    case "stats": //Retrieves economic statistics such as GDP and GINI

                        break;
                    case "reload": //Reloads the plugin

                        break;
                    case "player": //Modifies player balance externally
                        if (args.length >= 2) {
                            switch (args[1].toLowerCase()) {
                                case "list": //Displays all players who have a balance, and ranks them by (bank balance, personal balance)
                                    System.out.println("S");
                                    break;
                                case "add":
                                    System.out.println("R");
                                    break;
                                case "remove":
                                    System.out.println("T");
                                    break;
                                default:
                            }
                        }
                        break;
                }
            }
        } else { //TERMINAL USAGE
            if (args.length >= 1) {
                switch (args[0].toLowerCase()) {
                    case "mint":
                    case "unmint":
                        System.out.println(Main.prefix + ChatColor.RED + " This command only operates when used by a player");
                        break;
                    case "stats": //Retrieves economic statistics such as GDP and GINI

                        break;
                    case "reload": //Reloads the plugin

                        break;
                    case "player": //Modifies player balance externally
                        if (args.length >= 2) {
                            switch (args[1].toLowerCase()) {
                                case "list": //Displays all players who have a balance, and ranks them by (bank balance, personal balance)
                                    System.out.println("S");
                                    break;
                                case "add":
                                    System.out.println("R");
                                    break;
                                case "remove":
                                    System.out.println("T");
                                    break;
                                default:
                            }
                        }
                        break;
                }
            }
        }
        return false;
    }
}
