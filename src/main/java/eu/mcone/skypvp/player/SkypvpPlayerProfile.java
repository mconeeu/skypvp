/*
 * Copyright (c) 2017 -2018 Dominik Lippl, Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 */

package eu.mcone.skypvp.player;

import eu.mcone.coresystem.api.bukkit.player.profile.PlayerDataProfile;
import eu.mcone.skypvp.Skypvp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter @Setter
public class SkypvpPlayerProfile extends PlayerDataProfile {

    private List<Integer> kits = new ArrayList<>();

    SkypvpPlayerProfile(Player p) {
        super(p);

        SkypvpPlayer sp = Skypvp.getInstance().getSkypvpPlayer(p.getUniqueId());
        kits = new ArrayList<>();
        for (Kit kit : sp.getKits()) {
            kits.add(kit.getId());
        }
    }

    List<Kit> calculateKits() {
        List<Kit> result = new ArrayList<>();
        for (int id : kits) {
            result.add(Kit.getKitByID(id));
        }
        return result;
    }

}
