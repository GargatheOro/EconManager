package net.solarmc.econmanager.commands;

import net.solarmc.econmanager.processing.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BankCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length >= 1) {
                switch (args[0].toLowerCase()) {
                    case "open": //Opens a new bank account -- /bank open accountType initialDeposit player
                        if (player.hasPermission("econ.bank.open") || player.hasPermission("econ.bank.teller")) {
                            if (args.length == 4 && Main.checkArgForDouble(args[2])) {
                                double amount = Double.parseDouble(args[2]);
                                Player target = Bukkit.getPlayer(args[3]);
                                if ((target != null)) {
                                    if (args[1].equalsIgnoreCase("checking")) {
                                        Main.openChecking(target, amount);
                                    } else if (args[1].equalsIgnoreCase("savings")) {
                                        Main.openSavings(target, amount);
                                    } else {
                                        player.sendMessage(Main.prefix + ChatColor.RED + " Please specify a bank account type (checking or savings).");
                                    }
                                } else {
                                    player.sendMessage(Main.badArgs);
                                }
                            } else {
                                player.sendMessage(Main.improperArgs);
                            }
                        } else {
                            player.sendMessage(Main.prefix + ChatColor.RED + " You must use a teller at the bank to open an account.");
                        }
                        break;
                    case "deposit": //Deposits money from a wallet into a bank account -- /bank deposit accountType amount player
                        if (player.hasPermission("econ.bank.deposit") || player.hasPermission("econ.bank.teller")) {
                            if (args.length == 4 && Main.checkArgForDouble(args[2])) {
                                double amount = Double.parseDouble(args[2]);
                                Player target = Bukkit.getPlayer(args[3]);
                                if (target != null) {
                                    if (args[1].equalsIgnoreCase("checking")) {
                                        Main.depositChecking(target, amount);
                                    } else if (args[1].equalsIgnoreCase("savings")) {
                                        Main.depositSavings(target, amount);
                                    } else {
                                        player.sendMessage(Main.prefix + ChatColor.RED + " Please specify a bank account type (checking or savings).");
                                    }
                                } else {
                                    player.sendMessage(Main.badArgs);
                                }
                            } else {
                                player.sendMessage(Main.improperArgs);
                            }
                        } else {
                            player.sendMessage(Main.prefix + ChatColor.RED + " You must use a teller at the bank to deposit funds.");
                        }
                        break;
                    case "withdraw": //Withdraws money from a bank account to a wallet -- /bank withdraw accountType amount player
                        if (player.hasPermission("econ.bank.withdraw") || player.hasPermission("econ.bank.teller")) {
                            if (args.length == 4 && Main.checkArgForDouble(args[2])) {
                                double amount = Double.parseDouble(args[2]);
                                Player target = Bukkit.getPlayer(args[3]);
                                if (target != null) {
                                    if (args[1].equalsIgnoreCase("checking")) {
                                        Main.withdrawChecking(target, amount);
                                    } else if (args[1].equalsIgnoreCase("savings")) {
                                        Main.withdrawSavings(target, amount);
                                    } else {
                                        player.sendMessage(Main.prefix + ChatColor.RED + " Please specify a bank account type (checking or savings).");
                                    }
                                } else {
                                    player.sendMessage(Main.badArgs);
                                }
                            } else {
                                player.sendMessage(Main.improperArgs);
                            }
                        } else {
                            player.sendMessage(Main.prefix + ChatColor.RED + " You must use a teller at the bank to deposit funds.");
                        }
                        break;
                    case "transfer": //Transfers money from one's bank account to their other -- /bank transfer outputAccount amount
                        if (args.length == 3 && Main.checkArgForDouble(args[2])) {
                            double amount = Double.parseDouble(args[2]);
                            if (player.hasPermission("econ.bank.transfer") || player.hasPermission("econ.bank.teller")) {
                                if (args[1].equalsIgnoreCase("checking")) {
                                    Main.transferSavingsToChecking(amount);
                                } else if (args[1].equalsIgnoreCase("savings")) {
                                    Main.transferCheckingToSavings(amount);
                                }
                            }
                        }
                        break;
                    case "player": //Admin banking root
                        if (args.length >= 2 && player.hasPermission("econ.bank.player")) {
                            Player target = Bukkit.getPlayer(args[2]);
                            switch (args[1].toLowerCase()) {
                                case "clearfunds": //Sets all of a player's accounts to 0 (if positive)
                                    if (args.length == 3 && (target != null)) {

                                    } else {
                                        player.sendMessage(Main.badArgs);
                                    }
                                    break;
                                case "addfunds": //Adds funds to a given player's given account (can include wallet)
                                    System.out.println("R");
                                    break;
                                case "removefunds": //Removes funds to a given player's given account (can include wallet)
                                    System.out.println("T");
                                    break;
                                case "display": //Displays a given player's balance in all three accounts, if applicable
                                    System.out.println("W");
                                    break;
                                default:
                                    player.sendMessage(Main.badArgs);
                            }
                        } else {
                            player.sendMessage(Main.improperArgs + ChatColor.GRAY + " OR" + ChatColor.RED + " You do not have permission to execute this command.");
                        }
                        break;
                    case "wire": //Wires money from a checking account to another user's checking account -- /bank wire sender amount recipient
                        if (args.length == 4 && Main.checkArgForDouble(args[2])) {
                            double amount = Double.parseDouble(args[2]);
                            if (player.hasPermission("econ.bank.wire")) {
                                Player target = Bukkit.getPlayer(args[3]);
                                if (target != null) {
                                    Main.wireMoney(player, target, amount);
                                } else {
                                    player.sendMessage(Main.badArgs);
                                }
                            } else {
                                player.sendMessage(Main.noPermission);
                            }
                        } else {
                            player.sendMessage(Main.improperArgs);
                        }
                        break;
                    case "info": //Retrieves account information about a player -- /bank info [player if applicable]
                        if (args.length == 2 && player.hasPermission("econ.bank.info.others")) {
                            Player target = Bukkit.getPlayer(args[1]);
                            if ((target != null)) {
                                Main.getAccountInformation(target);
                            } else {
                                player.sendMessage(Main.badArgs);
                            }
                        } else if (args.length == 1) {
                            Main.getAccountInformation(player);
                        } else {
                            player.sendMessage(Main.badArgs);
                        }
                        break;
                    default:
                        player.sendMessage(Main.badArgs);
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
                                case "give":
                                    System.out.println("R");
                                    break;
                                case "take":
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