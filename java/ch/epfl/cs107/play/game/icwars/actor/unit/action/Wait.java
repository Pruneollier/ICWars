package ch.epfl.cs107.play.game.icwars.actor.unit;

import ch.epfl.cs107.play.game.icwars.actor.Unit;
import ch.epfl.cs107.play.game.icwars.actor.players.ICWarsPlayer;
import ch.epfl.cs107.play.game.icwars.actor.players.ICWarsPlayer.CurrentState;
import ch.epfl.cs107.play.game.icwars.area.ICWarsArea;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Keyboard;

public class Wait extends Action{

    public Wait(Unit unit, ICWarsArea area){
        super(unit, area);
        setKey(Keyboard.W);
        setName("(W)ait");
    }

    @Override
    public void draw(Canvas canvas) {
    }

    @Override
    public void doAction(float dt, ICWarsPlayer player, Keyboard keyboard) {
        this.unit.setUsableUnit(false);
        player.setCurrentState(CurrentState.NORMAL);
    }
}
