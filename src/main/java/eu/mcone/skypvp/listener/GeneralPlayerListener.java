/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.listener;

import eu.mcone.coresystem.api.bukkit.CoreSystem;
import eu.mcone.coresystem.api.bukkit.player.CorePlayer;
import eu.mcone.coresystem.api.bukkit.util.CoreActionBar;
import eu.mcone.skypvp.Skypvp;
import eu.mcone.skypvp.player.Kit;
import eu.mcone.skypvp.player.KitManager;
import eu.mcone.skypvp.player.SkypvpPlayer;
import eu.mcone.skypvp.util.SidebarObjective;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class GeneralPlayerListener implements Listener{

	private final static CoreActionBar LOADING_MSG = CoreSystem.getInstance().createActionBar().message("§7§oDeine Daten werden geladen...");
	private final static CoreActionBar LOADING_SUCCESS_MSG = CoreSystem.getInstance().createActionBar().message("§2§oDeine Daten wurden geladen!");

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		CorePlayer cp = CoreSystem.getInstance().getCorePlayer(p);

		e.setJoinMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + CoreSystem.getInstance().getTranslationManager().get("skypvp.join").replaceAll("%player%", p.getName()));
		p.getInventory().clear();

		LOADING_MSG.send(p);

        Bukkit.getScheduler().runTask(Skypvp.getInstance(), () -> {
            new SkypvpPlayer(cp);

            cp.getScoreboard().setNewObjective(new SidebarObjective());

            if (hasEmptyInventory(p)) {
                Skypvp.getInstance().getMessager().send(p, "§7Du scheinst neu auf SkyPvP zu sein! Du bekommst das Standart-Kit!");
                KitManager.setKit(Skypvp.getInstance().getSkypvpPlayer(p.getUniqueId()), Kit.PLAYER);
            }

            p.getPlayer().playEffect(p.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 10);
            LOADING_SUCCESS_MSG.send(p);
        });
	}

	@EventHandler
    public void onBedEnter(PlayerBedEnterEvent e){
    	Player p = e.getPlayer();
    	e.setCancelled(true);
    	Skypvp.getInstance().getMessager().send(p, "§cHier darf man kein Bett benutzen!");
    }

	@EventHandler(priority = EventPriority.LOW)
	public void on(PlayerQuitEvent e) {
		Player p = e.getPlayer();

		p.setLevel(0);
		e.setQuitMessage(CoreSystem.getInstance().getTranslationManager().get("skypvp.prefix") + CoreSystem.getInstance().getTranslationManager().get("skypvp.quit").replaceAll("%player%", p.getName()));

		SkypvpPlayer sp = Skypvp.getInstance().getSkypvpPlayer(p.getUniqueId());

		sp.saveData();
		Skypvp.getInstance().unregisterSkypvpPlayer(sp);
	}

	private boolean hasEmptyInventory(Player p) {
		for (ItemStack i : p.getInventory().getContents()) {
			if (i != null) {
				return false;
			}
		}
		return true;
	}

}
