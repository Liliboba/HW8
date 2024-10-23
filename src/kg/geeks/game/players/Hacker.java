package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Hacker extends Hero {
    private int healthToSteal;

    public Hacker(String name, int health, int damage, int healthToSteal) {
        super(name, health, damage, SuperAbility.HACKING);
        this.healthToSteal = healthToSteal;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getHealth() >= healthToSteal) {
            boss.setHealth(boss.getHealth() - healthToSteal);
            int randomIndex = RPG_Game.random.nextInt(heroes.length);
            Hero targetHero = heroes[randomIndex];
            if (targetHero.getHealth() > 0) {
                targetHero.setHealth(targetHero.getHealth() + healthToSteal);
                System.out.println("Hacker " + this.getName() + " stole " + healthToSteal +
                        " health from Boss and transferred it to " + targetHero.getName() + ".");
            }
        } else {
            System.out.println("Hacker " + this.getName() + " tried to steal health, but Boss does not have enough health.");
        }
    }
}
