package de.game.modules.model.player;

import de.game.modules.model.AbstractCharacter;

public class PlayerCharacter extends AbstractCharacter {
    /*
    int health = 100;
    int attackDamage = 25;
    int numHealthPotions= 4;
    int healthPotionHealAmount = 30;
    int healthPotionDropChance = 50;
    */
    private int numHealthPotions = 4;
    private Weapon weapon;
    private Inventory inventory;
    private Bag bag;

    public PlayerCharacter(Integer id, int health, int attackDamage, int defAmount, int numHealthPotions, Bag bag,
                           Weapon weapon, Inventory inventory) {
        super(id, health, attackDamage, defAmount);
        this.numHealthPotions = numHealthPotions;
        this.bag = bag;
        this.weapon = weapon;
        this.inventory = inventory;
    }

    public int getNumHealthPotions() {
        return numHealthPotions;
    }

    public void setNumHealthPotions(int numHealthPotions) {
        this.numHealthPotions = numHealthPotions;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
}
