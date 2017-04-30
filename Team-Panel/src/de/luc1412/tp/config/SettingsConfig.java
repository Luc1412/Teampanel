package de.luc1412.tp.config;

import de.luc1412.tp.TeamPanel;
import org.bukkit.configuration.file.YamlConfiguration;

import javax.print.attribute.standard.Fidelity;
import java.io.File;
import java.io.IOException;

/**
 * Created by Luc1412 on 17.04.2017.
 */
public class SettingsConfig {

    private File file = new File(TeamPanel.getInstance().getDataFolder() + "//settings.yml");
    private YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public void createConfig(){
        try {
            if (!file.exists()) {
                file.createNewFile();

                cfg.set("Maintenance", false);

                cfg.save(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean getBoolean(){
        return cfg.getBoolean("Maintenance");
    }

    public void setBoolean(boolean bool){
        cfg.set("Maintenance", bool);

        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
