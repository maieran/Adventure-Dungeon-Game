package de.game.modules.model;

import java.util.Random;

public class Assassin extends AbstractCharacter {
    private final Random random = new Random();

    public Assassin(Integer id) {
        super(id, 0, "Assassin", 0, 20);

        //Define random value
        int randomHealth = random.nextInt(30) + 20; //up to 50 health;
        int randomAttackDamage = random.nextInt(100); //up to 100 Attack Damage
        int randomDefAmount = random.nextInt(21); //up to 15 Defense from Damage

        setHealth(randomHealth);
        setAttackDamage(randomAttackDamage);
        setDefAmount(randomDefAmount);
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
