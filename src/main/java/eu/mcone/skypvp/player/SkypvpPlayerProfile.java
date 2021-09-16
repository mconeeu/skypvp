package eu.mcone.skypvp.player;

import eu.mcone.coresystem.api.bukkit.player.profile.PlayerInventoryProfile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

@NoArgsConstructor
@Getter
public class SkypvpPlayerProfile extends PlayerInventoryProfile {

    private int crates;

    SkypvpPlayerProfile(Player p, Inventory enderchest, int crates) {
        super(p, enderchest);
        this.crates = crates;
    }

}
