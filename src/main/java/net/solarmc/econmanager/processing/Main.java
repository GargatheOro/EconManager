package net.solarmc.econmanager.processing;

import net.solarmc.econmanager.commands.BankCommand;
import net.solarmc.econmanager.commands.EconCommand;
import net.solarmc.econmanager.commands.PayCommand;
import net.solarmc.econmanager.commands.WalletCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static final String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Economy" + ChatColor.DARK_GRAY + "]";
    public static final String improperArgs = prefix + ChatColor.RED + " Check your arguments again. You are either missing or exceeding required components.";
    public static final String badArgs = prefix + ChatColor.RED + " Check your arguments again. One or more of your arguments has an error.";
    public static final String noPermission = prefix + ChatColor.RED + " You do not have permission to execute this command.";

    @Override
    public void onEnable() {
        getCommand("bank").setExecutor(new BankCommand());
        getCommand("econ").setExecutor(new EconCommand());
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("wallet").setExecutor(new WalletCommand());
    }

    public static boolean checkArgForDouble(String argument) {
        try {
            Double.parseDouble(argument);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public static void openChecking(Player accountHolder, double initialDeposit) {

        accountHolder.sendMessage(ChatColor.GREEN + " Your account has been created successfully.");
    }

    public static void openSavings(Player accountHolder, double initialDeposit) {

    }

    public static void getAccountInformation(Player target) {

    }

    public static void transferCheckingToSavings(double amount) {

    }

    public static void transferSavingsToChecking(double amount) {

    }

    public static void wireMoney(Player sender, Player recipient, double amount) {

    }

    public static void depositChecking(Player accountHolder, double amount) {

    }

    public static void depositSavings(Player accountHolder, double amount) {

    }

    public static void withdrawChecking(Player accountHolder, double amount) {

    }

    public static void withdrawSavings(Player accountHolder, double amount) {

    }
}