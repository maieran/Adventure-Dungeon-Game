package de.game.modules.model.player;

public class Weapon {
    private String weaponName;
    private boolean isEquiped;
    private boolean isDefensive;
    private int attack;
    private int defensive;

    public Weapon(String weaponName, boolean isEquiped, boolean isDefensive, int attack, int defensive) {
        this.weaponName = weaponName;
        this.isEquiped = isEquiped;
        this.isDefensive = isDefensive;
        this.attack = attack;
        this.defensive = defensive;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
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
        this.attack = attack;
    }

    public int getDefensive() {
        return defensive;
    }

    public void setDefensive(int defensive) {
        this.defensive = defensive;
    }
}
