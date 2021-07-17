package com.github.eighty88.hidenames;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class HideNames extends JavaPlugin {
    @Override
    public void onEnable() {
        for(Player player: getServer().getOnlinePlayers()) { player.setPlayerListName(""); }
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, () -> Bukkit.getServer().getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onJoin(PlayerJoinEvent e) { e.getPlayer().setPlayerListName(""); }

            @EventHandler
            public void onQuit(PlayerQuitEvent e) { e.getPlayer().setPlayerListName(e.getPlayer().getDisplayName()); }
        }, this), 20L);
    }

    @Override
    public void onDisable() {
        for(Player player: getServer().getOnlinePlayers()) { player.setPlayerListName(player.getDisplayName()); }
    }
}
