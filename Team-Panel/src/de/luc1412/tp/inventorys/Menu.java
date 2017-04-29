package de.luc1412.tp.inventorys;

import de.luc1412.tp.TeamPanel;
import de.luc1412.tp.config.Messages;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

/**
 * Created by Luc1412 on 12.04.2017 at 00:21
 */

public class Menu implements Listener{

    private int taskId;
    private int inventoryState;
    private int worldInvState;
    private boolean canClick;


    public void openMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*6, "§1Team§8-§4Panel§8|§6" + p.getDisplayName());

        inventoryState = 0;
        canClick = false;

        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(TeamPanel.getInstance(), new Runnable() {
            int i = 0;
            @Override
            public void run() {
                i++;
                switch (i){
                    case 1:
                        /*
                        Item 1
                         */
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.Heal"))
                                || p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.Kill"))
                                || p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.Fly"))
                                || p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.Vanish"))
                                || p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.Clear"))
                                || p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.Chat"))
                                || p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.Ip-Ban"))
                                || p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.Ban"))
                                || p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.Kick"))) {
                            inv.setItem(18, TeamPanel.getItemCreator().createSkull(p, 1, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGS), false));
                        } else {
                            inv.setItem(18, TeamPanel.getItemCreator().createNoPermItem());
                        }
                        /*
                        Item 2
                         */
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.World.SetTime"))
                                || p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.World.SetTime"))
                                || p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.World.ToggleMobSpawning"))){
                            inv.setItem(27, TeamPanel.getItemCreator().createItem(Material.GRASS, 1, 1, TeamPanel.getMessagesConfig().getString(Messages.WORLDSETTINGS), false));
                        } else {
                            inv.setItem(27, TeamPanel.getItemCreator().createNoPermItem());
                        }
                        break;
                    case 2:
                        /*
                        Item 1
                         */
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Server.Stop"))
                                || p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Server.Reload"))
                                || p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Server.Restart"))){
                            inv.setItem(9, TeamPanel.getItemCreator().createItem(Material.COMMAND, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.SERVERSETTINGS), false));
                        } else {
                            inv.setItem(9, TeamPanel.getItemCreator().createNoPermItem());
                        }
                        /*
                        Item 2
                         */
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Maintenance"))){
                            inv.setItem(36, TeamPanel.getItemCreator().createItem(Material.REDSTONE_BLOCK, 1, 1, TeamPanel.getMessagesConfig().getString(Messages.MAINTENANCESETTINGS), false));
                        } else {
                            inv.setItem(36, TeamPanel.getItemCreator().createNoPermItem());
                        }
                        break;
                    case 3:
                        /*
                        Item 1
                         */
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Gamemode.0"))
                                || p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Gamemode.1"))
                                || p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Gamemode.2"))
                                || p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Gamemode.3"))){
                            inv.setItem(0, TeamPanel.getItemCreator().createItem(Material.STONE, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGS), false));
                        } else {
                            inv.setItem(0, TeamPanel.getItemCreator().createNoPermItem());
                        }
                        /*
                        Item 2
                         */
                        inv.setItem(45, TeamPanel.getItemCreator().createItem(Material.DIAMOND_ORE, 1, 1, "§1Comming §4Soon§8...", false));
                        break;
                    case 4:
                        inv.setItem(46, TeamPanel.getItemCreator().createDesigneItemWhite());
                        break;
                    case 5:
                        inv.setItem(47, TeamPanel.getItemCreator().createDesigneItemWhite());
                        inv.setItem(37, TeamPanel.getItemCreator().createDesigneItemWhite());
                        break;
                    case 6:
                        inv.setItem(28, TeamPanel.getItemCreator().createDesigneItemWhite());
                        inv.setItem(48, TeamPanel.getItemCreator().createDesigneItemWhite());
                        break;
                    case 7:
                        inv.setItem(19, TeamPanel.getItemCreator().createDesigneItemWhite());
                        inv.setItem(49, TeamPanel.getItemCreator().createDesigneItemWhite());
                        break;
                    case 8:
                        inv.setItem(10, TeamPanel.getItemCreator().createDesigneItemWhite());
                        inv.setItem(50, TeamPanel.getItemCreator().createDesigneItemWhite());
                        break;
                    case 9:
                        inv.setItem(1, TeamPanel.getItemCreator().createDesigneItemWhite());
                        inv.setItem(51, TeamPanel.getItemCreator().createDesigneItemWhite());
                        break;
                    case 10:
                        inv.setItem(52, TeamPanel.getItemCreator().createDesigneItemWhite());
                        break;
                    case 11:
                        inv.setItem(53, TeamPanel.getItemCreator().createCloseItem());
                        break;
                    case 12:
                        inv.setItem(23, TeamPanel.getItemCreator().createDesigneItemBlack());
                        break;
                    case 13:
                        inv.setItem(13, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(14, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(15, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(22, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(24, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(31, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(32, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(33, TeamPanel.getItemCreator().createDesigneItemBlack());
                        break;
                    case 14:
                        inv.setItem(3, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(4, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(5, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(6, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(7, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(12, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(16, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(21, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(25, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(30, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(34, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(39, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(40, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(41, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(42, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(43, TeamPanel.getItemCreator().createDesigneItemBlack());
                        break;
                    case 15:
                        inv.setItem(20, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(26, TeamPanel.getItemCreator().createDesigneItemBlack());
                        break;
                    case 16:
                        inv.setItem(11, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(35, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(17, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(29, TeamPanel.getItemCreator().createDesigneItemBlack());
                        break;
                    case 17:
                        inv.setItem(2, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(8, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(38, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(44, TeamPanel.getItemCreator().createDesigneItemBlack());
                        break;
                    case 18:
                        Bukkit.broadcastMessage("true");
                        canClick = true;
                        stopScheduler(taskId);
                        break;
                    default:

                        break;

                }
            }
        }, 5, TeamPanel.getInstance().getConfig().getInt("OpenAnimation"));
        p.openInventory(inv);
    }

    @EventHandler
    public void onInventoryInteract(InventoryClickEvent e)
    {
        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();
        if(e.getClickedInventory().getName() != null)
        {
            if (e.getClickedInventory().getName().equals("§1Team§8-§4Panel§8|§6" + p.getDisplayName()))
            {
                e.setCancelled(true);







                /*
                Gamemode-Settings
                 */
                    if (TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.STONE, TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGS)))
                    {
                        if(inventoryState == 2)
                        {
                            inv.setItem(9, TeamPanel.getItemCreator().createItem(Material.COMMAND, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.SERVERSETTINGS), false));
                            inv.setItem(10, TeamPanel.getItemCreator().createDesigneItemWhite());
                            inv.setItem(23, TeamPanel.getItemCreator().createDesigneItemBlack());
                        } else if(inventoryState == 3)
                        {
                            inv.setItem(18, TeamPanel.getItemCreator().createSkull(p, 1, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGS), false));
                            inv.setItem(5 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(12 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(16 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(19 , TeamPanel.getItemCreator().createDesigneItemWhite());
                            inv.setItem(20 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(23 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(26 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(30 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(34 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(41 , TeamPanel.getItemCreator().createDesigneItemBlack());
                        } else if(inventoryState == 4)
                        {
                            inv.setItem(27, TeamPanel.getItemCreator().createItem(Material.GRASS, 1, 1, TeamPanel.getMessagesConfig().getString(Messages.WORLDSETTINGS), false));
                            inv.setItem(28, TeamPanel.getItemCreator().createDesigneItemWhite());
                            inv.setItem(23, TeamPanel.getItemCreator().createDesigneItemBlack());
                        } else if(inventoryState == 5)
                        {
                            inv.setItem(36, TeamPanel.getItemCreator().createItem(Material.REDSTONE_ORE, 1, 1, TeamPanel.getMessagesConfig().getString(Messages.MAINTENANCESETTINGS), false));
                            inv.setItem(27, TeamPanel.getItemCreator().createDesigneItemWhite());
                            inv.setItem(23, TeamPanel.getItemCreator().createDesigneItemBlack());
                        }
                            inventoryState = 1;
                            inv.setItem(1, TeamPanel.getItemCreator().createDesigneItemGreen());
                            inv.setItem(0, TeamPanel.getItemCreator().createItem(Material.STONE, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGS), true));
                            inv.setItem(14, TeamPanel.getItemCreator().createItem(Material.BEDROCK, 2, 0, TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGSITEM2), false));
                            inv.setItem(21, TeamPanel.getItemCreator().createItem(Material.GRASS, 0, 0, TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGSITEM0), false));
                            inv.setItem(25, TeamPanel.getItemCreator().createItem(Material.STAINED_GLASS, 3, 11, TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGSITEM3), false));
                            inv.setItem(32, TeamPanel.getItemCreator().createItem(Material.DIAMOND_BLOCK, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGSITEM1), false));
                    } else if (TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.GRASS, TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGSITEM0)))
                    {
                        if (p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Gamemode.0")))
                        {
                            p.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage(TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGSMESSAGE0));
                        }
                    } else if (TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.DIAMOND_BLOCK, TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGSITEM1)))
                    {
                        if (p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Gamemode.1")))
                        {
                            p.setGameMode(GameMode.CREATIVE);
                            p.sendMessage(TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGSMESSAGE1));
                        }
                    } else if (TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.BEDROCK, TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGSITEM2)))
                    {
                        if (p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Gamemode.2")))
                        {
                            p.setGameMode(GameMode.ADVENTURE);
                            p.sendMessage(TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGSMESSAGE2));
                        }
                    } else if (TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.STAINED_GLASS, TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGSITEM3), 11))
                    {
                        if (p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Gamemode.3")))
                        {
                            p.setGameMode(GameMode.SPECTATOR);
                            p.sendMessage(TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGSMESSAGE3));
                        }












                         /*
                     Close Item
                         */
                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.REDSTONE, TeamPanel.getMessagesConfig().getString(Messages.CLOSE)))
                    {
                        p.closeInventory();
                    }













                        /*
                        Server-Settings
                         */
                     else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.COMMAND, TeamPanel.getMessagesConfig().getString(Messages.SERVERSETTINGS)))
                    {
                        if(inventoryState == 1)
                        {
                            inv.setItem(0, TeamPanel.getItemCreator().createItem(Material.STONE, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGS), false));
                            inv.setItem(1, TeamPanel.getItemCreator().createDesigneItemWhite());
                            inv.setItem(14, TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(32, TeamPanel.getItemCreator().createDesigneItemBlack());
                        } else if(inventoryState == 3)
                        {
                            inv.setItem(18, TeamPanel.getItemCreator().createSkull(p, 1, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGS), false));                            inv.setItem(5 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(12 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(16 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(19 , TeamPanel.getItemCreator().createDesigneItemWhite());
                            inv.setItem(20 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(26 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(30 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(34 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(41 , TeamPanel.getItemCreator().createDesigneItemBlack());
                        } else if(inventoryState == 4)
                        {
                            inv.setItem(27, TeamPanel.getItemCreator().createItem(Material.GRASS, 1, 1, TeamPanel.getMessagesConfig().getString(Messages.WORLDSETTINGS), false));
                            inv.setItem(28, TeamPanel.getItemCreator().createDesigneItemWhite());
                        } else if(inventoryState == 5)
                        {
                            inv.setItem(36, TeamPanel.getItemCreator().createItem(Material.REDSTONE_ORE, 1, 1, TeamPanel.getMessagesConfig().getString(Messages.MAINTENANCESETTINGS), false));
                            inv.setItem(27, TeamPanel.getItemCreator().createDesigneItemWhite());
                            inv.setItem(23, TeamPanel.getItemCreator().createDesigneItemBlack());
                        }
                        inventoryState = 2;
                        inv.setItem(9, TeamPanel.getItemCreator().createItem(Material.COMMAND, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.SERVERSETTINGS), true));
                        inv.setItem(10 , TeamPanel.getItemCreator().createDesigneItemGreen());
                        inv.setItem(21 , TeamPanel.getItemCreator().createItem(Material.STAINED_CLAY, 1, 4, TeamPanel.getMessagesConfig().getString(Messages.SERVERSETTINGSITEMRELOAD), false));
                        inv.setItem(23 , TeamPanel.getItemCreator().createItem(Material.STAINED_CLAY, 1, 1, TeamPanel.getMessagesConfig().getString(Messages.SERVERSETTINGSITEMRESTART), false));
                        inv.setItem(25 , TeamPanel.getItemCreator().createItem(Material.STAINED_CLAY, 1, 14, TeamPanel.getMessagesConfig().getString(Messages.SERVERSETTINGSITEMSTOP), false));

                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.STAINED_CLAY, TeamPanel.getMessagesConfig().getString(Messages.SERVERSETTINGSITEMRELOAD), 4))
                    {
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Server.Reload")))
                        {
                            p.sendMessage(TeamPanel.getMessagesConfig().getString(Messages.SERVERSETTINGSMESSAGERELOAD));
                            Bukkit.getServer().reload();
                        }
                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.STAINED_CLAY, TeamPanel.getMessagesConfig().getString(Messages.SERVERSETTINGSITEMRESTART), 1))
                    {
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Server.Reload")))
                        {
                            p.sendMessage(TeamPanel.getMessagesConfig().getString(Messages.SERVERSETTINGSITEMRESTART));
                            Bukkit.getServer().spigot().restart();
                        }
                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.STAINED_CLAY, TeamPanel.getMessagesConfig().getString(Messages.SERVERSETTINGSITEMSTOP), 14))
                    {
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Server.Reload")))
                        {
                            p.sendMessage(TeamPanel.getMessagesConfig().getString(Messages.SERVERSETTINGSMESSAGESTOP));
                            Bukkit.getServer().shutdown();
                        }















                        /*
                        Player-Settings
                         */
                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.SKULL_ITEM, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGS), 3))
                    {
                        if(inventoryState == 1)
                        {
                            inv.setItem(0, TeamPanel.getItemCreator().createItem(Material.STONE, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGS), false));
                            inv.setItem(1, TeamPanel.getItemCreator().createDesigneItemWhite());
                            inv.setItem(14, TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(21, TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(25, TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(32, TeamPanel.getItemCreator().createDesigneItemBlack());
                        } else if(inventoryState == 2)
                        {
                        inv.setItem(9, TeamPanel.getItemCreator().createItem(Material.COMMAND, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.SERVERSETTINGS), false));
                        inv.setItem(10, TeamPanel.getItemCreator().createDesigneItemWhite());
                        inv.setItem(21, TeamPanel.getItemCreator().createDesigneItemBlack());
                        inv.setItem(25, TeamPanel.getItemCreator().createDesigneItemBlack());
                        } else if(inventoryState == 4)
                        {
                            inv.setItem(27, TeamPanel.getItemCreator().createItem(Material.GRASS, 1, 1, TeamPanel.getMessagesConfig().getString(Messages.WORLDSETTINGS), false));
                            inv.setItem(28, TeamPanel.getItemCreator().createDesigneItemWhite());
                        } else if(inventoryState == 5)
                        {
                            inv.setItem(36, TeamPanel.getItemCreator().createItem(Material.REDSTONE_ORE, 1, 1, TeamPanel.getMessagesConfig().getString(Messages.MAINTENANCESETTINGS), false));
                            inv.setItem(27, TeamPanel.getItemCreator().createDesigneItemWhite());
                            inv.setItem(21, TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(25, TeamPanel.getItemCreator().createDesigneItemBlack());
                        }
                        inventoryState = 3;
                        inv.setItem(18, TeamPanel.getItemCreator().createSkull(p, 1, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGS), true));
                        inv.setItem(19 , TeamPanel.getItemCreator().createDesigneItemGreen());
                        inv.setItem(5 , TeamPanel.getItemCreator().createItem(Material.FEATHER, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMFLY), false));
                        inv.setItem(12 , TeamPanel.getItemCreator().createItem(Material.GOLDEN_APPLE, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMHEAL), false));
                        inv.setItem(16 , TeamPanel.getItemCreator().createItem(Material.PISTON_BASE, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMBAN), false));
                        inv.setItem(20 , TeamPanel.getItemCreator().createItem(Material.DIAMOND_SWORD, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMKILL), false));
                        inv.setItem(23 , TeamPanel.getItemCreator().createItem(Material.PAPER, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMCHAT), false));
                        inv.setItem(26 , TeamPanel.getItemCreator().createItem(Material.DIAMOND_BOOTS, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMKICK), false));
                        inv.setItem(30 , TeamPanel.getItemCreator().createItem(Material.CHEST, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMINVENTORY), false));
                        inv.setItem(34 , TeamPanel.getItemCreator().createItem(Material.PISTON_STICKY_BASE, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMBANIP), false));
                        inv.setItem(41 , TeamPanel.getItemCreator().createItem(Material.STAINED_GLASS, 1, 9, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMVANISH), false));

                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.DIAMOND_SWORD, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMKILL), 0)){
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.Kill"))){

                        }
                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.GOLDEN_APPLE, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMHEAL), 0)){
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.Heal"))){
                            p.setHealth(20);
                            p.setFoodLevel(20);
                            p.sendMessage(TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSMESSAGEHEAL));
                        }
                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.CHEST, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMINVENTORY), 0)){
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.ClearInventory"))){

                        }
                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.FEATHER, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMFLY), 0)){
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.Fly"))){
                            if(p.getAllowFlight()){
                                p.setAllowFlight(false);
                                p.sendMessage(TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSMESSAGEFLYOFF));
                            } else {
                                p.setAllowFlight(true);
                                p.sendMessage(TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSMESSAGEFLYON));
                            }
                        }
                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.PAPER, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMCHAT), 0)){
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.ClearChat"))){
                            Bukkit.broadcastMessage(" \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n " +
                                    "\n \n \n \n \n \n" + TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSMESSAGECHAT));
                        }
                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.GLASS, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMVANISH), 9)){
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.Vanish"))){

                        }
                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.PISTON_BASE, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMBAN), 0)){
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.Ban"))){

                        }
                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.PISTON_STICKY_BASE, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMBANIP), 0)){
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.Ip-Ban"))){

                        }
                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.DIAMOND_BOOTS, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGSITEMKICK), 0)){
                        if(p.hasPermission(TeamPanel.getInstance().getConfig().getString("Permissions.Player.Kick"))){

                        }












                        /*
                        World-Settings
                         */
                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.GRASS, TeamPanel.getMessagesConfig().getString(Messages.WORLDSETTINGS))) {
                        if(inventoryState == 1)
                        {
                            inv.setItem(0, TeamPanel.getItemCreator().createItem(Material.STONE, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.GAMEMODESETTINGS), false));
                            inv.setItem(1, TeamPanel.getItemCreator().createDesigneItemWhite());
                            inv.setItem(14, TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(32, TeamPanel.getItemCreator().createDesigneItemBlack());
                        } else if(inventoryState == 2) {

                        } else if(inventoryState == 3)
                        {
                            inv.setItem(18, TeamPanel.getItemCreator().createSkull(p, 1, TeamPanel.getMessagesConfig().getString(Messages.PLAYERSETTINGS), false));
                            inv.setItem(5 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(12 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(16 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(19 , TeamPanel.getItemCreator().createDesigneItemWhite());
                            inv.setItem(20 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(26 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(30 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(34 , TeamPanel.getItemCreator().createDesigneItemBlack());
                            inv.setItem(41 , TeamPanel.getItemCreator().createDesigneItemBlack());
                        } else if(inventoryState == 5)
                        {
                            inv.setItem(36, TeamPanel.getItemCreator().createItem(Material.REDSTONE_ORE, 1, 1, TeamPanel.getMessagesConfig().getString(Messages.MAINTENANCESETTINGS), false));
                            inv.setItem(27, TeamPanel.getItemCreator().createDesigneItemWhite());
                            inv.setItem(23, TeamPanel.getItemCreator().createDesigneItemBlack());
                        }
                        inv.setItem(27, TeamPanel.getItemCreator().createItem(Material.GRASS, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.WORLDSETTINGS), true));
                        inv.setItem(28, TeamPanel.getItemCreator().createDesigneItemWhite());
                        inv.setItem(21, TeamPanel.getItemCreator().createItem(Material.WATCH, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.WORLDSETTINGSITEMTIME), false));
                        inv.setItem(23, TeamPanel.getItemCreator().createItem(Material.SKULL_ITEM, 1 ,4, TeamPanel.getMessagesConfig().getString(Messages.WORLDSETTINGSITEMMOBS), false));
                        inv.setItem(25, TeamPanel.getItemCreator().createItem(Material.STAINED_GLASS, 1, 3, TeamPanel.getMessagesConfig().getString(Messages.WORLDSETTINGSITEMWEATHER), false));
                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.WATCH, TeamPanel.getMessagesConfig().getString(Messages.WORLDSETTINGSITEMTIME))){
                        inv.setItem(21, TeamPanel.getItemCreator().createItem(Material.WATCH, 1, 0, TeamPanel.getMessagesConfig().getString(Messages.WORLDSETTINGSITEMTIME), false));
                        inv.setItem(47, TeamPanel.getItemCreator().createBackItem());
                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.SKULL_ITEM, TeamPanel.getMessagesConfig().getString(Messages.WORLDSETTINGSITEMMOBS), 4)){

                    } else if(TeamPanel.getItemCreator().testItem(e.getCurrentItem(), Material.STAINED_GLASS, TeamPanel.getMessagesConfig().getString(Messages.WORLDSETTINGSITEMWEATHER), 3)){

                    }
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e){
        Player p = (Player) e.getPlayer();
        if(Bukkit.getScheduler().isCurrentlyRunning(taskId)){
            if(e.getInventory().getName() != null){
                if(e.getInventory().getName().equals("§1Team§8-§4Panel §3-> §6" + p.getDisplayName())){
                    Bukkit.broadcastMessage("Task Canceled");
                    stopScheduler(taskId);
                }
            }
        }
    }


    private void stopScheduler(int taskId){
        Bukkit.getScheduler().cancelTask(taskId);
        Bukkit.broadcastMessage("Task canceld");
    }
}
