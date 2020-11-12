package com.company.players;

public abstract class GameEntity {

    int health;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
    int damage;

    public GameEntity(int health, String name, int damage) {
        this.health = health;
        this.name = name;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0){
            this.health = 0;
        } else {
            this.health = health;
        }
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
