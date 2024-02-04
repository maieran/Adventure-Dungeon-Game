package de.game.modules.interfaces;

import de.game.modules.model.AbstractCharacter;
import de.game.modules.model.player.PlayerCharacter;

public interface Lootable {

    void onLoot(AbstractCharacter character);
}
