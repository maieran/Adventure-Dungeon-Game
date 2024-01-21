package de.game.modules.model;

import java.util.Random;

public class Skeleton extends AbstractCharacter {
    private final Random random = new Random();

    public Skeleton(Integer id) {
        super(id, 0, "Skeleton", 0, 0);  // Call super() with default values

        // Define random values
        int randomHealth = random.nextInt(35); // up to 35 health
        int randomAttackDamage = random.nextInt(31); // up to 30 damage

        setHealth(randomHealth);
        setAttackDamage(randomAttackDamage);
    }

    @Override
    public boolean shouldDropPotion() {
        if (isDefeated()) {
            int potionDropChance = random.nextInt(101); // up to 100 drop chance
            return potionDropChance <= 50; // Adjust the drop chance as needed
        }
        return false;
    }
}

