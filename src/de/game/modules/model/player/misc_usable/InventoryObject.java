package de.game.modules.model.player.misc_usable;


public class InventoryObject<T> {
    private String name;
    private T inventoryObjectType;


    public InventoryObject(String name, T inventoryObjectType) {
        this.name = name;
        this.inventoryObjectType = inventoryObjectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getInventoryObjectType() {
        return inventoryObjectType;
    }

    public void setInventoryObjectType(T inventoryObjectType) {
        this.inventoryObjectType = inventoryObjectType;
    }
}
