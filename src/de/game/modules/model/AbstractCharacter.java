package de.game.modules.model;

public abstract class AbstractCharacter {
    private final Integer id;
    private int health;

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


    public AbstractCharacter(Integer id, int health, int attackDamage, int defAmount) {
        this.id = id;
        this.health = health;
        this.attackDamage = attackDamage;
        this.defAmount = defAmount;
    }
}
