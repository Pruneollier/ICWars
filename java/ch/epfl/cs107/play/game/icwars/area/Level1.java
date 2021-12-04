package ch.epfl.cs107.play.game.icwars.area;

import ch.epfl.cs107.play.game.areagame.actor.Background;
import ch.epfl.cs107.play.game.areagame.actor.Foreground;
import ch.epfl.cs107.play.game.icwars.actor.players.RealPlayer;
import ch.epfl.cs107.play.game.icwars.area.ICWarsArea;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Vector;

/**
 * Specific area
 */
public class Level1 extends ICWarsArea {

    @Override
    public String getTitle() {
        return "icwars/level1";
    }

    @Override
    public DiscreteCoordinates getPlayerSpawnPosition() {
        return new DiscreteCoordinates(5,15);
    }

    protected void createArea() {
        // Base
        registerActor(new Background(this)) ;
        registerActor(new Foreground(this)) ;
        registerActor(new RealPlayer());
    }
}
