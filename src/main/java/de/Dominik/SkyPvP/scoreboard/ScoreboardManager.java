/*
 * Copyright (c) 2017 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package de.Dominik.SkyPvP.scoreboard;

import de.Dominik.SkyPvP.Main;
import org.bukkit.Bukkit;

import java.util.ArrayList;

public class ScoreboardManager {

    static ArrayList<Scoreboard> scoreboards = new ArrayList<>();

    public ScoreboardManager() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
            for(Scoreboard sb : scoreboards) {
                sb.updateScoreboard();
            }
        }, 20, 20);
    }

}
