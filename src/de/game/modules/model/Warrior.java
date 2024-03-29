package de.game.modules.model;

import de.game.modules.interfaces.Lootable;

import java.util.Random;

public class Warrior extends AbstractCharacter implements Lootable {
    private final Random random = new Random();

    public Warrior(Integer id) {
        super(id, 0, "Warrior", 0, 20);

        //Define random value
        int randomHealth = random.nextInt(50) + 50; //up to 100 health;
        int randomAttackDamage = random.nextInt(51); //up to 50 Attack Damage
        int randomDefAmount = random.nextInt(41); //up to 15 Defense from Damage

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

    @Override
    public void onLoot(AbstractCharacter character) {

    }
}
