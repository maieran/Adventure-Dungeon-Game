package de.game.modules.model;

import de.game.modules.interfaces.Lootable;
import de.game.modules.model.player.PlayerCharacter;
import de.game.modules.model.player.misc_usable.InventoryObject;
import de.game.modules.model.player.misc_usable.InventoryObjectType;

import java.util.Random;
import java.util.Scanner;

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
    public void onLoot(AbstractCharacter playerCharacter) {
        if (playerCharacter instanceof PlayerCharacter) {
            PlayerCharacter player = (PlayerCharacter) playerCharacter;
            InventoryObject assassinGoogle = dropAssassinGoogles();
            if (assassinGoogle != null) {
                System.out.println(" ⚔︎ The " + this.getName() + " dropped Assassin's Goggles! ⚔︎ ");

                System.out.println("*************************************************");
                System.out.println("Do you want to loot Assassin's Goggles?");
                System.out.println("1. Yes, I want to pick them up");
                System.out.println("2. Leave them, as they are.");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();

                while (!input.equals("1") && !input.equals("2")) {
                    System.out.println("Invalid command! Choose 1 or 2");
                    input = scanner.nextLine();
                }

                if (input.equals("1")) {
                    player.getBag().addInventoryObject(assassinGoogle);
                    System.out.println("You picked up Assassin's Goggles!");
                }

                if (input.equals("2")) {
                    System.out.println("You decided to leave Assassin's Goggles.");
                }
            }
        }

    }

    public void setInitialHealth(int health) {
        this.initialHealthImportantForLoot = health;
    }

    public int getInitialHealth(){
        return initialHealthImportantForLoot;
    }

}
