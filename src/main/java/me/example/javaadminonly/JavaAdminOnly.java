package me.example.javaadminonly;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;
import org.geysermc.floodgate.api.FloodgateApi;

public class JavaAdminOnly extends JavaPlugin implements Listener {

    private final String allowedJavaUsername = "liger_123"; // Your Java admin username

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("JavaAdminOnly Plugin Enabled!");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();
        boolean isFloodgatePlayer = FloodgateApi.getInstance().isFloodgatePlayer(event.getPlayer().getUniqueId());

        if (!isFloodgatePlayer && !playerName.equalsIgnoreCase(allowedJavaUsername)) {
            event.getPlayer().kickPlayer("❌ Only Bedrock players are allowed. Java players are blocked.");
        }
    }
}
