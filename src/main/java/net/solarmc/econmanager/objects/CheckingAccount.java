package net.solarmc.econmanager.objects;

import org.bukkit.entity.Player;

public class CheckingAccount extends Account {
    Player player;
    double balance;
    int accountNumber;
    String password;

    public CheckingAccount(Player player, double balance, int accountNumber, String password) {
        this.player = player;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.password = password;
    }
}