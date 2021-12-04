package ch.epfl.cs107.play.game.icwars.actor;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.MovableAreaEntity;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.window.Canvas;

import java.util.Collections;
import java.util.List;

abstract public class ICWarsActors extends MovableAreaEntity {
    final Faction faction;

    protected enum Faction {
        NONE,
        ALLY,
        ENEMY;
    }

    public ICWarsActors(Area area, DiscreteCoordinates position, Faction faction){
        super(area, Orientation.UP, position);
        this.faction = faction;
    }

    public void leaveArea(){
        getOwnerArea().unregisterActor(this);
    }

    public void enterArea(Area area, DiscreteCoordinates position){
        area.registerActor(this);
        setOwnerArea(area);
        setCurrentPosition(position.toVector());
    }

    public List<DiscreteCoordinates> getCurrentCells() {
        return Collections.singletonList(getCurrentMainCellCoordinates());
    }
}


