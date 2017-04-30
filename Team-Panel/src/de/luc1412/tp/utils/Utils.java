package de.luc1412.tp.utils;

import de.luc1412.tp.TeamPanel;
import org.bukkit.Bukkit;

/**
 * Created by Luc1412 on 29.04.2017 at 23:16
 */
public class Utils {

    private boolean protocolLib;

    public Utils (){
        protocolLib = false;
    }

    public void sendError(String error){
        Bukkit.broadcastMessage(TeamPanel.getPrefix() + "§4ERROR: " + error + " SHUTDOWN SERVER!");
        Bukkit.getConsoleSender().sendMessage(TeamPanel.getPrefix() + "§4ERROR: " + error + " SHUTDOWN SERVER!");
        Bukkit.getServer().shutdown();
    }

    public void checkForProtocolLib(){
        if(TeamPanel.getInstance().getServer().getPluginManager().getPlugin("ProtocolLib") == null){
            Bukkit.getConsoleSender().sendMessage(TeamPanel.getPrefix() + "§4ProtocolLib was not found. Version will not override");
        } else {
            Bukkit.getConsoleSender().sendMessage(TeamPanel.getPrefix() + "§2ProtocolLib was not found. Version will override");
            protocolLib = true;
        }

    }

    public boolean getprotocolLib(){
        return protocolLib;
    }
}
