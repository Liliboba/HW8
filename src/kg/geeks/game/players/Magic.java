package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Magic extends Hero {
    private int damageBoost;

    public Magic(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        this.damageBoost = (kg.geeks.game.general.RPG_Game.random.nextInt(2) + 1) * 5;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && RPG_Game.getRoundNumber() < 5) {
                hero.setDamage(hero.getDamage() + this.damageBoost);
            }
        }
        System.out.println("Magic " + this.getName() + " boost our damage by "
                + this.damageBoost );
    }
}