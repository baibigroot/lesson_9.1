package com.company.players;

import java.util.Random;

public class Magic extends Hero {
    public Magic(int health, String name, int damage) {
        super(health, name, damage);

    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random random = new Random();
        int n = random.nextInt(2) + 1;


        if (getHealth() > 0){
            for (int i = 0; i < heroes.length; i++) {
               heroes[i].setDamage(heroes[i].getDamage() * n);

            }
        }














    }
}
