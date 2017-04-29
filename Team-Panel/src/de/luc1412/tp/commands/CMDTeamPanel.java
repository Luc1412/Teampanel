package de.luc1412.tp.commands;

import de.luc1412.tp.TeamPanel;
import de.luc1412.tp.config.Messages;
import de.luc1412.tp.inventorys.Menu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Luc1412 on 12.04.2017.
 */
public class CMDTeamPanel implements CommandExecutor {

    Menu menu;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
        if(cmd.getName().equalsIgnoreCase("teampanel")){
            if(sender instanceof Player){
                Player p = (Player) sender;
                if(p.hasPermission("teampanel.use")){
                    if(args.length > 0){
                    } else {
                        menu = new Menu();
                        menu.openMenu(p);
                    }
                } else p.sendMessage(TeamPanel.getMessagesConfig().getString(Messages.NOPERMISSION));
            }
        }
        return false;
    }
}
