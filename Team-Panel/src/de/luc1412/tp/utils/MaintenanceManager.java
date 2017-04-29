package de.luc1412.tp.utils;

import de.luc1412.tp.TeamPanel;
import de.luc1412.tp.config.Messages;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.server.ServerListPingEvent;

/**
 * Created by Luc1412 on 21.04.2017.
 */
public class MaintenanceManager implements Listener{

    public void toggleMaintenance(){
        if(TeamPanel.getSettingsConfig().getBoolean()){
            TeamPanel.getSettingsConfig().setBoolean(false);
        } else {
            TeamPanel.getSettingsConfig().setBoolean(false);
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

}
