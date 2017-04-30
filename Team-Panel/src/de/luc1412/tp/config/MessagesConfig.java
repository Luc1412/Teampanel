package de.luc1412.tp.config;

import de.luc1412.tp.TeamPanel;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by Luc1412 on 17.04.2017.
 */
public class MessagesConfig {

    private File file = new File(TeamPanel.getInstance().getDataFolder() + "//messages.yml");
    private YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);


    public void createConfig() throws IOException {
        if(!file.exists()){
            file.createNewFile();

            cfg.set("NoPermissions", "&4You dont´t have Permissions to perform this Command!");
            cfg.set("Close-Button", "&c&lClose");

            /*
            Gamemode-Settings
            */
            cfg.set("GamemodeSettings.MainItem", "&1Gamemode&8-&4Settings");
            cfg.set("GamemodeSettings.Item.0", "&1Gamemode&40");
            cfg.set("GamemodeSettings.Item.1", "&1Gamemode&41");
            cfg.set("GamemodeSettings.Item.2", "&1Gamemode&42");
            cfg.set("GamemodeSettings.Item.3", "&1Gamemode&43");
            cfg.set("GamemodeSettings.Message.0", "&2Gamemode set to &6&lSurvival");
            cfg.set("GamemodeSettings.Message.1", "&2Gamemode set to &6&lCreative");
            cfg.set("GamemodeSettings.Message.2", "&2Gamemode set to &6&lAdventure");
            cfg.set("GamemodeSettings.Message.3", "&2Gamemode set to &6&lSpectator");

            /*
            Server-Settings
             */
            cfg.set("ServerSettings.MainItem", "&1Server&8-&4Settings");
            cfg.set("ServerSettings.Item.Stop", "&1Stop&8-&4Server");
            cfg.set("ServerSettings.Item.Reload", "&1Reload&8-&4Server");
            cfg.set("ServerSettings.Item.Restart", "&1Restart&8-&4Server");
            cfg.set("ServerSettings.Message.Stop", "&2The Server will be &6&lStopped§r§8...");
            cfg.set("ServerSettings.Message.Reload", "&2The Server will be &6&lReloaded§r§8...");
            cfg.set("ServerSettings.Message.Restart", "&2The Server will be &6&lRestarted§r§8...");

            /*
            Player-Settings
             */
            cfg.set("PlayerSettings.MainItem", "&1Player&8-&4Settings");
            cfg.set("PlayerSettings.Item.Fly", "&1Fly&8-&4Toggle");
            cfg.set("PlayerSettings.Item.Heal", "&1Heal&8-&4Player");
            cfg.set("PlayerSettings.Item.Ban", "&1Ban&8-&4Player");
            cfg.set("PlayerSettings.Item.Kill", "&1Kill&8-&4Player");
            cfg.set("PlayerSettings.Item.Chat", "&1Chat&8-&4Clear");
            cfg.set("PlayerSettings.Item.Kick", "&1Kick&8-&4Player");
            cfg.set("PlayerSettings.Item.Inventory", "&1Inventory&8-&4Clear");
            cfg.set("PlayerSettings.Item.BanIp", "&1Ban-Ip&8-&4Player");
            cfg.set("PlayerSettings.Item.Vanish", "&1Vanish&8-&4Toggle");
            cfg.set("PlayerSettings.Message.Fly.On", "&2Flying &6&lenabled");
            cfg.set("PlayerSettings.Message.Fly.Off", "&2Flying &6&ldisabled");
            cfg.set("PlayerSettings.Message.Heal", "&2Your &6&lHealth &r&2and your &6&lHunger &r&2have been restored!");
            cfg.set("PlayerSettings.Message.Ban", " ");
            cfg.set("PlayerSettings.Message.Kill", " ");
            cfg.set("PlayerSettings.Message.Chat", "&2The Chat was cleared by an &6&lTeam Member&r&2!");
            cfg.set("PlayerSettings.Message.Kick", " ");
            cfg.set("PlayerSettings.Message.Inventory", " ");
            cfg.set("PlayerSettings.Message.BanIp", " ");
            cfg.set("PlayerSettings.Message.Vanish.On", "&2Vanish &6&lenabled");
            cfg.set("PlayerSettings.Message.Vanish.Off", "&2Vanish &6&ldisabled");

            /*
            World-Settings
             */
            cfg.set("WorldSettings.MainItem", "&1World&8-&4Settings");
            cfg.set("WorldSettings.Time", "&1Time&8-&4Settings");
            cfg.set("WorldSettings.Weather", "&1Weather&8-&4Settings");
            cfg.set("WorldSettings.Mobs", "&1Mob&8-&4Settings");

            /*
            Maintenance-Settings
             */
            cfg.set("MaintenanceSettings.MainItem", "&1Maintenance&8-&4Settings");
            cfg.set("MaintenanceSettings.Motd", "&4The Server is Currently in Maintenance");
            cfg.set("MaintenanceSettings.KickMessage", "&4The Server is Currently in Maintenance. Please try it later again.");
            cfg.set("MaintenanceSettings.VersionName", "Maintenance");

            cfg.save(file);
        }
    }

    public String getString(Messages messages){
        if(messages.equals(Messages.NOPERMISSION)){
            return TeamPanel.getPrefix() + cfg.getString("NoPermissions").replaceAll("&", "§");
        } else if(messages.equals(Messages.CLOSE)){
            return cfg.getString("Close-Button").replaceAll("&", "§");
        }

        /*
        Gamemode-Settings
         */
        else if(messages.equals(Messages.GAMEMODESETTINGS)){
            return cfg.getString("GamemodeSettings.MainItem").replaceAll("&", "§");
        }else if(messages.equals(Messages.GAMEMODESETTINGSITEM0)){
            return cfg.getString("GamemodeSettings.Item.0").replaceAll("&", "§");
        } else if(messages.equals(Messages.GAMEMODESETTINGSITEM1)){
            return cfg.getString("GamemodeSettings.Item.1").replaceAll("&", "§");
        } else if(messages.equals(Messages.GAMEMODESETTINGSITEM2)){
            return cfg.getString("GamemodeSettings.Item.2").replaceAll("&", "§");
        } else if(messages.equals(Messages.GAMEMODESETTINGSITEM3)){
            return cfg.getString("GamemodeSettings.Item.3").replaceAll("&", "§");
        } else if(messages.equals(Messages.GAMEMODESETTINGSMESSAGE0)){
            return TeamPanel.getPrefix() + cfg.getString("GamemodeSettings.Message.0").replaceAll("&", "§");
        } else if(messages.equals(Messages.GAMEMODESETTINGSMESSAGE1)){
            return TeamPanel.getPrefix() + cfg.getString("GamemodeSettings.Message.1").replaceAll("&", "§");
        } else if(messages.equals(Messages.GAMEMODESETTINGSMESSAGE2)){
            return TeamPanel.getPrefix() + cfg.getString("GamemodeSettings.Message.2").replaceAll("&", "§");
        } else if(messages.equals(Messages.GAMEMODESETTINGSMESSAGE3)){
            return TeamPanel.getPrefix() + cfg.getString("GamemodeSettings.Message.3").replaceAll("&", "§");
        }

        /*
        Server-Settings
         */
        else if(messages.equals(Messages.SERVERSETTINGS)){
            return cfg.getString("ServerSettings.MainItem").replaceAll("&", "§");
        } else if(messages.equals(Messages.SERVERSETTINGSITEMSTOP)){
            return cfg.getString("ServerSettings.Item.Stop").replaceAll("&", "§");
        } else if(messages.equals(Messages.SERVERSETTINGSITEMRELOAD)){
            return cfg.getString("ServerSettings.Item.Reload").replaceAll("&", "§");
        } else if(messages.equals(Messages.SERVERSETTINGSITEMRESTART)){
            return cfg.getString("ServerSettings.Item.Restart").replaceAll("&", "§");
        } else if(messages.equals(Messages.SERVERSETTINGSMESSAGESTOP)){
            return TeamPanel.getPrefix() + cfg.getString("ServerSettings.Message.Stop").replaceAll("&", "§");
        } else if(messages.equals(Messages.SERVERSETTINGSMESSAGERELOAD)){
            return TeamPanel.getPrefix() + cfg.getString("ServerSettings.Message.Reload").replaceAll("&", "§");
        } else if(messages.equals(Messages.SERVERSETTINGSMESSAGERESTART)){
            return TeamPanel.getPrefix() + cfg.getString("ServerSettings.message.Restart").replaceAll("&", "§");
        }

        /*
        Player-Settings
         */
        else if(messages.equals(Messages.PLAYERSETTINGS)){
            return cfg.getString("PlayerSettings.MainItem").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSITEMFLY)){
            return cfg.getString("PlayerSettings.Item.Fly").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSITEMHEAL)){
            return cfg.getString("PlayerSettings.Item.Heal").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSITEMBAN)){
            return cfg.getString("PlayerSettings.Item.Ban").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSITEMKILL)){
            return cfg.getString("PlayerSettings.Item.Kill").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSITEMCHAT)){
            return cfg.getString("PlayerSettings.Item.Chat").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSITEMKICK)){
            return cfg.getString("PlayerSettings.Item.Kick").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSITEMINVENTORY)){
            return cfg.getString("PlayerSettings.Item.Inventory").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSITEMBAN)){
            return cfg.getString("PlayerSettings.Item.BanIp").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSITEMVANISH)){
            return cfg.getString("PlayerSettings.Item.Vanish").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSMESSAGEFLYON)){
            return TeamPanel.getPrefix() + cfg.getString("PlayerSettings.Message.Fly.On").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSMESSAGEFLYOFF)){
            return TeamPanel.getPrefix() + cfg.getString("PlayerSettings.Message.Fly.Off").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSMESSAGEHEAL)){
            return TeamPanel.getPrefix() + cfg.getString("PlayerSettings.Message.Heal").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSMESSAGEBAN)){
            return TeamPanel.getPrefix() + cfg.getString("PlayerSettings.Message.Ban").replaceAll("&", "§");
        } else if(messages.equals(Messages.PLAYERSETTINGSMESSAGEKILL)){
            return TeamPanel.getPrefix() + cfg.getString("PlayerSettings.Message.Kill").replaceAll("&", "§");
        } else if(messages.equals(Messages.PLAYERSETTINGSMESSAGECHAT)){
            return TeamPanel.getPrefix() + cfg.getString("PlayerSettings.Message.Chat").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSMESSAGEKICK)){
            return TeamPanel.getPrefix() + cfg.getString("PlayerSettings.Message.Kick").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSMESSAGEINVENTORY)){
            return TeamPanel.getPrefix() + cfg.getString("PlayerSettings.Message.Inventory").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSMESSAGEBANIP)){
            return TeamPanel.getPrefix() + cfg.getString("PlayerSettings.Message.BanIp").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSMESSAGEVANISHON)){
            return TeamPanel.getPrefix() + cfg.getString("PlayerSettings.MessageVanish.On").replaceAll("&", "§");
        }else if(messages.equals(Messages.PLAYERSETTINGSMESSAGEVANISHOFF)){
            return TeamPanel.getPrefix() + cfg.getString("PlayerSettings.Message.Vanish.Off").replaceAll("&", "§");
        }

        /*
        World-Settings
         */
        else if(messages.equals(Messages.WORLDSETTINGS)){
            return cfg.getString("WorldSettings.MainItem").replaceAll("&", "§");
        } else if(messages.equals(Messages.WORLDSETTINGSITEMTIME)){
            return cfg.getString("WorldSettings.Time").replaceAll("&", "§");
        } else if(messages.equals(Messages.WORLDSETTINGSITEMWEATHER)){
            return cfg.getString("WorldSettings.Weather").replaceAll("&", "§");
        } else if(messages.equals(Messages.WORLDSETTINGSITEMMOBS)){
            return cfg.getString("WorldSettings.Mobs").replaceAll("&", "§");
        }

        /*
        Maintenance-Settings
         */
        else if(messages.equals(Messages.MAINTENANCESETTINGS)){
            return cfg.getString("MaintenanceSettings.MainItem").replaceAll("&", "§");
        } else if(messages.equals(Messages.MAINTENANCESETTINGSMOTD)){
            return cfg.getString("MaintenanceSettings.Motd").replaceAll("&", "§");
        } else if(messages.equals(Messages.MAINTENANCESETTINGSKICKMSG)){
            return cfg.getString("MaintenanceSettings.KickMessage").replaceAll("&", "§");
        } else if(messages.equals(Messages.MAINTENANCESETTINGSVERSION)){
            return cfg.getString("MaintenanceSettings.VersionName");
        }
        return null;
    }
}
