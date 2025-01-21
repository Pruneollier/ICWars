package ch.epfl.cs107.play.game.icwars.handler;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Interactable;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.icwars.actor.ICWarsActors;
import ch.epfl.cs107.play.game.icwars.actor.Unit;
import ch.epfl.cs107.play.game.icwars.actor.players.RealPlayer;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

public interface ICWarsInteractionVisitor extends AreaInteractionVisitor {
    public default void RealPlayer(Area area, DiscreteCoordinates position, ICWarsActors.Faction faction, Unit... units) {
    }
    public default void Unit(Area area, DiscreteCoordinates position, ICWarsActors.Faction faction, int damage, int maxHp, int ray){
    }

    public default void interactWith(RealPlayer realPlayer){
    }

    public default void interactWith(Unit unit){
    }
}