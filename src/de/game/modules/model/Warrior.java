package de.game.modules.model;

import java.util.Random;

public class Warrior extends AbstractCharacter {
    private final Random random = new Random();

    public Warrior(Integer id) {
        super(id, 0, "Warrior", 0, 20);

        //Define random value
        int randomHealth = random.nextInt(100); //up to 100 health;
        int randomAttackDamage = random.nextInt(50); //up to 50 Attack Damage

        setHealth(randomHealth);
        setAttackDamage(randomAttackDamage);
    }

    @Override
    public boolean shouldDropPotion() {
        if (isDefeated()) {
            int potionDropChance = random.nextInt(101);
            return potionDropChance <= 95;
        }
        return false;
    }
}
