package de.game.modules;

import de.game.modules.model.*;
import de.game.modules.model.player.*;
import de.game.modules.model.player.misc_usable.AssassinGoogle;
import de.game.modules.model.player.misc_usable.InventoryObject;
import de.game.modules.model.player.misc_usable.InventoryObjectType;
import de.game.modules.model.player.misc_usable.Potion;
import de.game.modules.model.player.weapon_equipable.Weapon;
import de.game.modules.model.player.weapon_equipable.WeaponType;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class GameClass
{

    public GameClass() {
    }


    public static void main(String[] args) {
        GameClass gameClass = new GameClass();
        gameClass.startGameWithOutGui();
    }

    public void startGameWithOutGui() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Player character init
        Bag standardPlayerBag = new Bag(10, "BagImage");
        Weapon standardShortPlayerSword =  new Weapon("Sword", true, false, random.nextInt(31), 0, WeaponType.SHORT_SWORD);
        Inventory standardPlayerInventory = new Inventory();
        standardPlayerBag.addInventoryObject(standardShortPlayerSword);
        standardPlayerInventory.addBag(standardPlayerBag);

        PlayerCharacter player = new PlayerCharacter(0, 100, "Player", 25, 26, 4, standardPlayerBag,
                standardShortPlayerSword, standardPlayerInventory);
        player.setAttackDamage(player.getAttackDamage() + standardShortPlayerSword.getAttack());
        player.setBag(standardPlayerBag);
        for (int i = 1; i <= 4; i++) {
            player.getBag().addInventoryObject(new Potion("Health Potion 🧪", 30));
        }



        System.out.println("WELCOME TO THE DUNGEON");

        while (true) {
            System.out.println("*************************************************");
            AbstractCharacter[] enemiesCharacters = {new Skeleton(1), new Zombie(2), new Warrior(3), new Assassin(4)};
            AbstractCharacter enemy = enemiesCharacters[random.nextInt(enemiesCharacters.length)];
            System.out.println("\t<< " + enemy.getName() + " has appeared ! >>\n");

            GAME:
            while (enemy.getHealth() > 0 && player.getHealth() > 0) {
                System.out.println("\tYour HP: " + player.getHealth());
                System.out.println("\t" + enemy.getName() + "'s HP: " + enemy.getHealth());

                //TODO: Bring another category that can gives you a pet, where you can decide either the pet or you can receive the dmg for Warrior and can heal itself
                //TODO: Add some loot for Skeleton and Zombie

                /**
                 * Checks if assasineGoogle is equipped, not null and uses it then on the player and the enemy
                 */

                useEquippedAssassinGoogle(enemy, player);
                //useWarriorPetAgainstEnemy(enemy, player);
                //useZombieShirt(player);
                //useSkeletonSkull(player);


                System.out.println("\n\tWhat would you like to do with your enemy?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!!");
                System.out.println("\t4. Open inventory");

                // Interaction with the player/user
                String input = scanner.nextLine();
                switch (input) {
                    case "1":
                        fightingTheEnemy(player, enemy);
                        break;
                    case "2":
                        player.useHealthPotion();
                        break;
                    case "3":
                        System.out.println("\t> You run away from the " + enemy.getName() + "!");
                        break GAME;
                    case "4":
                        System.out.println("You have opened inventory");
                        player.openBag(scanner); //later u may have multiple bags
                        break;
                    default:
                        System.out.println("Invalid command, Choose 1, 2, 3, or 4!");
                }

                // Check after interaction whether the player is still alive
                if (player.getHealth() < 1) {
                    System.out.println("You are bleeding out and cannot fight anymore");
                    break;
                }

                System.out.println("*************************************************");
                System.out.println(" What would you like to do now? ");
                System.out.println("1. Continue fighting? ");
                System.out.println("2. Exit game");
                input = scanner.nextLine();

                while (!input.equals("1") && !input.equals("2")) {
                    System.out.println("Invalid command! Choose 1 or 2");
                    input = scanner.nextLine();
                }
                if (input.equals("1")) {
                    System.out.println("You can continue on your adventure!");
                } else if (input.equals("2")) {
                    System.out.println("Game over");
                    break;
                }
            }

            if (player.getHealth() < 0 ) {
                System.out.println("You are dead, game over !");
                return;
            }
        }
    }

    private static void fightingTheEnemy(PlayerCharacter player, AbstractCharacter enemy) {
        int damageDealt = player.dealDamage(player.getAttackDamage());
        int reducedDamageDealt = enemy.defendDamage(damageDealt);
        enemy.takeDamage(reducedDamageDealt);
        System.out.println("\t You strike the " + enemy.getName() + " for " + damageDealt + " damage. ");

        if (reducedDamageDealt > 0) {
            System.out.println("\t The " + enemy.getName() + " attempts to defend, but receives " + reducedDamageDealt + " damage.");
        } else {
            System.out.println("\t The " + enemy.getName() + " was able to defend and there is no impact");
        }


        int damageTaken = enemy.dealDamage(enemy.getAttackDamage());
        int reduceDamageTaken = player.defendDamage(damageTaken);
        player.takeDamage(reduceDamageTaken);

        if (reduceDamageTaken > 0) {
            System.out.println("\t The " + player.getName() + " attempts to defend, but receives " + reduceDamageTaken  + " damage.");
        } else {
            System.out.println("\t The " + player.getName() + " was able to defend the attack from " + enemy.getName() + " there is no impact");
        }
        System.out.println(" ");

        handleEnemyDefeat(enemy, player);

        if (player.getHealth() <= 0) {
            System.out.println("\t You have taken too much damage, you are too weak and die");
        }
    }

    private static void useEquippedAssassinGoogle(AbstractCharacter enemy, PlayerCharacter player) {
        if (player.isEquippedWith(InventoryObjectType.ASSASSIN_GOOGLE)) {
            Optional<InventoryObject> assassinGoogleOnOptional = player.getEquippedItems().stream()
                    .filter(obj -> obj.getInventoryObjectType() == InventoryObjectType.ASSASSIN_GOOGLE)
                    .findFirst();

            if (assassinGoogleOnOptional.isPresent()) {
                AssassinGoogle assassinGoogleOnUse = (AssassinGoogle) assassinGoogleOnOptional.get();
                if (assassinGoogleOnUse.isEquiped()) {
                    assassinGoogleOnUse.readAttackDamage(enemy, player);
                }
            }
        }
    }

    private static void handleEnemyDefeat(AbstractCharacter enemy, PlayerCharacter player) {
        Scanner scanner = new Scanner(System.in);
        if (enemy.isDefeated()) {
            System.out.println("*************************************************");
            System.out.println(" ⚔︎ " + enemy.getName() + " was defeated! ⚔︎ ");
            if (enemy.shouldDropPotion()) {
                System.out.println(" ⚔︎ The " + enemy.getName() + " dropped a health potion 🧪 ⚔︎ ");

                System.out.println("*************************************************");
                System.out.println("Do you want to loot the health potion 🧪?");
                System.out.println("1. Yes, I want to pick it up");
                System.out.println("2. Leave it, as it is.");
                String input = scanner.nextLine();

                while (!input.equals("1") && !input.equals("2")) {
                    System.out.println("Invalid command! Choose 1 or 2");
                    input = scanner.nextLine();
                }

                if (input.equals("1")) {
                    agreeToAddLootedHealthPotionToBag(player);
                }

                if (input.equals("2")) {
                    System.out.println("You are leaving the dead body of " + enemy.getName() + " to the worms");
                }

                checkIfAssassinGooglesAreDropped(enemy, player);
            }
        }
        System.out.println(" ⚔︎ You have " + player.getHealth() + " HP left. ⚔︎");
    }

    private static void agreeToAddLootedHealthPotionToBag(PlayerCharacter player) {
        if (player.getBag().getSlots().size() < player.getBag().getSize()) {
            System.out.println("You are picking up the health potion 🧪");
            player.getBag().addInventoryObject(new Potion("Health Potion 🧪", 30));
            int totalFreeSlotsInTheBag = player.getBag().utilTotalFreeSlotsInTheCurrentBag();
            int totalAmountOfHealthPotionsInTheBag = player.getBag().utilTotalAmountOfHealthPotionsInTheBag(player.getBag());
            System.out.println(" ︎ You have now " + totalAmountOfHealthPotionsInTheBag
                    + " health potions 🧪 ⚔︎ ");
            System.out.println(" You have " + totalFreeSlotsInTheBag + " free slots in your bag.");
        } else {
            System.out.println("The Bag is full, you need to free slots");
        }
    }

    private static void checkIfAssassinGooglesAreDropped(AbstractCharacter enemy, PlayerCharacter player) {
        if (enemy.isDefeated() && enemy instanceof Assassin) {
            ((Assassin) enemy).onLoot(player);
        }
    }

}
