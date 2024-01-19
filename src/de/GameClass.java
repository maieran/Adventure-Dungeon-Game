package de;

import com.sun.security.jgss.GSSUtil;

import java.util.Random;
import java.util.Scanner;

public class GameClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        //game variables
        String [] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
        int maxEnemyHealth = 70;
        int enemyAttackDamage = 30;

        //player variable
        int health = 100;
        int attackDamage = 25;
        int numHealthPotions= 4;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;

        boolean running = true;
        System.out.println("WELCOEM TO THE DUNGEON");

        // Start of Game

        while(running) {
            System.out.println("*************************************************");

            int enemyHealth = random.nextInt(maxEnemyHealth);
            String enemy = enemies[(random.nextInt(enemies.length))];
            System.out.println("\t<< " + enemy + " has appeared ! >>\n");

            while(enemyHealth > 0) {
                System.out.println("\t Your HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do with your enemy?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!!");
                
            }
        }

    }
}
