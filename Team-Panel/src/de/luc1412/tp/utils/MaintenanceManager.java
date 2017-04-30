package de.luc1412.tp.utils;

import com.comphenix.protocol.wrappers.WrappedServerPing;
import de.luc1412.tp.TeamPanel;
import de.luc1412.tp.config.Messages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.server.ServerListPingEvent;

import java.io.File;

/**
 * Created by Luc1412 on 21.04.2017.
 */
public class MaintenanceManager implements Listener{

    public void toggleMaintenance(){
        if(TeamPanel.getSettingsConfig().getBoolean()){
            TeamPanel.getSettingsConfig().setBoolean(false);
        } else {
            TeamPanel.getSettingsConfig().setBoolean(true);
            Bukkit.broadcastMessage("");
            Bukkit.getScheduler().scheduleSyncDelayedTask(TeamPanel.getInstance(), () -> {
                for(Player all: Bukkit.getOnlinePlayers()){
                    if(!all.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Maintenance.Bypass"))){
                        all.kickPlayer(TeamPanel.getMessagesConfig().getString(Messages.MAINTENANCESETTINGSKICKMSG));
                    }
                }
            }, TeamPanel.getInstance().getConfig().getInt("MaintenanceTime") * 20);
        }
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        if(TeamPanel.getSettingsConfig().getBoolean()) {
            if(!e.getPlayer().hasPermission(TeamPanel.getInstance().getConfig().getString("Maintenance.ByPass"))){
                e.setKickMessage(TeamPanel.getMessagesConfig().getString(Messages.MAINTENANCESETTINGSKICKMSG));
                e.setResult(PlayerLoginEvent.Result.KICK_OTHER);
            }
        }
    }

    @EventHandler
    public void onServerPing(ServerListPingEvent e){
        if(TeamPanel.getSettingsConfig().getBoolean()){
            if(TeamPanel.getInstance().getConfig().getInt("MaintenanceIcon") == 1) {
                try {
                    e.setServerIcon(Bukkit.loadServerIcon(new File(TeamPanel.getInstance().getDataFolder().toString() + File.separator + "maintenance-icon.png")));
                } catch (Exception e1) {
                    TeamPanel.getUtils().sendError("CAN´T FIND THE \"maintenance-icon.png\" FILE!");
                    Bukkit.broadcastMessage(TeamPanel.getPrefix() + "§4ERROR: CAN´T FIND THE \"maintenance-icon.png\" FILE! SHUTDOWN SERVER!");
                    Bukkit.getConsoleSender().sendMessage(TeamPanel.getPrefix() + "§4ERROR: CAN´T FIND THE \"maintenance-icon.png\" FILE! SHUTDOWN SERVER!");
                    Bukkit.getServer().shutdown();
                }
            } else e.setServerIcon(Bukkit.getServerIcon());
        }
    }

    public void onWrappedServerPing(WrappedServerPing e){
        if(TeamPanel.getUtils().getprotocolLib()) {
            if (TeamPanel.getSettingsConfig().getBoolean()) {
                e.setMotD(TeamPanel.getMessagesConfig().getString(Messages.MAINTENANCESETTINGSMOTD));
                e.setVersionProtocol(-1);
                e.setVersionName(TeamPanel.getMessagesConfig().getString(Messages.MAINTENANCESETTINGSVERSION));
                e.setPlayersMaximum(1);
                e.setPlayersOnline(1);
            }
        }
    }

}
