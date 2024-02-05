package de.game.modules.model.player.misc_usable;


import de.game.modules.interfaces.Lootable;
import de.game.modules.interfaces.Usable;
import de.game.modules.model.AbstractCharacter;
import de.game.modules.model.player.PlayerCharacter;

public class Potion extends InventoryObject<InventoryObjectType> implements Usable {
    private int healingAmount;

    public Potion(String potionName, int healingAmount) {
        super(potionName, InventoryObjectType.POTION);
        this.healingAmount = healingAmount;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }


    @Override
    public void onUse(AbstractCharacter character) {
        if (character instanceof PlayerCharacter) {
            ((PlayerCharacter) character).useHealthPotion();
        }
    }
}

