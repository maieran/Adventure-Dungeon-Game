package de.game.modules.model.player;

import de.game.modules.interfaces.Equipable;
import de.game.modules.interfaces.Usable;
import de.game.modules.model.AbstractCharacter;
import de.game.modules.model.player.misc_usable.InventoryObject;
import de.game.modules.model.player.misc_usable.InventoryObjectType;
import de.game.modules.model.player.misc_usable.Potion;
import de.game.modules.model.player.weapon_equipable.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PlayerCharacter extends AbstractCharacter {
    private Weapon weapon;
    private Inventory inventory;
    private Bag bag;


    private List<InventoryObject> equippedItems;
    public PlayerCharacter(Integer id, int health, String name, int attackDamage, int defAmount, int numHealthPotions, Bag bag,
                           Weapon weapon, Inventory inventory) {
        super(id, health, name, attackDamage, defAmount);
        this.bag = bag;
        this.weapon = weapon;
        this.inventory = inventory;
        this.equippedItems = new ArrayList<>(5);
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


    public int getAmountOfHealthPotions() {
        int count = 0;
        for (int i = 0; i < getBag().getSlots().size(); i++) {
            InventoryObject expectedHealthPotion = getBag().getSlots().get(i);
            if (expectedHealthPotion.getName().equals("Health Potion 🧪") && expectedHealthPotion instanceof Potion) {
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

    public void equipItem(InventoryObject item) {
        if (item instanceof Equipable) {
            //((Equipable) item).onEquip(this);
            this.getEquippedItems().add(item);
            System.out.println("Equipped" + item.getName());
        } else {
            System.out.println("This item is not equipable.");
        }
    }

    public void unequipItem(InventoryObject item) {
        if (item instanceof Equipable) {
            //((Equipable) item).onEquip(this);
            this.getEquippedItems().remove(item);
            System.out.println("Equipped" + item.getName());
        } else {
            System.out.println("This item is not equipable.");
        }
    }

    //TODO: Methode soll fürs Benutzen der Schlüssel von Dungeon verwendet werden
    public void useEquippedItems() {
        if (!equippedItems.isEmpty()) {
            System.out.println("Using equipped items: ");

            for (InventoryObject equippedItem : equippedItems) {
                if (equippedItem instanceof Equipable) {
                    ((Usable) equippedItem).onUse(this);
                    System.out.println("Used " + equippedItem);
                }
            }
        } else {
            System.out.println("No items equipped or equipped items are not usable.");
        }
    }

    public void openBag(Scanner scanner) {
        System.out.println("You have opened inventory");
        System.out.println("\tIn your bag there are still: " + this.getBag().utilTotalFreeSlotsInTheCurrentBag() + " free slots for new items");
        System.out.println("Press 0, to leave the Bag.");
        System.out.println(" ");

        for (int i = 0; i < this.getBag().getSlots().size(); i++) {
            System.out.println((i + 1) + ". " + this.getBag().getSlots().get(i).getName());
        }

        System.out.println("Choose an item to equip or use by entering the corresponding number or 0 to go back");
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= this.getBag().getSlots().size()) {
            InventoryObject chosenItem = this.getBag().getSlots().get(choice - 1);

            if (chosenItem instanceof Equipable) {
                ((Equipable) chosenItem).onEquip(this);
                System.out.println("You equipped " + chosenItem.getName());
                equippedItems.add(chosenItem);
            }
            if (chosenItem instanceof  Usable) {
                ((Usable) chosenItem).onUse(this);
                System.out.println("You used " + chosenItem.getName());
            }
        } else {
            System.out.println("Invalid choice");
        }
    }

    public List<InventoryObject> getEquippedItems() {
        return equippedItems;
    }

    public void setEquippedItems(List<InventoryObject> equippedItems) {
        this.equippedItems = equippedItems;
    }

    public boolean isEquippedWith(InventoryObjectType type) {
        return getEquippedItems().stream().anyMatch(item -> item.getInventoryObjectType() == type);
    }
}
