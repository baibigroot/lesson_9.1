package com.company.players;

public abstract class Hero extends GameEntity implements HavingSuperAbility {
    private SuperAbility superAbility;

    public Hero(int health, String name, int damage) {
        super(health, name, damage);
    }
}
