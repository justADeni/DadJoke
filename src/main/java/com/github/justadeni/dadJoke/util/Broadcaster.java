package com.github.justadeni.dadJoke.util;

import com.github.justadeni.dadJoke.DadJoke;
import com.github.justadeni.dadJoke.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Broadcaster {

    private static BukkitTask runnable;

    public static void broadcast(boolean enable) {
        if (enable) {
            if (runnable != null)
                return;

            runnable = new BukkitRunnable() {
                @Override
                public void run() {
                    if (Bukkit.getOnlinePlayers().isEmpty())
                        return;

                    String joke = Client.getJoke();
                    if (joke.isEmpty()) {
                        DadJoke.getPlugin().getLogger().info(Config.getInstance().PREFIX + Config.getInstance().ERROR);
                        return;
                    }

                    String broadcast = Config.getInstance().BROADCAST_FORMAT.replace("%dadjoke%", joke);
                    Bukkit.getOnlinePlayers().stream()
                            .filter(player -> player.hasPermission("dadjoke.broadcast"))
                            .forEach(player -> player.sendMessage(broadcast));
                }
            }.runTaskTimerAsynchronously(DadJoke.getPlugin(), 0L, Config.getInstance().FREQUENCY * 1200L);
        } else {
            if (runnable == null)
                return;

            runnable.cancel();
            runnable = null;
        }
    }

}
