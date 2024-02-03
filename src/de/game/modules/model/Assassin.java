package de.game.modules.model;

import de.game.modules.interfaces.Lootable;
import de.game.modules.model.player.misc_usable.InventoryObject;
import de.game.modules.model.player.misc_usable.InventoryObjectType;

import java.util.Random;

public class Assassin extends AbstractCharacter implements Lootable {
    private final Random random = new Random();
    private int initialHealthImportantForLoot;

    public Assassin(Integer id) {
        super(id, 0, "Assassin", 0, 20);

        //Define random value
        int randomHealth = random.nextInt(30) + 20; //up to 50 health;
        int randomAttackDamage = random.nextInt(100); //up to 100 Attack Damage
        int randomDefAmount = random.nextInt(21); //up to 15 Defense from Damage

        setHealth(randomHealth);
        setAttackDamage(randomAttackDamage);
        setDefAmount(randomDefAmount);
        setInitialHealth(getHealth());
    }

    @Override
    public boolean shouldDropPotion() {
        if (isDefeated()) {
            int potionDropChance = random.nextInt(101);
            return potionDropChance <= 95;
        }
        return false;
    }

    public InventoryObject dropAssassinGoogles() {
        if (isDefeated() && 50 >= getAttackDamage() && getInitialHealth() >= 30) {
            int dropChance = random.nextInt(101);
            if (dropChance <= 40) {
                InventoryObject assassinGoogle = new InventoryObject("Assassin's Goggles",  InventoryObjectType.ASSASSIN_GOOGLE);
                System.out.println("Assassin dropped " + assassinGoogle.getName() + "!");
                return assassinGoogle;
            }
        }
        return null;
    }

    @Override
    public void onLoot(AbstractCharacter character) {

    }

    public void setInitialHealth(int health) {
        this.initialHealthImportantForLoot = health;
    }

    public int getInitialHealth(){
        return initialHealthImportantForLoot;
    }
}
