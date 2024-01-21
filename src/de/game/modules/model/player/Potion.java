package de.game.modules.model.player;


public class Potion extends InventoryObject {
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
}

