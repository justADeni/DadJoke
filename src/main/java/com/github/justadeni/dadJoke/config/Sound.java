package com.github.justadeni.dadJoke.config;

import com.github.justadeni.dadJoke.DadJoke;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sound {

    private org.bukkit.Sound sound;
    private final Float volume;
    private final Float pitch;

    public Sound(String key) {
        try {
            this.sound = org.bukkit.Sound.valueOf(DadJoke.getPlugin().getConfig().getString(key + ".key"));
        } catch (NullPointerException | EnumConstantNotPresentException | IllegalArgumentException exception){
            this.sound = null;
        }
        this.volume = (float) DadJoke.getPlugin().getConfig().getDouble(key + ".volume");
        this.pitch = (float) DadJoke.getPlugin().getConfig().getDouble(key + ".pitch");
    }

    public void play(Player player) {
        if (sound != null)
            player.playSound(player, sound, volume, pitch);
    }

    public void play(CommandSender sender) {
        if (sender instanceof Player player)
            play(player);
    }

}
