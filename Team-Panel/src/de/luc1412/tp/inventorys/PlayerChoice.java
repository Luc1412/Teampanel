package de.luc1412.tp.inventorys;

import de.luc1412.tp.TeamPanel;
import de.luc1412.tp.utils.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Created by Luc1412 on 12.04.2017.
 */
public class PlayerChoice {

    public void getPlayerGUI(int seite){
        if(seite <= 0) throw new IllegalArgumentException("Die angegebende Seite darf nicht kleiner gleich 0 seien.");

        Inventory inv = Bukkit.createInventory(null, 54 , "Online Player - Seite " + seite);
        int min = (seite - 1)*51;
        int max = seite *51;
        if(min > Bukkit.getOnlinePlayers().size()) throw new IllegalArgumentException("Diese Seite gibt es nicht!");

        for(int i = 0; i < max; i++){
            if(i > Bukkit.getOnlinePlayers().size()) break;
            List<Player> onlinePlayers = (List<Player>) Bukkit.getOnlinePlayers();
            Player p = onlinePlayers.get(i);
            inv.addItem(TeamPanel.getItemCreator().createSkull(p, 1, p.getDisplayName(), false));
        }

        ItemStack pageBack = TeamPanel.getItemCreator().createItem(Material.BOOK, 1, 0, "Back", false);
        ItemStack pageCurrent = TeamPanel.getItemCreator().createItem(Material.PAPER, 1, 0, "Current", false);
        ItemStack pageVor = TeamPanel.getItemCreator().createItem(Material.BOOK, 1, 0, "Vor", false);

        if(seite != 1) {
            inv.setItem(max, pageBack);
        } else {
            inv.setItem(max, new ItemStack(Material.IRON_FENCE, 1));
        }
        inv.setItem(max+1, pageCurrent);
        if(max < Bukkit.getOnlinePlayers().size()){
            inv.setItem(max+2, pageVor);
        } else {
            inv.setItem(max+2, new ItemStack(Material.IRON_FENCE, 1));
        }

        return;
    }
}
