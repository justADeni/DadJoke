package com.github.justadeni.dadJoke.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class TabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        if (args.length > 0 && "reload".startsWith(args[0]) && sender.hasPermission("dadjoke.reload"))
            return List.of("reload");
        return List.of();
    }

}
