package de.game.modules.model.player;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Bag> bags = new ArrayList<>();

    public void addBag(Bag bag) {
        bags.add(bag);
    }

    public List<Bag> getBags() {
        return this.bags;
    }
    // Other methods for managing the overall inventory
}
