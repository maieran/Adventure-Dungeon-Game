package de.game.modules;

import de.game.modules.model.*;

import java.util.Random;
import java.util.Scanner;

public class GameClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        //game variables
        String [] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
        //AbstractCharacter[] enemiesCharacter = {new Assassin(1), new Zombie(2), new Warrior(3), new Skeleton(4)};
        int maxEnemyHealth = 70;
        int enemyAttackDamage = 30;

        //player variable
        int health = 100;
        int attackDamage = 25;
        int numHealthPotions= 4;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;


        System.out.println("WELCOME TO THE DUNGEON");

        // Start of Game
        while(true) {
            System.out.println("*************************************************");

            int enemyHealth = random.nextInt(maxEnemyHealth);
            String enemy = enemies[(random.nextInt(enemies.length))];
            System.out.println("\t<< " + enemy + " has appeared ! >>\n");

            GAME:
            while(enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do with your enemy?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!!");

                //Interaction with the player/user
                String input = scanner.nextLine();
                switch (input) {
                    case "1":
                        int damageDealt = random.nextInt(attackDamage);
                        int damageTaken = random.nextInt(enemyAttackDamage);


                        enemyHealth -= damageDealt;
                        System.out.println("\t You strike the " + enemy + " for " + damageDealt + " damage. ");
                        health -= damageTaken;
                        System.out.println("\t You receive " + damageTaken + " in retaliation!");
                        System.out.println(" ");

                        if (random.nextInt(100) < healthPotionDropChance) {
                            numHealthPotions++;
                            System.out.println(" ⚔︎ The " + enemy + " dropped a health potion ⚔︎ ");
                            System.out.println(" ⚔︎ You have " + numHealthPotions + " health potions ⚔︎ ");
                        }

                        if (health <= 0) {
                            System.out.println("\t You have taken too much damage, you are too weak and died");
                            break GAME;
                        }
                        break;
                    case "2":
                        if (numHealthPotions > 0) {
                            health += healthPotionHealAmount;
                            numHealthPotions--;
                            System.out.println("\t> You have healed yourself " + healthPotionHealAmount + "\n\t You have " + health + "amount " +
                                    "of HP. " + "\n\t" + numHealthPotions + "health potions left. \n");
                        } else {
                            System.out.println("\t> You have run out of health potions! Perhaps your enemies might have one!");
                        }
                        break;
                    case "3":
                        System.out.println("\t> You run away from the " + enemy + "!");
                        break GAME;
                    case "4":
                        System.out.println("You have opened inventory");
                    default:
                        System.out.println("Invalid command, Choose 1, 2 or 3!");
                }

                //Check after interaction whether the player is still alive
                if (health < 1) {
                    System.out.println("You are bleeding out and cannot fight anymore");
                    break;
                }

                if (enemyHealth <= 0) {
                    System.out.println("*************************************************");
                    System.out.println(" ⚔︎ " + enemy + " was defeated! ⚔︎ ");
                    System.out.println(" ⚔︎ You have " + health + " HP left. ⚔︎");
                }

                System.out.println("*************************************************");
                System.out.println(" ⚔︎ You have " + health + " HP left. ⚔︎");



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
        }
    }
}
