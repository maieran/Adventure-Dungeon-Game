package de.game.modules.model.player.weapon_equipable;

import de.game.modules.interfaces.Equipable;
import de.game.modules.interfaces.Lootable;
import de.game.modules.model.AbstractCharacter;
import de.game.modules.model.player.misc_usable.InventoryObject;

public class Weapon extends InventoryObject<WeaponType> implements Lootable, Equipable {
    private boolean isEquiped;
    private boolean isDefensive;
    private int attack;
    private int defensive;
    private WeaponType weaponType;
    public Weapon(String weaponName, boolean isEquiped, boolean isDefensive, int attack, int defensive, WeaponType weaponType) {
        super(weaponName, weaponType);
        this.isEquiped = isEquiped;
        this.isDefensive = isDefensive;
        this.attack = attack;
        this.defensive = defensive;
        this.weaponType = weaponType;
    }

    public boolean isEquiped() {
        return isEquiped;
    }

    public void setEquiped(boolean equiped) {
        isEquiped = equiped;
    }

    public boolean isDefensive() {
        return isDefensive;
    }

    public void setDefensive(boolean defensive) {
        isDefensive = defensive;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if (attack >= 0) {
            this.attack = attack;
        } else {
            throw new IllegalArgumentException("Attack value must be non-negative.");
        }
    }

    public int getDefensive() {
        return defensive;
    }

    public void setDefensive(int defensive) {
        if (defensive >= 0) {
            this.defensive = defensive;
        } else {
            throw new IllegalArgumentException("Defensive value must be non-negative");
        }
    }

    @Override
    public void onEquip(AbstractCharacter character) {

    }

    @Override
    public void onLoot(AbstractCharacter character) {

    }
}
