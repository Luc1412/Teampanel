package de.luc1412.tp;

import de.luc1412.tp.commands.CMDTeamPanel;
import de.luc1412.tp.config.MessagesConfig;
import de.luc1412.tp.config.SettingsConfig;
import de.luc1412.tp.inventorys.Menu;
import de.luc1412.tp.utils.ItemCreator;
import de.luc1412.tp.utils.MaintenanceManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

/**
 * Created by Luc1412 on 12.04.2017.
 */
public class TeamPanel extends JavaPlugin {

    private static TeamPanel instance;
    private static ItemCreator itemCreator;
    private static MessagesConfig messagesConfig;
    private static SettingsConfig settingsConfig;
    private static final String prefix = "§8|§1Team§8-§4Panel§8| §3->§r ";

    @Override
    public void onLoad() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage(getPrefix() + "§2The Plugin was successfully loaded!");
    }

    @Override
    public void onEnable() {
        itemCreator = new ItemCreator();
        messagesConfig = new MessagesConfig();


        saveDefaultConfig();
        try {
            messagesConfig.createConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }

            settingsConfig.createConfig();


        init();

        Bukkit.getConsoleSender().sendMessage("§9|§7~~~~~~~~~~~~~~~~~~~~~§1Team§8-§4Panel§7~~~~~~~~~~~~~~~~~~~~~§9|\n" +
                "                 §9|§1Team§8-§4Panel §e1.0 §aBY LUC1412 WAS SUCCESSFULLY ENABLED! §9|\n" +
                "                 §9|§4ALL RIGHTS RESERVED BY LUC1412!                     §9|\n" +
                "                 §9|§4YOU ARE NOT ALLOWED TO DECOMPILE THIS PLUGIN!       §9|\n" +
                "                 §9|§7~~~~~~~~~~~~~~~~~~~~~§1Team§8-§4Panel§7~~~~~~~~~~~~~~~~~~~~~§9|");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(getPrefix() + "§2The Plugin was successfully disabled!");

    }

    private void init(){
        this.getCommand("teampanel").setExecutor(new CMDTeamPanel());

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Menu(), this);
        pm.registerEvents(new MaintenanceManager(), this);
    }

    public static TeamPanel getInstance() {
        return instance;
    }

    public static ItemCreator getItemCreator() {
        return itemCreator;
    }

    public static MessagesConfig getMessagesConfig() {
        return messagesConfig;
    }

    public static SettingsConfig getSettingsConfig() {
        return settingsConfig;
    }

    public static String getPrefix() {
        return prefix;
    }
}
