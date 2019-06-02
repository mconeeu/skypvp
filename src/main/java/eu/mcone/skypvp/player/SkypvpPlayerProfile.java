/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.player;

import eu.mcone.coresystem.api.bukkit.player.profile.PlayerInventoryProfile;
import eu.mcone.skypvp.Skypvp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter @Setter
public class SkypvpPlayerProfile extends PlayerInventoryProfile {

    private List<Integer> kits = new ArrayList<>();
    private transient List<Kit> kitList = new ArrayList<>();

    SkypvpPlayerProfile(Player p, Inventory enderchest) {
        super(p, enderchest);

        SkypvpPlayer sp = Skypvp.getInstance().getSkypvpPlayer(p.getUniqueId());
        kits = new ArrayList<>();
        for (Kit kit : sp.getKits()) {
            kits.add(kit.getId());
        }
    }

    @Override
    public void doSetData(Player p) {
        super.doSetData(p);

        for (int id : kits) {
            kitList.add(Kit.getKitByID(id));
        }
    }
}
