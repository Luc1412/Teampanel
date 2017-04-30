package de.luc1412.tp.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;

import java.util.List;

/**
 * Created by Luc1412 on 12.04.2017.
 */
public class ItemCreator {

    public ItemStack createItem(Material mat, int amount, int data, String name, boolean encahnted){
        ItemStack item = new ItemStack(mat, amount, (short) 0, (byte) data);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        if(encahnted) {
            itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        }
        item.setItemMeta(itemMeta);
        return item;
    }

    public ItemStack createItem(Material mat, int amount, int data, String name, boolean encahnted, List lore){
        ItemStack item = new ItemStack(mat, amount, (short) 0, (byte) data);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        if(encahnted) {
            itemMeta.addEnchant(Enchantment.DURABILITY, 1, false);
        }
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    public ItemStack createDesigneItemWhite(){
            ItemStack item = this.createItem(Material.STAINED_GLASS_PANE, 1, 0, " ", false);
            return item;
    }

    public ItemStack createDesigneItemBlack(){
        ItemStack item = this.createItem(Material.STAINED_GLASS_PANE, 1, 15, " ", false);
        return item;
    }

    public ItemStack createDesigneItemGreen(){
        ItemStack item = this.createItem(Material.STAINED_GLASS_PANE, 1, 13, " ", false);
        return item;
    }

    public ItemStack createBackItem(){
        ItemStack item = this.createItem(Material.RED_ROSE, 1, 1, "§cBack", false);
        return item;
    }

    public ItemStack createCloseItem(){
        ItemStack item = this.createItem(Material.REDSTONE, 1, 0, "§c§lClose", false);
        return item;
    }

    public ItemStack createNoPermItem(){
        ItemStack item = this.createItem(Material.BARRIER, 1, 1, "§4No Permisson", true);
        return item;
    }

    public ItemStack createSkull(Player p, int amount, String name, boolean enchanted){
        ItemStack item = new ItemStack(Material.SKULL_ITEM, amount, (short) 0, (byte) 3);
        SkullMeta skullMeta = (SkullMeta) item.getItemMeta();
        skullMeta.setOwner(p.getName());
        skullMeta.setDisplayName(name);
        if(enchanted){
            skullMeta.addEnchant(Enchantment.DURABILITY, 1, false);
        }
        item.setItemMeta(skullMeta);
        return item;
    }

    public boolean testItem(ItemStack item, Material mat, String name){
        if(item.getType() == mat){
            if(item.getItemMeta().getDisplayName() != null){
                if(item.getItemMeta().getDisplayName().equals(name)){
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }

    public boolean testItem(ItemStack item, Material mat, String name, int data){
        if(item.getType() == mat){
            MaterialData matData = item.getData();
            if(matData.getData() == data){
                if(item.getItemMeta().getDisplayName() != null) {
                    if (item.getItemMeta().getDisplayName().equals(name)) {
                        return true;
                    } else return false;
                } else return false;
            } else return false;
        } else return false;
    }

}
