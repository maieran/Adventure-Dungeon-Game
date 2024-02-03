package de.game.modules.model.player.misc_usable;

import de.game.modules.interfaces.Equipable;
import de.game.modules.interfaces.Lootable;
import de.game.modules.interfaces.Usable;
import de.game.modules.model.AbstractCharacter;
import de.game.modules.model.Assassin;

//TODO: we will leave it as usable and change it later to equipable, once the player's body parts become possible to equip
public class AssassinGoogle extends InventoryObject<InventoryObjectType> implements Lootable, Usable {

    public AssassinGoogle(String assassinGoogleName, InventoryObjectType inventoryObjectType) {
        super(assassinGoogleName, InventoryObjectType.ASSASSIN_GOOGLE);

    }

    @Override
    public void onLoot(AbstractCharacter character) {

    }

    @Override
    public void onUse(AbstractCharacter character) {
        //readEnemiesHealthPointsAndAttackPoints(character);
    }
}
