package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Deku extends Hero {
    private int[] coefOfPower = {20, 50, 100};
    private int[] healthLoss = {10, 25 , 50};
    public Deku(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.CRUSHER);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int probability = kg.geeks.game.general.RPG_Game.random.nextInt(2);
        if (this.getHealth() > 0 && probability == 0) {
            int power = kg.geeks.game.general.RPG_Game.random.nextInt(coefOfPower.length);
            this.setDamage(this.getDamage() + (this.getDamage() * (this.coefOfPower[power]/100)));
            this.setHealth(this.getHealth() - healthLoss[power]);
            System.out.println(this.getName() + " intensified by " + this.coefOfPower[power] + " and weakened in " + healthLoss[power] + " health");
        }
    }
}
