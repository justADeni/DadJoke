package com.github.justadeni.dadJoke.config;

import com.github.justadeni.dadJoke.DadJoke;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private static Config instance;

    public static Config getInstance() {
        return getInstance(false);
    }

    public static Config getInstance(boolean reload) {
        if (instance != null && !reload)
            return instance;

        DadJoke.getPlugin().reloadConfig();
        instance = new Config();
        return instance;
    }

    public final FileConfiguration CONFIG;

    public final String PREFIX;
    public final String FORMAT;
    public final String NOPERMISSION;
    public final String RELOADED;
    public final String ERROR;
    public final Sound SOUND_SUCCESS;
    public final Sound SOUND_FAILURE;


    private Config() {
        CONFIG = DadJoke.getPlugin().getConfig();
        PREFIX = CONFIG.getString("prefix");
        FORMAT = CONFIG.getString("format");
        NOPERMISSION = CONFIG.getString("no-permission");
        RELOADED = CONFIG.getString("reloaded");
        ERROR = CONFIG.getString("error");
        SOUND_SUCCESS = new Sound("sound-success");
        SOUND_FAILURE = new Sound("sound-failure");
    }

}
