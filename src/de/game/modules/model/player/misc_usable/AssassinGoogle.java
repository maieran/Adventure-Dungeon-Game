package de.game.modules.model.player.misc_usable;

import de.game.modules.interfaces.Equipable;
import de.game.modules.interfaces.Lootable;
import de.game.modules.interfaces.Usable;
import de.game.modules.model.AbstractCharacter;
import de.game.modules.model.Assassin;
import de.game.modules.model.player.PlayerCharacter;

//TODO: Now equip to player's body parts
public class AssassinGoogle extends InventoryObject<InventoryObjectType> implements Equipable {

    private boolean isEquiped;

    public AssassinGoogle(String assassinGoogleName, InventoryObjectType inventoryObjectType) {
        super(assassinGoogleName, InventoryObjectType.ASSASSIN_GOOGLE);
        this.isEquiped = false;
    }

    @Override
    public void onEquip(AbstractCharacter character) {
        if (character instanceof PlayerCharacter) {
            PlayerCharacter player = (PlayerCharacter) character;
            player.equipItem(this);
            setEquiped(true);
            System.out.println();
        }
    }

    @Override
    public void onUnequip(AbstractCharacter character) {
        if (character instanceof PlayerCharacter) {
            PlayerCharacter player = (PlayerCharacter) character;
            player.unequipItem(this);
            setEquiped(true);
            System.out.println();
        }
    }

    public boolean isEquiped() {
        return isEquiped;
    }

    public void setEquiped(boolean equiped) {
        isEquiped = equiped;
    }



}
