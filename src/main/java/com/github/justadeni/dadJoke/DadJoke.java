package com.github.justadeni.dadJoke;

import com.github.justadeni.dadJoke.command.Command;
import com.github.justadeni.dadJoke.command.TabComplete;
import org.bukkit.plugin.java.JavaPlugin;

public final class DadJoke extends JavaPlugin {

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    private static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        getCommand("dadjoke").setExecutor(new Command());
        getCommand("dadjoke").setTabCompleter(new TabComplete());
    }

    @Override
    public void onDisable() {

    }
}
