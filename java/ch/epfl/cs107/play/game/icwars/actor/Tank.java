package ch.epfl.cs107.play.game.icwars.actor;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

public class Tank extends Unit{
    private static final int TANK_DAMAGE = 7;
    private static final int TANK_RAY = 4;
    private static final int TANK_MAXHP = 10;

    public Tank(Area area, DiscreteCoordinates position, Faction faction){

        super(area, position, faction, TANK_DAMAGE, TANK_MAXHP, TANK_RAY );

        if(faction == Faction.ALLY){
            setName("icwars/friendlyTank");
        } else if(faction == Faction.ENEMY){
            setName("icwars/enemyTank");
        }

        setSprite();
    }
}
