package de.game.modules.model.player;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private int size;
    private String image;
    private List<InventoryObject> slots;

    public Bag(int size, String image) {
        this.size = size;
        this.image = image;
        this.slots = new ArrayList<>(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public List<InventoryObject> getSlots() {
        return slots;
    }

    public void addInventoryObject(InventoryObject inventoryObject) {
        if (slots.size() < size || slots.isEmpty()) {
            slots.add(inventoryObject);
        } else {
            System.out.println("Bag is full. Cannot add more inventory objects.");
            // You might want to handle this situation based on your requirements
        }
    }

    public void removeInventoryObject(InventoryObject inventoryObject) {
        if (!inventoryObject.getName().isEmpty() && slots.contains(inventoryObject)) {
            for (int i = 0; i < slots.size(); i++) {
                if (inventoryObject.getName().equals(slots.get(i).getName())) {
                    setSize(getSize() - 1);

                    slots.remove(i);
                    return;
                }
            }
        }
        System.out.println("Inventory object not found in the bag.");
    }

    public InventoryObject findHealthPotion() {
        for (InventoryObject inventoryObject : slots) {
            if (inventoryObject.getName().equals("Health Potion 🧪")) {
                return inventoryObject;
            }
        }
        return null;  // Return null if no health potion is found
    }

    public int utilTotalFreeSlotsInTheCurrentBag() {

        return getSize() - getSlots().size();
    }

    public int utilTotalAmountOfHealthPotionsInTheBag(Bag bag) {
        List<InventoryObject> listOfHealthPotions = new ArrayList<>();

        for (InventoryObject inventoryObject : bag.getSlots()) {
             if (inventoryObject instanceof Potion) {
                 listOfHealthPotions.add(inventoryObject);
             }
        }
        return listOfHealthPotions.size();
    }
}
