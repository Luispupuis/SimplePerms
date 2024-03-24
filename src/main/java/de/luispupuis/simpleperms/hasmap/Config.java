package de.luispupuis.simpleperms.hasmap;


import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    private FileConfiguration fileconf;
    private File file;
    public Config(String name, File path){
        file = new File(path, name);

        if(!file.exists()) {
            path.mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        fileconf = new YamlConfiguration();
        try {
            fileconf.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }


    }
    public File getFile(){
        return file;

    }
    public FileConfiguration toFileconfiguration(){
        return fileconf;
    }
    public void save(){
        try {
            fileconf.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void reload(){
        try {
            fileconf.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }

    }
    public void set(String path, Object value){
        fileconf.set(path, value);

    }
    public String getRankString(String playerUUID) {
        return fileconf.getString(playerUUID);
    }
    public void getB(String path){
        fileconf.getBoolean(path);

    }
    public void getS(String path){
        fileconf.getString(path);

    }
    public void cont(String path){
        fileconf.contains(path);

    }

}
