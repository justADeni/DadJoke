package com.github.justadeni.dadJoke.command;

import com.github.justadeni.dadJoke.config.Config;
import com.github.justadeni.dadJoke.util.Client;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String s, String[] args) {
        if (args.length > 0) {
            if (args[0].equals("reload") && sender.hasPermission("dadjoke.reload")) {
                sender.sendMessage(Config.getInstance(true).PREFIX + Config.getInstance().RELOADED);
                Config.getInstance().SOUND_SUCCESS.play(sender);
            } else {
                sender.sendMessage(Config.getInstance().PREFIX + Config.getInstance().NOPERMISSION);
                Config.getInstance().SOUND_FAILURE.play(sender);
            }
            return true;
        } else {
            if (!sender.hasPermission("dadjoke.use")) {
                sender.sendMessage(Config.getInstance().PREFIX + Config.getInstance().NOPERMISSION);
                Config.getInstance().SOUND_FAILURE.play(sender);
                return true;
            }
            String joke = Client.getJoke();
            if (joke.isEmpty()) {
                sender.sendMessage(Config.getInstance().PREFIX + Config.getInstance().ERROR);
                Config.getInstance().SOUND_FAILURE.play(sender);
                return true;
            }
            sender.sendMessage(Config.getInstance().PREFIX + Config.getInstance().FORMAT.replace("%dadjoke%", joke));
            Config.getInstance().SOUND_SUCCESS.play(sender);
        }

        return true;
    }

}
