package com.github.justadeni.dadJoke.config;

import com.github.justadeni.dadJoke.DadJoke;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sound {

    private final org.bukkit.Sound sound;
    private final Float volume;
    private final Float pitch;

    public Sound(String key) {
        this.sound = org.bukkit.Sound.valueOf(DadJoke.getPlugin().getConfig().getString(key + ".key"));
        this.volume = (float) DadJoke.getPlugin().getConfig().getDouble(key + ".volume");
        this.pitch = (float) DadJoke.getPlugin().getConfig().getDouble(key + ".pitch");
    }

    public void play(Player player) {
        player.playSound(player, sound, volume, pitch);
    }

    public void play(CommandSender sender) {
        if (sender instanceof Player player)
            play(player);
    }

}
