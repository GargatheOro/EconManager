package net.solarmc.econmanager.objects;

import org.bukkit.entity.Player;

public class SavingsAccount extends Account {
    Player player;
    double balance;

    public SavingsAccount(Player player, double balance, int accountNumber, String password) {
        this.player = player;
        this.balance = balance;
    }
}