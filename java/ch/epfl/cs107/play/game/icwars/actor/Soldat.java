package ch.epfl.cs107.play.game.icwars.actor;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

import java.util.List;

public class Soldat extends Unit{
    private static final int SOLDIER_DAMAGE = 2;
    private static final int SOLDIER_RAY = 2;
    private static final int SOLDIER_MAXHP = 5;

    public Soldat(Area area, DiscreteCoordinates position, Faction faction){

        super(area, position, faction, SOLDIER_DAMAGE, SOLDIER_MAXHP, SOLDIER_RAY );

        if(faction == Faction.ALLY){
            setName("icwars/friendlySoldier");
        } else if(faction == Faction.ENEMY){
            setName("icwars/enemySoldier");
        }
        setSprite();
    }
}
