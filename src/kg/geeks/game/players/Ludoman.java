package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Ludoman extends Hero {
    private int dice1;
    private int dice2;

    public Ludoman(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.EXCITATION);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        this.dice1 = kg.geeks.game.general.RPG_Game.random.nextInt(6) + 1;
        this.dice2 = kg.geeks.game.general.RPG_Game.random.nextInt(6) + 1;

        if (dice1 == dice2){
            boss.setHealth(boss.getHealth() - (this.dice1 * this.dice2 ));
            System.out.println("Good luck " + this.getName() + ", we caused damage " + (this.dice1 * this.dice2 ) + " for Boss");
        }else {
            int who = kg.geeks.game.general.RPG_Game.random.nextInt(heroes.length);
            heroes[who].setHealth(heroes[who].getHealth() - (dice1 + dice2));
            System.out.println("Bad omen, " + heroes[who].getName() + " suffered damage " + (dice1 + dice2));
        }
    }
}
