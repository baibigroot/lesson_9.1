package com.company.game;

import com.company.players.*;

public class RPG_Game {

    public static void start() {
        Boss boss = new Boss(700, "Boss", 20);
        Warrior warrior = new Warrior(250, "Warrior", 35 );
        Hunter hunter = new Hunter(260, "Hunter", 15);
        Medic doctor = new Medic(230, "Doctor", 15);
        Medic medic = new Medic(270, "Medic", 10);
        Magic magic = new Magic(270, "Magic", 20);
        Golem golem = new Golem(500, "Golem", 10);
        Hero[] heroes = {warrior, hunter, doctor, medic, magic, golem};

        printStatistics(boss, heroes);

        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }

    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("-----------");
        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName()
                    + " health: " + heroes[i].getHealth());
        }
        System.out.println("-----------");
    }

    private static void round(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            bossHits(boss, heroes);
        }
        heroesHit(boss, heroes);
        applySuper(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static void applySuper(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }

        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && !heroes[i].getName().equals("Golem")) {
                if (heroes[i].getHealth() - boss.getDamage() > 0) {
                    heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
                } else {
                    heroes[i].setHealth(0);
                }
            }
        }

        GolemSuperAbility(heroes, boss);
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {

        heroes[4].applySuperAbility(boss, heroes );
        heroes[0].applySuperAbility(boss, heroes );
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0 && !heroes[i].getName().equals("Golem")) {
                if (boss.getHealth() - heroes[i].getDamage() > 0) {
                    boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                } else {
                    boss.setHealth(0);
                }
            }
        }
    }

    private static void GolemSuperAbility(Hero[] heroes, Boss boss) {
        if (heroes[5].getHealth() > 0 && boss.getHealth() > 0) {
            int damageBoss = boss.getDamage() - boss.getDamage() / 5;
            if (heroes[5].getHealth() - damageBoss > 0) {
                heroes[5].setHealth(heroes[5].getHealth() - damageBoss);
            } else {
                heroes[5].setHealth(0);
            }
        }
    }
}
