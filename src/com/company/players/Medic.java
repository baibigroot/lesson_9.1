package com.company.players;

import java.util.Random;

public class Medic extends Hero {


    public Medic(int health, String name, int damage) {
        super(health, name, damage);
    }

 @Override
            public void applySuperAbility(Boss boss, Hero[] heroes) {
                Random random = new Random();
                int healPoints=random.nextInt(50)+20;
                for (int i = 0; i < heroes.length; i++) {
                    if (this != heroes[i]
                            && heroes[i].getHealth() > 0
                            && heroes[i].getHealth() < 200) {
                heroes[i].setHealth(heroes[i].getHealth() + healPoints);
            }
        }
    }
}
