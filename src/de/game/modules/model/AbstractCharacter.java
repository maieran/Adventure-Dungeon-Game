package de.game.modules.model;

import java.util.Random;

public abstract class AbstractCharacter {
    private final Integer id;
    private int health;
    private String name;
    private final Random random = new Random();

    protected AbstractCharacter(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getDefAmount() {
        return defAmount;
    }

    public void setDefAmount(int defAmount) {
        this.defAmount = defAmount;
    }

    private int attackDamage;
    private int defAmount;


    public AbstractCharacter(Integer id, int health, String name, int attackDamage, int defAmount) {
        this.id = id;
        this.health = health;
        this.name = name;
        this.attackDamage = attackDamage;
        this.defAmount = defAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void takeDamage(int damageTaken) {
        if (getHealth() > 0) {
            int health = getHealth() - damageTaken;
            setHealth(health);
        }
    }

    public int dealDamage (int attackDamage) {
        //TODO: Change back again to random
        //return random.nextInt(attackDamage + 1);
        return 100;
    }

    public boolean isDefeated() {
        return getHealth() <= 0;
    }

    public abstract boolean shouldDropPotion();

    public int defendDamage(int damageTaken) {
        int combatDefendAmount = random.nextInt(getDefAmount() + 1);
        if (damageTaken > combatDefendAmount) {
            return damageTaken - combatDefendAmount;
        } else {
            return 0;
        }
    }
}
