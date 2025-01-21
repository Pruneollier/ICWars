package ch.epfl.cs107.play.game.icwars.actor.unit;

import ch.epfl.cs107.play.game.icwars.actor.ICWarsActors;
import ch.epfl.cs107.play.game.icwars.actor.ICWarsActors.Faction;
import ch.epfl.cs107.play.game.icwars.actor.Unit;
import ch.epfl.cs107.play.game.icwars.actor.players.ICWarsPlayer;
import ch.epfl.cs107.play.game.icwars.area.ICWarsArea;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Keyboard;

import java.util.List;

public class Attack extends Action{

    public Attack(Unit unit, ICWarsArea area){
        super(unit, area);
        setKey(Keyboard.A);
        setName("(A)ttack");
    }

    @Override
    public void draw(Canvas canvas) {
    }

    @Override
    public void doAction(float dt, ICWarsPlayer player, Keyboard keyboard) {
        if()
    }

    public List<Integer> getAttackableUnits(ICWarsPlayer enemyPlayer){
        if (unit.faction == Faction.ALLY){

        }
        for(Unit unit : enemyPlayer.getUnits()){

        }
    }
}
