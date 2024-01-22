package de.game.modules.model.player;

import de.game.modules.model.AbstractCharacter;


public class PlayerCharacter extends AbstractCharacter {
    private Weapon weapon;
    private Inventory inventory;
    private Bag bag;

    public PlayerCharacter(Integer id, int health, String name, int attackDamage, int defAmount, int numHealthPotions, Bag bag,
                           Weapon weapon, Inventory inventory) {
        super(id, health, name, attackDamage, defAmount);
        this.bag = bag;
        this.weapon = weapon;
        this.inventory = inventory;
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

    public void useHealthPotion() {
        InventoryObject healthPotion = bag.findHealthPotion();
        if (healthPotion instanceof Potion && healthPotion != null) {
            int healingAmount = ((Potion) healthPotion).getHealingAmount();
            int currentHealth = getHealth();
            int newHealth = Math.min(getMaxHealth(), currentHealth + healingAmount);
            setHealth(newHealth);
            bag.removeInventoryObject(healthPotion);
            System.out.println("Used a health potion and healed for " + healingAmount + " HP.");
            System.out.println("There are still " + getAmountOfHealthPotions() + " health potions 🧪 left");
        } else {
            System.out.println("Invalid health potion selection.");
        }
    }

    private int getAmountOfHealthPotions() {
        int count = 0;
        for (int i = 0; i < getBag().getSize(); i++) {
            if (getBag().getSlots().get(i).getName().equals("Health Potion 🧪")) {
                count ++;
            }
        }
        return count;
    }

    private int getMaxHealth() {
        return 100;
    }

    @Override
    public boolean shouldDropPotion() {
        return false;
    }
}
