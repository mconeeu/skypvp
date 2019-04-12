package eu.mcone.skypvp.listener;

import eu.mcone.coresystem.api.bukkit.event.NpcInteractEvent;
import eu.mcone.coresystem.api.bukkit.npc.entity.PlayerNpc;
import net.minecraft.server.v1_8_R3.PacketPlayInUseEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NpcInteract implements Listener {

    @EventHandler
    public void onNpcInteract(NpcInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getNpc().getData().getType().equals(EntityType.PLAYER) && e.getAction().equals(PacketPlayInUseEntity.EnumEntityUseAction.INTERACT)) {
            PlayerNpc npc = (PlayerNpc) e.getNpc();

            if (npc.getData().getName().equals("shop")) {
                p.performCommand("shop");
            } else if (npc.getData().getName().equals("kits")) {
                p.performCommand("kit");
            }
        }
    }

}
