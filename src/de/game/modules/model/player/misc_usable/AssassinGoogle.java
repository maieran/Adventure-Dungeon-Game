package de.game.modules.model.player.misc_usable;

import de.game.modules.interfaces.Equipable;
import de.game.modules.model.AbstractCharacter;
import de.game.modules.model.player.PlayerCharacter;


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
            setEquiped(false);
            System.out.println();
        }
    }

    public boolean isEquiped() {
        return isEquiped;
    }

    public void setEquiped(boolean equiped) {
        isEquiped = equiped;
    }

    public void readAttackDamage(AbstractCharacter enemy, PlayerCharacter player) {
        System.out.println(" ");
        System.out.println(this.getName() + " allows you to see yours and the attack potential of your enemy!");
        System.out.println("\t" + enemy.getName() + "'s " + enemy.getAttackDamage() + " attack damage potential");
        System.out.println("\t" + player.getName() + "'s " + player.getAttackDamage() + "'s attack damage potential");
    }
}
