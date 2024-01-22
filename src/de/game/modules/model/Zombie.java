package de.game.modules.model;

import java.util.Random;

public class Zombie extends AbstractCharacter {
    private final Random random = new Random();

    public Zombie(Integer id) {
        super(id, 0, "Zombie", 0, 0);

        //Define random value
        int randomHealth = random.nextInt(71); //up to 70 health;
        int randomAttackDamage = random.nextInt(31); //up to 30 Attack Damage
        int randomDefAmount = random.nextInt(16); //up to 15 Defense from Damage

        setHealth(randomHealth);
        setAttackDamage(randomAttackDamage);
        setDefAmount(randomDefAmount);
    }

    public boolean isDefeated() {
        return getHealth() <= 0;
    }

    @Override
    public boolean shouldDropPotion() {
        if (isDefeated()) {
            int potionDropChance = random.nextInt(101);
            return potionDropChance <= 70;
        }
        return false;
    }

}
